package com.itwill.brown_carrot_market.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.brown_carrot_market.dto.ProductImage;
import com.itwill.brown_carrot_market.dto.ReviewImage;
import com.itwill.brown_carrot_market.mapper.ProductImageMapper;
import com.itwill.brown_carrot_market.mapper.ReviewImageMapper;

@Repository(value = "reviewImageDaoImpl")
public class ReviewImageDaoImpl implements ReviewImageDao{
	
	@Autowired(required = true)
	private ReviewImageMapper reviewImageMapper;

	@Override
	public int insertReviewImgList(List<ReviewImage> reviewImageList)
			throws Exception {
		return reviewImageMapper.insertReviewImgList(reviewImageList);
	}
	
}