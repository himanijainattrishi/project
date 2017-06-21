package com.niit.activity.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.niit.activity.dao.UsersDAO;
import com.niit.activity.model.Error;
import com.niit.activity.model.User;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class UserController {
	@Autowired
    User user;
	
	
	@Autowired
	UsersDAO userDAO; 
	
	@RequestMapping(value = "/register/",method=RequestMethod.POST, produces= "application/json")
	public ResponseEntity<User> createUser(@RequestBody User user){
		
		userDAO.saveUser(user);
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST , produces= "application/json" )
	public ResponseEntity<?> login(@RequestBody @Valid User user,HttpSession session){
		
		User validUser=userDAO.login(user);
		if(validUser==null){                        
			Error error =new Error(3,"Unauthorized user.. Please enter valid username  and  password..");
			return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
		}
		else{

		/*	validUser.setOnline(true);
			userDao.updateUser(validUser);

			session.setAttribute("user", validUser);*/
			return new ResponseEntity<User>(validUser,HttpStatus.OK);
			}
		}
	@RequestMapping(value="/logout",method=RequestMethod.PUT)
	public ResponseEntity<?> logout(HttpSession session){
		User user=(User)session.getAttribute("user");
		if(user==null){                              //Unauthorized user
			Error error =new Error(3,"Unauthorized user.. Please Login..");
			return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
		}
		else{
			//user=userDao.getUser(user.getId());
			//user.setOnline(false);
			//userDao.updateUser(user);
			session.removeAttribute("user");
			session.invalidate();
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}
}