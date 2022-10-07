package com.itwill.brown_carrot_market.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.brown_carrot_market.dto.Notice;
import com.itwill.brown_carrot_market.service.NoticeService;
import com.itwill.brown_carrot_market.util.PageMakerDto;


@RestController
public class NoticeRestController {
	@Autowired
	private NoticeService noticeService;
	
	
	
	
	/*
	 * 게시글 리스트 반환 (REST)
	 */
	@RequestMapping("/tables_rest")
	public  Map<String, Object> tables_rest(@RequestParam(required = false, defaultValue = "1") Integer pageno) {
		Map<String, Object> resultMap = new HashMap<>();	
		PageMakerDto<Notice> noticeList = null;
		try {
			noticeList = noticeService.selectAll(pageno);
			resultMap.put("errorCode", 1); 
			resultMap.put("errorMsg", "성공");
			resultMap.put("data", noticeList);
		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("errorCode", -1);
			resultMap.put("errorMsg", "관리자에게 문의하세요");
		}
		return resultMap;
	}
	
	
	
	
	
	
	
}
