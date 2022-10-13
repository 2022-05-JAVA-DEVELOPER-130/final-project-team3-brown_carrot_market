package com.itwill.brown_carrot_market.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.itwill.brown_carrot_market.dto.ReviewImage;

@Mapper
public interface ReviewImageMapper {

	//@Insert("")
	public int insertReviewImgList(List<ReviewImage> reviewImageList);
}
