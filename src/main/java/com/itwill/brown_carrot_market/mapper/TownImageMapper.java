package com.itwill.brown_carrot_market.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.itwill.brown_carrot_market.dto.TownImage;

@Mapper
public interface TownImageMapper {
	
	public int deleteTownBoardImgAll(int t_no);
	
	public int deleteTownBoardImgOne(int t_img_no);
	
	public TownImage insertTownBoardImg(TownImage townImage);
	

}
