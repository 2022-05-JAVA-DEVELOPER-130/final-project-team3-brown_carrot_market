package com.itwill.brown_carrot_market.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwill.brown_carrot_market.dto.Notice;
import com.itwill.brown_carrot_market.service.NoticeService;

@Controller
public class NoticeController {
	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping("/tables")
	public String notice_list(Model model)throws Exception{
		List<Notice> noticeList = noticeService.selectAll();
		model.addAttribute("noticeList", noticeList);
		
		return "tables";
	}
	
	
	
	
	
	
	
}
