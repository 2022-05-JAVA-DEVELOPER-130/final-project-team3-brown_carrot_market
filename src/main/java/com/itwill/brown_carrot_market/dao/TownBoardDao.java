package com.itwill.brown_carrot_market.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.itwill.brown_carrot_market.dto.Address;
import com.itwill.brown_carrot_market.dto.TownBoard;

public interface TownBoardDao {
	
	/*
	//동네 게시판 비회원이 전체조회
	List<TownBoard> selectNonMemberTownBoardList()throws Exception;
	*/
	//동네 게시판 비회원이 전체조회 페이징 처리
	List<TownBoard> selectNonMemberTownBoardList(int pageStart, int pageEnd)throws Exception;
	//동네 게시판 비회원이 게시글 수 계산
	int selectNonMemberCountTownBoard();
	
	
	/*
	//동네 게시판 비회원이 카테고리 조건으로 전체조회
	List<TownBoard> selectNonMemberCtgrTownBoardList(int t_ctgr_no)throws Exception;
	*/
	//동네 게시판 비회원이 카테고리 조건으로 전체조회 -- 페이징처리
	List<TownBoard> selectNonMemberCtgrTownBoardList(int t_ctgr_no,int pageStart, int pageEnd)throws Exception;
	//동네 게시판 카테고리 조건 비회원이 게시글 수 계산
	int selectNonMemberCountCtgrTownBoard(int t_ctgr_no);
	
	
	
	
	/*
	//동네 게시판 회원이 좌표값 조건으로 전체조회 
	List<TownBoard> selectTownBoardListCoordinate(Address address)throws Exception;
	*/
	//동네 게시판 회원이 좌표값 조건으로 전체조회 -- 페이징처리
	List<TownBoard> selectTownBoardListCoordinate(Address address, int pageStart, int pageEnd)throws Exception;
	//동네 게시판 회원이 게시글 수 계산
	int selectMemberCountTownBoard(Address address);
	
	
	
	
	/*
	//동네 게시판 회원이 좌표값과 카테고리 조건으로 전체조회 -- 좌표 범위대로 나오는지 다시 확인하기..
	List<TownBoard> selectTownBoardCtgrListCoordinate(int t_ctgr_no ,Address address)throws Exception;
	*/
	//동네 게시판 회원이 좌표값과 카테고리 조건으로 전체조회 -- 페이징처리
	List<TownBoard> selectTownBoardCtgrListCoordinate(Map map, int t_ctgr_no, int pageStart, int pageEnd)throws Exception;
	//회원이 카테고리 조건 게시판 게시글 수 계산
	int selectMemberCtgrCountTownBoard(Map map,int t_ctgr_no);
	//회원이 카테고리 조건 게시판 게시글 수 계산을 위한 파라메타 맵 만들기
	Map selectMemberCtgrTownBoardAddress(String user_id,int address_no);
	
	
	//비회원 인기글 리스트 
	List<TownBoard> selectNonMemberTownBoardListTop3();
	
	//회원 인기글 리스트
	List<TownBoard> selectMemberTownBoardListTop3(Address address);
	
	
	//동네 게시판 게시글 한개 조회
	TownBoard selectTownBoardOne(int t_no)throws Exception;
	
	//동네 게시판 글 하나 삭제
	int deleteTownBoardOne(int t_no) throws Exception;
		
	//동네게시판 게시글 한개 수정
	int updateTownBoardOne(TownBoard townBoard)throws Exception;
	
	//동네게시판 게시물 조회수 증가
	int updateTownBoardCount(int t_no)throws Exception;
	
	
	//동네게시판 글 아이디로 조회(내가 쓴 글 조회)
	List<TownBoard> selectTownBoardIdList(String user_id)throws Exception;
	
	/******************************************************/
	//동네게시판 글 등록
	//int insertTownBoard(TownBoard townBoard)throws Exception;
	
	
	Map selectTownBoardAddress(String user_id,int address_no);
	
	int insertTownBoard(Map map);

	/******************************************************/
	
	
}
