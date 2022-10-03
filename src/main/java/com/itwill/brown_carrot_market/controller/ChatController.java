package com.itwill.brown_carrot_market.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itwill.brown_carrot_market.dto.ChatContents;
import com.itwill.brown_carrot_market.dto.ChatRoomListView;
import com.itwill.brown_carrot_market.service.ChatService;



@Controller
public class ChatController {
	
	@Autowired private ChatService chatService;
	 
	
	/**************************************************/
		@RequestMapping(value="/chat_room", method=RequestMethod.POST)
		public String chatList(HttpSession httpSession,@RequestParam String user) {
			List<ChatRoomListView> chatList = chatService.chatRoomSelectAll(user);
			httpSession.setAttribute("chatList",chatList);
			httpSession.setAttribute("loginId", user);
			return "chat_room";
		}	
		
		@RequestMapping(value = "/login", method = { RequestMethod.GET })
		public String login(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {
			return "login";
		}
		
		

	/**************************************************/
	
	@RequestMapping(value = "/chat", method = { RequestMethod.GET })
	public String chat(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {
		return "chat";
	}
	
	@RequestMapping(value = "/chat_content", method = { RequestMethod.GET })
	public String chat_content(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {
		return "chat_content";
	}
	
	@ResponseBody
	   @RequestMapping(value = "/sessionCheck", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	   public String returnSessionCheck(HttpSession httpSession) {
	      String mId = (String)httpSession.getAttribute("mId"); // 아이디 얻기 
			/*
			 * Map<String, Member> memberInfo = dmService.getMemberInfo(mId); String mImage
			 * = memberInfo.get("member").getmImage(); String mName =
			 * memberInfo.get("member").getmName();
			 */
	      String mName="닉네임";
	      return mId+","+mName;
	   }
	
	//채팅방의 저장되어있던 데이터  
	
	@ResponseBody
	@GetMapping(value="/chat_detail")
	public List<ChatContents> chatDetail (@RequestParam("c_room_no") int c_room_no){
		List<ChatContents> chatDetailList=chatService.chatSellectByRoom(c_room_no);
		return chatDetailList;
	}
	

	
	
	//읽음(1)으로 변경
	@ResponseBody
	@GetMapping(value="/chat_readUpdate")
	public int chatReadUpdate(@RequestParam("c_room_no") int c_room_no) {
		return chatService.chatReadUpdate(c_room_no);
	}
	
	//메세지 삭제
	@ResponseBody
	@PostMapping(value="/chat_delete")
	public int chatDelete(@RequestParam("c_content_no") int c_content_no) {
		return chatService.chatDelete(c_content_no);
	}
	
	
	//메세지 전송 
	@ResponseBody
	@PostMapping(value="/chat_message")
	public String insertChat(@RequestBody Map<String,String> messages) {
		int rowCount=0;
		ChatContents newChat=new ChatContents(0, String.valueOf(messages.get("contents")),
				null, null, String.valueOf(messages.get("mId")), 
				Integer.valueOf(messages.get("c_room_no")));
		rowCount=chatService.insertChat(
					newChat
				);
		
		//insert 후  클라이언트에게 jsonObject  만들어서 보내기 
		
		JSONObject jsonObject=null;
		try {
			jsonObject=new JSONObject();
			jsonObject.put("mId", String.valueOf(messages.get("mId")));
			jsonObject.put("yourId", String.valueOf(messages.get("yourId")));
			jsonObject.put("contents", String.valueOf(messages.get("contents")));
			jsonObject.put("sendtime",chatService.chatSellectOne(newChat.getC_content_no()).getSend_time() );
			jsonObject.put("c_room_no", String.valueOf(messages.get("c_room_no")));
			jsonObject.put("chat_read", String.valueOf(messages.get("chat_read")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonObject.toString();
				
		
	}
	
	/*
	 * // [post body json : Map 방식]
    // [경로 지정 : http://localhost:7000/testPostBodyJson]
    // [body json 데이터 : {"idx":"1", "name":"투케이"}]
    @PostMapping("/testPostBodyJson")
    public String testPostBodyJson(@RequestBody Map<String, String> param) {
        System.out.println("\n");
        System.out.println("=======================================");
        System.out.println("[ModuleApiController] : [testPostBodyJson] : [start]");
        System.out.println("[request keySet] : " + String.valueOf(param.keySet()));
        System.out.println("[request idx] : " + String.valueOf(param.get("idx")));
        System.out.println("[request name] : " + String.valueOf(param.get("name")));
        System.out.println("=======================================");
        System.out.println("\n");

        // 리턴을 반환할 JSON 데이터 생성 실시
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject();
            jsonObject.put("idx", String.valueOf(param.get("idx")));
            jsonObject.put("name", String.valueOf(param.get("name")));
        }
        catch (Exception e){
            e.printStackTrace();
        }

        // return 리턴 데이터 반환 [json 형식]
        return jsonObject.toString();
    }
	 */
	
	
	
	

}
