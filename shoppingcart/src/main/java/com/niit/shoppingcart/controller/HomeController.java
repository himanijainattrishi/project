package com.niit.shoppingcart.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.domain.User;
import com.niit.shoppingcart.dao.CartDAO;
import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.domain.Category;
import com.niit.shoppingcart.domain.MyCart;
import com.niit.shoppingcart.domain.Product;
import com.niit.shoppingcart.domain.Supplier;

@Controller
public class HomeController {
	
	@Autowired
	private CartDAO cartDAO;

	@Autowired
	private MyCart cart;
	
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private Category category;
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private Product product;
	
	@Autowired
	private SupplierDAO supplierDAO;
	
	@Autowired
	private Supplier supplier;
	
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private User user;
	
	
	@Autowired
	private HttpSession session;
	
	@RequestMapping("/")
	public ModelAndView showhomepage()
	{
		ModelAndView mv = new ModelAndView("/Home");
		
		mv.addObject("msg", "welcome to Shopping Cart");
		session.setAttribute("category", category);
		session.setAttribute("product", product);
		session.setAttribute("supplier", supplier);
		
		session.setAttribute("user", user);
		session.setAttribute("categoryList", categoryDAO.list());
		session.setAttribute("productList", productDAO.list());
		session.setAttribute("supplierList", supplierDAO.list());
		
		return mv;
	}
	
	@RequestMapping("/login")
	public ModelAndView showloginpage()
	{
		ModelAndView mv = new ModelAndView("/Home");
		mv.addObject("isuserclickedlogin", "true");
		return mv;
	}
	
	@RequestMapping("/Registration")
	public ModelAndView showRegistrationpage()
	{
		ModelAndView mv = new ModelAndView("/Home");
		mv.addObject("isuserclickedRegister", "true");
		return mv;
	}
	
	@PostMapping("/validate")
	public ModelAndView validatecredentials(@RequestParam("user ID") String id,@RequestParam("password") String password )
	{
		//have to get data from db but temporary we are doing this
		ModelAndView mv = new ModelAndView("/Home");
		
		
		
		
		if(userDAO.validate(id, password)==true)
		{
			
			
			
			user = userDAO.getUser(id);
			
			if(user.getRole().equals("ROLE_ADMIN"))
			{
				mv.addObject("isAdmin", "true");
			}
			else
			{
				
				mv.addObject("isAdmin", "false");
			}
			
			mv.addObject("successmessage", "valid credentials");
			session.setAttribute("loginmessage", "welcome :"+id);
			
			session.setAttribute("loggedInUser", user);
			
		
		}
		else
		{
			mv.addObject("errormessage", "invalid credentials try again");
		}
		return mv;
	}
	@RequestMapping("/logout")
	public ModelAndView logout()
	{
		ModelAndView mv=new ModelAndView("/Home");
		//session.invalidate();
		session.removeAttribute("loginmessage");
		return mv;
	}
	

	
	@RequestMapping("/cart")
	public ModelAndView showCartPage()
	{
		
		ModelAndView modelAndView = new ModelAndView("/Home");
		modelAndView.addObject("isUserclickedcart", "true");
		
		
		return modelAndView;
	}
	
	@RequestMapping("/AboutUs")
	public ModelAndView aboutus()
	{
		ModelAndView mv = new ModelAndView("/Home");
		mv.addObject("isUserclickedaboutus", "true");
		return mv;
	}
	
	@RequestMapping("/Home")
	public ModelAndView  rediecttohome(){
		
	ModelAndView mv = new ModelAndView("/Home");
	
	mv.addObject("msg", "welcome to Shopping Cart");
	session.setAttribute("category", category);
	session.setAttribute("product", product);
	session.setAttribute("supplier", supplier);
	
	session.setAttribute("user", user);
	session.setAttribute("categoryList", categoryDAO.list());
	session.setAttribute("productList", productDAO.list());
	session.setAttribute("supplierList", supplierDAO.list());
	
	return mv;
}
	
	


	

}