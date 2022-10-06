package com.itwill.brown_carrot_market.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.brown_carrot_market.dto.Orders;
import com.itwill.brown_carrot_market.service.OrdersService;

@RestController
public class OrdersRestController {
	@Autowired
	private OrdersService ordersService;
	
	@GetMapping("/orders_view_json")
	public Map orders_view_json(Orders orders) throws Exception{
		Map resultMap = new HashMap();
		int code=1;
		String url = "main";
		String msg = "";
		
		List<Orders> resultsList = (ArrayList<Orders>) ordersService.selectAllById("carrot5");
		
		resultMap.put("code", code);
		resultMap.put("url", url);
		resultMap.put("msg",msg);
		resultMap.put("data", resultsList);
		return resultMap;
	}
	
}
