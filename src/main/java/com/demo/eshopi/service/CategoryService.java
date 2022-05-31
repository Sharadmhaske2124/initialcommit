package com.demo.eshopi.service;

import java.util.List;

import com.demo.eshopi.model.Category;

public interface CategoryService {

	Category saveCategory(Category category);
	List<Category> getAllCategory();
	Category getCategoryById(int id);
	Category updateCategory(Category category, int id);
	void deleteCategory(int id);
}
