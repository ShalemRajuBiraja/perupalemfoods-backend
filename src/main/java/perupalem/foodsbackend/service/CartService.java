package perupalem.foodsbackend.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import perupalem.foodsbackend.entity.Cart;
import perupalem.foodsbackend.pojo.CartApiData;
import perupalem.foodsbackend.repository.CartRepository;

@Service
public class CartService {
	
	@Autowired
	CartRepository cartRepository;
	
	
	/*
	 * 1. Check if the product already exists in the cart for the user
	 * 2. If it exists, throw an exception or return a message indicating that the product is already in the cart
	 * 3. If it does not exist, create a new Cart entity, set the userId, productId, productName, and price from the CartApiData, and save it to the database using the cartRepository
	 * 4. Return the saved Cart entity or a success message indicating that the product has been added to the cart
	 * 
	 */
	
	
	public Object addToCartService(CartApiData cartApiData) throws Exception {
		
		Optional<Cart> responseOptional = cartRepository.findByUserIdAndProductId(cartApiData.getUserId(), cartApiData.getProductId());	
		
		if(responseOptional.isPresent()) {
			throw new Exception("Product already exists in cart");
		}
		
		Cart cart = new Cart();
		cart.setUserId(cartApiData.getUserId());
		cart.setProductId(cartApiData.getProductId());
		cart.setProductName(cartApiData.getProductName());
		cart.setPrice(cartApiData.getPrice());
		cart.setImageUrl(cartApiData.getImageUrl());
		
		return cartRepository.save(cart);
		}
	
	
	/*
	 * 1. Retrieve all cart items for the user from the database using the cartRepository
	 * 2. Map the retrieved Cart entities to a CartApiData object, which contains a list of cart items with their details (productId, productName, price)
	 * 3. Return the CartApiData object containing the cart items for the user
	 * 
	 */
	public List<Cart> getCartItemsService(int userId) {
		
		return  cartRepository.findByUserId(userId);
	}
	

}
