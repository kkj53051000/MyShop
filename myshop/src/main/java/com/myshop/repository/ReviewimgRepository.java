package com.myshop.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.myshop.domain.Reviewimg;

@Repository
public class ReviewimgRepository {
	@PersistenceContext
	private EntityManager em;
	
	public void insertReviewimg(Reviewimg reviewimg) {
		em.persist(reviewimg);
	}
}
