package com.tonyb650.productscategories.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tonyb650.productscategories.models.Category;
import com.tonyb650.productscategories.models.Product;
import com.tonyb650.productscategories.services.CategoryService;
import com.tonyb650.productscategories.services.ProductService;

import jakarta.validation.Valid;

@Controller
public class MainController {

	@Autowired
	ProductService products;
	
	@Autowired
	CategoryService categories;
	
	
	@GetMapping("")
	public String index(){
		return "redirect:/home";
	}
	
	@GetMapping("/home")
	public String home(Model model) {
		model.addAttribute("products", products.getAllProducts());
		model.addAttribute("categories", categories.getAllCategories());
		return "home.jsp";
	}
	
	@GetMapping("/products/new")
	public String addProduct(@ModelAttribute("product") Product product) {
		return "addproduct.jsp";
	}
	
	@GetMapping("/categories/new")
	public String addCategory(@ModelAttribute("category") Category category) {
		return "addcategory.jsp";
	}
	
	@GetMapping("/products/{id}/assigncategories")
	public String assignCategories(@PathVariable("id") Long id, Model model) {
		model.addAttribute("product", products.getProductById(id));
		List<Category> unusedCategories = categories.getUnusedCategories(products.getProductById(id));
		model.addAttribute("categories", unusedCategories);
		return "assigncategory.jsp";
	}

	@GetMapping("/categories/{id}/assignproducts")
	public String assignProducts(@PathVariable("id") Long id, Model model) {
		model.addAttribute("category", categories.getCategoryById(id));
		Category category = categories.getCategoryById(id);
		model.addAttribute("products", products.getUnusedProducts(category));
		return "assignproduct.jsp";
	}
	
	@PutMapping("/category/{id}/assignproduct")
	public String addProductToCategory(@PathVariable("id") Long categoryId, @RequestParam("id") Long productId, Model model) {
		products.assignCategory(productId, categoryId);
		Category category = categories.getCategoryById(categoryId);
		model.addAttribute("category", category );
		model.addAttribute("products", products.getUnusedProducts(category));
		return "assignproduct.jsp";
	}
	
	@PutMapping("/products/{productId}/assigncategory")
	public String addCategoryToProduct(@PathVariable("productId") Long productId, @RequestParam("id") Long categoryId, Model model) {
	    products.assignCategory(productId, categoryId);
	    Product product = products.getProductById(productId);
		model.addAttribute("product", product);
		List<Category> unusedCategories = categories.getUnusedCategories(product);
		model.addAttribute("categories", unusedCategories);
		return "assigncategory.jsp";
	}
	
	@PostMapping("/products/create")
	public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if(result.hasErrors()) {
			return "addproduct.jsp";
		}
		products.createProduct(product);
		return "redirect:/home";
	}
	
	@PostMapping("/categories/create")
	public String createCategory(@Valid @ModelAttribute("category")Category category, BindingResult result) {
		if(result.hasErrors()) {
			return "addcategory.jsp";
		}
		categories.createCategory(category);
		return "redirect:/home";
	}
	
}
