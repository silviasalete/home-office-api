package com.homeoffice.api.service;

import com.homeoffice.api.model.User;
import com.homeoffice.api.web.dto.UserRegistrationDto;

public interface UserService {

	User save(UserRegistrationDto userRegistrationDto);
	User findById(Long id);
	
}
