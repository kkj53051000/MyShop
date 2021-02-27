package com.myshop.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.myshop.domain.Category;
import com.myshop.domain.Product;

@Repository
public class ProductRepository {
	@PersistenceContext
	private EntityManager em;
	
	public void insertProduct(Product product) {
		em.persist(product);
	}
	
	public List<Product> selectProducts(Category category){
		List<Product> products = em.createQuery("select p From Product p where p.category = :category", Product.class)
				.setParameter("category", category)
				.getResultList();
		
		return products;
	}
	
	public List<Product> selectAllProducts(){
		List<Product> products = em.createQuery("select p From Product p", Product.class)
				.getResultList();
		
		return products;
	}
	
	public Product selectProduct(long id) {
		Product product = em.find(Product.class, id);
		
		return product;
	}
	
}
