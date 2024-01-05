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
		
		if(resultSet.next()) {
			int id = resultSet.getInt("id");
			String name = resultSet.getString("user_name");
			String pwd= resultSet.getString("password");
			String mail = resultSet.getString("email");
			
			return new User(id, name, pwd, mail);
		}
		return null;
		
	}

}
