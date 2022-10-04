package com.itwill.brown_carrot_market.service;

import java.util.List;

import com.itwill.brown_carrot_market.dto.Address;
import com.itwill.brown_carrot_market.dto.TownBoard;

public interface TownBoardService {
	
	//동네 게시판 비회원이 전체조회
	List<TownBoard> selectNonMemberTownBoardList()throws Exception;
	
	//동네 게시판 비회원이 카테고리 조건으로 전체조회
	List<TownBoard> selectNonMemberCtgrTownBoardList(int t_ctgr_no)throws Exception;
	
	//동네 게시판 회원이 좌표값 조건으로 전체조회 -- 좌표 범위대로 나오는지 다시 확인하기..
	List<TownBoard> selectTownBoardListCoordinate(Address address)throws Exception;
	
	//동네 게시판 회원이 좌표값과 카테고리 조건으로 전체조회 -- 좌표 범위대로 나오는지 다시 확인하기..
	List<TownBoard> selectTownBoardCtgrListCoordinate(int t_ctgr_no ,Address address)throws Exception;
	
	//동네 게시판 게시글 한개 조회
	TownBoard selectTownBoardOne(int t_no)throws Exception;
	
	//동네 게시판 글 하나 삭제
	int deleteTownBoardOne(int t_no) throws Exception;
	
	//동네게시판 게시글 한개 수정
	int updateTownBoardOne(TownBoard townBoard)throws Exception;
	
	//동네게시판 게시물 조회수 증가
	int updateTownBoardCount(int t_no)throws Exception;
	
	//동네게시판 글 등록
	//int insertTownBoard(TownBoard townBoard)throws Exception;
	
	//동네게시판 글 아이디로 조회(내가 쓴 글 조회)
	List<TownBoard> selectTownBoardIdList(String user_id)throws Exception;
	
	
	
	
	
}
