package perupalem.foodsbackend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import perupalem.foodsbackend.entity.Cart;


public interface CartRepository extends JpaRepository<Cart, Integer> {
	
	Optional<Cart> findByUserIdAndProductId(int userId, int productId);

}
