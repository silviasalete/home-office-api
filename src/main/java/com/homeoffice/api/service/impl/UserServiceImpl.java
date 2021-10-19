package com.homeoffice.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homeoffice.api.model.User;
import com.homeoffice.api.repository.UserRepository;
import com.homeoffice.api.service.UserService;
import com.homeoffice.api.web.dto.UserRegistrationDto;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public User save(UserRegistrationDto userRegistrationDto) {
		return userRepository.save(userRegistrationDto.toEntity(userRegistrationDto));
	}

	@Override
	public User findById(Long id) {
		return userRepository.findById(id).get();
	}
	
	

}
