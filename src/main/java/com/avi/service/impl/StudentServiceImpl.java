package com.avi.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.avi.dao.StudentDAO;
import com.avi.dto.StudentDTO;
import com.avi.model.sqlserver.Student;
import com.avi.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	StudentDAO studentDAO;
	
	
	public Student saveStudent(Student student) throws Exception {
		
	   return studentDAO.saveStudent(student)	;
	}
	


	public List<Student> getStudent(Long Id) throws Exception {
		// TODO Auto-generated method stub
		List<StudentDTO> StudentDTOList=new ArrayList();;
		List<Student> studentList =studentDAO.getStudent(Id);
	
		studentList.forEach(st ->{
			StudentDTO studentDTO = new StudentDTO();
			
			studentDTO.setStudentId(st.getStudentId());
			studentDTO.setStudentName(st.getStudentName());
			StudentDTOList.add(studentDTO);
			
		});
	
		
		return studentList;
	}



	@Override
	public List<Student> getStudentALl() throws Exception {
		List<Student> studentList =studentDAO.getStudentAll();
		return studentList;
	}


}
