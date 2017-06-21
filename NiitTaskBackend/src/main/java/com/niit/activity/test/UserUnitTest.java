package com.niit.activity.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.activity.dao.UsersDAO;
import com.niit.activity.model.User;

public class UserUnitTest {


	@Autowired 
	static AnnotationConfigApplicationContext context;
	@Autowired
	static UsersDAO userDAO;
	@Autowired 
	static User user;
	
	@BeforeClass
	public static void initialize()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.activity");
		context.refresh();
		userDAO=(UsersDAO)context.getBean("usersDAO");
		user=(User)context.getBean("user");
	}
	@Test
	public void createUserTestCase()
	{
	  user.setEmail("himani@gmail.com");
	  user.setMobile("7887878");
	  user.setPassword("himani");
	  user.setUsername("himani");
	boolean flag=userDAO.saveUser(user);
	assertEquals("createUserTestCase", true,flag);
	
	}
	
	@Test
	public void updateUserTestCase()
	{
		// giving id is mandatory as it is primary key.
		
		user=userDAO.get(1);
		user.setUsername("himanijain");
	
		
		assertEquals( true, userDAO.update(user));
		
	}
	
	
}
