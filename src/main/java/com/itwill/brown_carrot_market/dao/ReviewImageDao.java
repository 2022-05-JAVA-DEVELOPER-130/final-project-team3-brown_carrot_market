package com.itwill.brown_carrot_market.dao;

import java.util.List;

import com.itwill.brown_carrot_market.dto.ProductImage;
import com.itwill.brown_carrot_market.dto.ReviewImage;

public interface ReviewImageDao {
	
	
	//int insertProductListImg(ProductImage productImage)throws Exception;
	public int insertReviewImgList(List<ReviewImage> reviewImageList) throws Exception;
	
}
