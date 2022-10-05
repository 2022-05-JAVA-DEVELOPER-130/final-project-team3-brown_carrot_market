package com.itwill.brown_carrot_market.controller;

import java.util.List;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.brown_carrot_market.dto.Product;
import com.itwill.brown_carrot_market.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService productService;
	public ProductController() {
		System.out.println("### ProductController() 기본생성자");
	}
	@RequestMapping(value = "/product_main")
	public String product_main() {
		return "product_main";
	}
	
	@RequestMapping("/product_list")
	public String product_list(Model model) throws Exception {

		List<Product> productList = productService.selectProductAll();
		model.addAttribute("productList", productList);	
		return "product_list";
	}
	
	@RequestMapping(value = "/product_detail", params = "p_no")
	public String guest_view(@RequestParam int p_no, Model model) throws Exception {
		
		Product product = productService.selectByOne(p_no);
		model.addAttribute("product", product);
		
		return "product_detail";
	}
}
