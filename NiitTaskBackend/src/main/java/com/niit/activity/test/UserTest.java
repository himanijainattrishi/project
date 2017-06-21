package com.niit.activity.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.activity.dao.UsersDAO;
import com.niit.activity.model.User;

public class UserTest {
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		
		context.scan("com.niit.activity");
		context.refresh();
		
		User user = (User)context.getBean("user");
		user.setEmail("pankaj@gmail.com");
		user.setMobile("78978979");
		user.setPassword("123445");
		user.setUsername("pankaj");
		UsersDAO dao =(UsersDAO)context.getBean("usersDAO");
		dao.saveUser(user);
		
		System.out.println("Bean Creayed");
		
		context.close();
	}

}
