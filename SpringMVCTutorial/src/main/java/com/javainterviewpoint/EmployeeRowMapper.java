package com.javainterviewpoint;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class EmployeeRowMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet resultSet, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		return new Employee(resultSet.getInt("id"), resultSet.getString("name"),
				resultSet.getString("address"));
	}

}
