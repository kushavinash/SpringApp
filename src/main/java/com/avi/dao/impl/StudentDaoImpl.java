package com.avi.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.avi.dao.StudentDAO;
import com.avi.jdbc.template.StudentMapper;
import com.avi.model.sqlserver.Student;
import com.avi.repository.sqlserver.StudentRepo;

@Repository
public class StudentDaoImpl implements StudentDAO {
	
	
	@Autowired
	JdbcTemplate jdbcTempalate ;
	
	@Autowired
	StudentRepo studentRepo ;
	
	public List<Student> getStudent(Long Id) throws Exception {
	
		Student st =studentRepo.findOne(Id);
		 List<Student> stlst = new ArrayList<>();
		 stlst.add(st);
		return stlst;
	}
	
	
	public Student saveStudent(Student student) throws Exception {
				
		studentRepo.save(student)	;
		Student st =studentRepo.findOne(student.getStudentId());
		return st;
	}
	
	
	public void getStudentWithJdbcTempalate(String name,Integer id){
		
		System.out.println("inserting the data through jdbc tempalate");
		jdbcTempalate.update("insert into student (student_id, student_name) values(?,?)" ,new Object[]{id,name});
			
		
	}
	
public List<Student> getStudentListWithJdbcTempalate(){
		
		System.out.println("inserting the data through jdbc tempalate");
	List<Student>stdlist=	jdbcTempalate.query("select student_id, student_name from student" ,new StudentMapper());
			
		System.out.println("stdlist size--->"+stdlist.size());
		
		return stdlist;
	}


@Override
public List<Student> getStudentAll() throws Exception {
	List<Student>stdlist = new ArrayList<>();
	studentRepo.findAll().forEach(Student ->{
	if(Objects.nonNull(Student))	
	stdlist.add(Student);
	}
			);
	return stdlist ;
}

}
