package com.itwill.brown_carrot_market.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.brown_carrot_market.dto.TownBoard;
import com.itwill.brown_carrot_market.service.TownBoardService;
import com.itwill.brown_carrot_market.util.PageMakerDto;

@Controller
public class TownBoardController {
	@Autowired
	private TownBoardService townBoardService;
	
	//우리동네 게시판 전체 조회(비회원)
	@RequestMapping("/townBoard_list")
	public String townBoard_list(@RequestParam(required = false, defaultValue = "1") Integer pageno,Model model) {
		try {
		PageMakerDto<TownBoard> townBoardList = townBoardService.selectNonMemberTownBoardList(pageno);
		model.addAttribute("townBoardList", townBoardList);
		model.addAttribute("pageno", pageno);
		}catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		
		
		return "town_boardList";
	}
	
	
	
	
	
	
}
