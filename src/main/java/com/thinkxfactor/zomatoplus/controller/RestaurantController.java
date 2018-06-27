package com.thinkxfactor.zomatoplus.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thinkxfactor.zomatoplus.models.Items;
import com.thinkxfactor.zomatoplus.models.Restaurant;
import com.thinkxfactor.zomatoplus.repository.ItemsRepository;
import com.thinkxfactor.zomatoplus.repository.RestaurantRepository;
import java.util.*;


@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
	

	

	
	@Autowired
	private RestaurantRepository restaurantRepository;
	
	@Autowired
	private ItemsRepository itemsRepository;
	
	
	@GetMapping("/getAll")
	public List<Restaurant> getAll() {
		List <Restaurant> listofrestaurants=restaurantRepository.findAll();
		return listofrestaurants;
	}
	
	@PostMapping("/add")
	public Restaurant addRestaurant(@RequestBody Restaurant restaurant) {
		Restaurant persistedRestaurant=restaurantRepository.save(restaurant);
		return persistedRestaurant;
	}
	
	@PostMapping("/addItem")
	public Items addItem(@RequestBody Items item)
	{
		Items persistedItems=itemsRepository.save(item);
		return persistedItems;
	}
	
	@GetMapping("/getAllItems")
	public List<Items> getAllItems() {
		List <Items> listofitems=itemsRepository.findAll();
		return listofitems;
	}
	
	
}
