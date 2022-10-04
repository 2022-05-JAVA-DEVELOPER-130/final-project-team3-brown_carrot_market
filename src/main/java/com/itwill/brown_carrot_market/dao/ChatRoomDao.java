package com.itwill.brown_carrot_market.dao;

import java.util.List;

import com.itwill.brown_carrot_market.dto.ChatRoom;
import com.itwill.brown_carrot_market.dto.ChatRoomListView;


public interface ChatRoomDao {


	// 채팅방 목록
	 public  List<ChatRoomListView> chatRoomSelectAll(String user_id);
	
	// 채팅방 생성
	 public int chatRoomCreate(String from_id,String to_id,Integer p_no);
	
	// 채탱방 삭제
	 public int chatRoomDelete(int c_room_no);

	// 채팅방 체크
	 public List<ChatRoom> chatRoomCheck(String from_id, String to_id, Integer p_no);

	 // 채팅방 목록 체크
	 public ChatRoom chatRoomSelect(Integer c_room_no);

	 
	 public int chatNotRead(int c_room_no, String user_id);

}
