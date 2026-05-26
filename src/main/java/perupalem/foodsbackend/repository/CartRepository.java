package perupalem.foodsbackend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import perupalem.foodsbackend.entity.CartEntity;


public interface CartRepository extends JpaRepository<CartEntity, Integer> {
	
	Optional<CartEntity> findByUserIdAndProductId(int userId, int productId);
	List<CartEntity> findByUserId( int userId);

}
