package com.niit.activity.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.activity.model.User;
@Repository(value="usersDAO")
@Transactional
public class UsersDAOImpl implements UsersDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	public boolean saveUser(User users) {
		try {
			sessionFactory.getCurrentSession().save(users);
			System.out.println("save user");
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public User get(int id) {
		return (User)sessionFactory.getCurrentSession().get(User.class, id);
	}
	
	public boolean update(User user1) {
		
		try {
			sessionFactory.getCurrentSession().update(user1);
			
		} catch (HibernateException e) {
			
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	public User authenticate(int id, String password) {
		String hql = "from User where id= '" + id + "' and " + " password ='" + password+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<User> list = query.list();
		if(list == null){
			return null;
		}
		else{
		return list.get(0);
		}
	}
	
	public User login(User user) {
		
		//Session session = sessionFactory.openSession();
		// select * from user_batch15 where username=user.getUsername() and
		// password=user.getPassword()
		//Query query = session.createQuery("from User where username='"+user.getUsername()+"' and password='"+user.getPassword()+"'"); // from user where username='john' and password='123'
		//User validUser = (User) query.uniqueResult();
		//return validUser;
		String query="from User where username='"+user.getUsername()+"' and password='"+user.getPassword()+"'";
		return (User) sessionFactory.getCurrentSession().createQuery(query).uniqueResult();
	}

}
