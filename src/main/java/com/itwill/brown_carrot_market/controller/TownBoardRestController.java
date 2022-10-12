package com.itwill.brown_carrot_market.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.brown_carrot_market.dto.Notice;
import com.itwill.brown_carrot_market.dto.TownBoard;
import com.itwill.brown_carrot_market.service.TownBoardService;
import com.itwill.brown_carrot_market.util.PageMakerDto;

@RestController
public class TownBoardRestController {
	@Autowired
	private TownBoardService townBoardService;
	
	/*
	 * 게시글 리스트 반환 (REST) -- 비회원 전체조회
	 */
	@RequestMapping("/townBoard_list_nonmember_rest")
	public  Map<String, Object> townBoard_list_nonmember_rest(@RequestParam(required = false, defaultValue = "1") Integer pageno) throws Exception{
		Map<String, Object> resultMap = new HashMap<>();	
		PageMakerDto<TownBoard> townBoardList = null;
		try {
			townBoardList = townBoardService.selectNonMemberTownBoardList(pageno);
			resultMap.put("errorCode", 1); 
			resultMap.put("errorMsg", "성공");
			resultMap.put("data", townBoardList);
		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("errorCode", -1);
			resultMap.put("errorMsg", "관리자에게 문의하세요");
		}
		return resultMap;
	}
	
	
	
	
	
	
	
}
