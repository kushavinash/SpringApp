package com.avi.dao;

import java.util.List;

import com.avi.model.sqlserver.Student;

public interface StudentDAO {
	
	public Student saveStudent(Student student) throws Exception ;
	
	public List<Student> getStudent(Long Id) throws Exception;
	public List<Student> getStudentAll() throws Exception;


}
