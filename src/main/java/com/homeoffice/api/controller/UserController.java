package com.homeoffice.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homeoffice.api.dto.UserDto;
import com.homeoffice.api.model.User;
import com.homeoffice.api.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {
	
	@Autowired
	private UserService userService;

	@GetMapping
	public String helloWord() {
		return "Hello World";
	}
	
	@PostMapping("/save")
	public User save(@RequestBody UserDto userDto) {
		System.out.println("Chamou...save");
		return userService.save(userDto);
	}
}
