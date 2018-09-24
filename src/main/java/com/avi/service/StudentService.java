package com.avi.service;

import java.util.List;

import com.avi.model.sqlserver.Student;

public interface StudentService {
	
	
	public Student saveStudent(Student student) throws Exception ;
	
	public List<Student> getStudent(Long Id) throws Exception;

	public List<Student> getStudentALl() throws Exception;
}
