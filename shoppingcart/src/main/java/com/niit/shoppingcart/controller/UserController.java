package com.niit.shoppingcart.controller;
import java.util.List;
import java.security.Principal;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageContext;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.niit.shoppingcart.dao.CartDAO;
import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.domain.MyCart;
import com.niit.shoppingcart.domain.Address;
import com.niit.shoppingcart.domain.Category;
import com.niit.shoppingcart.domain.Item;
import com.niit.shoppingcart.domain.Product;
import com.niit.shoppingcart.domain.Supplier;
import com.niit.shoppingcart.domain.User;
import com.niit.shoppingcart.domain.Address;
@Controller
public class UserController {
	

	@Autowired
	private UserDAO userDAO;
	

	@Autowired
	private User user;

	@Autowired
	private CartDAO cartDAO;

	@Autowired
	private MyCart myCart;

	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private Category category;

	@Autowired
	private SupplierDAO supplierDAO;

	@Autowired
	private Supplier supplier;
	
	@Autowired
	private ProductDAO productDAO;
	
	/*@Autowired
	private Product product;*/

	
	@Autowired
	private HttpSession session;
	
	
	
	
	
	/*@RequestMapping("/logout")
	public ModelAndView logout() {
		
		ModelAndView mv = new ModelAndView("/Home");
		session.invalidate(); // will remove the attributes which are added
								// session
		session.setAttribute("category", category);
		session.setAttribute("categoryList", categoryDAO.list());

		mv.addObject("logoutMessage", "You successfully logged out");
		mv.addObject("loggedOut", "true");
		
	   
		return mv;
	}*/
	
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView registerUser(@ModelAttribute User user) {
		
		ModelAndView mv = new ModelAndView("/Home");
		if (userDAO.getUser(user.getId()) == null) {
			user.setRole("ROLE_USER"); // all the users are end users by default
			userDAO.save(user);
			
			mv.addObject("successMessage", "You are successfully registered");
		} else {
			
			mv.addObject("errorMessage", "User exist with this id");
		}
	
		return mv;
	}
	
	@RequestMapping(value = "/loginError", method = RequestMethod.GET)
	public String loginError(Model model) {
		
		model.addAttribute("errorMessage", "Invalid Credentials.  Please try again.");
		
		return "Home";

	}
	
	@RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
	public String accessDenied(Model model) {
		
		model.addAttribute("errorMessage", "You are not authorized to access this page");
		
		return "Home";

	}

	@RequestMapping(value="/product1")
	  public String Product(Model m)
	  {
		  
		  ModelAndView model=new ModelAndView("product1");
		  Gson gson = new Gson();
			 
			
			List<Product> list=productDAO.list();
			
		  // String json = new Gson().toJson(list );
		     // System.out.println("json values is" +json);
		      m.addAttribute("list",list);
		      /*  model.addObject("access",json);*/
		     return "product1"; 
	  }
	public Product initFlow(){
		return product;
	}
	List<Item> cart = null;
	
	@RequestMapping("/order")
	 public String Order() {
          return "redirect:/memberShip";
    }
	Product product;
	@RequestMapping(value="/productdetails")
	public ModelAndView productdetails(@ModelAttribute("product") Product product)
	{
		this.product=product;
		ModelAndView model=new ModelAndView("productdetails");
		
		  return model;
	}

	Address address;
	public String insertaddress(Address address,MessageContext messageContext) {
	this.address=address;
		String str=this.userDAO.insertaddress(address);
		return str;
	
	}
	
	
	
	public Address getadd()
	{
		return address;
	}
}



