package com.itwill.brown_carrot_market.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.brown_carrot_market.dto.TownReply;
import com.itwill.brown_carrot_market.mapper.TownReplyMapper;

@Repository(value = "townReplyDaoImpl")
public class TownReplyDaoImpl implements TownReplyDao{
	@Autowired(required = true)
	private TownReplyMapper townReplyMapper;
	
	public TownReplyDaoImpl() {
		System.out.println(">>> TownReplyDaoImpl 호출");
	}
	public TownReplyMapper getTownReplyMapper() {
		return townReplyMapper;
	}
	public void setTownReplyMapper(TownReplyMapper townReplyMapper) {
		System.out.println(">>> townReplyDaoImpl : setTownReplyMapper()호출");
		this.townReplyMapper = townReplyMapper;
	}
	@Override
	public int insertTownBoardReply(TownReply townReply) {
		System.out.println(">>> townReplyDaoImpl: insertTownBoardReply()호출");
		return townReplyMapper.insertTownBoardReply(townReply);
	}
	@Override
	public int deleteTownBoardReply(int t_reply_no) {
		System.out.println(">>> townReplyDaoImpl : deleteTownBoardReply()호출");
		return townReplyMapper.deleteTownBoardReply(t_reply_no);
	} 
	@Override
	public int updateTownBoardReply(TownReply townReply) {
		System.out.println(">>> townReplyDaoImpl :updateTownBoardReply()호출");
		return townReplyMapper.updateTownBoardReply(townReply);
	}
	
	
	
	
	
	
	
}
