
package com.itwill.brown_carrot_market.mapper;
 
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.itwill.brown_carrot_market.dto.Address;
import com.itwill.brown_carrot_market.dto.TownBoard;

@Mapper 
public interface TownBoardMapper {

//동네 게시판 비회원이 전체조회
public List<TownBoard> selectNonMemberTownBoardList();

//동네 게시판 비회원이 카테고리 조건으로 전체조회
public List<TownBoard> selectNonMemberCtgrTownBoardList(int t_ctgr_no);

//동네 게시판 회원이 좌표값 조건으로 전체조회
public List<TownBoard> selectTownBoardListCoordinate(Address address);

//동네 게시판 회원이 좌표값과 카테고리 조건으로 전체조회
public List<TownBoard> selectTownBoardCtgrListCoordinate(int t_ctgr_no, Address address);

//동네 게시판 게시글 한개 조회
public TownBoard selectTownBoardOne(int t_no);

//동네 게시판 글 하나 삭제
public int deleteTownBoardOne(int t_no);

//동네게시판 게시글 한개 수정
public int updateTownBoardOne(TownBoard townBoard);

//동네게시판 게시물 조회수 증가
public int updateTownBoardCount(int t_no);

//동네게시판 게시물 등록
//public int insertTownBoard(TownBoard townBoard);


//동네게시판 글 아이디로 조회(내가 쓴 글 조회)
public List<TownBoard> selectTownBoardIdList(String user_id);



}

	


