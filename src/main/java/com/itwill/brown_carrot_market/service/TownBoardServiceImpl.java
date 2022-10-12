package com.itwill.brown_carrot_market.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.itwill.brown_carrot_market.dao.TownBoardDao;
import com.itwill.brown_carrot_market.dao.UserInfoDao;
import com.itwill.brown_carrot_market.dto.Address;
import com.itwill.brown_carrot_market.dto.TownBoard;
import com.itwill.brown_carrot_market.util.PageMaker;
import com.itwill.brown_carrot_market.util.PageMakerDto;

@Service
public class TownBoardServiceImpl implements TownBoardService{
	@Autowired
	@Qualifier("townBoardDaoImpl")
	private TownBoardDao townBoardDao;
	
	private UserInfoDao userInfoDao;
	
	
	
	public TownBoardServiceImpl() throws Exception{
		System.out.println(">>> townBoardServiceImpl : 기본 생성자 호출");
	}
	
	//비회원 동네게시판 전체조회 페이징처리
	@Override
	public PageMakerDto<TownBoard> selectNonMemberTownBoardList(int currentPage) throws Exception {
		int totTownBoardNonMemberCount = townBoardDao.selectNonMemberCountTownBoard();
		PageMaker pageMaker = new PageMaker(totTownBoardNonMemberCount, currentPage, 5, 5);
		List<TownBoard> townBoardList = townBoardDao.selectNonMemberTownBoardList(pageMaker.getPageBegin(), pageMaker.getPageEnd());
		PageMakerDto<TownBoard> pageMakerTownBoardList = new PageMakerDto<TownBoard>(townBoardList, pageMaker, totTownBoardNonMemberCount);
		
		return pageMakerTownBoardList;
	}
	//비회원이 동네 게시판 게시글 수 계산
	@Override
	public int selectNonMemberCountTownBoard() {
		return townBoardDao.selectNonMemberCountTownBoard();
	}
	
	
	//동네 게시판 비회원이 카테고리 조건으로 전체조회
	@Override
	public PageMakerDto<TownBoard> selectNonMemberCtgrTownBoardList(int t_ctgr_no, int currentPage) throws Exception {
		int totTownBoardNonMemberCtgrCount = townBoardDao.selectNonMemberCountCtgrTownBoard(t_ctgr_no);
		PageMaker pageMaker = new PageMaker(totTownBoardNonMemberCtgrCount, currentPage, 5, 5);
		List<TownBoard> townBoardList = townBoardDao.selectNonMemberCtgrTownBoardList(t_ctgr_no, pageMaker.getPageBegin(), pageMaker.getPageEnd());
		PageMakerDto<TownBoard> pageMakerTownBoardList = new PageMakerDto<TownBoard>(townBoardList, pageMaker, totTownBoardNonMemberCtgrCount);
		return pageMakerTownBoardList;
	}
	//동네 게시판 카테고리 조건 비회원이 게시글 수 계산
	@Override
	public int selectNonMemberCountCtgrTownBoard(int t_ctgr_no) {
		return townBoardDao.selectNonMemberCountCtgrTownBoard(t_ctgr_no);
	}
	
	
	
	

	//회원이 동네 게시판 전체조회 페이징
	@Override
	public PageMakerDto<TownBoard> selectTownBoardListCoordinate(Address address,int currentPage) throws Exception {
		int totTownBoardMemberCount = townBoardDao.selectMemberCountTownBoard(address);
		PageMaker pageMaker = new PageMaker(totTownBoardMemberCount, currentPage, 5, 5);
		List<TownBoard> townBoardList = townBoardDao.selectTownBoardListCoordinate(address, pageMaker.getPageBegin(), pageMaker.getPageEnd());
		PageMakerDto<TownBoard> pageMakerTownBoardList = new PageMakerDto<TownBoard>(townBoardList, pageMaker, totTownBoardMemberCount);
		return pageMakerTownBoardList;
	}
	//회원이 동네 게시판 게시글 수 계산
	@Override
	public int selectMemberCountTownBoard(Address address) {
		return townBoardDao.selectMemberCountTownBoard(address);
		
	}

	
	
	
	//동네 게시판 회원이 좌표값과 카테고리 조건으로 전체조회 -- 페이징처리
	@Override
	public PageMakerDto<TownBoard> selectTownBoardCtgrListCoordinate(Map map, int currentPage) throws Exception {
		int totTownBoardMemberCtgrCount = townBoardDao.selectMemberCtgrCountTownBoard(map);
		PageMaker pageMaker = new PageMaker(totTownBoardMemberCtgrCount, currentPage, 5, 5);
		List<TownBoard> townBoardList = townBoardDao.selectTownBoardCtgrListCoordinate(map, pageMaker.getPageBegin(), pageMaker.getPageEnd());
		PageMakerDto<TownBoard> pageMakerTownBoardList = new PageMakerDto<TownBoard>(townBoardList, pageMaker, totTownBoardMemberCtgrCount);
		return pageMakerTownBoardList;
	}
	
	//회원이 카테고리 조건 게시판 게시글 수 계산
	@Override
	public int selectMemberCtgrCountTownBoard(Map map) {
		return townBoardDao.selectMemberCtgrCountTownBoard(map);
	}
	//회원이 카테고리 조건 게시판 게시글 수 계산을 위한 파라메타 맵 만들기
	@Override
	public Map selectMemberCtgrTownBoardAddress(int t_ctgr_no, String user_id, int address_no) {
		return townBoardDao.selectMemberCtgrTownBoardAddress(t_ctgr_no, user_id, address_no);
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
	@Override
	public List<TownBoard> selectTownBoardIdList(String user_id) throws Exception {
		return townBoardDao.selectTownBoardIdList(user_id);
	}

	
	/*
	@Override
	public int insertTownBoard(TownBoard townBoard) throws Exception {
		return townBoardDao.insertTownBoard(townBoard);
	}
	 */
	
	@Override
	public Map selectTownBoardAddress(String user_id, int address_no) {
		return townBoardDao.selectTownBoardAddress(user_id, address_no);
	}

	@Override
	public int insertTownBoard(Map map) {
		return townBoardDao.insertTownBoard(map);
	}





	

	


	
	
	
	
	
	
	
	
	
	
	
}
