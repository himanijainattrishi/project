package com.niit.shoppingcart.testcase;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.CartDAO;
import com.niit.shoppingcart.domain.MyCart;

public class CartTestCase {
	
	@Autowired
	private static AnnotationConfigApplicationContext context;
	
	@Autowired
	private static MyCart myCart;
	
	@Autowired
	private static CartDAO cartDAO;
	
	@BeforeClass
	public static void init()
	{
	    context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		myCart = (MyCart) context.getBean("myCart");
		
		cartDAO = (CartDAO) context.getBean("cartDAO");
		
	}
	
	 @Test
	public void createCartTestCase()
	{
		myCart.setId(1);
		myCart.setUserID("niit");
		myCart.setProductName("MAC_Beauty");
		myCart.setPrice(200);
		myCart.setStatus('N');
		
		 boolean flag = cartDAO.save(myCart);
		 
		 //compare what you are excepting VS what you are getting from save method
		 
		 Assert.assertEquals( "createCartTestCase" ,true, flag);
		
		
	}
   

}
