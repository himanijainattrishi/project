package com.niit.shoppingcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.domain.Category;
import com.niit.shoppingcart.domain.Supplier;

@Controller
public class SupplierController {
	
	@Autowired
	private SupplierDAO supplierDAO;
	
	@Autowired
	private Supplier supplier;
	
	String k;
	
	@RequestMapping(value = "/manage_supplier_add", method = RequestMethod.POST)
	public String addSupplier(@ModelAttribute ("supplier") Supplier supplier, Model model) {
				System.out.println("abc is" +k);
		
		if(supplier.getId()!= null)
		{
			supplierDAO.save(supplier);
		}
	
		
		
		else
		{
			supplier.setId(k);
			supplierDAO.update(supplier);
            model.addAttribute("msg", "updated the supplier");}
		
		model.addAttribute("supplier", supplier);
		model.addAttribute("supplierList", supplierDAO.list());
		model.addAttribute("isAdminClickedSuppliers", "true");
	
		return "redirect:/manage_suppliers";
	}

	@RequestMapping(value = "/manage_supplier_delete/{id}")
	public String deleteSupplier(@PathVariable("id") String id, Model model) throws Exception {
		System.out.println("supplier id is" + id);
		try {
			supplierDAO.delete(id);
			model.addAttribute("message", "Successfully removed");
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			e.printStackTrace();
		}

		return "redirect:/manage_suppliers";
	}

	@RequestMapping(value = "/manage_supplier_edit/{id}")
	public String editSupplier(@PathVariable("id") String id, Model model) throws Exception {
		
		k=id;
		supplier = supplierDAO.getSupplierByID(id);
		
		model.addAttribute("supplier", supplier);
		model.addAttribute("supplierList", supplierDAO.list());
		model.addAttribute("isAdminClickedSuppliers", "true");
		return "Admin/supplier";
	}

}
