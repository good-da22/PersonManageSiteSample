package com.person.sample.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.person.sample.dto.PersonDto;

public interface PersonDao {

	int insert(PersonDto personDto) throws SQLException;

	List<PersonDto> selectAll() throws SQLException;

	PersonDto select(String personId) throws SQLException;

	void delete(String personId) throws SQLException;

}
