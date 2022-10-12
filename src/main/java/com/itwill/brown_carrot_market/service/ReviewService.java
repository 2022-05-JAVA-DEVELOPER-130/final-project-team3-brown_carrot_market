package com.itwill.brown_carrot_market.service;

import java.util.List;

import com.itwill.brown_carrot_market.dto.Review;

public interface ReviewService {
	
	int createReview(Review review) throws Exception;

	List<Review> findReceivedReview(String user_id) throws Exception;
	
	List<Review> findReceivedReviewByBuyer(String user_id) throws Exception;
	
	List<Review> findReceivedReviewBySeller(String user_id) throws Exception;
	
	public int isExistedReviewByOrdersNoId(Review review) throws Exception;
}
