package com.person.sample.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.person.sample.dto.UserDto;
import com.person.sample.model.service.UserService;
import com.person.sample.model.service.UserServiceImpl;

@WebServlet("/user")
public class UserController extends HttpServlet{
	
	private UserService userService = UserServiceImpl.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
String action = req.getParameter("action");
		
		String path = req.getContextPath() + "/index.jsp";
		
		switch (action) {		
		case "login":
			path = login(req);
			resp.sendRedirect(path);
			break;
		
		case "logout":
			path = logout(req);
			resp.sendRedirect(path);
			break;

		default:
			resp.sendRedirect(path);
			break;
		}
	}
	
	private String logout(HttpServletRequest req) {
		HttpSession session = req.getSession();
		UserDto userDto = (UserDto) session.getAttribute("userinfo");
		
		userService.logout(req, userDto);
		
		return req.getContextPath() + "/index.jsp";
	}

	private String login(HttpServletRequest req) {
		
		UserDto userDto = new UserDto();
		
		userDto.setUserId(req.getParameter("userid"));
		userDto.setUserPwd(req.getParameter("userpwd"));
		
		userService.login(req, userDto);
		
		return req.getContextPath() + "/index.jsp";
	}

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		doGet(req, resp);
	}
}
