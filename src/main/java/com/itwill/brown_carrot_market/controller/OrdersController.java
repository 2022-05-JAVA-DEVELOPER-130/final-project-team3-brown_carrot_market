package com.itwill.brown_carrot_market.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwill.brown_carrot_market.dto.Orders;
import com.itwill.brown_carrot_market.service.OrdersService;

@Controller
public class OrdersController {
	@Autowired
	private OrdersService ordersService;
	
	
	@RequestMapping(value = "/orders_view")
	public String orders_view(Model model/*HttpServletRequest request*/) throws Exception{
		String forwardPath="";
		
		//String sUserId=(String)request.getSession().getAttribute("carrot1");
		List<Orders> ordersList=ordersService.selectAllById("carrot2");
		model.addAttribute("ordersList", ordersList);
		forwardPath="/orders_view";
		
		return forwardPath;
	}
}