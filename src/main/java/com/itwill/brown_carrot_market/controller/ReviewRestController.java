package com.itwill.brown_carrot_market.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.brown_carrot_market.dto.Review;
import com.itwill.brown_carrot_market.service.ReviewService;

@RestController
public class ReviewRestController {

	@Autowired
	private ReviewService reviewService;
	
	//@PostMapping
	@RequestMapping("review_view_json")
	public Map review_view_json(HttpServletRequest request) throws Exception{
		Map resultMap=new HashMap();
		int code=1;
		String url="review_view_json";
		String msg="review_view_json 실패";
		
		String sUserId=(String)request.getSession().getAttribute("sUserId");
		List<Review> reviewList=
		reviewService.findReceivedReview(sUserId);
		
		resultMap.put("code", code);
		resultMap.put("url", url);
		resultMap.put("msg", msg);
		resultMap.put("data",reviewList);
		return resultMap;
	}
}
