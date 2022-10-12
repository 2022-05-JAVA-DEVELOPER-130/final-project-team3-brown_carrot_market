package com.itwill.brown_carrot_market.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwill.brown_carrot_market.service.ReviewService;


public class ReviewController {

	@Autowired
	private ReviewService reviewService;
	@RequestMapping("/review_write_form")
	public String user_login_form() {
		return "review_write_form";
	}
}
