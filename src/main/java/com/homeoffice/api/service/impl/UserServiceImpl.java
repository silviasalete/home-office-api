package com.homeoffice.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homeoffice.api.dto.UserDto;
import com.homeoffice.api.model.User;
import com.homeoffice.api.repository.UserRepository;
import com.homeoffice.api.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public User save(UserDto userDto) {
		
		return userRepository.save(userDto.toEntity());
	}
	
	

}
