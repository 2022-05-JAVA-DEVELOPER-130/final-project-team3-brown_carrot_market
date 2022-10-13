package com.itwill.brown_carrot_market.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

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
	
	
	public String townBoardReply_list(Model model, HttpSession session) {

		String sUserId = (String)session.getAttribute("sUserId");
		Address sAddress = (Address)session.getAttribute("sAddress");
		
		//List<TownReply> 
		
		
		return null;
	}
	
	
	
	
}
