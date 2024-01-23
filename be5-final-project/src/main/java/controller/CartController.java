package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CartController
 */
@WebServlet("/Cart")
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		try {

			switch (action) {
			case "ADD_TO_CART": {
				addToCart(request, response);
				break;
			}
			default:
				break;
			}

		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void addToCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		String productId = request.getParameter("productId");
		Set<Integer> uniqueProductIds;
		Map<Integer, Integer> quantityEachProduct;

		HttpSession session = request.getSession();

		// Unique Product
		if (session.getAttribute("cart") == null) {
			uniqueProductIds = new HashSet<Integer>();
		} else {
			uniqueProductIds = (Set<Integer>) session.getAttribute("cart");

		}
		uniqueProductIds.add(Integer.parseInt(productId));
		session.setAttribute("cart", uniqueProductIds);

		// Quantity of each Product
		if (session.getAttribute("quantityEachProduct") == null) {
			quantityEachProduct = new HashMap<Integer, Integer>();
		} else {
			quantityEachProduct = (Map<Integer, Integer>) session.getAttribute("quantityEachProduct");
		}

		int currentQuantity = quantityEachProduct.getOrDefault(Integer.parseInt(productId), 0);
		quantityEachProduct.put(Integer.parseInt(productId), currentQuantity + 1);
		session.setAttribute("quantityEachProduct", quantityEachProduct);

		response.sendRedirect("Product?productId=" + productId);

		// Print the quantity of each unique product
	    System.out.println("Quantity of each product:");
	    for (Integer uniqueProductId : uniqueProductIds) {
	        int quantity = quantityEachProduct.getOrDefault(uniqueProductId, 0);
	        System.out.println("Product id: " + uniqueProductId + ", Quantity: " + quantity);
	    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
