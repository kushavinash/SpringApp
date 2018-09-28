package com.avi.service.impl;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;




@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentServiceImplTest {
		
	@Mock
	private Environment env;

	 @Autowired
	UserServiceImpl UserServiceImpl;
		
	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testLoadAssetCollection() {
		
		//UserServiceImpl =Mockito.mock(UserServiceImpl.class);
		UserServiceImpl.deleteAllUsers();	 
	    verify(UserServiceImpl,times(1)).deleteAllUsers();	
	}

}
