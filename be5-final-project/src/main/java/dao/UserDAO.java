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

}
