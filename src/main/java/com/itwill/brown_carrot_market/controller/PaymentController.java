package com.itwill.brown_carrot_market.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwill.brown_carrot_market.dto.Payment;
import com.itwill.brown_carrot_market.service.PaymentService;


@Controller
public class PaymentController {
//	@Autowired
//	private PaymentService paymentService;
	@LoginCheck
	@RequestMapping(value = "/payment")
	public String payment(Model model, HttpServletRequest request) throws Exception{
		String forwardPath="";
		String sUserId=(String)request.getSession().getAttribute("sUserId");
		request.getSession().setAttribute("sUserId", sUserId);
		if(sUserId==null || sUserId.equals("")) {
			return "user_login";
		}else {
		
		forwardPath="/payment";
		return forwardPath;
		}
	}
	
}