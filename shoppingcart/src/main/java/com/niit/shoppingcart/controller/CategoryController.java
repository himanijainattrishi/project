package com.niit.shoppingcart.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.domain.Category;

import sun.rmi.runtime.Log;

@Controller
public class CategoryController {
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private Category category;
	
	String k;
	
	
	
	@RequestMapping(value="/manage_category_add", method = RequestMethod.POST)
	public String addCategory(@ModelAttribute ("category") Category category, Model model){
		
		System.out.println("abc is" +k);
		/*category.setCid(k);*/
		if(category.getId()!= null)
		{
			categoryDAO.save(category);
		}
	
		
		/*if (categoryDAO.save(category) == true){
		
		model.addAttribute("msg", "Successfully created/updated the category");}*/
		else
		{
			category.setId(k);
			categoryDAO.update(category);
            model.addAttribute("msg", "updated the category");}
		
		model.addAttribute("category", category);
		model.addAttribute("categoryList", categoryDAO.list());
		model.addAttribute("isAdminClickedCategories", "true");
		
		return "redirect:/manage_categories";
	}
	
	@RequestMapping(value = "/manage_category_delete/{id}")
	public String deleteCategory(@PathVariable("id") String id, Model model) throws Exception {
		System.out.println("category id is" + id);
		try {
			categoryDAO.delete(id);
			model.addAttribute("message", "Successfully removed");
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			e.printStackTrace();
		}

		return "redirect:/manage_categories";
	}
		
	
		
	@RequestMapping(value = "/manage_category_edit/{id}")
	public String editSupplier(@PathVariable("id") String id, Model model) throws Exception {
		k=id;
		
		category = categoryDAO.getCategoryByID(id);
		
		model.addAttribute("category", category);
		model.addAttribute("categoryList", categoryDAO.list());
		model.addAttribute("isAdminClickedCategories", "true");
		return "/Admin/Category";
	}

	
		

	
	
	
	

}
