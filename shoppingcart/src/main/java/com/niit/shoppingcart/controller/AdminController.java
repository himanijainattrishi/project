package com.niit.shoppingcart.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.domain.Category;
import com.niit.shoppingcart.domain.Product;
import com.niit.shoppingcart.domain.Supplier;


@Controller
public class AdminController {
	
	@Autowired
	Category category;
	
	@Autowired
	CategoryDAO categoryDAO;
	
	@Autowired
	Supplier supplier;
	
	@Autowired
	SupplierDAO supplierDAO;
	
	@Autowired
	Product product;
	
	@Autowired
	ProductDAO productDAO;
	
	
	

	@RequestMapping("/manage_categories")
	public ModelAndView managecategories()
	{
		ModelAndView mv = new ModelAndView("/Admin/AdminHome");
		
		mv.addObject("isUserClickedCategories", "true");
		
		List<Category> categoryList=categoryDAO.list();
		mv.addObject("categoryList", categoryList);
		mv.addObject("category", category);
		
		return mv;
	}
	
	@RequestMapping("/manage_products")
	public ModelAndView manageproducts()
	{
		ModelAndView mv = new ModelAndView("/Admin/AdminHome");
		
		mv.addObject("isUserClickedProducts", "true");
		
		List<Product> productList=productDAO.list();
		mv.addObject("productList", productList);
		mv.addObject("product", product);
		return mv;
	}
	
	@RequestMapping("/manage_suppliers")
	public ModelAndView managesuppliers()
	{
		ModelAndView mv = new ModelAndView("/Admin/AdminHome");
		
		mv.addObject("isUserClickedSuppliers", "true");
		
		List<Supplier> supplierList=supplierDAO.list();
		mv.addObject("supplierList", supplierList);
		mv.addObject("supplier", supplier);
		
		return mv;
	}
}
