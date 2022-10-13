package com.itwill.brown_carrot_market.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.brown_carrot_market.dto.Address;
import com.itwill.brown_carrot_market.dto.Notice;
import com.itwill.brown_carrot_market.dto.TownBoard;
import com.itwill.brown_carrot_market.service.TownBoardService;
import com.itwill.brown_carrot_market.util.PageMakerDto;

@RestController
public class TownBoardRestController {
	@Autowired
	private TownBoardService townBoardService;
	
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
	
	
	
	
	
	
	
}
