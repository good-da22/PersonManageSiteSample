package com.person.sample.model.service;

import java.sql.SQLException;
import java.util.List;

import com.person.sample.dto.PersonDto;
import com.person.sample.model.dao.PersonDao;
import com.person.sample.model.dao.PersonDaoImpl;

public class PersonServiceImpl implements PersonService {

	private PersonDao personDao = PersonDaoImpl.getInstance();
	
	private static PersonService instace = new PersonServiceImpl();
	
	private PersonServiceImpl() {}
	
	public static PersonService getInstance() {
		return instace;
	}

	@Override
	public int regist(PersonDto personDto) throws Exception {
		return personDao.insert(personDto);
	}

	@Override
	public List<PersonDto> list() throws Exception {
		return personDao.selectAll();
	}

	@Override
	public PersonDto detail(String personId) throws Exception {
		return personDao.select(personId);
	}

	@Override
	public void remove(String personId) throws Exception {
		personDao.delete(personId);
	}

}
