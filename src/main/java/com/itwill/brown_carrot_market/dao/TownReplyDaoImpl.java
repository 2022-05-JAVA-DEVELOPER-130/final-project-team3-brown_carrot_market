package com.itwill.brown_carrot_market.dao;

import java.util.List;

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
	//댓글등록
	@Override
	public int insertTownBoardReply(TownReply townReply) throws Exception{
		System.out.println(">>> townReplyDaoImpl: insertTownBoardReply()호출");
		return townReplyMapper.insertTownBoardReply(townReply);
	}
	@Override
	public int deleteTownBoardReply(int t_reply_no) throws Exception{
		System.out.println(">>> townReplyDaoImpl : deleteTownBoardReply()호출");
		return townReplyMapper.deleteTownBoardReply(t_reply_no);
	} 
	@Override
	public int updateTownBoardReply(TownReply townReply) throws Exception{
		System.out.println(">>> townReplyDaoImpl :updateTownBoardReply()호출");
		return townReplyMapper.updateTownBoardReply(townReply);
	}
	
	//해당 게시물의 댓글 전체 조회
	@Override
	public List<TownReply> selectTownBoardReplyList(int t_no) {
		return townReplyMapper.selectTownBoardReplyList(t_no);
	}
	
	
	
	
	
	
	
}
