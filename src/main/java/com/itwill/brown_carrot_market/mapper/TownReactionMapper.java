package com.itwill.brown_carrot_market.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.itwill.brown_carrot_market.dto.TownReaction;

@Mapper
public interface TownReactionMapper {
	
	public int insertTownBoardReac(TownReaction townReaction);
	
	public int deleteTownBoardReac(int t_reac_no);
	
	
	
}
