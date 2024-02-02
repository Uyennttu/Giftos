package entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Order {
	

	public Order(int orderId, int productId, int quantity, double price, java.sql.Date submitDate2) {
		// TODO Auto-generated constructor stub
	}
	private int id;
	private int userId;
	private Date submitDate;

}
