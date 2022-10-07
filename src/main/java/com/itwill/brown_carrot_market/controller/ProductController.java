package com.itwill.brown_carrot_market.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.brown_carrot_market.dto.Address;
import com.itwill.brown_carrot_market.dto.Product;
import com.itwill.brown_carrot_market.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService productService;
	public ProductController() {
		System.out.println("### ProductController() 기본생성자");
	}
	
	@RequestMapping(value={"/product_list",
							"/product_login_list"})
	public String product_list(Model model, HttpSession session) throws Exception {
		
		String sUserId = (String)session.getAttribute("sUserId");
		Address sAddress = (Address)session.getAttribute("sAddress");
		if(sUserId != null) {
			//로그인한 회원 주위의 상품 리스트
			List<Product> productLoginList = productService.selectListByRange(sAddress);
			model.addAttribute("productLoginList",productLoginList);
			return "product_login_list";
		}
		
		//비회원 상품리스트
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
	
	@RequestMapping("/product_write_form")
	public String product_write_form()throws Exception {
			System.out.println("product_write_form 컨트롤러 호출-productService: " + productService);
		return "product_write_form";
	}
	
	@RequestMapping(value = "/product_write_action", method = RequestMethod.GET)
	public String product_write_action_get() {
		return "redirect : product_list";
	}
	

	@RequestMapping(value = "/product_write_action", method = RequestMethod.POST)
	public String product_write_action(@RequestParam Map<String, Object> map, Model model, HttpSession session) {
		String forwardPath = "";
		String sUserId = (String)session.getAttribute("sUserId");
		Address sAddress = (Address)session.getAttribute("sAddress");
		try {
			map.put("product.userInfo.user_id", sUserId);
			map.put("user_id", sUserId);
			map.put("address_no", sAddress.getAddress_no());
			System.out.println(map);
			//model.addAttribute("product", map);
			
			int insertRowCount = productService.insertProduct(map);
			
			forwardPath = "redirect:product_list";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("MSG", "잘모르는실패!!!");
			forwardPath = "redirect:main";
		}
		return forwardPath;
	}
	
	
	
}
