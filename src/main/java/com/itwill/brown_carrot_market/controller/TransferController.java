package com.itwill.brown_carrot_market.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwill.brown_carrot_market.dto.Transfer;
import com.itwill.brown_carrot_market.service.TransferService;

@Controller
public class TransferController {
	@Autowired
	private TransferService transferService;
	
	@RequestMapping(value = "/transfer_list")
	public String transfer_list(Model model /*HttpServletRequest request*/) throws Exception{
		String forwardPath="";
		
		List<Transfer> transferList = transferService.selectById("carrot2");
		model.addAttribute("transferList", transferList);
		forwardPath="/transfer_list";
		
		return forwardPath;
	}
	
}
