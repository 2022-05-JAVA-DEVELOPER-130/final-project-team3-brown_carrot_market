package com.itwill.brown_carrot_market.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.brown_carrot_market.dto.Transfer;
import com.itwill.brown_carrot_market.service.TransferService;

@RestController
public class TransferRestController {
	@Autowired
	private TransferService transferService;
	@GetMapping("/transfer_list_json")
	public Map transfer_view_json(Transfer transfer) throws Exception{
		Map resultMap = new HashMap();
		int code = 1;
		String url = "";
		String msg = "";
		
		List<Transfer> resultList = (ArrayList<Transfer>) transferService.selectById("carrot1");
		
		resultMap.put("code", code);
		resultMap.put("url", url);
		resultMap.put("msg", msg);
		resultMap.put("data", resultList);
		
		return resultMap;
	}
}
