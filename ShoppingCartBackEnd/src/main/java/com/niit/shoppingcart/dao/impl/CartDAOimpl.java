package com.niit.shoppingcart.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.niit.shoppingcart.domain.MyCart;
import com.niit.shoppingcart.dao.CartDAO;

@Transactional
@Repository("cartDAO")
public class CartDAOimpl implements CartDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public List<MyCart> list(String userID) {
		
		String hql = "from MyCart where userID=" + "'" + userID + "'  and status = " + "'N'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		return query.list();
	}

	public MyCart get(String id) {
		return(MyCart)sessionFactory.getCurrentSession().get(MyCart.class,id);
	}

	public boolean save(MyCart myCart) {
		try {
			myCart.setId(1);
			sessionFactory.getCurrentSession().save(myCart);;
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}

	public boolean delete(MyCart myCart) {
		myCart.setStatus('X');
		return update(myCart);
	}

	public boolean update(MyCart myCart) {
		try {
			sessionFactory.getCurrentSession().update(myCart);
			
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			
			return false;
		}
	}

	public Long getTotalAmount(String userID) {
     String hql = "select sum(price) from MyCart where userID=" + "'" + userID + "' " + "  and status = " + "'N'";
		

		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		return (Long) query.uniqueResult();
   
	}
	
	

	

	
}
