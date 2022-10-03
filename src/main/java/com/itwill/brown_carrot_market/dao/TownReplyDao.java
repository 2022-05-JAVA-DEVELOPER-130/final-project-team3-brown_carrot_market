package com.itwill.brown_carrot_market.dao;

import com.itwill.brown_carrot_market.dto.TownReply;

public interface TownReplyDao {
	
	//댓글등록
	int insertTownBoardReply(TownReply townReply);
	
	//댓글삭제
	int deleteTownBoardReply(int t_reply_no);
	
	//댓글수정
	int updateTownBoardReply(TownReply townReply);
	
	
}
