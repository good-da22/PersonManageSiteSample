package com.person.sample.model.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.person.sample.dto.UserDto;

public class UserServiceImpl implements UserService {

	private static UserService instance = new UserServiceImpl();
	
	private UserServiceImpl() {}
	
	public static UserService getInstance() {
		return instance;
	}

	@Override
	public void login(HttpServletRequest req, UserDto userDto) {
		HttpSession session = req.getSession();
		
		String userId = userDto.getUserId();
		String userPwd = userDto.getUserPwd();
		
		if("test".equals(userId) && "1234".equals(userPwd)) {
			session.setAttribute("userinfo", userDto);
		} else {
			session.setAttribute("message", "id와 비밀번호를 확인하세요!");
		}
		
	}

	@Override
	public void logout(HttpServletRequest req, UserDto userDto) {
		
		if(userDto != null) {
			HttpSession session = req.getSession();
			session.removeAttribute("userinfo");
		}
	}
}
