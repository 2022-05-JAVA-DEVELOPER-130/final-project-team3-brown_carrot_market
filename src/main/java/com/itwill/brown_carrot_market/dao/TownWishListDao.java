package com.itwill.brown_carrot_market.dao;

import java.util.List;

import com.itwill.brown_carrot_market.dto.TownWishList;

public interface TownWishListDao {

	//관심목록 총 갯수
	int selectTownWishListCount(String user_id);
	
	//관심목록 전체 리스트 조회
	List<TownWishList> selectTownWishListAll(String user_id);
	
	//관심목록 리스트에서 한개 글 선택
	TownWishList selectTownWishListOne(int t_wl_no);
	
	//관심목록 등록
	int insertTownWishList(TownWishList townWishList);
	
	//관심목록 한개 삭제
	int deleteTownWishList(int t_wl_no);
	
}
