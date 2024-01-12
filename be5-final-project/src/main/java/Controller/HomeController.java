package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoryDAO;
import dao.ProductDAO;
import dao.UserDAO;
import entity.Category;
import entity.Product;
import entity.User;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/Home")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
			ProductDAO productDAO = new ProductDAO();
			List<Product> products;

			CategoryDAO categoryDAO = new CategoryDAO();
			List<Category> categories = categoryDAO.getAllCategories();

			String categoryIdString = request.getParameter("categoryId");
			String action = request.getParameter("action");
			String searchValue = request.getParameter("searchValue");
			String productIdString = request.getParameter("productId");

			if (productIdString == null) {
				if ("SHOW_ALL".equals(action)) {
					products = productDAO.getAllProducts();

				} else if (categoryIdString != null) {
					int categoryId = Integer.parseInt(categoryIdString);
					products = productDAO.getProductsByCategoryId(categoryId);

				} else if (searchValue != null) {
					products = productDAO.getProductsBySearch(searchValue);

				} else {
					products = productDAO.getLatestProducts();
				}

				request.setAttribute("products", products);
				request.setAttribute("categories", categories);
				RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
				rd.forward(request, response);

			} else {
				int productId = Integer.parseInt(productIdString);
				Product product = productDAO.getProductById(productId);
				request.setAttribute("categories", categories);
				request.setAttribute("product", product);
				RequestDispatcher rd = request.getRequestDispatcher("/product_details.jsp");
				rd.forward(request, response);
			}

		} catch (SQLException e) {
			e.printStackTrace();

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
