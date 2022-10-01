package com.itwill.brown_carrot_market.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.itwill.brown_carrot_market.dto.TownBoard;

public interface TownBoardDao {
	
	//동네게시판 글 등록
	//int insertTownBoard(TownBoard townBoard);
	
	//동네 게시판 글 하나 삭제
	int deleteTownBoardOne(int t_no) throws Exception;
	
	//동네 게시판 비회원이 전체조회
	List<TownBoard> selectNonMemberTownBoardList();
	
	//동네 게시판 비회원이 카테고리 조건으로 전체조회
	List<TownBoard> selectNonMemberCtgrTownBoardList(int t_ctgr_no);
	
	//동네 게시판 회원이 좌표값 조건으로 전체조회
	//List<TownBoard> selectTownBoardListCoordinate();
	
	
	
	
}
