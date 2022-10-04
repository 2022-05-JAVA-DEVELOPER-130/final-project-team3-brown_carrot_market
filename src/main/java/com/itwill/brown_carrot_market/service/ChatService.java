package com.itwill.brown_carrot_market.service;

import java.util.List;

import com.itwill.brown_carrot_market.dto.ChatContents;
import com.itwill.brown_carrot_market.dto.ChatRoom;
import com.itwill.brown_carrot_market.dto.ChatRoomListView;


public interface ChatService {
	
	public List<ChatContents> chatSellectByRoom(int c_room_no);
	
	public ChatContents chatSellectOne(int c_content_no);
	
	public int chatReadUpdate(int c_room_no);
	
	public int chatDelete(int c_content_no);

	public int deleteChatUpdate(int c_content_no);
	
	public int insertChat(ChatContents chat_contents);
	
	public String testService();
	
	//채팅방 1개 조회
	public ChatRoom chatRoomSelect(Integer c_room_no);
	
	// 채팅방 전체 조회
	public List<ChatRoomListView> chatRoomSelectAll(String user_id);
	
	// 채팅방 생성
	public int chatRoomCreate(String from_id,String to_id,Integer p_no);
		
	// 채팅방 삭제
	public int chatRoomDelete(int c_room_no);

	// 중복체크 
	boolean duplicateCheck(String mId, String mIdYou, Integer p_no);

	public int chatNotRead(int c_room_no, String user_id);
}