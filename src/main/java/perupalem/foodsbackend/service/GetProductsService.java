package perupalem.foodsbackend.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import perupalem.foodsbackend.entity.Product;
import perupalem.foodsbackend.repository.ProductRepository;

@Service
public class GetProductsService {
	
	@Autowired
	ProductRepository productRepository;
	
	public List<Product> getAllProducts() {
		
		 return productRepository.findAll();
	}

}
