package com.itwill.brown_carrot_market.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.itwill.brown_carrot_market.dto.TownReply;

@Mapper
public interface TownReplyMapper {

	public int insertTownBoardReply(TownReply townReply);
	
	public int deleteTownBoardReply(int t_reply_no);
	
	
	
}
