package com.itwill.brown_carrot_market.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwill.brown_carrot_market.dto.Product;
import com.itwill.brown_carrot_market.dto.Transfer;
import com.itwill.brown_carrot_market.dto.UserInfo;
import com.itwill.brown_carrot_market.service.ProductService;
import com.itwill.brown_carrot_market.service.TransferService;
import com.itwill.brown_carrot_market.service.UserInfoService;

@Controller
public class TransferController {
	@Autowired
	private TransferService transferService;
	@Autowired
	private ProductService productService;
	@Autowired
	private UserInfoService userInfoService;

	@LoginCheck
	@RequestMapping(value = "/point_list")
	public String transfer_list(Model model, HttpServletRequest request) throws Exception {
		String forwardPath = "";
		String sUserId = (String) request.getSession().getAttribute("sUserId");
		if (sUserId == null || sUserId.equals("")) {
			return "user_login";
		} else {
			List<Transfer> transferList = transferService.selectById(sUserId);
			model.addAttribute("transferList", transferList);
			forwardPath = "/point_list";
			return forwardPath;
		}
	}
 
	@LoginCheck
	@RequestMapping(value = "/transfer_page")
	public String transfer_page(int p_no,Model model, HttpServletRequest request) throws Exception {
		String forwardPath = "";
		String sUserId = (String) request.getSession().getAttribute("sUserId");
		Product product = productService.selectByOne(p_no);
		model.addAttribute("product", product);
		forwardPath = "/transfer_page";
		return forwardPath;

	}
	
	@RequestMapping(value = "/transfer_action")
	public String transfer_action(int p_no, HttpServletRequest request) throws Exception {
		String forwardPath="";
		boolean result = transferService.transfer_transaction(p_no);
		if(result == true){
			forwardPath="redirect:transfer_fail?p_no="+p_no;
		}else if(result == false){
			forwardPath="redirect:transfer_complete?p_no="+p_no;
		}
		return forwardPath;
	}
	
	@LoginCheck
	@RequestMapping(value = "/transfer_complete")
	public String transfer_complete(int p_no,Model model, HttpServletRequest request) throws Exception {
		String sUserId = (String) request.getSession().getAttribute("sUserId");
		Product product = productService.selectByOne(p_no);
		model.addAttribute("product", product);
		return "/transfer_complete";
	}

	@LoginCheck
	@RequestMapping(value = "/transfer_fail")
	public String transfer_fail(int p_no,Model model, HttpServletRequest request) throws Exception {
		String sUserId = (String) request.getSession().getAttribute("sUserId");
		Product product = productService.selectByOne(p_no);
		UserInfo userInfo = userInfoService.findUser(sUserId);
		model.addAttribute("product", product);
		model.addAttribute("userInfo", userInfo);
		return "/transfer_fail";
	}

}
