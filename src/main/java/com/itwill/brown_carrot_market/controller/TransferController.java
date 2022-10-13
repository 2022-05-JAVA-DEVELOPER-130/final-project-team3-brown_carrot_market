package com.itwill.brown_carrot_market.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.brown_carrot_market.dto.Product;
import com.itwill.brown_carrot_market.dto.Transfer;
import com.itwill.brown_carrot_market.service.ProductService;
import com.itwill.brown_carrot_market.service.TransferService;

@Controller
public class TransferController {
	@Autowired
	private TransferService transferService;

	@LoginCheck
	@RequestMapping(value = "/point_list")
	public String transfer_list(Model model, HttpServletRequest request) throws Exception {
		String forwardPath = "";
		String sUserId = (String) request.getSession().getAttribute("sUserId");
		request.getSession().setAttribute("sUserId", sUserId);
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
	public String transfer_page(Model model, HttpServletRequest request) throws Exception {
		String forwardPath = "";
		String sUserId = (String) request.getSession().getAttribute("sUserId");
		request.getSession().setAttribute("sUserId", sUserId);
		if (sUserId == null || sUserId.equals("")) {
			return "user_login";
		} else {
			List<Transfer> transferList = transferService.selectById(sUserId);
			model.addAttribute("transferList", transferList);
			forwardPath = "/transfer_page";
			return forwardPath;
		}

	}
	@LoginCheck
	@RequestMapping(value = "/transfer_complate")
	public String transfer_complate(Model model, HttpServletRequest request) throws Exception {
		String forwardPath = "";
		String sUserId = (String) request.getSession().getAttribute("sUserId");
		request.getSession().setAttribute("sUserId", sUserId);
		if (sUserId == null || sUserId.equals("")) {
			return "user_login";
		} else {
			List<Transfer> transferList = transferService.selectById(sUserId);
			model.addAttribute("transferList", transferList);
			forwardPath = "/transfer_complate";
			return forwardPath;
		}

	}
}
