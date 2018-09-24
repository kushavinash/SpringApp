package com.avi.jdbc.template;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class StudentMapper implements RowMapper {

	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		StudentResultSetExtracter extracter = new StudentResultSetExtracter();
		
		return extracter.extractData(rs);		
	
	}

}
