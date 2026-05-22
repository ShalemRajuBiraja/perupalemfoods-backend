package perupalem.foodsbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import perupalem.foodsbackend.entity.Order;
import perupalem.foodsbackend.pojo.OrderData;
import perupalem.foodsbackend.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	OrderRepository orderRepository;
	
	public Object placeOrder(OrderData orderData) {
		
		Order order = new Order();
		order.setProductId(orderData.getProductId());
		order.setProductName(orderData.getProductName());
		order.setProductPrice(orderData.getPrice());
		order.setProductQuantity(orderData.getQuantity());
	
	return orderRepository.save(order);
		
		
		
	}

}
