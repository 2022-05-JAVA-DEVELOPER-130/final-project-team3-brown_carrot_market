package com.itwill.brown_carrot_market.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.brown_carrot_market.dto.Address;
import com.itwill.brown_carrot_market.dto.UserInfo;
import com.itwill.brown_carrot_market.service.UserInfoService;



@RestController
public class UserInfoRestController {
	@Autowired
	private UserInfoService userService;
	
	@LoginCheck
	@PostMapping("/user_account_details")
	public Map user_account_details_json(HttpServletRequest request) throws Exception{
		Map resultMap=new HashMap();
		int code=1;
		String url="user_main";
		String msg="";
		List<UserInfo> resultList=new ArrayList<UserInfo>();
		
		String sUserId=(String)request.getSession().getAttribute("sUserId");
		UserInfo loginUser=userService.findUser(sUserId);
		resultList.add(loginUser);
		
		resultMap.put("code", code);
		resultMap.put("url", url);
		resultMap.put("msg", msg);
		resultMap.put("data",resultList);
		return resultMap;
	}
	
	@LoginCheck
	@PostMapping("/user_view_json")
	public Map user_view_json(HttpServletRequest request) throws Exception{
		Map resultMap=new HashMap();
		int code=1;
		String url="user_main";
		String msg="";
		List<UserInfo> resultList=new ArrayList<UserInfo>();
		
		String sUserId=(String)request.getSession().getAttribute("sUserId");
		UserInfo loginUser=userService.findUser(sUserId);
		resultList.add(loginUser);
		
		resultMap.put("code", code);
		resultMap.put("url", url);
		resultMap.put("msg", msg);
		resultMap.put("data",resultList);
		return resultMap;
	}
	
	@LoginCheck
	@PostMapping("/user_update_address_json")
	public Map user_update_address_json(HttpServletRequest request, @ModelAttribute Address address) throws Exception{
		Map resultMap=new HashMap();
		int code=0;
		String url="user_main";
		String msg="update_address 실패";
		List<UserInfo> resultList=new ArrayList<UserInfo>();
		
		String sUserId=(String)request.getSession().getAttribute("sUserId");

		System.out.println("RestController-user_update_address_json() 호출");
		System.out.println("sUserId >>>>>>>>>"+sUserId);
		address.setUser_id(sUserId);
		/***********수정 필요***********/
		code = userService.updateAddress(address);
		/******************************/
		
		UserInfo loginUser=userService.findUser(sUserId);
		resultList.add(loginUser);
		
		resultMap.put("code", code);
		resultMap.put("url", url);
		resultMap.put("msg", msg);
		resultMap.put("data",resultList);
		return resultMap;
	}
	@LoginCheck
	@PostMapping("/user_insert_address_json")
	public Map user_insert_address_json(HttpServletRequest request, @ModelAttribute Address address) throws Exception{
		Map resultMap=new HashMap();
		int code=0;
		String url="user_main";
		String msg="insert_address 실패";
		List<UserInfo> resultList=new ArrayList<UserInfo>();
		
		String sUserId=(String)request.getSession().getAttribute("sUserId");
		
		System.out.println("RestController-user_insert_address_json() 호출");
		System.out.println("sUserId >>>>>>>>>"+sUserId);
		/***********수정 필요***********/
		address.setUser_id(sUserId);
		System.out.println(address);
		code=userService.createAddress(address);
		/******************************/
		
		UserInfo loginUser=userService.findUser(sUserId);
		resultList.add(loginUser);
		
		resultMap.put("code", code);
		resultMap.put("url", url);
		resultMap.put("msg", msg);
		resultMap.put("data",resultList);
		return resultMap;
	}
	
	@LoginCheck
	@PostMapping("/user_remove_action_json")
	public Map user_remove_action_json(HttpServletRequest request) throws Exception{
		Map resultMap=new HashMap();
		int code=1;
		String url="user_main";
		String msg="";
		List<UserInfo> resultList=new ArrayList<UserInfo>();
		String sUserId=(String)request.getSession().getAttribute("sUserId");
		int row_count=userService.remove(sUserId);
		
		request.getSession().invalidate();
		
		resultMap.put("code", code);
		resultMap.put("url", url);
		resultMap.put("msg", msg);
		resultMap.put("data",resultList);
		return resultMap;
	}
	@LoginCheck
	@PostMapping("/user_modify_form_json")
	public Map user_modify_form_json(HttpServletRequest request) throws Exception{
		Map resultMap=new HashMap();
		int code=1;
		String url="user_modify_form";
		String msg="";
		List<UserInfo> resultList=new ArrayList<UserInfo>();
		
		String sUserId=(String)request.getSession().getAttribute("sUserId");
		UserInfo loginUser=userService.findUser(sUserId);
		resultList.add(loginUser);
		
		resultMap.put("code", code);
		resultMap.put("url", url);
		resultMap.put("msg", msg);
		resultMap.put("data",resultList);
		return resultMap;
	}

	@PostMapping(value="/user_modify_action_json")
	public Map user_modify_action_json(@ModelAttribute UserInfo user,Model model,HttpServletRequest request) 
			throws Exception{
		Map resultMap=new HashMap();
		int code=1;
		String url="user_main";
		String msg="";
		List<UserInfo> resultList=new ArrayList<UserInfo>();
		
		try {
			int row_count=userService.update(user);
			String sUserId=(String)request.getSession().getAttribute("sUserId");
			UserInfo loginUser=userService.findUser(sUserId);
			resultList.add(loginUser);
			code=1;
			url="user_main";
			msg= "회원수정성공";
		}catch(Exception e) {
			code=2;
			url="user_main";
			msg= "회원수정실패";
			e.printStackTrace();
		}
		resultMap.put("code", code);
		resultMap.put("url", url);
		resultMap.put("msg", msg);
		resultMap.put("data",resultList);
		return resultMap;
	}
	
	@LoginCheck
	@PostMapping(value = "/user_logout_action_json")
	public Map user_logout_action_json(HttpServletRequest request) {
		
		Map resultMap=new HashMap();
		int code=1;
		String url="user_main";
		String msg="";
		List<UserInfo> resultList=new ArrayList<UserInfo>();
		
		request.getSession().invalidate();
		
		resultMap.put("code", code);
		resultMap.put("url", url);
		resultMap.put("msg", msg);
		resultMap.put("data",resultList);
		return resultMap;
	}

	@PostMapping(value = "/user_login_action_json")
	public Map user_login_action_json(@ModelAttribute(value = "loginUser") UserInfo user,HttpServletRequest request) throws Exception{
		
		int code=0;
		String url="";
		String msg="";
		Map resultMap=new HashMap();
		List<UserInfo> resultList=new ArrayList<UserInfo>();
		System.out.println("파라메타로 받은 >>>>>>>"+user);
		
		int result=
				userService.login(user.getUser_id(), user.getUser_pw());
		System.out.println("result >>>>>>>"+result);
		
		/*
		 * 회원로그인
		 * 0:아이디존재안함
		 * 1:패쓰워드 불일치
		 * 2:로그인성공(세션)
		 */
		switch (result) {
		case 0:
			code=0;
			url="user_login_form";
			msg="아이디존재안함";
			break;
		case 1:
			code=1;
			url="user_login_form";
			msg="패쓰워드 불일치";
			break;
		case 2:
			request.getSession().setAttribute("sUserId", user.getUser_id());
			//우선은 첫번째 주소만 넣었습니다.
			if(user.getAddressList()!=null) {
				request.getSession().setAttribute("sAddressNo", user.getAddressList().get(0).getAddress_no());
			}
			UserInfo sUser=userService.findUser(user.getUser_id());
			
			code=2;
			url="user_main";
			msg="로그인 성공";
			resultList.add(sUser);
			break;

		}
		resultMap.put("code", code);
		resultMap.put("url", url);
		resultMap.put("msg", msg);
		resultMap.put("data",resultList);
		return resultMap;
	}
	
	@LoginCheck
	@PostMapping(value = "/user_session_check_json")
	public Map user_session_check_json(HttpSession session) throws Exception{
		Map resultMap=new HashMap();
		int code=1;
		String url="index";
		String msg="세션존재 안함XX";
		List<UserInfo> resultList=new ArrayList<UserInfo>();
		String sUserId=(String)session.getAttribute("sUserId");
		System.out.println("user_session_check_json : sUserId >>> "+sUserId);
		if(sUserId!=null) {
			UserInfo sUser=userService.findUser(sUserId);
			code=2;
			url="index";
			msg="세션존재";
			resultList.add(sUser);
		}
		
		resultMap.put("code", code);
		resultMap.put("url", url);
		resultMap.put("msg", msg);
		resultMap.put("data",resultList);
		return resultMap;
		
	}
	@PostMapping(value = "/user_id_check_json")
	public boolean user_id_check_json(@RequestParam String userId) throws Exception{
		System.out.println(userId);
		Map resultMap=new HashMap();
		int code=1;
		String url="user_main";
		String msg="세션존재함";
		List<UserInfo> resultList=new ArrayList<UserInfo>();
		boolean isDuplicate=userService.isDuplicateId(userId);
		return !isDuplicate;
		
	}
	
	@PostMapping(value="/user_write_action_json")
	public Map user_write_action_json(@ModelAttribute(value = "fuser") UserInfo user, Address address,Model model) 
			throws Exception{
		Map resultMap=new HashMap();
		int code=1;
		String url="user_main";
		String msg="세션존재함";
		List<UserInfo> resultList=new ArrayList<UserInfo>();
		/*
		 *  0:아이디중복
		 *  1:회원가입성공
		 */
		int result=userService.create(user,address);
		if(result==-1) {
			code=2;
			url="user_write_form";
			msg= user.getUser_id()+" 는 이미 존재하는 아이디 입니다.";
			
		}else if(result==1) {
			code=1;
			url="user_login_form";
			msg= "회원가입성공";
		}
		
		resultMap.put("code", code);
		resultMap.put("url", url);
		resultMap.put("msg", msg);
		resultMap.put("data",resultList);
		return resultMap;
	}
}
