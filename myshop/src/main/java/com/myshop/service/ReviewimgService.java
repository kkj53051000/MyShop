package com.myshop.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myshop.domain.Reviewimg;
import com.myshop.repository.ReviewimgRepository;

@Service
@Transactional
public class ReviewimgService {
	@Autowired
	ReviewimgRepository reviewimgRepository;
	
	public void saveReviewimg(Reviewimg reviewimg) {
		reviewimgRepository.insertReviewimg(reviewimg);
	}
}
