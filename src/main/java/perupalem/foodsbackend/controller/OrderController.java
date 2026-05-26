package perupalem.foodsbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import perupalem.foodsbackend.entity.OrderEntity;
import perupalem.foodsbackend.payload.ApiResponse;
import perupalem.foodsbackend.pojo.OrderData;
import perupalem.foodsbackend.service.OrderService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class OrderController {
	
	@Autowired
	OrderService orderService;
	

	@PostMapping("/placeOrder")
	public Object placeOrder( @Valid @RequestBody OrderData orderData) {
		
		
		Object orderResponseObject = orderService.placeOrder(orderData);
		
		return orderResponseObject;
	}
	
	
	@GetMapping("/getOrders/{userId}")
	public ResponseEntity<ApiResponse<List<OrderEntity>>> handleGetOrders( @PathVariable int userId) {

	    List<OrderEntity> orders = orderService.getOrdersService(userId);

	    ApiResponse<List<OrderEntity>> apiResponse = new ApiResponse<>(true, "Orders fetched successfully",orders);

	    return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
	}
}
