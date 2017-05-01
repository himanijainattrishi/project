package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.domain.Product;


public interface ProductDAO {
	
	public List<Product> list();
	
	
	public boolean save (Product product);
	
	public boolean update (Product product);
	
	public boolean delete(int id);
	
	public boolean delete(Product product);
	
	public Product getProductBYID(int id);
	
	public Product getProductBYNAME(String name);
	


}
