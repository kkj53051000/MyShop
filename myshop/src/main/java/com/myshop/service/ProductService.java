package com.myshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myshop.domain.Category;
import com.myshop.domain.Product;
import com.myshop.repository.ProductRepository;

@Service
@Transactional
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	
	public void uploadProduct(Product product) {
		productRepository.insertProduct(product);
	}
	
	@Transactional(readOnly = true)
	public List<Product> getProducts(Category category){
		List<Product> products = productRepository.selectProducts(category);
 		return products;
	}
	
	@Transactional(readOnly = true)
	public List<Product> getAllProducts(){
		List<Product> products = productRepository.selectAllProducts();
		return products;
	}
	
	@Transactional(readOnly = true)
	public Product getProduct(long id) {
		Product product = productRepository.selectProduct(id);
		
		return product;
	}
}
