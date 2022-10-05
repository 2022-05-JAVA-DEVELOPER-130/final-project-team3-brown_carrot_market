package com.itwill.brown_carrot_market.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.itwill.brown_carrot_market.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService productService;
	
	
}
