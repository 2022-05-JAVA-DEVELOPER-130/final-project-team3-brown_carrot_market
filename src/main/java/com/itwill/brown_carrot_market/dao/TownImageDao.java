package com.itwill.brown_carrot_market.dao;

import com.itwill.brown_carrot_market.dto.TownImage;

public interface TownImageDao {
	
	//해당 게시물의 사진 전체 삭제
	int deleteTownBoardImgAll(int t_no)throws Exception;
	
	//해당 게시물의 사진 한개 삭제
	int deleteTownBoardImgOne(int t_img_no)throws Exception;
	
	//사진 삽입
	//TownImage insertTownBoardImg(TownImage townImage)throws Exception;
	
	
}
