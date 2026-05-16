package perupalem.foodsbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import perupalem.foodsbackend.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
