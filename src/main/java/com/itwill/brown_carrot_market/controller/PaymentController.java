package com.itwill.brown_carrot_market.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwill.brown_carrot_market.dto.Payment;
import com.itwill.brown_carrot_market.dto.UserInfo;
import com.itwill.brown_carrot_market.service.PaymentService;
import com.itwill.brown_carrot_market.service.TransferService;
import com.itwill.brown_carrot_market.service.UserInfoService;

import ch.qos.logback.core.recovery.ResilientSyslogOutputStream;


@Controller
public class PaymentController {
	@Autowired
	private TransferService transferService;
	@Autowired
	private UserInfoService userInfoService;
	
	@LoginCheck
	@RequestMapping(value = "/payment")
	public String payment(Model model, UserInfo userInfo,HttpServletRequest request) throws Exception{
		String sUserId=(String)request.getSession().getAttribute("sUserId");
		userInfoService.findUser("sUser");
		if(sUserId==null || sUserId.equals("")) {
			return "user_login";
		}else {
			return "/payment";
		}
	}
	
//	@LoginCheck
//	@RequestMapping(value = "/payment_deposit")
//	public String payment_deposit(Model model, HttpServletRequest request) throws Exception{
//		String sUserId=(String)request.getSession().getAttribute("sUserId");
//		request.getSession().setAttribute("sUserId", sUserId);
//		if(sUserId==null || sUserId.equals("")) {
//			return "user_login";
//		}else {
//			return "/payment_deposit";
//		}
//	}
	
	@LoginCheck
	@RequestMapping(value = "/payment_complete")
	public String payment_complete(int payment_amount,Model model, HttpServletRequest request) throws Exception{
		String sUserId=(String)request.getSession().getAttribute("sUserId");
		UserInfo sUser=(UserInfo)request.getSession().getAttribute("sUser");
		request.getSession().setAttribute("sUserId", sUserId);
		if(sUserId==null || sUserId.equals("")) {
			return "user_login";
		}else {
			model.addAttribute("payment_amount",payment_amount);
			transferService.insert_Point_Deposit(payment_amount, sUserId);
			transferService.update_Point_By_Id(sUserId);
			UserInfo userInfo = userInfoService.findUser(sUserId);
			model.addAttribute("userInfo",userInfo);
			return "payment_complete";
		}
	}
	
	@LoginCheck
	@RequestMapping(value = "/payment_fail")
	public String payment_fail(Model model, HttpServletRequest request) throws Exception{
		String sUserId=(String)request.getSession().getAttribute("sUserId");
		request.getSession().setAttribute("sUserId", sUserId);
		if(sUserId==null || sUserId.equals("")) {
			return "user_login";
		}else {
			return "payment_fail";
		}
	}
	
}