package entity;




import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.ProductInCart;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Cart {
	private Map<ProductInCart, Integer> items;
	private double total;
	
		
	

}
