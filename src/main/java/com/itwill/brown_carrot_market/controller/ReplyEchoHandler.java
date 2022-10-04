package com.itwill.brown_carrot_market.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.brown_carrot_market.dto.ChatContents;
import com.itwill.brown_carrot_market.dto.ChatRoom;
import com.itwill.brown_carrot_market.dto.ChatRoomListView;
import com.itwill.brown_carrot_market.service.ChatService;


@RestController
@ServerEndpoint(value = "/replyEcho")
public class ReplyEchoHandler {
	@Autowired
	private ChatService chatService;

	private static Map<String, Session> userSessions = new HashMap();
	String userId="";

	   @RequestMapping(value = "/get_id", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	   public String returnSessionCheck(HttpSession httpSession) {
	      String mId = (String)httpSession.getAttribute("sUserId");
	      this.userId=mId;
	      //Map<String, Member> memberInfo = dmService.getMemberInfo(mId);       
	      System.out.println("get_id 호출:"+mId);
	      return mId;
	   }
	   
	
	@PostMapping(value = "/chat_detail_rest")
	public Map chatDetail_rest(@RequestBody Map<String, String> chatList) {
		Map resultMap = new HashMap();
		int code = 1;
		String url = "";
		String msg = "";
		String yourId = "";
		//int room_no = Integer.parseInt(c_room_no);
//		String room_no = c_room_no.substring(7);
		String room_no = chatList.get("c_room_no");
		String mId=chatList.get("loginId");
		
		ChatRoom chatRoom=chatService.chatRoomSelect(Integer.parseInt(room_no));
		
		if(chatRoom.getFrom_id().equals(mId)) {
			yourId=chatRoom.getTo_id();
		}else {
			yourId=chatRoom.getFrom_id();
		}
		
		List<ChatContents> resultList = new ArrayList<ChatContents>();
		try {
			List<ChatContents> chatDetailList = chatService.chatSellectByRoom(Integer.parseInt(room_no));
			code = 1;
			msg = "성공";
			resultList = chatDetailList;
		} catch (Exception e) {
			code = 2;
			msg = "성공";
			e.printStackTrace();

		}

		resultMap.put("code", code);
		resultMap.put("msg", msg);
		resultMap.put("yourId", yourId);
		resultMap.put("data", resultList);

		return resultMap;
	}
	
	//채팅방 상대 아이디 가져오기 
	/*
	 * @PostMapping(value="/chat_your_id",produces =
	 * "application/json;charset=UTF-8") public Map chat_your_id() {
	 * 
	 * }
	 */
	

	
	/***********************************************************************/

	@OnOpen
	public void handleOpen(Session session) {
		String mId = (String)session.getQueryString();
		System.out.println("연결 세션:" + session);
		System.out.println("아이디:" + mId);
		userSessions.put(mId, session);
		// System.out.println(userSessions.keySet());
		System.out.println(userSessions);
	}

	/*
	 * public void afterConnectionEstablished(WebSocketSession session) throws
	 * Exception{ System.out.println("연결 세션:"+session); String
	 * mId=(String)session.getAttributes().get("user_id"); //session에 저장된 id 찾기
	 * userSessions.put(mId, session); }
	 */

	@OnMessage
	public void handleMessage(String message, Session session) {

		System.out.println("---------ON MESSAGE--------");
		System.out.println(message);

		System.out.println("메세지 전송한 세션:" + session);

		JSONObject jsonObj = new JSONObject(message);
		String yourId = jsonObj.getString("your_id");
		String myId=jsonObj.getString("mId");
		System.out.println("메세지(JSONObject) 보내는 내 아이디(key):" + myId);
		System.out.println("메세지(JSONObject) 받는 상대 아이디(key):" + yourId);

		//Session yourSession = userSessions.get(yourId);
		
		Session mySession=userSessions.get(myId);
		System.out.println("메세지 보내는 세션:" + mySession);
		//System.out.println("메세지 받는 세션:" + yourSession);

		JSONArray jsonArr = (JSONArray) jsonObj.get("data");
		JSONObject jsonChat = (JSONObject) jsonArr.get(0);

		System.out.println("jsonData.data 채팅 내용:" + jsonChat.getString("c_content"));

		ChatContents newChat = new ChatContents(0, jsonChat.getString("c_content"), "time", 0,
				jsonChat.getString("user_id"), Integer.parseInt(jsonChat.getString("c_room_no")));
		System.out.println("채팅 DB 넣을 때 객체:" + newChat);

		try {
			Session yourSession = userSessions.get(yourId);
			System.out.println("메세지 받는 세션:" + yourSession);


			System.out.println("채팅 상대방 소켓에 전송 시도");
			if (yourSession != null) {
				yourSession.getBasicRemote().sendText(jsonObj.toString());
			}
			mySession.getBasicRemote().sendText(jsonObj.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@PostMapping(value = "/chat_message_rest")
	public String insertChat(@RequestBody Map<String, String> messages) {
	
		
		int rowCount = 0;
		System.out.println(String.valueOf(messages.get("user_id")));
		ChatContents newChat = new ChatContents(0, String.valueOf(messages.get("c_content")), null, null,
				String.valueOf(messages.get("user_id")), Integer.valueOf(messages.get("c_room_no")));

		rowCount = chatService.insertChat(newChat);
		String sendTime=chatService.chatSellectOne(newChat.getC_content_no()).getSend_time();

		// insert 후 클라이언트에게 jsonObject 만들어서 보내기

		JSONObject jsonObject = null;
		try {
			jsonObject = new JSONObject();
			jsonObject.put("rowCount", rowCount);
			jsonObject.put("send_time", sendTime);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonObject.toString();

	}

	@OnClose
	public void handleClose(Session session) {
		System.out.println("socket 닫기:" + userId);
		userSessions.remove(userId);
		System.out.println(userSessions);
	}

	/*
	 * public void afterConnectionClosed(WebSocketSession session, CloseStatus
	 * status) throws Exception { // TODO Auto-generated method stub String
	 * mId=(String)session.getAttributes().get("user_id");
	 * System.out.println("커넥션 끝:"+mId); }
	 */

}
