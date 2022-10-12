package com.itwill.brown_carrot_market.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
