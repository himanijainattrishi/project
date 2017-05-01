package com.niit.shoppingcart.controller;

import org.springframework.stereotype.Controller;
import java.util.Collection;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.niit.shoppingcart.dao.CartDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.domain.MyCart;
import com.niit.shoppingcart.domain.Product;
@Controller
public class CartController {
	
	Logger log = LoggerFactory.getLogger(CartController.class);
	@Autowired
	private CartDAO cartDAO;

	@Autowired
	private MyCart myCart;

	
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private Product product;

	@RequestMapping(value = "/myCart", method = RequestMethod.POST)
	public String cart(Model model) {
		
		model.addAttribute("cart", new MyCart());
		// get the logged-in user id
		String loggedInUserid = (String) session.getAttribute("loggedInUserID");

		/*if (loggedInUserid == null) {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			loggedInUserid = auth.getName();
			Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>)   auth.getAuthorities();
			authorities.contains("ROLE_USER");
			
		}*/
		if(loggedInUserid!=null)
		{

		int cartSize = cartDAO.list(loggedInUserid).size();

		if (cartSize == 0) {
			model.addAttribute("errorMessage", "You do not have any products in your Cart");
		} else {
			model.addAttribute("cartList", cartDAO.list(loggedInUserid));
			model.addAttribute("totalAmount", cartDAO.getTotalAmount(loggedInUserid));
			model.addAttribute("displayCart", "true");
			model.addAttribute("cart",myCart);

		}
		
		}
		return "/Home";
	}

	// For add and update myCart both
	@RequestMapping(value = "/myCart/add/{id}", method = RequestMethod.POST)
	public ModelAndView addToCart(@PathVariable("id") int id) {
		log.debug("Starting of the method addToCart");
		// get the product based on product id
		Product product = productDAO.getProductBYID(id);
		myCart.setPrice(product.getPrice());
		myCart.setProductName(product.getName());
		String userID = (String) session.getAttribute("loggedInUserID");
		/*if (userID == null) {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			userID = auth.getName();
		}*/
		myCart.setUserID(userID);
		//It is not required if you given default value while creating the table
		myCart.setStatus('N'); // Status is New. Once it is dispatched, we can
								// changed to 'D'
		
		//To get sequence number, you can do programmatically in DAOImpl
		//myCart.setId(ThreadLocalRandom.current().nextLong(100, 1000000 + 1));

		
		cartDAO.save(myCart);
		// return "redirect:/view/Home.jsp";

		ModelAndView mv = new ModelAndView("redirect:/Home");
		mv.addObject("successMessage", " Successfuly add the product to myCart");
		log.debug("Ending of the method addToCart");
		return mv;

	}	

	
	/*@RequestMapping("/displayPage/{id}")
	public String getSelectedProduct(@PathVariable("id") String id,Model model)
			throws Exception {
		System.out.println("hello");
		product = productDAO.getProductBYID(id);
       model.addAttribute("product", product);
		
		return "displayPage";
	}*/
	
	
	

	

	
	

}
