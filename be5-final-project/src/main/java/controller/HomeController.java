package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoryDAO;
import dao.ProductDAO;
import entity.Category;
import entity.Product;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/Home")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ProductDAO productDAO = new ProductDAO();
	List<Product> products;
	CategoryDAO categoryDAO = new CategoryDAO();
	List<Category> categories;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HomeController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String action = request.getParameter("action");
			if (action == null) {
				action = "DEFAULT";
			}

			switch (action) {
			case "SHOW_PRODUCTS_BY_CATEGORY": {
				String categoryId = request.getParameter("categoryId");
				products = ProductDAO.getProductsByCategoryId(categoryId);
				break;
			}
			case "SHOW_ALL_PRODUCTS": {
				products = productDAO.getAllProducts();
				break;
			}
			case "SEARCH": {
				getProductsBySearch(request, response);
				break;
			}
			default:
				products = productDAO.getLatestProducts();
			}
			categories = categoryDAO.getAllCategories();
			dispatchAttributesToView(request, response);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void getProductsBySearch(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		String searchValue = request.getParameter("searchValue");
		products = productDAO.getProductsBySearch(searchValue);

		if (products.isEmpty()) {
			request.setAttribute("searchResultMessage", "This item is out of stock.");
			request.setAttribute("categories", categories);
			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
			rd.forward(request, response);
		}
	}

	private void dispatchAttributesToView(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
		request.setAttribute("products", products);
		request.setAttribute("categories", categories);
		rd.forward(request, response);
	}

}
