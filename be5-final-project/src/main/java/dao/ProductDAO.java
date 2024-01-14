package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Product;
import sql.connection.DBConnection;

public class ProductDAO {

	public List<Product> getLatestProducts() throws SQLException {
		Connection connection = DBConnection.makeConnection();
		Statement stmt = connection.createStatement();
		String sqlQuery = "SELECT * FROM product WHERE is_new = 1";
		ResultSet resultSet = stmt.executeQuery(sqlQuery);

		List<Product> list = new ArrayList<Product>();

		while (resultSet.next()) {
			int id = resultSet.getInt("id");
			String name = resultSet.getString("name");
			int price = resultSet.getInt("price");
			String imgName = resultSet.getString("img_name");
			boolean isNew = resultSet.getBoolean("is_new");

			Product product = new Product(id, name, price, imgName, isNew);
			list.add(product);

		}
		return list;

	}

	public static Product getProductById(int productId) throws SQLException {
		Connection connection = DBConnection.makeConnection();
		String sqlQuery = "SELECT * FROM product WHERE id = ?";
		PreparedStatement preStmt = connection.prepareStatement(sqlQuery);
		preStmt.setInt(1, productId);
		ResultSet resultSet = preStmt.executeQuery();

		if (resultSet.next()) {
			int id = resultSet.getInt("id");
			String name = resultSet.getString("name");
			int price = resultSet.getInt("price");
			String imgName = resultSet.getString("img_name");
			boolean isNew = resultSet.getBoolean("is_new");
			int quantity = resultSet.getInt("quantity");
			String description = resultSet.getString("description");

			return new Product(id, name, price, imgName, isNew, quantity, description);
		}
		return null;

	}

	public List<Product> getAllProducts() throws SQLException {
		Connection connection = DBConnection.makeConnection();
		Statement stmt = connection.createStatement();
		String sqlQuery = "SELECT * FROM product";
		ResultSet resultSet = stmt.executeQuery(sqlQuery);

		List<Product> list = new ArrayList<Product>();

		while (resultSet.next()) {
			int id = resultSet.getInt("id");
			String name = resultSet.getString("name");
			int price = resultSet.getInt("price");
			String imgName = resultSet.getString("img_name");
			boolean isNew = resultSet.getBoolean("is_new");

			Product product = new Product(id, name, price, imgName, isNew);
			list.add(product);

		}
		return list;

	}

	public static List<Product> getProductsByCategoryId(String categoryId) throws SQLException {
		Connection connection = DBConnection.makeConnection();
		String sqlQuery = "SELECT * FROM product WHERE category_id = ?";
		PreparedStatement preStmt = connection.prepareStatement(sqlQuery);
		preStmt.setInt(1, Integer.parseInt(categoryId));
		ResultSet resultSet = preStmt.executeQuery();

		List<Product> list = new ArrayList<Product>();

		while (resultSet.next()) {
			int id = resultSet.getInt("id");
			String name = resultSet.getString("name");
			int price = resultSet.getInt("price");
			String imgName = resultSet.getString("img_name");
			boolean isNew = resultSet.getBoolean("is_new");

			Product product = new Product(id, name, price, imgName, isNew);
			list.add(product);

		}
		return list;

	}

	public static List<Product> getProductsBySearch(String searchValue) throws SQLException {
		Connection connection = DBConnection.makeConnection();
		String sqlQuery = "SELECT * FROM product WHERE name LIKE ?";
		PreparedStatement preStmt = connection.prepareStatement(sqlQuery);
		preStmt.setString(1, "%" + searchValue + "%");
		ResultSet resultSet = preStmt.executeQuery();

		List<Product> list = new ArrayList<Product>();

		while (resultSet.next()) {
			int id = resultSet.getInt("id");
			String name = resultSet.getString("name");
			int price = resultSet.getInt("price");
			String imgName = resultSet.getString("img_name");
			boolean isNew = resultSet.getBoolean("is_new");

			Product product = new Product(id, name, price, imgName, isNew);
			list.add(product);

		}
		return list;

	}
}
