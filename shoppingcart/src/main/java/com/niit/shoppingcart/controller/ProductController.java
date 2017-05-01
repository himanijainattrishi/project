package com.niit.shoppingcart.controller;








import java.io.File;
import java.nio.file.Paths;
import java.nio.file.Path;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.PathVariable;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.domain.Category;
import com.niit.shoppingcart.domain.Product;
import com.niit.shoppingcart.domain.Supplier;
import com.niit.shoppingcart.util.FileUtil;
import com.niit.shoppingcart.util.Util;





@Controller
public class ProductController {
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private Product product;
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private Category category;
	
	@Autowired
	private SupplierDAO supplierDAO;
	
	@Autowired
	private Supplier supplier;
	
	private Path path;
	
	int k;
	
	
	@RequestMapping(value = "/manage_product_add")
	public String addProduct(@ModelAttribute("product") Product product, MultipartFile file,
			Model model, HttpServletRequest request) {
		
	 System.out.println("abc is" +k);
		category=categoryDAO.getCategoryByName(product.getCategory().getName());
		supplier = supplierDAO.getSupplierByName(product.getSupplier().getName());
		 
		 product.setCategory(category); 
		 product.setSupplier(supplier);
		 product.setCategory_id(category.getId());
		 product.setSupplier_id(supplier.getId());
		
		 /*product.setId(com.niit.shoppingcart.util.Util.removeComman(product.
		 * getId())); log.debug("id:"+ product.getId()); if
		 * (productDAO.save(product) == true){
		 * 
		 * model.addAttribute("msg",
		 * "Successfully created/updated the product");} else {
		 * model.addAttribute("msg", "not able to create/update the product");}
		 * 
		 //FileUtil.upload(path,file,product.getId()+".jpg");
		 */

		   if(product.getId()!= 0)
		   {
			productDAO.save(product);}
			else
			{
				product.setId(k);
				productDAO.update(product);
	            model.addAttribute("msg", "updated the product");}
			
		
			MultipartFile image = product.getImage();
			String rootDirectory = request.getSession().getServletContext().getRealPath("/");
			path = Paths.get(rootDirectory + "/resources/img/" + product.getName() + ".jpg");
			System.out.println(path);
			if (image != null && !image.isEmpty()) {
				try {
					image.transferTo(new File(path.toString()));
				} catch (Exception ex) {
					ex.printStackTrace();
					throw new RuntimeException("Product image saving failed", ex);
				}
			} 

		
		
		
		return "redirect:/manage_products";
	}

	@RequestMapping(value = "/manage_product_delete/{id}")
	public String deleteProduct(@PathVariable("id") int id, Model model) throws Exception {
		

		try {
			productDAO.delete(id);
			model.addAttribute("message", "Successfully removed");
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			e.printStackTrace();
		}

		return "redirect:/manage_products";
	}

	@RequestMapping(value = "/manage_product_edit/{id}")
	public String editProduct(@PathVariable("id") int id, Model model) throws Exception {
		
		k=id;
		product = productDAO.getProductBYID(id);
       
		model.addAttribute("product", product);
		model.addAttribute("productList", productDAO.list());
		model.addAttribute("isAdminClickedProducts", "true");
		return "/Admin/product";
	}

	
	

	

	
	@RequestMapping("/displayPage/{id}")
	public String getSelectedProduct(@PathVariable("id") int id,Model model)
			throws Exception {
		System.out.println("hello");
		product = productDAO.getProductBYID(id);
       model.addAttribute("product", product);
		
		return "displayPage";
	}
	
	@RequestMapping("/showproduct/{id}")
	public String getselectedproductdetails(@PathVariable("id")int id,Model model)
	{
		product=productDAO.getProductBYID(id);
		model.addAttribute("product", product);
		return "showproduct";
		
	}
	
	
}
