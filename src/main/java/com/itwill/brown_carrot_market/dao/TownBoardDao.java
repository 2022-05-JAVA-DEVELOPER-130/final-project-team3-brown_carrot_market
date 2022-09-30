package com.itwill.brown_carrot_market.dao;

import java.util.List;

import com.itwill.brown_carrot_market.dto.TownBoard;

public interface TownBoardDao {
	
	//동네게시판 글 등록
	int insertTownBoard(TownBoard townBoard);
	
	//동네 게시판 글 하나 삭제
	int deleteTownBoardOne(int t_no);
	
	
	
	
	
	
}
