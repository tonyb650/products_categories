package com.tonyb650.productscategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tonyb650.productscategories.models.Category;
import com.tonyb650.productscategories.models.Product;
import com.tonyb650.productscategories.respositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepo;
	
	@Autowired
	CategoryService categoryService;
	
	public List<Product> getAllProducts(){
		return productRepo.findAll();
	}
	
	public Product createProduct(Product product) {
		return productRepo.save(product);
	}
	
	public Product getProductById(Long id) {
		Optional<Product> possibleProduct = productRepo.findById(id);
		if(possibleProduct.isPresent()) {
			return possibleProduct.get();
		}
		return null;
	}
	
	public Product assignCategory(Long productId, Long categoryId) {
		Product thisProduct = getProductById(productId);
		Category thisCategory = categoryService.getCategoryById(categoryId);
		thisProduct.getCategories().add(thisCategory);
		return productRepo.save(thisProduct);
	}
	
	public List<Product> getUnusedProducts(Category category){
		List<Product> unusedProducts = productRepo.findByCategoriesNotContains(category);
		return unusedProducts;
	}
	
}
