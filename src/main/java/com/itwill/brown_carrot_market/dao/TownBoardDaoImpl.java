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
	public void setTownBoardMapper(TownBoardMapper townBoardMapper) {
		System.out.println(">>> townBoardDaoImpl() : setTownBoardMapper() 호출");
		this.townBoardMapper = townBoardMapper;
	}
	
	/*
	@Override
	public int insertTownBoard(TownBoard townBoard) {
		
		return townBoardMapper.insertTownBoard(townBoard);
	}
	*/

	@Override
	public int deleteTownBoardOne(int t_no) {
		System.out.println(">>> townBoardDaoImpl : delete()호출");
		return townBoardMapper.deleteTownBoardOne(t_no);
	}
	

	
	
	
	
	
	
	
	
	
}
