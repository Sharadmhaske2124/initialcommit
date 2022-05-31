package com.demo.eshopi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.eshopi.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
