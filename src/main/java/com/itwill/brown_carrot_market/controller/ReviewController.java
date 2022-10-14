package com.itwill.brown_carrot_market.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itwill.brown_carrot_market.dto.Orders;
import com.itwill.brown_carrot_market.dto.Review;
import com.itwill.brown_carrot_market.dto.ReviewImage;
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
	public String review_write_action(@RequestParam Map<String, Object> map, HttpServletRequest request) throws Exception {
		
		//System.out.println("****review_write_action-review: "+review);
		System.out.println("****review_write_action-images: "+map);
		
		String json = map.get("review").toString();
		ObjectMapper mapper = new ObjectMapper();
		Review review = mapper.readValue(json, new TypeReference<Review>(){});
		System.out.println("review >>"+review);
		
		json = map.get("orders_no").toString();
		int orders_no= mapper.readValue(json, new TypeReference<Integer>(){});
		System.out.println("orders_no >>"+orders_no);
		review.setOrders(new Orders(orders_no, null, null, null, null, null));

		json = map.get("images").toString();
		if(json!=null && json!="") {	//image가 업로드 된 경우에만
			List<ReviewImage> reviewImages = mapper.readValue(json, new TypeReference<ArrayList<ReviewImage>>(){});
			System.out.println("reviewImages >>"+reviewImages);
			review.setReviewImageList(reviewImages);
		}
		
		UserInfo sUser = (UserInfo)request.getSession().getAttribute("sUser");
		review.setUserInfo(sUser);
		
		int result= reviewService.createReview(review);
		
		return "redirect:orders_list";
	}
}
