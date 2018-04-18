package com.javainterviewpoint;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.JdbcUtils;

public class SinleRowSingleColumnMapper<T> implements RowMapper<T>{
private int index;



	public int getIndex() {
	return index;
}



public void setIndex(int index) {
	this.index = index;
}



	@Override
	public  T mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		return (T)getResultsFromResultSet(rs,index);
		//return null;
	}



	private Object getResultsFromResultSet(ResultSet rs, int index2) throws SQLException {
		// TODO Auto-generated method stub
		return JdbcUtils.getResultSetValue(rs, index2);
	}

}
