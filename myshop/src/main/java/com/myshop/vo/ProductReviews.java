package com.myshop.vo;

import java.util.List;

import com.myshop.domain.Review;
import com.myshop.domain.Reviewimg;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class ProductReviews {
	private Review review;
	private List<Reviewimg> reviewimgs;
	
	public ProductReviews(Review review, List<Reviewimg> reviewimgs) {
		this.review = review;
		this.reviewimgs = reviewimgs;
	}
}
