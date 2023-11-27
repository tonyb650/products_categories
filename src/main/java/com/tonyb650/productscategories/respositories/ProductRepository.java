package com.tonyb650.productscategories.respositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.tonyb650.productscategories.models.Category;
import com.tonyb650.productscategories.models.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
	List<Product> findAll();
	
    List<Product> findAllByCategories(Category category);

    List<Product> findByCategoriesNotContains(Category category);

}
