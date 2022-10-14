package com.itwill.brown_carrot_market.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.itwill.brown_carrot_market.dto.Address;
import com.itwill.brown_carrot_market.dto.Product;
import com.itwill.brown_carrot_market.dto.ProductCategory;
import com.itwill.brown_carrot_market.dto.ProductImage;
import com.itwill.brown_carrot_market.dto.UserInfo;
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
		System.out.println(product);
		model.addAttribute("product", product);
		
		return "product_detail";
	}
	
	@RequestMapping("/product_write_form")
	public String product_write_form(HttpSession session)throws Exception {
		System.out.println("product_write_form 컨트롤러 호출-productService: " + productService);
		String forwardPath = "";
		String sUserId = (String)session.getAttribute("sUserId");
		//비회원 로그인폼으로 보내버리기
		forwardPath = "user_login";
		//회원 상품등록
		if(sUserId != null) {
				
			forwardPath = "product_write_form";
		}
		
		return forwardPath;
	}
	
	@RequestMapping(value = "/product_write_action", method = RequestMethod.GET)
	public String product_write_action_get() {
		return "redirect : product_list";
	}
	

	@RequestMapping(value = "/product_write_action", method = RequestMethod.POST)
	public String product_write_action(@RequestParam Map<String, Object> map, Model model, HttpSession session) {
		String forwardPath = "";
		String sUserId = (String)session.getAttribute("sUserId");
		//map.put("user_id", sUserId);
		Address sAddress = (Address)session.getAttribute("sAddress");
		map.put("address", sAddress);
		map.put("p_no", 0);
		System.out.println();
		
		String message = "";
		String newFileName= "";

		try {
			/*
			List<ProductImage> productImageList = new ArrayList<>();
			productImageList.add(new ProductImage(0, newFileName, 0));
			map.put("pi_name",newFileName);
			*/
			UserInfo userInfo = new UserInfo(sUserId, sUserId, sUserId, sUserId, forwardPath, 0, 0, sUserId, null);
			map.put("userInfo", userInfo);	
			ProductCategory productCategory = new ProductCategory(Integer.parseInt(map.get("p_ctgr_no").toString()), "");
			map.put("productCategory", productCategory);
			map.remove("p_ctgr_no");
			//map.put("product", map);
			
			
			//사진
			
			
			
			
			
			System.out.println("controller map : "+map);
			
			
			
			
			//인서트해주기
			int insertRowCount = productService.insertProduct(map);
			
			
			forwardPath = "redirect:product_list";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("MSG", "잘모르는실패!!!");
			forwardPath = "redirect:main";
		}
		return forwardPath;
	}
	
	@RequestMapping(value = "/product_delete_action", method = RequestMethod.GET)
	public String product_delete_action_get() {
		return "redirect : product_list";
	}
	
	/* 상품삭제
	@RequestMapping(value = "/product_delete_action", method = RequestMethod.POST)
	public String product_delete_action() {
		
		return "";
	}
	*/
	
	//상품 판매상태
	@RequestMapping(value = "/product_modify_sell_action")
	public String product_modify_sell_action(int p_sell,@RequestParam(value = "p_no", required = false, defaultValue = "")int p_no) {
		String forwardPath = "";
		try {
			int updateRowCount = productService.updateProductSell(p_sell, p_no);
			forwardPath = "redirect:product_list";
		} catch (Exception e) {
			e.printStackTrace();
			forwardPath = "product_list";
		}
		
		
		return forwardPath;
	}
	
	
	
}
