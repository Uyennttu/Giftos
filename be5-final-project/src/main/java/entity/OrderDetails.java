package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class OrderDetails {
	private int id;
	private int orderId;
	private int productId;
	private int quantity;
	private double price;

}
