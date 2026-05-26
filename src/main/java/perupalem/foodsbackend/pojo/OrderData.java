package perupalem.foodsbackend.pojo;

import lombok.Data;

import java.math.BigDecimal;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Data
@SuppressWarnings("unused")
public class OrderData {
	
	
	@NotNull(message = "User ID is required")
	private int userId;
	
	@NotNull(message = "Product ID is required")
	private int productId;

    @NotBlank(message = "Product name is required")
    private String productName;

    @NotNull(message = "Price is required")
    @Positive(message = "Price must be greater than 0")
    private BigDecimal price;

    @NotNull(message = "Quantity is required")
    @Min(value = 1, message = "Quantity must be at least 1")
    private int quantity;

}