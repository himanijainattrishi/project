package com.niit.shoppingcart.testcase;


import static org.junit.Assert.*;

import javax.transaction.Transactional;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.domain.Product;
import com.niit.shoppingcart.domain.User;

import junit.framework.Assert;

public class UserTestCase {
	
	@Autowired
	private static User user;
	
	@Autowired
	private static UserDAO userDAO;
	
	
	@BeforeClass
	public static void init()
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		user = (User) context.getBean("user");
		
		userDAO = (UserDAO) context.getBean("userDAO");
		
	
	

}
	
	
	
	 @Test
		public void createUserTestCase()
		{
			user.setId("niit");
			user.setName("niit");
			user.setPassword("niit123");
			user.setContact("9891145447");
			user.setMail("niit@gmail.com");
			user.setRole("ROLE_USER");
			
			 boolean flag = userDAO.save(user);
					 //compare what you are excepting VS what you are getting from save method
			 
			 Assert.assertEquals( "createProductTestCase" ,true, flag);
			
			
		}
	 
	 /*@Test
	   public void updateUserTestCase()
	   {
		   
		   user.setId("U0");
		   user.setName("niit");
		   user.setMail("niit@gmail.com");
		   user.setPassword("niit@123");
		   user.setContact("7011013025");
		   user.setRole("Admin");
		   
		  
		   
		   boolean flag = userDAO.update(user);
		   
		   Assert.assertEquals( "updateUserTestCase" ,true, flag);
		   
		   
	   }*/
	 
	 
	 
}