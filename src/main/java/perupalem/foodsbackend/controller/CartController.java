package perupalem.foodsbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
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
	
	

}





















