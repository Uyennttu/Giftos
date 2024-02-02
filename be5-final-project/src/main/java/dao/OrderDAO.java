package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Order;
import entity.OrderDetails;
import sql.connection.DBConnection;

public class OrderDAO {
	public Order placeOrder(int userId, Date submitDate) throws SQLException {
		Connection connection = DBConnection.makeConnection();
		String sqlQuery = "INSERT INTO `order` (user_id, submit_date) VALUES (?,?)";
		PreparedStatement preStmt = connection.prepareStatement(sqlQuery);
		preStmt.setInt(1, userId);
		preStmt.setDate(2, submitDate);
		preStmt.executeUpdate();
		return new Order();

	}

	public OrderDetails placeOrderDetails(int orderId, int productId, int quantity, double price) throws SQLException {
		Connection connection = DBConnection.makeConnection();
		String sqlQuery = "INSERT INTO `order-details` (order_id, product_id, quantity, price) VALUES (?,?,?,?)";
		PreparedStatement preStmt = connection.prepareStatement(sqlQuery);
		preStmt.setInt(1, orderId);
		preStmt.setInt(2, productId);
		preStmt.setInt(3, quantity);
		preStmt.setDouble(4, price);
		preStmt.executeUpdate();
		return new OrderDetails();

	}

	public List<Order> getOrderDetails(String userId) throws SQLException {
		Connection connection = DBConnection.makeConnection();
		String sqlQuery = "SELECT o.*, od.* FROM `order` o JOIN `order-details` od ON o.id = od.order_id WHERE o.user_id = ?";

		PreparedStatement preStmt = connection.prepareStatement(sqlQuery);

		if (userId != null && !userId.isEmpty()) {
		    preStmt.setInt(1, Integer.parseInt(userId));
		} 


		ResultSet resultSet = preStmt.executeQuery();
		List<Order> list = new ArrayList<Order>();
		while (resultSet.next()) {
			int orderId = resultSet.getInt("od.order_id");
			int productId = resultSet.getInt("od.product_id");
			int quantity = resultSet.getInt("od.quantity");
			double price = resultSet.getDouble("od.price");
			Date submitDate = resultSet.getDate("o.submit_date");			

			Order order = new Order(orderId, productId, quantity, price, submitDate);
			list.add(order);
			
		}
		return list;

	}

}
