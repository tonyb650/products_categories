package com.tonyb650.productscategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tonyb650.productscategories.models.Category;
import com.tonyb650.productscategories.models.Product;
import com.tonyb650.productscategories.respositories.CategoryRepository;
import com.tonyb650.productscategories.respositories.ProductRepository;

@Service
public class CategoryService {

	@Autowired
	CategoryRepository categoryRepo;
	
	@Autowired
	ProductRepository productRepo;
	
	
	public List<Category> getAllCategories(){
		return categoryRepo.findAll();
	}
	
	public Category createCategory(Category category) {
		return categoryRepo.save(category);
	}
	
	public Category getCategoryById(Long id) {
		Optional<Category> possibleCategory = categoryRepo.findById(id);
		if(possibleCategory.isPresent()) {
			return possibleCategory.get();
		}
		return null;
	}
	
	public List<Category> getUnusedCategories(Product product){
		return categoryRepo.findByProductsNotContains(product);
	}

	public Category assignProduct(Long categoryId, Long productId) {
		Category thisCategory = getCategoryById(categoryId);
//		Product thisProduct = productService.getProductById(productId);
	//	thisCategory.getProducts().add(thisProduct);
		return categoryRepo.save(thisCategory);
	}
}
