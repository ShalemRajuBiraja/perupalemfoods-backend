package perupalem.foodsbackend.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import perupalem.foodsbackend.entity.ProductEntity;
import perupalem.foodsbackend.repository.ProductRepository;

@Service
public class GetProductsService {
	
	@Autowired
	ProductRepository productRepository;
	
	public List<ProductEntity> getAllProducts() {
		
		 return productRepository.findAll();
	}

}
