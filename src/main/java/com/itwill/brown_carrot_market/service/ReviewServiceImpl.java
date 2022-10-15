package com.itwill.brown_carrot_market.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.brown_carrot_market.dao.ReviewDao;
import com.itwill.brown_carrot_market.dao.ReviewImageDao;
import com.itwill.brown_carrot_market.dao.UserInfoDao;
import com.itwill.brown_carrot_market.dto.Review;
import com.itwill.brown_carrot_market.dto.ReviewImage;
import com.itwill.brown_carrot_market.dto.UserInfo;

@Service
public class ReviewServiceImpl implements ReviewService{

	@Autowired
	@Qualifier("reviewDaoImpl")
	private ReviewDao reviewDao;
	
	@Autowired
	@Qualifier("reviewImageDaoImpl")
	private ReviewImageDao reviewImageDao;
	
	@Autowired
	@Qualifier("userDaoImpl")
	private UserInfoDao userInfoDao;

	public ReviewServiceImpl() {
		System.out.println("#### ReviewServiceImpl() : 디폴트생성자 호출");
	}

	@Transactional
	@Override
	public int createReview(Review review) throws Exception {
		int result = 0;
		int review_no = reviewDao.createReview(review);
		
		if(review.getReviewImageList()!=null) {//review이미지가 존재하면
			List<ReviewImage> imageList = new ArrayList();
			for (ReviewImage image : review.getReviewImageList()) {
				image.setReview_no(review_no);
				imageList.add(image);
			}
			result= reviewImageDao.insertReviewImgList(imageList);
		}
		return result;
	}
	
	@Override
	public int countReceivedReview(String user_id) throws Exception {
		return reviewDao.countReceivedReview(user_id);
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
	public Review findReviewByRivewNo(int review_no) throws Exception {
		return reviewDao.findReviewByRivewNo(review_no);
	}
	
	@Override
	public Review isExistedReviewByOrdersNoId(Review review) throws Exception {
		return reviewDao.isExistedReviewByOrdersNoId(review);
	}



	
	
}
