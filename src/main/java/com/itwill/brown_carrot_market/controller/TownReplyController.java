package com.itwill.brown_carrot_market.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.brown_carrot_market.dto.Address;
import com.itwill.brown_carrot_market.dto.Notice;
import com.itwill.brown_carrot_market.dto.TownReply;
import com.itwill.brown_carrot_market.service.TownReplyService;

@Controller
public class TownReplyController {
	@Autowired
	private TownReplyService townReplyService;
	
	public TownReplyController() {
		// TODO Auto-generated constructor stub
	}
	/*
	@RequestMapping("/townReply_list")
	public String townBoardReply_list(@RequestParam Integer t_no ,Model model, HttpSession session) {

		String sUserId = (String)session.getAttribute("sUserId");
		Address sAddress = (Address)session.getAttribute("sAddress");
		
		List<TownReply> townReplyList = townReplyService.selectTownBoardReplyList(t_no);
		model.addAttribute("townReplyList", townReplyList);
		//townReply_list
		return "townReply_list";
	}
	*/
	
	//댓글 작성 폼
	@RequestMapping("/townReply_write_form")
	public String townReply_write_form(HttpSession session) {
		String sUserId = (String)session.getAttribute("sUserId");
		String forwardPath = "";
		/*
		 * js에서 폼 클릭하면 알림창 나오게 하는게 좋을듯
		//비회원일때
		if(sUserId == null) {
			forwardPath = "user_login";
		}
		//회원일때
		if(sUserId != null) {
			forwardPath = "";
		}
		*/
		return forwardPath;
	}
	
	//댓글작성
	@RequestMapping("/townReply_write_action")
	public String townReply_write_action(@ModelAttribute TownReply townReply, HttpSession session) {
		String sUserId = (String)session.getAttribute("sUserId");
		
		try {
		townReplyService.insertTownBoardReply(townReply);
		
		}catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		
		return null;
	}
	
	
}
