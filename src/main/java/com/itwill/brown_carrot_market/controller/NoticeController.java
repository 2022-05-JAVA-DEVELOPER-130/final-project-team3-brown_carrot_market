package com.itwill.brown_carrot_market.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.brown_carrot_market.dto.Notice;
import com.itwill.brown_carrot_market.service.NoticeService;
import com.itwill.brown_carrot_market.util.PageMakerDto;

@Controller
public class NoticeController {
	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping("/notice_list")
	public String notice_list(@RequestParam(required = false, defaultValue = "1") Integer pageno,Model model)throws Exception{
		
		try {
		PageMakerDto<Notice> noticeList = noticeService.selectAll(pageno);
		//List<Notice> noticeList = noticeService.selectAll();
		model.addAttribute("noticeList", noticeList);
		model.addAttribute("pageno", pageno);
		}catch(Exception e) {
			e.printStackTrace();
			return "error";
		}
		
		return "tables";
	}
	
	@RequestMapping("/notice_view")
	public String notice_view(@RequestParam Integer pageno, Integer notice_no, Model model) throws Exception{
		if(pageno==null || notice_no==null) {
			return "tables";
		}
		try {
		Notice notice = noticeService.selectByNo(notice_no);
		noticeService.updateNoticeCount(notice_no);
		model.addAttribute("notice", notice);
		model.addAttribute("pageno", pageno);
		}catch (Exception e){
			e.printStackTrace();
			return "error";
		}
		return "tables-detail";
	}
	
	
	
	
	
	
	
}
