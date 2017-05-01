package com.niit.shoppingcart.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.domain.*;

@Transactional
@Repository("userDAO")
public class UserDAOimpl implements UserDAO{
	@Autowired
	private SessionFactory sessionFactory;
	
	

	public List<User> list() {
		return sessionFactory.getCurrentSession().createQuery("from User").list();
	}

	public User getUser(String id) {
		return  (User)sessionFactory.getCurrentSession().get(User.class, id);
	}

	public boolean save(User user) {
		try{
			sessionFactory.getCurrentSession().save(user);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(User user) {
		try{
			sessionFactory.getCurrentSession().update(user);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	public boolean validate(String id, String password) {
		String hql= "from User where id='"+id+ "'and password = '"+password+"'";
		if(sessionFactory.getCurrentSession().createQuery(hql).uniqueResult()==null)
		{
			return false;
		}
		return true;
	}

	public String insertaddress(Address address) {
		Session session=sessionFactory.getCurrentSession();
		session.save(address);		
		System.out.println("User DAO");
		return "success";
	}

}
