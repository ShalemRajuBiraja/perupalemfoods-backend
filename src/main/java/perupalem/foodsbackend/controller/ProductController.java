package perupalem.foodsbackend.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import perupalem.foodsbackend.entity.Product;
import perupalem.foodsbackend.service.GetProductsService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class ProductController {
	
	@Autowired
	GetProductsService getProductsService;
	
	
	
	@GetMapping("/getProducts")
	public List<Product> getProducts() {
		
		List<Product> productsList = getProductsService.getAllProducts();
		return productsList;
	}

}
