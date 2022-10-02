package com.itwill.brown_carrot_market.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.brown_carrot_market.dto.Orders;
import com.itwill.brown_carrot_market.service.OrdersService;

@RestController
public class OrdersRestController {
	@Autowired
	private OrdersService ordersService;
	
	@PostMapping("/orders_view_json")
	public Map orders_view_json(HttpServletRequest request) throws Exception{
		Map resultMap = new HashMap();
		int code=1;
		String url = "main";
		String msg = "";
		List<Orders> resultList = new ArrayList<Orders>();
		
		String sUserId=(String)request.getSession().getAttribute("sUsersId");
		List<Orders> ordersList = ordersService.selectAllById(sUserId);
		
		resultList.addAll(ordersList);
		
		resultMap.put("code",code);
		resultMap.put("url", url);
		resultMap.put("msg",msg);
		resultMap.put("data", ordersList);
		return resultMap;
	}
	
}
