package com.itwill.brown_carrot_market.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.itwill.brown_carrot_market.dto.TownReply;

@Mapper
public interface TownReplyMapper {

	//댓글등록
	public int insertTownBoardReply(TownReply townReply);
	
	//댓글삭제
	public int deleteTownBoardReply(int t_reply_no);
	
	//댓글수정
	public int updateTownBoardReply(TownReply townReply);
	
	
}
