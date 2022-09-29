package com.itwill.brown_carrot_market.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.itwill.brown_carrot_market.dto.TownBoard;

@Mapper
public interface TownBoardMapper {
	
	public TownBoard selectTownBoardOne(int t_no);
	
	public int deleteTownBoardOne(int t_no);
	
	public int updateTownBoardOne(TownBoard townBoard);
	
	public int updateTownBoardCount(int t_no);
	
	
	
	
	
	
	
	
}
