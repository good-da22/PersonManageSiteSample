package com.person.sample.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.person.sample.dto.PersonDto;
import com.person.sample.dto.UserDto;
import com.person.sample.model.service.PersonService;
import com.person.sample.model.service.PersonServiceImpl;
import com.person.sample.model.service.UserService;
import com.person.sample.model.service.UserServiceImpl;

@WebServlet("/main")
public class PersonController extends HttpServlet {

	private PersonService personService = PersonServiceImpl.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		
		String path = req.getContextPath() + "/index.jsp";
		RequestDispatcher disp = null;
		
		switch (action) {
		case "regist":
			path = regist(req);
			disp = req.getRequestDispatcher(path);
			disp.forward(req, resp);
			break;
		
		case "list":
			path = list(req);
			disp = req.getRequestDispatcher(path);
			disp.forward(req, resp);
			break;
			
		case "detail":
			path = detail(req);
			disp = req.getRequestDispatcher(path);
			disp.forward(req, resp);
			break;
		
		case "remove":
			path = remove(req);
			resp.sendRedirect(path);
			break;

		default:
			resp.sendRedirect(path);
			break;
		}
	}
	private String remove(HttpServletRequest req) {

		try {
			String personId = req.getParameter("personid");
			personService.remove(personId);
			return req.getContextPath() + "/main?action=list";
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return req.getContextPath() + "/error/error.jsp";
	}

	private String detail(HttpServletRequest req) {
		PersonDto personDto = null;
		
		try {
			String personId = req.getParameter("personid");
			personDto = personService.detail(personId);
			req.setAttribute("person", personDto);
			return "./detail_result.jsp";
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "./error/error.jsp";
	}

	private String list(HttpServletRequest req) {
		List<PersonDto> list = null;
		
		try {
			list = personService.list();
			req.setAttribute("list", list);
			return "./list_result.jsp";
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "./error/error.jsp";
	}

	private String regist(HttpServletRequest req) {
		PersonDto personDto = new PersonDto();
		
		personDto.setId(req.getParameter("personId"));
		personDto.setName(req.getParameter("name"));
		personDto.setDepartmentName(req.getParameter("departmentName"));
		personDto.setPay(req.getParameter("pay"));
		
		try {
			int cnt = personService.regist(personDto);
			req.setAttribute("cnt", cnt);
			return "./regist_result.jsp";
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "./error/error.jsp";

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		doGet(req, resp);
	}
}
