package com.itwill.brown_carrot_market.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.brown_carrot_market.dto.Notice;
import com.itwill.brown_carrot_market.service.NoticeService;
import com.itwill.brown_carrot_market.util.PageMakerDto;


@Controller
public class NoticeController {
	@Autowired
	private NoticeService noticeService;
	
	//공지사항 전체조회
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
	
	//공지사항 상세보기
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
	
	/*
	 * 새글 등록
	 */
	
	@LoginCheck
	@RequestMapping("/notice_new_write")
	public String notice_new_write(@ModelAttribute Notice notice, @RequestParam Integer pageno, HttpSession session) {
		String sUserId = (String)session.getAttribute("sUserId");
		if (pageno == null) {
			return "";
		}
		if(sUserId != "admin") {
			return "tables";
		}
		try {
			noticeService.insertNotice(notice);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "redirect:notice_list?pageno=" + pageno;
	}
	
	
	/*
	 * 게시글 입력폼
	 */
	@LoginCheck
	@RequestMapping("/notice_write_form")
	public String qna_write_form(Integer pageno, Model model, HttpSession session) {
		String sUserId = (String)session.getAttribute("sUserId");
		if (pageno == null) {
			return "";
		}
		if(sUserId != "admin") {
			return "redirect:notice_list";
		}
		try {
			//List<Cart> cartList = cartService.cartListAll((String) session.getAttribute("sM_id"));
			model.addAttribute("pageno", pageno);
			//model.addAttribute("cartList", cartList);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "tables-write";
	}
	
	
	
	
	
}
