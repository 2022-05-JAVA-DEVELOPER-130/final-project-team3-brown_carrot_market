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
	public  Map<String, Object> townBoard_list_rest(@RequestParam(required = false, defaultValue = "1") Integer pageno, HttpSession session) throws Exception{
		Map<String, Object> resultMap = new HashMap<>();	
		PageMakerDto<TownBoard> townBoardList = null;
		String sUserId = (String)session.getAttribute("sUserId");
		Address sAddress = (Address)session.getAttribute("sAddress");
		try {
			//회원 게시글 리스트 반환
			if(sUserId != null) {
				townBoardList = townBoardService.selectTownBoardListCoordinate(sAddress, pageno);
				
				resultMap.put("errorCode", 1); 
				resultMap.put("errorMsg", "성공");
				resultMap.put("data", townBoardList);
			}
			//비회원 게시글 리스트 반환
			if(sUserId == null) {
				townBoardList = townBoardService.selectNonMemberTownBoardList(pageno);
				
				resultMap.put("errorCode",2); 
				resultMap.put("errorMsg", "성공");
				resultMap.put("data", townBoardList);
			}
		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("errorCode", -1);
			resultMap.put("errorMsg", "관리자에게 문의하세요");
		}
		return resultMap;
	}
	
	
	
	
	
	
	
}
