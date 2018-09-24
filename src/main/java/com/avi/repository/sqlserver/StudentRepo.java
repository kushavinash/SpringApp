package com.avi.repository.sqlserver;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.avi.model.sqlserver.Student;
import com.avi.utils.QueryConstants;


public interface StudentRepo  extends CrudRepository<Student, Long> {
	
	     @Query(value=QueryConstants.FIND_STUDENT_BY_STUDENTID_QUERY ,nativeQuery=true)
        Student	findStudentById(@Param ("studentId") long studentId);

	
}
