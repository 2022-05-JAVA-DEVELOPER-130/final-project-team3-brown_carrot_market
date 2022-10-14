package com.itwill.brown_carrot_market.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.brown_carrot_market.service.ProductService;

@RestController
public class ProductRestController {
	@Autowired
	private ProductService productService;
	
	
}
