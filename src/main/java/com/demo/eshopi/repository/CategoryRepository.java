package com.demo.eshopi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.eshopi.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
