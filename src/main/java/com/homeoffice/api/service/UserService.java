package com.homeoffice.api.service;

import com.homeoffice.api.dto.UserDto;
import com.homeoffice.api.model.User;

public interface UserService {
	
	User save(UserDto userDto);
}
