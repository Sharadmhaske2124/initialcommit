package com.demo.eshopi.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.demo.eshopi.exception.ResourceNotFoundException;
import com.demo.eshopi.model.Category;
import com.demo.eshopi.repository.CategoryRepository;
import com.demo.eshopi.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	private CategoryRepository categoryRepository;
	
	
	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		super();
		this.categoryRepository = categoryRepository;
	}

	@Override
	public Category saveCategory(Category category) {
		
		return categoryRepository.save(category);
	}

	@Override
	public List<Category> getAllCategory() {
		
		return categoryRepository.findAll();
	}

	@Override
	public Category getCategoryById(int id) {
		
		Optional<Category> category = categoryRepository.findById(id);
		
		if(category.isPresent()) {
			return category.get();
		}else {
			throw new ResourceNotFoundException("Category", "Id", id);
		}
	}

	@Override
	public Category updateCategory(Category category, int id) {
		Category category2 = categoryRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Category", "Id", id));
		
		category2.setCategoryName(category.getCategoryName());
		category2.setCategoryDescription(category.getCategoryDescription());
		
		categoryRepository.save(category2);
		
		return category2;
	}

	@Override
	public void deleteCategory(int id) {
		categoryRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Category", "Id", id));
		categoryRepository.deleteById(id);	
	}

}
