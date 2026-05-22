package perupalem.foodsbackend.pojo;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class CartApiData {
	
	private int userId;
	
	private int productId;
	
	private String productName;
	
	private BigDecimal price;
	
}
