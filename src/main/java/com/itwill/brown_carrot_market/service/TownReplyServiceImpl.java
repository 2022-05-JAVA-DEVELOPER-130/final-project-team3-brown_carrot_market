package com.itwill.brown_carrot_market.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.itwill.brown_carrot_market.dao.TownReplyDao;
import com.itwill.brown_carrot_market.dto.TownReply;

@Service
public class TownReplyServiceImpl implements TownReplyService{
	@Autowired
	@Qualifier("townReplyDaoImpl")
	private TownReplyDao townReplyDao;
	
	public TownReplyServiceImpl() throws Exception{
		System.out.println(">>> townReplyDaoImpl: 기본 생성자 호출");
	}

	@Override
	public int insertTownBoardReply(TownReply townReply) throws Exception {
		return townReplyDao.insertTownBoardReply(townReply);
	}

	@Override
	public int deleteTownBoardReply(int t_reply_no) throws Exception {
		return townReplyDao.deleteTownBoardReply(t_reply_no);
	}

	@Override
	public int updateTownBoardReply(TownReply townReply) throws Exception {
		return townReplyDao.updateTownBoardReply(townReply);
	}
	
	
	
	
	
	
}
