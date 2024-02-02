package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CategoryDAO;
import dao.ProductDAO;
import entity.Cart;
import entity.Category;
import entity.Product;
import model.ProductInCart;

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
			case "VIEW_CART": {
				viewCart(request, response);
				break;
			}
			case "REMOVE_ITEM": {
				viewCart(request, response);
				break;
			}
			case "ADD_ITEM": {
				viewCart(request, response);
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
		Cart cart;
		HttpSession session = request.getSession();

		if (session.getAttribute("cart") == null) {
			cart = new Cart();
			cart.setItems(new HashMap<ProductInCart, Integer>());
		} else {
			cart = (Cart) session.getAttribute("cart");
		}
		Product product = ProductDAO.getProductById(productId);
		ProductInCart productInCart = new ProductInCart(product.getId(), product.getName(), product.getPrice(), 0);

		if (cart.getItems().containsKey(productInCart)) {
			int newQuantity = cart.getItems().get(productInCart) + 1;
			productInCart.setSubTotal(newQuantity * productInCart.getPrice());
			cart.getItems().remove(productInCart);
			cart.getItems().put(productInCart, newQuantity);
		} else {
			productInCart.setSubTotal(productInCart.getPrice());
			cart.getItems().put(productInCart, 1);
		}
		cart.setTotal(cart.getTotal() + productInCart.getPrice());
		session.setAttribute("cart", cart);

		response.sendRedirect("Product?productId=" + productId);

	}

	public void viewCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		CategoryDAO categoryDAO = new CategoryDAO();
		List<Category> categories = categoryDAO.getAllCategories();

		RequestDispatcher rd = request.getRequestDispatcher("/cart.jsp");
		request.setAttribute("categories", categories);
		rd.forward(request, response);

	}

	public void removeItem(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
	    String productId = request.getParameter("productId");
	    HttpSession session = request.getSession();
	   
	    response.sendRedirect("/cart.jsp");
	}
	
	public void addItem(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
	    String productId = request.getParameter("productId");
	    HttpSession session = request.getSession();
	   
	    response.sendRedirect("/cart.jsp");
	}
	
	

}
