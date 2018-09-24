package com.avi.jdbc.template;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.avi.model.sqlserver.Student;


public class StudentResultSetExtracter implements ResultSetExtractor {

	public Object extractData(ResultSet rs) throws SQLException, DataAccessException {
		Student student = new Student();
		
		student.setStudentId(rs.getInt(1));
		student.setStudentName(rs.getString(2));
		return student;
	}

}
