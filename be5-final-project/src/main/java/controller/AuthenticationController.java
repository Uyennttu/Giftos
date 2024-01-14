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
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			UserDAO userDAO = new UserDAO();
			User user = userDAO.getUserByNameAndPassword(username, password);

			String action = request.getParameter("action");
			if (action == null) {
				action = "LOG_IN";
			}
			switch (action) {
			case "LOG_IN": {
				Login(request, response, user);
				break;
			}

			case "LOG_OUT": {
				Logout(request, response);
				break;
			}
			default:
			}

		} catch (

		SQLException e) {
			e.printStackTrace();
		}

	}

	private void Login(HttpServletRequest request, HttpServletResponse response, User user)
			throws ServletException, IOException {
		if (user == null) {
			request.setAttribute("errorMessage", "Incorrect username or password. Please try again");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			response.sendRedirect("Home");
		}
	}

	private void Logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
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
