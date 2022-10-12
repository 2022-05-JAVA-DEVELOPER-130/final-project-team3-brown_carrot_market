package com.itwill.brown_carrot_market.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.brown_carrot_market.dto.Address;
import com.itwill.brown_carrot_market.dto.TownBoard;
import com.itwill.brown_carrot_market.service.TownBoardService;
import com.itwill.brown_carrot_market.util.PageMakerDto;

@Controller
public class TownBoardController {
	@Autowired
	private TownBoardService townBoardService;
	
	/*
	//우리동네 게시판 전체 조회
	@RequestMapping("/townBoard_list")
	public String townBoard_list(@RequestParam(required = false, defaultValue = "1") Integer pageno,Model model, HttpSession session) {
		try {
			String sUserId = (String)session.getAttribute("sUserId");
			Address sAddress = (Address)session.getAttribute("sAddress");
			System.out.println("townBoard_list: sAddress" +sAddress);
			
			//회원 게시판 전체조회
			if(sUserId != null) {
				PageMakerDto<TownBoard> townBoardList = townBoardService.selectTownBoardListCoordinate(sAddress, pageno);
				model.addAttribute("townBoardList", townBoardList);
				model.addAttribute("pageno", pageno);
			}
			
			//비회원 게시판 전체조회	
			if(sUserId == null) {
				PageMakerDto<TownBoard> townBoardList = townBoardService.selectNonMemberTownBoardList(pageno);
				model.addAttribute("townBoardList", townBoardList);
				model.addAttribute("pageno", pageno);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		
		
		return "town_boardList";
	}
	*/
	
	//우리동네 게시판 전체 조회 카테고리까지
	@RequestMapping("/townBoard_list")
	public String townBoard_list(@RequestParam(required = false, defaultValue = "1") Integer pageno,Model model, HttpSession session, @RequestParam(required = false, defaultValue = "0") int t_ctgr_no) {
		try {
			String sUserId = (String)session.getAttribute("sUserId");
			Address sAddress = (Address)session.getAttribute("sAddress");
			System.out.println("townBoard_list: sAddress" +sAddress);
			
			//회원 게시판 전체조회
			if(sUserId != null) {
				
				if(t_ctgr_no == 0) {
					PageMakerDto<TownBoard> townBoardList = townBoardService.selectTownBoardListCoordinate(sAddress, pageno);
					model.addAttribute("townBoardList", townBoardList);
					model.addAttribute("pageno", pageno);
					
				}
				if(t_ctgr_no != 0) {
					//PageMakerDto<TownBoard> townBoardList = townBoardService;
				}
				
				
			}
			
			//비회원 게시판 전체조회	
			if(sUserId == null) {
				if(t_ctgr_no == 0) {
					PageMakerDto<TownBoard> townBoardList = townBoardService.selectNonMemberTownBoardList(pageno);
					model.addAttribute("townBoardList", townBoardList);
					model.addAttribute("pageno", pageno);
					
				}
				//비회원이 카테고리 조건 전체조회
				if(t_ctgr_no != 0) {
					PageMakerDto<TownBoard> townBoardList = townBoardService.selectNonMemberCtgrTownBoardList(t_ctgr_no, pageno);
					model.addAttribute("townBoardList", townBoardList);
					model.addAttribute("pageno", pageno);
				}
				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		
		
		return "townboard_list";
	}
	
	/*
	//우리동네 게시판 카테고리 조건 전체 조회
	@RequestMapping("/townBoard_Ctgr_list")
	public String townBoard_Ctgr_list(@RequestParam(required = false, defaultValue = "1") Integer pageno,Model model, HttpSession session, int t_ctgr_no) {
		try {
			String sUserId = (String)session.getAttribute("sUserId");
			Address sAddress = (Address)session.getAttribute("sAddress");
			
			//회원 게시판 카테고리 조건 전체조회
			
			if(sUserId != null) {
				PageMakerDto<TownBoard> townBoardList = 
				model.addAttribute("townBoardList", townBoardList);
				model.addAttribute("pageno", pageno);
			}
			
			//비회원 게시판 카테고리 조건 전체조회	
			if(sUserId == null) {
				PageMakerDto<TownBoard> townBoardList = townBoardService.selectNonMemberCtgrTownBoardList(t_ctgr_no, pageno);
				model.addAttribute("townBoardList", townBoardList);
				model.addAttribute("pageno", pageno);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		
		
		return "townboard_list";
		
		
	}
	*/
	@RequestMapping(value = "/townboard_view", params = "t_no")
	public String townBoard_view(@RequestParam int t_no, Model model) {
		
		try {
		TownBoard townBoard = townBoardService.selectTownBoardOne(t_no);
		model.addAttribute("townBoard", townBoard);
		}catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		
		return "townboard_view";
		
	}
	
	
	
	
	
	
}
