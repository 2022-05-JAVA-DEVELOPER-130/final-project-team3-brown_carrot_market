package com.itwill.brown_carrot_market.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwill.brown_carrot_market.dto.Orders;
import com.itwill.brown_carrot_market.service.OrdersService;

@Controller
public class OrdersController {
	@Autowired
	private OrdersService ordersService;
	
	
	@RequestMapping("/orders_view")
	public String orders_view(HttpServletRequest request) throws Exception{
		String sUserId=(String)request.getSession().getAttribute("sUsdrId");
		List<Orders> ordersList=ordersService.selectAllById(sUserId);
		request.setAttribute("ordersList", ordersList);
		return "orders_view";
	}
}