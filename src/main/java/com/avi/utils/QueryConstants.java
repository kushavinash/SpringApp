package com.avi.utils;


/**
 * The Class QueryConstants.
 *
 * @author 
 */
public interface QueryConstants {
		
	 String FIND_STUDENT_BY_STUDENTID_QUERY	=	"SELECT *  FROM  Student s WHERE s.studentId= :studentId";

	 String FIND_USER_QUERY =	" SELECT *  FROM users u WHERE u.user_id= :user_id";
}
