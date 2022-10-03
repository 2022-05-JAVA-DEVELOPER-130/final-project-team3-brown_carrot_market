package com.itwill.brown_carrot_market.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.brown_carrot_market.dto.ChatRoom;
import com.itwill.brown_carrot_market.dto.ChatRoomListView;
import com.itwill.brown_carrot_market.mapper.ChatRoomMapper;



@Repository
public class ChatRoomDaoImpl implements ChatRoomDao {
	
	@Autowired
	private ChatRoomMapper chatRoomMapper;
	
	
	public ChatRoomDaoImpl() {
		
	}
	
	// 채팅방 전체 조회
	@Override
	public List<ChatRoomListView> chatRoomSelectAll(String user_id) {
		return chatRoomMapper.chatRoomSelectAll(user_id);
	}
	
	// 채팅방 목록 체크기능
	@Override
	public ChatRoom chatRoomSelect(Integer c_room_no) {
		return chatRoomMapper.chatRoomSelect(c_room_no);
	}
	
	// 채팅방 생성
	@Override
	public int chatRoomCreate(String from_id, String to_id, Integer p_no) {
		return chatRoomMapper.chatRoomCreate(from_id, to_id, p_no);
	}
	// 채팅방 삭제
	@Override
	public int chatRoomDelete(int c_room_no) {
		return chatRoomMapper.chatRoomDelete(c_room_no);
	}
	
	@Override
	public List<ChatRoom> chatRoomCheck(String from_id,String to_id,Integer p_no) {
		return chatRoomMapper.chatRoomCheck(from_id, to_id, p_no);
	}

	
}
