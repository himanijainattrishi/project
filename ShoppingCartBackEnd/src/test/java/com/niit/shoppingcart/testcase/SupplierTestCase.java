package com.niit.shoppingcart.testcase;

import static org.junit.Assert.*;

import javax.transaction.Transactional;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.domain.Supplier;

import junit.framework.Assert;

public class SupplierTestCase {
	
	@Autowired
	private static Supplier supplier;
	
	@Autowired
	private static SupplierDAO supplierDAO;
	
	
	@BeforeClass
	public static void init()
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		supplier = (Supplier) context.getBean("supplier");
		
		supplierDAO = (SupplierDAO) context.getBean("supplierDAO");
		
	}
	
	@Test
	public void createSupplierTestCase()
	{
		supplier.setId("S010120110");
		supplier.setName("raymonds sons");
		supplier.setAddress("chandni chowk");
		
		 boolean flag = supplierDAO.save(supplier);
				 //compare what you are excepting VS what you are getting from save method
		 
		 Assert.assertEquals( "createSupplierTestCase" ,true, flag);
		
		
	}
	
	/* @Transactional
	   public void updateSupplierTestCase()
	   {
		   
		   supplier.setId("S01012019");
		   supplier.setName("raymond sons");
		   supplier.setAddress("ashok nagar");
		   
		  
		   
		   boolean flag = supplierDAO.update(supplier);
		   
		   Assert.assertEquals( "updateProductTestCase" ,true, flag);
		   
		   
	   }*/
	 
	 
	 @Test
	   public void getProductByIDTestCase()
	   {
		   
		  supplier = supplierDAO.getSupplierByID("S01012019");
		  
		  
		 // Assert.assertNotNull("getCategoryByIDTestCase", category);
		  
		  
		  Assert.assertEquals("getSupplierByIDTestCase", null, supplier);
		   
	   }
	 
	 @Test
	   public void getSupplierByNameTestCase()
	   {
		   
		  supplier = supplierDAO.getSupplierByName("raymond sons");
		  
		  
		 // Assert.assertNotNull("getCategoryByIDTestCase", category);
		  
		  
		  Assert.assertEquals("getSupplierByNameTestCase", null, supplier);
		   
	   }


}
