package com.example.SpringBootOneToMany.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBootOneToMany.entity.Cart;
import com.example.SpringBootOneToMany.entity.Item;

@RestController
public class ShoppingController {

	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	@GetMapping("/carts")
	public List<Cart> getAllCart(){
		return cartRepository.findAll();
	}
	
	
	@GetMapping("/items")
	public List<Item> getAllItem(){
		return itemRepository.findAll();
	}
	
	@PostMapping("/cart")
	public Cart addCart(@RequestBody Cart cart) {
		return cartRepository.save(cart);
	}
	
	
	@PostMapping("/item")
	public Item addItem(@RequestBody Item item) {
		return itemRepository.save(item);

	}
	
	@PutMapping("/add-item-to-cart")
	public String addItemToCart(@RequestParam int cartId, @RequestParam int itemId) {
		Cart cart = cartRepository.findById(cartId).get();
		Item item = itemRepository.findById(itemId).get();
		item.setCart(cart);
		itemRepository.save(item);
		return "cart updated successfully!";
	}
}
