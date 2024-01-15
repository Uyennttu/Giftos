package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import entity.User;

/**
 * Servlet implementation class AuthenticationController
 */
@WebServlet("/Authentication")
public class AuthenticationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UserDAO userDAO = new UserDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AuthenticationController() {
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
			if (action != null) {

				switch (action) {
				case "LOG_IN": {
					login(request, response);
					break;
				}

				case "LOG_OUT": {
					logout(request, response);
					break;
				}

				case "REGISTER": {
					register(request, response);
					break;
				}

				}
			}

		} catch (

		SQLException e) {
			e.printStackTrace();
		}

	}

	private void register(HttpServletRequest request, HttpServletResponse response)
			throws IOException, SQLException, ServletException {
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		User user = userDAO.registerNewAccount(email, username, password);
		if (user == null) {
			request.setAttribute("errorMessage", "Email or username already exists.");
			RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
			rd.forward(request, response);
		} else {
			response.sendRedirect("login.jsp");
		}
	}

	private void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		User user = userDAO.getUserByNameAndPassword(username, password);
		if (user == null) {
			request.setAttribute("errorMessage", "Incorrect username or password. Please try again.");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			response.sendRedirect("Home");
		}
	}

	private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect("Home");
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
