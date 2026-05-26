package perupalem.foodsbackend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import perupalem.foodsbackend.entity.Cart;
import perupalem.foodsbackend.payload.ApiResponse;
import perupalem.foodsbackend.pojo.CartApiData;
import perupalem.foodsbackend.service.CartService;

@CrossOrigin(origins = "http://localhost:5173") // Replace with your frontend URL
@RestController
public class CartController {
	
	@Autowired
	CartService cartService;
	
	
	@PostMapping("/addToCart")
	public ResponseEntity<ApiResponse<String>> handleaddToCart(@Valid @RequestBody CartApiData cartApiData ) throws Exception {
		  
		
		 	cartService.addToCartService(cartApiData);
		
		 	ApiResponse<String> apiResponse = new ApiResponse<>(true, "Product added to cart successfully", null);
		
		 	return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
	}
	
	
	@GetMapping("/getCartItems/{userId}")
	public ResponseEntity<ApiResponse<List<Cart>>> handleGetCartItems( @PathVariable int userId) {

	    List<Cart> cartItems = cartService.getCartItemsService(userId);

	    ApiResponse<List<Cart>> apiResponse = new ApiResponse<>( true,"Cart items retrieved successfully",cartItems);

	    return ResponseEntity
	            .status(HttpStatus.OK)
	            .body(apiResponse);
	}


}

















