package com.person.sample.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.person.sample.dto.PersonDto;
import com.person.sample.util.DBUtil;

public class PersonDaoImpl implements PersonDao {
	
	private DBUtil dbUtil = DBUtil.getInstance();
	
	private static PersonDao instance = new PersonDaoImpl();

	private PersonDaoImpl() {}
	
	public static PersonDao getInstance() {
		return instance;
	}

	@Override
	public int insert(PersonDto personDto) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = dbUtil.getConnection();
			
			StringBuilder sb = new StringBuilder();
			
			sb.append("INSERT INTO person (id, name, department_name, pay) \n").append("VALUES (?, ?, ?, ?) \n");
			String sql = sb.toString();
			
			pstmt = conn.prepareStatement(sql);
	
			int idx = 0;
			pstmt.setString(++idx, personDto.getId());
			pstmt.setString(++idx, personDto.getName());
			pstmt.setString(++idx, personDto.getDepartmentName());
			pstmt.setString(++idx, personDto.getPay());
			
			int cnt = pstmt.executeUpdate();
			
			if(cnt == 0) {
				throw new SQLException();
			} else {
				return cnt;
			}
			
		} finally {
			dbUtil.close(pstmt, conn);
		}
	}

	@Override
	public List<PersonDto> selectAll() throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = dbUtil.getConnection();
			
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT id, name, department_name, pay \n").append("FROM person \n");
			
			String sql = sb.toString();			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			List<PersonDto> list = new ArrayList<>();
			while(rs.next()) {
				PersonDto personDto = new PersonDto();
				
				personDto.setId(rs.getString("id"));
				personDto.setName(rs.getString("name"));
				personDto.setDepartmentName(rs.getString("department_name"));
				personDto.setPay(rs.getString("pay"));
				
				list.add(personDto);
			}
			
			return list;
			
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
	}

	@Override
	public PersonDto select(String personId) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = dbUtil.getConnection();
			
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT id, name, department_name, pay \n").append("FROM person \n").append("WHERE id = ? \n");
			
			String sql = sb.toString();			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, personId);
			rs = pstmt.executeQuery();
			
			PersonDto personDto = null;
			if(rs.next()) {
				personDto = new PersonDto();
				
				personDto.setId(rs.getString("id"));
				personDto.setName(rs.getString("name"));
				personDto.setDepartmentName(rs.getString("department_name"));
				personDto.setPay(rs.getString("pay"));
			}
			
			return personDto;
			
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
	}

	@Override
	public void delete(String personId) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = dbUtil.getConnection();
			
			StringBuilder sb = new StringBuilder();
			
			sb.append("DELETE FROM person \n").append("WHERE id = ? \n");
			String sql = sb.toString();
			
			pstmt = conn.prepareStatement(sql);
	
			pstmt.setString(1, personId);

			int cnt = pstmt.executeUpdate();
			
			if(cnt == 0) {
				throw new SQLException();
			}
			
		} finally {
			dbUtil.close(pstmt, conn);
		}
	}

}
