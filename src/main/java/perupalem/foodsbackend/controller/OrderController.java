package perupalem.foodsbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
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
	
}
