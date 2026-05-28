package perupalem.foodsbackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import perupalem.foodsbackend.entity.OrderEntity;
import perupalem.foodsbackend.pojo.OrderData;
import perupalem.foodsbackend.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	OrderRepository orderRepository;
	
	public Object placeOrder(OrderData orderData) {
		
		OrderEntity order = new OrderEntity();
		order.setUserId(orderData.getUserId());
		order.setProductId(orderData.getProductId());
		order.setProductName(orderData.getProductName());
		order.setProductPrice(orderData.getPrice());
		order.setProductQuantity(orderData.getQuantity());
	
			return orderRepository.save(order);
	}
	
	
	public List<OrderEntity> getOrdersService(int userId) {

        return orderRepository.findByUserId(userId);
	}
	
	
	@Transactional
	public void deleteOrder(int orderId) {
		
		orderRepository.deleteById(orderId);
	}
	
	
}
