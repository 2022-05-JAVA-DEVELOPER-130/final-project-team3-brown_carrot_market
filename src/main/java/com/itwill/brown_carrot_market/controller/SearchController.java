package com.itwill.brown_carrot_market.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwill.brown_carrot_market.dto.Address;
import com.itwill.brown_carrot_market.dto.Product;
import com.itwill.brown_carrot_market.service.SearchService;

@Controller
public class SearchController {
@Autowired
SearchService searchService;

@RequestMapping(value="/search_list",method=RequestMethod.GET)
public String searchKeyword(HttpServletRequest req, Model model, HttpSession session){
	String keyWord=req.getParameter("search_keyword");
	Address sAddress=(Address)session.getAttribute("sAddress");
	List<Product> searchList=null;
	System.out.println("검색 키워드:"+keyWord);
	if(sAddress!=null) {
		searchList= searchService.selectListSearch(keyWord, sAddress);
		model.addAttribute("searchList", searchList);
		System.out.println("로그인검색목록"+searchList);
	}else {
		searchList=searchService.selectListNotLogin(keyWord);
		model.addAttribute("searchList",searchList);
		System.out.println("검색목록"+searchList);
	}
return "search_list";	
}
	
}
