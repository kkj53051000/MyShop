package com.myshop.repository;

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
}
