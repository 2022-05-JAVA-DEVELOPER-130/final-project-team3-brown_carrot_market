package com.itwill.brown_carrot_market.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.brown_carrot_market.dto.Review;
import com.itwill.brown_carrot_market.mapper.ReviewMapper;

@Repository(value = "ReviewDaoImpl")
public class ReviewDaoImpl {

	@Autowired(required = false)
	private ReviewMapper reviewMapper;
	
	public ReviewDaoImpl() {
		System.out.println("#### ReviewDaoImpl() : 디폴트생성자 호출");
	}
	
	public int createReview(Review review) {
		return reviewMapper.createReview(review);
	}
}
