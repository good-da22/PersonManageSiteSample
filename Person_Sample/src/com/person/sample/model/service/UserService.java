package com.person.sample.model.service;

import javax.servlet.http.HttpServletRequest;

import com.person.sample.dto.UserDto;

public interface UserService {

	void login(HttpServletRequest req, UserDto userDto);

	void logout(HttpServletRequest req, UserDto userDto);

}
