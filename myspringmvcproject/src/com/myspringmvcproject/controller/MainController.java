package com.myspringmvcproject.controller;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.myspringmvcproject.model.Product;
import com.myspringmvcproject.service.ProductService;

@Controller
public class MainController {

	@Autowired //<-- injecting dependency through @Autowire
	ProductService productService;
	
	@RequestMapping("/")
	public String showHome(Model model) { //Dependency Injection (DI)
		model.addAttribute("dateVal", LocalDate.now()); 
		return "home"; //prefix: /WEB-INF/jsps/    suffix: .jsp
	}
	
	@RequestMapping("/products")
	public String showProducts(HttpServletRequest request) {
		//we reach out to DB, fetch all products data and pass on to jsp file
		List<Product> list =  productService.getAllProducts();
		request.setAttribute("productList", list);
		return "products";
	}
	
	@RequestMapping("/contact")
	public ModelAndView showContact(ModelAndView mav) {
		mav.addObject("dateVal", LocalDate.now());
		mav.setViewName("contact");
		return mav;
	}
	
	@RequestMapping("/about")
	public String showAboutUs() {
		return "about";
	}
	
	@RequestMapping("/show-add-product")
	public String showProductForm() {
		return "add-product";
	}
	
	@RequestMapping("/add-product")
	public String addProduct(@RequestParam("title") String title,
						   @RequestParam("price") double price,
						   @RequestParam("vendor") String vendor, 
						   Product product) {
		product.setTitle(title);
		product.setPrice(price);
		product.setVendor(vendor);
		
		productService.insertProduct(product);
		return "redirect:/products";
	}
	
	@RequestMapping("/delete-product")
	public String deleteProduct(@RequestParam("pid") int pid) {
		productService.deleteProduct(pid);
		return "redirect:/products?msg=product deleted";
	}
}
















