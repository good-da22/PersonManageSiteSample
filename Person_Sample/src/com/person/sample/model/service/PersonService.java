package com.person.sample.model.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.person.sample.dto.PersonDto;

public interface PersonService {

	int regist(PersonDto personDto) throws Exception;

	List<PersonDto> list() throws Exception;

	PersonDto detail(String personId) throws Exception;

	void remove(String personId) throws Exception;

}
