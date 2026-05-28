package perupalem.foodsbackend.repository;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import perupalem.foodsbackend.entity.OrderEntity;



public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {
	
	List<OrderEntity> findByUserId(int userId);
	

}
