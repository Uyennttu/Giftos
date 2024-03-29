package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.User;
import sql.connection.DBConnection;

public class UserDAO {
	public User getUserByNameAndPassword(String username, String password) throws SQLException {
		Connection connection = DBConnection.makeConnection();
		String sqlQuery = "SELECT * FROM user WHERE username = ? AND password = ?";
		PreparedStatement preStmt = connection.prepareStatement(sqlQuery);
		preStmt.setString(1, username);
		preStmt.setString(2, password);
		ResultSet resultSet = preStmt.executeQuery();

		if (resultSet.next()) {
			int id = resultSet.getInt("id");
			return new User(id, username, password);
		}
		return null;

	}

	public User registerNewAccount(String email, String username, String password, String firstname, String lastname, String gender, String[] interests) throws SQLException {
		Connection connection = DBConnection.makeConnection();
		if (checkExistedEmailAndUsername(email, username)) {
			return null;
		} else {
			String sqlQuery = "INSERT INTO user (email, username, password, firstname, lastname, gender, interest) VALUES (?,?,?,?,?,?,?)";
			PreparedStatement preStmt = connection.prepareStatement(sqlQuery);

			preStmt.setString(1, email);
			preStmt.setString(2, username);
			preStmt.setString(3, password);
			preStmt.setString(4, firstname);
			preStmt.setString(5, lastname);
			preStmt.setString(6, gender);
			
			String interestsString = String.join(",", interests);
			preStmt.setString(7, interestsString);
			

			preStmt.executeUpdate();
			return new User();
		}

	}

	private boolean checkExistedEmailAndUsername(String email, String username) throws SQLException {
		Connection connection = DBConnection.makeConnection();
		String sqlQuery = "SELECT COUNT(*) FROM user WHERE email=? OR username=?";
		PreparedStatement preStmt = connection.prepareStatement(sqlQuery);
		preStmt.setString(1, email);
		preStmt.setString(2, username);
		ResultSet resultSet = preStmt.executeQuery();

		return resultSet.next() && resultSet.getInt(1) > 0;
	}
}
