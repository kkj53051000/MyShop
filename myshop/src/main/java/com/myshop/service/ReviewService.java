package com.myshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myshop.domain.Review;
import com.myshop.repository.ReviewRepository;

@Service
@Transactional
public class ReviewService {
	@Autowired
	ReviewRepository reviewRepository;

	public void saveReview(Review review) {
		reviewRepository.insertReview(review);
	}
	
	public Review findReview(long id) {
		Review review = reviewRepository.selectReview(id);
		
		return review;
	}
	
	public List<Review> findReviews(long id){
		List<Review> reviews = reviewRepository.selectReviews(id);
		
		return reviews;
	}
	
}
