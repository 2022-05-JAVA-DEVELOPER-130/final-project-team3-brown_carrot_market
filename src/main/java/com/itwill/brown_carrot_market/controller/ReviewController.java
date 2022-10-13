package com.itwill.brown_carrot_market.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.brown_carrot_market.dto.Orders;
import com.itwill.brown_carrot_market.dto.Review;
import com.itwill.brown_carrot_market.dto.UserInfo;
import com.itwill.brown_carrot_market.service.ReviewService;

@Controller
public class ReviewController {

	@Autowired
	private ReviewService reviewService;
	
	public ReviewController() {
		System.out.println(">> ReviewController()생성");
	}
	
	@RequestMapping("/review_write_form")
	public String review_write_form() {
		return "review_write_form";
	}
	
	@PostMapping("/review_write_action")
	public String review_write_action(@ModelAttribute Review review,HttpServletRequest request) throws Exception {
		
		System.out.println("****review_write_action-review: "+review);
		
		UserInfo sUser = (UserInfo)request.getSession().getAttribute("sUser");
		review.setUserInfo(sUser);
		
		int result= reviewService.createReview(review);
		
		return "redirect:orders_list";
	}
}
