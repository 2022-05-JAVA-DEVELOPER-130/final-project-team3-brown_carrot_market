package com.itwill.brown_carrot_market.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.brown_carrot_market.dto.Address;
import com.itwill.brown_carrot_market.dto.TownReply;
import com.itwill.brown_carrot_market.service.TownReplyService;

@Controller
public class TownReplyController {
	@Autowired
	private TownReplyService townReplyService;
	
	public TownReplyController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping("/townReply_list")
	public String townBoardReply_list(@RequestParam Integer t_no ,Model model, HttpSession session) {

		String sUserId = (String)session.getAttribute("sUserId");
		Address sAddress = (Address)session.getAttribute("sAddress");
		
		List<TownReply> townReplyList = townReplyService.selectTownBoardReplyList(t_no);
		model.addAttribute("townReplyList", townReplyList);
		//townReply_list
		return "townReply_list";
	}
	
	
	
	
}
