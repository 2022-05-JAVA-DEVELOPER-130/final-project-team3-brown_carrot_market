package com.itwill.brown_carrot_market.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.itwill.brown_carrot_market.dto.ChatRoom;
import com.itwill.brown_carrot_market.dto.ChatRoomListView;



@Mapper
public interface ChatRoomMapper {

	
	
	// 채팅방 목록 
	@Select("select g.c_room_no,g.not_read,t.send_time,t.c_content from (select c_room_no,count(*) as not_read from chat_contents\r\n"
			+ "where c_room_no in (select c_room_no from chat_room where from_id=#{user_id} or to_id=#{user_id})\r\n"
			+ "and c_read=0 \r\n"
			+ "and user_id!=#{user_id}\r\n"
			+ "group by c_room_no) g inner join (select a.c_room_no,send_time,c_content\r\n"
			+ "from (select c_room_no from chat_room d where d.to_id = #{user_id} or d.from_id = #{user_id})a \r\n"
			+ "inner join (select a.send_time,a.c_room_no,a.c_content from chat_contents a \r\n"
			+ "left join chat_contents b \r\n"
			+ "on a.c_room_no = b.c_room_no and a.send_time<b.send_time \r\n"
			+ "where b.c_room_no is null) b \r\n"
			+ "on a.c_room_no = b.c_room_no\r\n"
			+ "order by send_time desc) t on g.c_room_no = t.c_room_no")
	public List<ChatRoomListView> chatRoomSelectAll(@Param("user_id") String user_id);
	
	// 채팅방 목록  체크기능
	@Select("select * from chat_room where c_room_no=#{c_room_no}")
	public ChatRoom chatRoomSelect(@Param("c_room_no") Integer c_room_no);
	
	// 채팅 생성 중복 체크
	@Select("select * from chat_room where from_id=#{from_id} and to_id=#{to_id} and p_no=#{p_no}")
	public List<ChatRoom> chatRoomCheck(@Param("from_id") String from_id,@Param("to_id") String to_id,@Param("p_no") Integer p_no);
	
	// 채팅방 생성
	@Insert("insert into chat_room(c_room_no,from_id,to_id,p_no) values(CHAT_ROOM_C_ROOM_NO_SEQ.nextval,#{from_id},#{to_id},#{p_no})")
	public int chatRoomCreate(@Param("from_id") String from_id,@Param("to_id") String to_id,@Param("p_no") Integer p_no);
	
	// 채팅방 삭제
	@Delete("delete from chat_room where c_room_no = #{c_room_no}")
	public int chatRoomDelete(int c_room_no);
	
}