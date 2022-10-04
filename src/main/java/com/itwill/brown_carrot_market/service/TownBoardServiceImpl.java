package com.itwill.brown_carrot_market.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.itwill.brown_carrot_market.dao.TownBoardDao;
import com.itwill.brown_carrot_market.dto.Address;
import com.itwill.brown_carrot_market.dto.TownBoard;

@Service
public class TownBoardServiceImpl implements TownBoardService{
	@Autowired
	@Qualifier("townBoardDaoImpl")
	private TownBoardDao townBoardDao;
	
	public TownBoardServiceImpl() throws Exception{
		System.out.println(">>> townBoardServiceImpl : 기본 생성자 호출");
	}

	@Override
	public List<TownBoard> selectNonMemberTownBoardList() throws Exception {
		return townBoardDao.selectNonMemberTownBoardList();
	}

	@Override
	public List<TownBoard> selectNonMemberCtgrTownBoardList(int t_ctgr_no) throws Exception {
		return townBoardDao.selectNonMemberCtgrTownBoardList(t_ctgr_no);
	}

	@Override
	public List<TownBoard> selectTownBoardListCoordinate(Address address) throws Exception {
		return townBoardDao.selectTownBoardListCoordinate(address);
	}

	@Override
	public List<TownBoard> selectTownBoardCtgrListCoordinate(int t_ctgr_no, Address address) throws Exception {
		return townBoardDao.selectTownBoardCtgrListCoordinate(t_ctgr_no, address);
	}

	@Override
	public TownBoard selectTownBoardOne(int t_no) throws Exception {
		return townBoardDao.selectTownBoardOne(t_no);
	}

	@Override
	public int deleteTownBoardOne(int t_no) throws Exception {
		return townBoardDao.deleteTownBoardOne(t_no);
	}

	@Override
	public int updateTownBoardOne(TownBoard townBoard) throws Exception {
		
		return townBoardDao.updateTownBoardOne(townBoard);
	}

	@Override
	public int updateTownBoardCount(int t_no) throws Exception {
		return townBoardDao.updateTownBoardCount(t_no);
	}
/*
	@Override
	public int insertTownBoard(TownBoard townBoard) throws Exception {
		return townBoardDao.insertTownBoard(townBoard);
	}
*/
	@Override
	public List<TownBoard> selectTownBoardIdList(String user_id) throws Exception {
		return townBoardDao.selectTownBoardIdList(user_id);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
