package com.itwill.brown_carrot_market.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.brown_carrot_market.dto.Address;
import com.itwill.brown_carrot_market.dto.Notice;
import com.itwill.brown_carrot_market.dto.TownBoard;
import com.itwill.brown_carrot_market.dto.TownReply;
import com.itwill.brown_carrot_market.service.TownBoardService;
import com.itwill.brown_carrot_market.service.TownReplyService;
import com.itwill.brown_carrot_market.util.PageMakerDto;

@RestController
public class TownBoardRestController {
	@Autowired
	private TownBoardService townBoardService;
	@Autowired
	private TownReplyService townReplyService;
	
	/*
	 * 게시글 리스트 반환 (REST)
	 */
	@RequestMapping("/townBoard_list_rest")
	public  Map<String, Object> townBoard_list_rest(@RequestParam(required = false, defaultValue = "1") Integer pageno, HttpSession session, @RequestParam Map<String, Object> map, @RequestParam(required = false, defaultValue = "0") int t_ctgr_no) throws Exception{
		Map<String, Object> resultMap = new HashMap<>();	
		PageMakerDto<TownBoard> townBoardList = null;
		String sUserId = (String)session.getAttribute("sUserId");
		Address sAddress = (Address)session.getAttribute("sAddress");
		
		System.out.println("townBoard_list_rest컨트롤러 map :"+map);
		
		try { 
			//회원 게시글 리스트 반환
			if(sUserId != null) {
				if(t_ctgr_no==0) {
					townBoardList = townBoardService.selectTownBoardListCoordinate(sAddress, pageno);
					resultMap.put("errorCode", 1); 
					resultMap.put("errorMsg", "회원 일반 성공");
					resultMap.put("data", townBoardList);
					
					List<TownBoard> townBoardListTop = townBoardService.selectNonMemberTownBoardListTop3();
					
				}
				if(t_ctgr_no != 0) {
					
					map.put("user_id", sUserId);
					map.put("address_no", sAddress.getAddress_no());
					map.put("address", sAddress);
					
					townBoardList = townBoardService.selectTownBoardCtgrListCoordinate(map,t_ctgr_no, pageno);
					resultMap.put("errorCode", 2); 
					resultMap.put("errorMsg", "회원 카테고리 성공");
					resultMap.put("data", townBoardList);
					
				}
					
			}
			//비회원 게시글 리스트 반환
			if(sUserId == null) {
				if(t_ctgr_no==0) {
					townBoardList = townBoardService.selectNonMemberTownBoardList(pageno);
					resultMap.put("errorCode",3); 
					resultMap.put("errorMsg", "비회원 일반 성공");
					resultMap.put("data", townBoardList);
					
				}
				if(t_ctgr_no != 0) {
					townBoardList = townBoardService.selectNonMemberCtgrTownBoardList(t_ctgr_no, pageno);
					resultMap.put("errorCode",4); 
					resultMap.put("errorMsg", "비회원 카테고리 성공");
					resultMap.put("data", townBoardList);
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("errorCode", -1);
			resultMap.put("errorMsg", "관리자에게 문의하세요");
		}
		return resultMap;
	}
	
	
	//게시글 삭제
	@RequestMapping("/townBoard_delete_rest")
	public Map<String, Object> townBoard_delete_rest(Integer pageno,@RequestParam Integer t_no){
		//String sUserId = (String)session.getAttribute("sUserId");
		Map<String, Object> resultMap = new HashMap<>();
		
		if (pageno == null || t_no == null) {
			resultMap.put("errorCode", -1);
			resultMap.put("errorMsg", "잘못된 접근입니다");
		}
		
		try {
			
			int result = townBoardService.deleteTownBoardOne(t_no);
			if (result == 1) {
				resultMap.put("errorCode", 1);
				resultMap.put("errorMsg", "게시글을 삭제하였습니다");
			} else {
				resultMap.put("errorCode", -2);
				resultMap.put("errorMsg", "게시글이 삭제되지 않았습니다");
			}
		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("errorCode", -3);
			resultMap.put("errorMsg", "관리자에게 문의하세요");
		}
		
		return resultMap;
	}
	
	
	
	//댓글등록
	@RequestMapping("/townReply_wirte_rest")
	public Map<String, Object> townReply_write_action(Integer pageno, @RequestParam Integer t_no, @ModelAttribute TownReply townReply, HttpSession session) {
		Map<String, Object> resultMap = new HashMap<>();
		String sUserId = (String)session.getAttribute("sUserId");
		
		try {
			int result = townReplyService.insertTownBoardReply(townReply);
			if (result == 1) {
				resultMap.put("errorCode", 1);
				resultMap.put("errorMsg", "게시글을 삭제하였습니다");
			} else {
				resultMap.put("errorCode", -2);
				resultMap.put("errorMsg", "게시글이 삭제되지 않았습니다");
			}
		}catch (Exception e) {
			e.printStackTrace();
			resultMap.put("errorCode", -3);
			resultMap.put("errorMsg", "관리자에게 문의하세요");
		}
		
		return resultMap;
	}
	
	//댓글 삭제
		@RequestMapping("/townReply_delete_rest")
		public Map<String, Object> townReply_delete_rest(Integer pageno,Integer t_no,@RequestParam Integer t_reply_no){
			//String sUserId = (String)session.getAttribute("sUserId");
			Map<String, Object> resultMap = new HashMap<>();
			
			if (pageno == null || t_reply_no == null) {
				resultMap.put("errorCode", -1);
				resultMap.put("errorMsg", "잘못된 접근입니다");
			}
			
			try {
				
				int result = townReplyService.deleteTownBoardReply(t_reply_no);
				if (result == 1) {
					resultMap.put("errorCode", 1);
					resultMap.put("errorMsg", "게시글을 삭제하였습니다");
				} else {
					resultMap.put("errorCode", -2);
					resultMap.put("errorMsg", "게시글이 삭제되지 않았습니다");
				}
			} catch (Exception e) {
				e.printStackTrace();
				resultMap.put("errorCode", -3);
				resultMap.put("errorMsg", "관리자에게 문의하세요");
			}
			
			return resultMap;
		}
	
	
	
	
	
	
	
}
