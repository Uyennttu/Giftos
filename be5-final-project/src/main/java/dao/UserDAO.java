package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.User;
import sql.connection.DBConnection;

public class UserDAO {
	public User login(String userName, String password) throws SQLException {
		Connection connection = DBConnection.makeConnection();
		String sqlQuery = "SELECT * FROM user WHERE user_name = ? AND password = ?";
		PreparedStatement preStmt = connection.prepareStatement(sqlQuery);
		preStmt.setString(1, userName);
		preStmt.setString(2, password);
		ResultSet resultSet = preStmt.executeQuery();

		User user = null;

		if (resultSet.next()) {
			user = new User();
			user.setUserName(userName);
			user.setPassword(password);

		}
		return user;

	}

}
