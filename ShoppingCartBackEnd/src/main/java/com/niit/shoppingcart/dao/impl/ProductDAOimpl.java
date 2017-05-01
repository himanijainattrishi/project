package com.niit.shoppingcart.dao.impl;

import java.util.List;
import java.util.logging.Logger;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.dao.ProductDAO;

import com.niit.shoppingcart.domain.Product;

@Transactional
@Repository("productDAO")
public class ProductDAOimpl implements ProductDAO {
	
	
	
	
	@Autowired
	private SessionFactory sessionFactory;

	public List<Product> list() {
		
		return	sessionFactory.getCurrentSession().createQuery("from Product").list();
	}

	public boolean save(Product product) {
		
		
		
		try
		{
		sessionFactory.getCurrentSession().save(product);
		return true;
		} catch(HibernateException e)
		{
			e.printStackTrace(); 
			return false;
		}
	}

	public boolean update(Product product) {
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
			
		}
	}

	public boolean delete(int id) {
		try {
			sessionFactory.getCurrentSession().delete(getProductBYID(id));
			return true;
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(Product product) {
		try {
			sessionFactory.getCurrentSession().delete(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
			
		}
	}

	public Product getProductBYID(int id) {
		return (Product)	sessionFactory.getCurrentSession().get(Product.class, id);
	}

	public Product getProductBYNAME(String name) {
		
		return	 (Product)sessionFactory.getCurrentSession().createQuery("from Product where name ='"+name+"'").uniqueResult();
	}

}
