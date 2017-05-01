package com.niit.shoppingcart.testcase;

import static org.junit.Assert.*;

import javax.transaction.Transactional;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.domain.Product;

import junit.framework.Assert;

public class ProductTestCase {
	
	@Autowired
	private static Product product;
	
	@Autowired
	private static ProductDAO productDAO;
	
	@BeforeClass
	public static void init()
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		product = (Product) context.getBean("product");
		
		productDAO = (ProductDAO) context.getBean("productDAO");
		
	}
	
	@Test
	public void createProduct()
	{
		
		product.setName("MAC_Beauty");
		product.setId(1);
		
		
		product.setPrice(200);
		product.setCategory_id("1");
		product.setSupplier_id("13");
		
        boolean flag = productDAO.save(product);
		
		assertEquals("createProductTestCase", true, flag);
		//Assert.assertEquals( "saveTestCase", true, productDAO.save(product));
		
	}
	 
	 /*@Transactional
	   public void updateCategoryTestCase()
	   {
		   
		   product.setId("P01012017");
		   product.setName("sarees");
		   product.setPrice(3000);
		   product.setCategory_id("CG02032017");
		   product.setSupplier_id("so1");
		  
		   
		   boolean flag = productDAO.update(product);
		   
		   Assert.assertEquals( "updateProductTestCase" ,true, flag);
		   
		   
	   }*/
	 
	 
	/* @Test
	   public void deleteProductByIDTestCase()
	   {
		   
		   boolean flag = productDAO.delete("P01012017");
		   
		   Assert.assertEquals("deleteProductBTIDTestCase",true,flag);
		   
		   
		   
	   }
	 
	 @Test
	   public void deleteProduct()
	   {
		   product.setId("P01012017");
		   
		   boolean flag = productDAO.delete(product);
		   
		   Assert.assertEquals( "deleteProductTestCase" ,true, flag);
		   
		   
		   
	   }*/
	 
	 @Test
	   public void getProductByIDTestCase()
	   {
		   
		  product = productDAO.getProductBYID(02);
		  
		  
		 // Assert.assertNotNull("getCategoryByIDTestCase", category);
		  
		  
		  Assert.assertEquals("getProductByIDTestCase", null, product);
		   
	   }
	 
	 @Test
	   public void getProductByNameTestCase()
	   {
		   
		  product = productDAO.getProductBYNAME("apple product");
		  
		  
		 // Assert.assertNotNull("getCategoryByIDTestCase", category);
		  
		  
		  Assert.assertEquals("getCategoryByNameTestCase", null, product);
		   
	   }

	 

}
