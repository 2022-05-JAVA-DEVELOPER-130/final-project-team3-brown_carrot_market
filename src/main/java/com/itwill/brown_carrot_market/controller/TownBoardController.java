package com.itwill.brown_carrot_market.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.brown_carrot_market.dto.Address;
import com.itwill.brown_carrot_market.dto.ProductCategory;
import com.itwill.brown_carrot_market.dto.TownBoard;
import com.itwill.brown_carrot_market.dto.TownCategory;
import com.itwill.brown_carrot_market.dto.UserInfo;
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
	public String townBoard_list(@RequestParam(required = false, defaultValue = "1") Integer pageno,Model model, HttpSession session, @RequestParam Map<String, Object> map, @RequestParam(required = false, defaultValue = "0") int t_ctgr_no) {
		
		System.out.println("townBoard_list컨트롤러 map: "+map);
		try {
			String sUserId = (String)session.getAttribute("sUserId");
			Address sAddress = (Address)session.getAttribute("sAddress");
			System.out.println("townBoard_list: sAddress" +sAddress);
			
			//회원 게시판 전체조회
			if(sUserId != null) {
				//카테고리 조건 없을때
				if(t_ctgr_no == 0) {
					PageMakerDto<TownBoard> townBoardList = townBoardService.selectTownBoardListCoordinate(sAddress, pageno);
					model.addAttribute("townBoardList", townBoardList);
					model.addAttribute("pageno", pageno);
					
				}
				//카테고리 조건 있을때
				if(t_ctgr_no != 0) {
					
					map.put("user_id", sUserId);
					//map.put("address_no", sAddress.getAddress_no());
					map.put("address", sAddress);
					
					PageMakerDto<TownBoard> townBoardList = townBoardService.selectTownBoardCtgrListCoordinate(map, t_ctgr_no, pageno);
					model.addAttribute("townBoardList", townBoardList);
					model.addAttribute("pageno", pageno);
					
				}
				
				
			}
			
			//비회원 게시판 전체조회	
			if(sUserId == null) {
				//카테고리 조건 없을때
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
	public String townBoard_Ctgr_list(@RequestParam(required = false, defaultValue = "1") Integer pageno, @RequestParam Map<String, Object> map,Model model, HttpSession session, int t_ctgr_no) {
		try {
			String sUserId = (String)session.getAttribute("sUserId");
			map.put("user_id", sUserId);
			
			Address sAddress = (Address)session.getAttribute("sAddress");
			map.put("address", sAddress);
			
			//회원 게시판 카테고리 조건 전체조회
			
			if(sUserId != null) {
				PageMakerDto<TownBoard> townBoardList = townBoardService.selectTownBoardCtgrListCoordinate(map, t_ctgr_no);
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
	//게시글 상세보기
	@RequestMapping(value = "/townboard_view")
	public String townBoard_view(@RequestParam int t_no,@RequestParam int pageno, Model model) throws Exception{
		
		try {
		TownBoard townBoard = townBoardService.selectTownBoardOne(t_no);
		townBoardService.updateTownBoardCount(t_no);
		model.addAttribute("townBoard", townBoard);
		model.addAttribute("pageno", pageno);
		}catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		
		return "townboard_view";
		
	}
	
	//게시글 작성 폼
	@RequestMapping("/townboard_write_form")
	public String townboard_write_form(HttpSession session) throws Exception{
		String sUserId = (String)session.getAttribute("sUserId");
		String forwardPath = "";
		//비회원일때
		if(sUserId == null) {
			forwardPath = "user_login";
		}
		//회원일때
		if(sUserId != null) {
			forwardPath = "townboard_write";
		}
		return forwardPath;
	}

	//새글 등록 
	@RequestMapping(value = "/townboard_write_action")
	public String townBoard_write_action(@RequestParam Map<String, Object> map, Model model, HttpSession session) throws Exception{
		String forwardPath = "";
		String sUserId = (String)session.getAttribute("sUserId");
		Address sAddress = (Address)session.getAttribute("sAddress");
		map.put("address", sAddress);
		
		try {
			
		UserInfo userInfo = new UserInfo(sUserId, sUserId, sUserId, sUserId, forwardPath, 0, 0, sUserId, null);
		map.put("userInfo", userInfo);	
		TownCategory townCategory = new TownCategory(Integer.parseInt(map.get("t_ctgr_no").toString()), "");
		map.put("townCategory", townCategory);
		map.remove("t_ctgr_no");
		
		//map.put("product", map);
		
		/*사진
		List<String> fileNames = new ArrayList<>();

		for (MultipartFile file : files) {
			System.out.println(file.isEmpty());
			if (!file.isEmpty()) {
				newFileName= storageService.save(file);
				fileNames.add(file.getOriginalFilename());

				message = "Uploaded the files successfully: " + fileNames+" newFileName"+newFileName;
			}else {
				message="Please select a valid mediaFile..";
			}
		}
		map.put("newFileName",newFileName);
		*/
		
		System.out.println("controller map : "+map);
		
		
		int insertCount = townBoardService.insertTownBoard(map);
		forwardPath = "redirect:townBoard_list";
		}catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("MSG", "잘모르는실패!!!");
			forwardPath = "redirect:main";
		}
		
		return forwardPath;
	}
	
	
	
	//게시글 수정폼
	@RequestMapping("/townboard_update_form")
	public String townboard_update_form(@RequestParam Integer pageno, Integer t_no, Model model, HttpSession session) throws Exception{
		String sUserId = (String)session.getAttribute("sUserId");
		String forwardPath = "";
		//비회원일때
		if(sUserId == null) {
			forwardPath = "user_login";
		}
		//회원일때
		if(sUserId != null) {
			forwardPath = "townboard_update";
		}
		return forwardPath;
	}
	
	//게시글 수정
	@RequestMapping("/townboard_update_action")
	public String townboard_update_action(@RequestParam Map<String, String> map, Model model, HttpSession session) throws Exception{
		String forwardPath = "";
		String pageno = map.get("pageno");
		String t_no = map.get("t_no");
		
	
		
		TownBoard townBoard = new TownBoard();
		townBoard.setT_no(Integer.parseInt(t_no));
		townBoard.setT_title(map.get("t_title"));
		townBoard.setT_content(map.get("t_content"));
		townBoardService.updateTownBoardOne(townBoard);
		
		
		return "redirect:townboard_view?pageno="+ pageno + "$t_no=" + t_no;
	}
	
	
	
	
	
	
	
	
	
	
	
}
