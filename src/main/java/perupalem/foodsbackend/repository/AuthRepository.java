package perupalem.foodsbackend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import perupalem.foodsbackend.entity.UserEntity;


public interface AuthRepository extends JpaRepository<UserEntity, Integer> {

	Optional<UserEntity> findByEmail(String email);
}
