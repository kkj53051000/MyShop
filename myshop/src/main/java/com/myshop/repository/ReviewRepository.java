package com.myshop.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.myshop.domain.Review;

@Repository
public class ReviewRepository {
	@PersistenceContext
	EntityManager em;
	
	public void insertReview(Review review) {
		em.persist(review);
	}
	
	public Review selectReview(long id) {
		Review review = em.find(Review.class, id);
		
		return review;
	}
	
	public List<Review> selectReviews(long id){
		List<Review> reviews = em.createQuery("select r From Review r join fetch r.user where r.productinfo.id = :id", Review.class)
				.setParameter("id", id)
				.getResultList();
		
		return reviews;
	}
}
