package com.itwill.brown_carrot_market.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.itwill.brown_carrot_market.dto.TownBoard;

@Mapper
public interface TownBoardMapper {
	
	public List<TownBoard> selectNonMemberTownBoardList();
	
	public List<TownBoard> selectNonMemberCtgrTownBoardList();
	
	public List<TownBoard> selectTownBoardListCoordinate();
	
	public List<TownBoard> selectTownBoardCtgrListCoordinate(int t_ctgr_no);
	
	public TownBoard selectTownBoardOne(int t_no);
	
	public int deleteTownBoardOne(int t_no);
	
	public int updateTownBoardOne(TownBoard townBoard);
	
	public int updateTownBoardCount(int t_no);
	
	public int insertTownBoard(TownBoard townBoard);
	
	
	
	
	
	
	
	
	
	
	
	
	
}