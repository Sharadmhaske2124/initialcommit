package com.demo.eshopi.service;

import java.util.List;

import com.demo.eshopi.model.Product;

public interface ProductService {

	Product saveProduct(Product product);
	List<Product> getAllProduct();
	Product getProductById(int id);
	Product updateProduct(Product product, int id);
	void deleteProduct(int id);
}
