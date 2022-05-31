package com.demo.eshopi.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.demo.eshopi.exception.ResourceNotFoundException;
import com.demo.eshopi.model.Product;
import com.demo.eshopi.repository.ProductRepository;
import com.demo.eshopi.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	private ProductRepository productRepository;
	
	
	public ProductServiceImpl(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}


	@Override
	public Product saveProduct(Product product) {
		
		return productRepository.save(product);
	}


	@Override
	public List<Product> getAllProduct() {
		
		return productRepository.findAll() ;
	}


	@Override
	public Product getProductById(int id) {
		
		Optional <Product> product = productRepository.findById(id);
		
		if(product.isPresent()) {
			return product.get();
		}else {
			throw new ResourceNotFoundException("Product", "Id", id);
		}
	}


	@Override
	public Product updateProduct(Product product, int id) {
		
		Product product2 = productRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Product", "Id", id));
		
		product2.setProductName(product.getProductName());
		product2.setProductDescription(product.getProductDescription());
		product2.setProductPrice(product.getProductPrice());
		product2.setProductQuantity(product.getProductQuantity());
		
		productRepository.save(product2);
		return product2;
	}


	@Override
	public void deleteProduct(int id) {
		productRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Product", "Id", id));
		productRepository.deleteById(id);
	}

}
