package com.itwill.brown_carrot_market.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.brown_carrot_market.dto.Address;
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
	
	@Override
	public List<TownBoard> selectNonMemberTownBoardList() {
		System.out.println(">>> townBoardDaoImpl : selectNonMemberTownBoardList()호출");
		return townBoardMapper.selectNonMemberTownBoardList();
	}

	@Override
	public List<TownBoard> selectNonMemberCtgrTownBoardList(int t_ctgr_no) {
		System.out.println(">>> townBoardDaoImpl : selectNonMemberCtgrTownBoardList()호출");
		return townBoardMapper.selectNonMemberCtgrTownBoardList(t_ctgr_no);
	}

	
	@Override
	public List<TownBoard> selectTownBoardListCoordinate(Address address) {
		System.out.println(">>> townBoardDaoImpl : selectTownBoardListCoordinate()호출");
		return townBoardMapper.selectTownBoardListCoordinate(address);
	}

	@Override
	public List<TownBoard> selectTownBoardCtgrListCoordinate(int t_ctgr_no, Address address) {
		System.out.println(">>> townBoardDaoImpl : selectTownBoardCtgrListCoordinate()호출");
		return townBoardMapper.selectTownBoardCtgrListCoordinate(t_ctgr_no, address);
	}


	@Override
	public TownBoard selectTownBoardOne(int t_no) {
		System.out.println(">>> townBoardDaoImpl : selectTownBoardOne()호출");
		return townBoardMapper.selectTownBoardOne(t_no);
	}
	
	@Override
	public int deleteTownBoardOne(int t_no) {
		System.out.println(">>> townBoardDaoImpl : delete()호출");
		return townBoardMapper.deleteTownBoardOne(t_no);
	}

	@Override
	public int updateTownBoardOne(TownBoard townBoard) {
		System.out.println(">>> townBoardDaoImpl : updateTownBoardOne()호출");
		return townBoardMapper.updateTownBoardOne(townBoard);
	}

	@Override
	public int updateTownBoardCount(int t_no) {
		System.out.println(">>> townBoardDaoImpl : updateTownBoardCount()호출");
		return townBoardMapper.updateTownBoardCount(t_no);
	}
	
	
	@Override
	public int insertTownBoard(TownBoard townBoard) {
		System.out.println(">>> townBoardDaoImpl : insertTownBoard()호출");
		return townBoardMapper.insertTownBoard(townBoard);
	}

	@Override
	public List<TownBoard> selectTownBoardIdList(String user_id) {
		System.out.println(">>> townBoardDaoImpl : selectTownBoardIdList()호출");
		return townBoardMapper.selectTownBoardIdList(user_id);
	}


	

	
	
	
	
	
	
	
	
	
}
