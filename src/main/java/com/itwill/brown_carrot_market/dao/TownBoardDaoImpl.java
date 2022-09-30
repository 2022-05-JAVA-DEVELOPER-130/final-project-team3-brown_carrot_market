package com.itwill.brown_carrot_market.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.brown_carrot_market.dto.TownBoard;
import com.itwill.brown_carrot_market.mapper.TownBoardMapper;

@Repository(value = "townBoardDaoImpl")
public class TownBoardDaoImpl implements TownBoardDao{
	
	@Autowired(required = true)
	private TownBoardMapper townBoardMapper;
	
	public TownBoardDaoImpl() {
		System.out.println(">>> TownBoardDaoImpl 호출");
	}
	public TownBoardMapper getTownBoardMapper() {
		return townBoardMapper;
	}
	@Override
	public int insertTownBoard(TownBoard townBoard) {
		
		return townBoardMapper.insertTownBoard(townBoard);
	}

	
	
	
	
	
	
	
	
	
}
