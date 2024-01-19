package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import entity.User;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/Register")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String gender = request.getParameter("gender");
		String[] interests = request.getParameterValues("interest");

		User user = new User(email, username, password, firstname, lastname, gender, "");
		for (String interest : interests) {
			if (user.getInterest().isEmpty()) {
				user.setInterest(interest);
			} else {
				user.setInterest(user.getInterest() + "," + interest);
			}
		}
		UserDAO userDAO = new UserDAO();
		try {
			user = userDAO.registerNewAccount(email, username, password, firstname, lastname, gender, interests);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (user == null) {
			request.setAttribute("errorMessage", "Email or username already exists.");
			RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
			rd.forward(request, response);
		} else {
			response.sendRedirect("login.jsp");
		}
	}

}
