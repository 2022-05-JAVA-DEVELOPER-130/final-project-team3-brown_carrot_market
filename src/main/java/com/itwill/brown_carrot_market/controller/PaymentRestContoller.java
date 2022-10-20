package com.itwill.brown_carrot_market.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.brown_carrot_market.dto.Orders;
import com.itwill.brown_carrot_market.dto.Payment;
import com.itwill.brown_carrot_market.dto.Transfer;
import com.itwill.brown_carrot_market.service.PaymentService;
import com.itwill.brown_carrot_market.service.TransferService;

@RestController
public class PaymentRestContoller {
	@Autowired
	private TransferService transferService;
	
	@RequestMapping("/payment_json")
	public Map payment_json (HttpServletRequest request) throws Exception{
		Map resultMap = new HashMap();
		int code=1;
		String url = "";
		String msg = "";
		String data = "";
		String sUserId=(String)request.getSession().getAttribute("sUserId");
		
		resultMap.put("code", code);
		resultMap.put("url", url);
		resultMap.put("msg", msg);
		resultMap.put("data", data);
		return resultMap;
	}
	
	@RequestMapping("/payment_complete_json")
	  public Map payment_complete_json (HttpServletRequest request, int payment_amount) throws Exception{
		Map resultMap = new HashMap();
		int code=1;
		String url = "";
		String msg = "";
		String data = "";
		String sUserId=(String)request.getSession().getAttribute("sUserId");
		int RowCount = transferService.insert_Point_Deposit(payment_amount, sUserId);
		
		System.out.println("payment_amount: "+payment_amount);
	
		resultMap.put("code", code);
		resultMap.put("url", url);
		resultMap.put("msg", msg);
		resultMap.put("RowCount", RowCount);
		return resultMap;
	}
}
