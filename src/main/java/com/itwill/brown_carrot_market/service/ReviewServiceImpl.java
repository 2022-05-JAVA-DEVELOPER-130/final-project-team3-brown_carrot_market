package com.itwill.brown_carrot_market.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.itwill.brown_carrot_market.dao.ReviewDao;
import com.itwill.brown_carrot_market.dao.UserInfoDao;
import com.itwill.brown_carrot_market.dto.Review;
import com.itwill.brown_carrot_market.dto.UserInfo;

@Service
public class ReviewServiceImpl implements ReviewService{

	@Autowired
	@Qualifier("ReviewDaoImpl")
	private ReviewDao reviewDao;
	
	@Autowired
	@Qualifier("userDaoImpl")
	private UserInfoDao userInfoDao;

	public ReviewServiceImpl() {
		System.out.println("#### ReviewServiceImpl() : 디폴트생성자 호출");
	}

	@Override
	public int createReview(Review review) throws Exception {
		int result = 0;
		
		reviewDao.createReview(review);
		//UserInfo updateUser = new UserInfo(null, null, null, null, null, result, result, null, null)
		//userInfoDao.updateFreshness();
		
		return result;
	}

	@Override
	public List<Review> findReceivedReview(String user_id) throws Exception {
		return reviewDao.findReceivedReview(user_id);
	}

	@Override
	public List<Review> findReceivedReviewByBuyer(String user_id)
			throws Exception {
		return reviewDao.findReceivedReviewByBuyer(user_id);
	}

	@Override
	public List<Review> findReceivedReviewBySeller(String user_id)
			throws Exception {
		return reviewDao.findReceivedReviewBySeller(user_id);
	}

	@Override
	public int isExistedReviewByOrdersNoId(Review review) throws Exception {
		return reviewDao.isExistedReviewByOrdersNoId(review);
	}
	
	
	
}
