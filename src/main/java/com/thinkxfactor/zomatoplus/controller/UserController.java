package com.thinkxfactor.zomatoplus.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thinkxfactor.zomatoplus.models.User;
import com.thinkxfactor.zomatoplus.repository.UserRepository;

import java.util.*;


@RestController
@RequestMapping("/user")
public class UserController {
	

	

	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/login")
	public User userLogin(@RequestBody String name,String password) {
		User persistedUser=userRepository.findByNameAndPassword(name, password);
		return persistedUser;
	}
	
	@GetMapping("/getAll")
	public List<User> getAll() {
		List <User> listofusers=userRepository.findAll();
		return listofusers;
	}
	
	@PostMapping("/add")
	public User addUser(@RequestBody User user) {
		User persistedUser=userRepository.save(user);
		return persistedUser;
	}
	
}
