package com.itwill.brown_carrot_market.dao;

import com.itwill.brown_carrot_market.dto.Review;

public interface ReviewDao {

	public int createReview(Review review) throws Exception;
}
