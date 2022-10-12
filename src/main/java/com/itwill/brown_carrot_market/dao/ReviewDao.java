package com.itwill.brown_carrot_market.dao;

import java.util.List;

import com.itwill.brown_carrot_market.dto.Review;

public interface ReviewDao {

	public int createReview(Review review) throws Exception;
	
	public List<Review> findReceivedReview(String user_id) throws Exception;
	
	public List<Review> findReceivedReviewByBuyer(String user_id) throws Exception;
	
	public List<Review> findReceivedReviewBySeller(String user_id) throws Exception;
	
	public int isExistedReviewByOrdersNoId(Review review) throws Exception;
}
