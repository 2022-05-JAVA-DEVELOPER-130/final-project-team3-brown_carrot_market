package com.itwill.brown_carrot_market.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.itwill.brown_carrot_market.dto.TownImage;

@Mapper
public interface TownImageMapper {
	
	//해당 게시물의 사진 전체 삭제
	public int deleteTownBoardImgAll(int t_no);
	
	//해당 게시물의 사진 한개 삭제
	public int deleteTownBoardImgOne(int t_img_no);
	
	//사진 삽입
	//public TownImage insertTownBoardImg(TownImage townImage);
	

}
