/*package com.avi.repository.mysql;

import com.avi.model.mysql.Users;
import com.avi.utils.QueryConstants;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

*//**
 * @author avinash.k
 *
 *//*
@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
  
	@Query( value=QueryConstants.FIND_USER_QUERY,nativeQuery=true) Users findUserByDsId(@Param("user_id") String user_id);
   
}*/