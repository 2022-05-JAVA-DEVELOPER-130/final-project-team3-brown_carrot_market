package com.itwill.brown_carrot_market.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.brown_carrot_market.dto.Review;
import com.itwill.brown_carrot_market.mapper.ReviewMapper;

@Repository(value = "ReviewDaoImpl")
public class ReviewDaoImpl implements ReviewDao {

	@Autowired
	private ReviewMapper reviewMapper;
	
	public ReviewDaoImpl() {
		System.out.println("#### ReviewDaoImpl() : 디폴트생성자 호출");
	}
	
	@Override
	public int createReview(Review review) {
		reviewMapper.createReview(review);
		return review.getReview_no();	//insert된 review_no Return	
	}

	@Override
	public List<Review> findReceivedReview(String user_id) throws Exception {
		return reviewMapper.findReceivedReview(user_id);
	}

	@Override
	public List<Review> findReceivedReviewByBuyer(String user_id)
			throws Exception {
		return reviewMapper.findReceivedReviewByBuyer(user_id);
	}

	@Override
	public List<Review> findReceivedReviewBySeller(String user_id)
			throws Exception {
		return reviewMapper.findReceivedReviewBySeller(user_id);
	}

	@Override
	public int isExistedReviewByOrdersNoId(Review review) throws Exception {
		return reviewMapper.isExistedReviewByOrdersNoId(review);
	}
}
