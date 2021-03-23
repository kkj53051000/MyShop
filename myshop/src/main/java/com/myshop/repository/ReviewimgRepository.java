package com.myshop.repository;

import java.util.List;

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
	
	public List<Reviewimg> selectReviewimgs(long id){
		
		List<Reviewimg> reviewimgs = em.createQuery("select r From Reviewimg r where review_id = :id", Reviewimg.class)
				.setParameter("id", id)
				.getResultList();
		
		return reviewimgs;
	}
}
