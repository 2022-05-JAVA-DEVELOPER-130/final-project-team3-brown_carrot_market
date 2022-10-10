package com.itwill.brown_carrot_market.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
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
import com.itwill.brown_carrot_market.dto.Invitation;
import com.itwill.brown_carrot_market.dto.UserInfo;
import com.itwill.brown_carrot_market.service.KakaoUserGetService;
import com.itwill.brown_carrot_market.service.KakaoRestJsonService;
import com.itwill.brown_carrot_market.service.UserInfoService;

@RestController
public class UserInfoRestController {
	@Autowired
	private UserInfoService userService;

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
			System.out.println("sUser: "+sUser);
			
			/***********수정 필요***********/
			Address sAddress=(Address)session.getAttribute("sAddress");
			System.out.println("sAddress: "+sAddress);
			/******************************/
			
			code=2;
			url="index";
			msg="세션존재";
			resultList.add(sUser);
			resultMap.put("sUserId",sUserId);
			resultMap.put("sUser",sUser);
			resultMap.put("sAddress",sAddress);
		}
		
		resultMap.put("code", code);
		resultMap.put("url", url);
		resultMap.put("msg", msg);
		resultMap.put("data",resultList);
		return resultMap;
		
	}
	
	@PostMapping(value = "/user_login_action_json")
	public Map user_login_action_json(@ModelAttribute(value = "sUser") UserInfo user,HttpServletRequest request) throws Exception{
		int code=0;
		String url="";
		String msg="";
		Map resultMap=new HashMap();
		List<UserInfo> resultList=new ArrayList<UserInfo>();
		System.out.println("user_login_action_json - user: "+user);
		
		int result= userService.login(user.getUser_id(), user.getUser_pw());
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
			UserInfo sUser=userService.findUser(user.getUser_id());
			request.getSession().setAttribute("sUser", sUser);
			System.out.println("sUser"+sUser);
			//우선은 address_range()>0 인 주소만 넣었습니다.
			if(sUser.getAddressList()!=null) {
				for(Address address: sUser.getAddressList()) {
					if(address.getAddress_range()>0) {
						request.getSession().setAttribute("sAddress", address);
					}
				}
			}
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
	@PostMapping("/user_view_json")
	public Map user_view_json(HttpServletRequest request) throws Exception{
		Map resultMap=new HashMap();
		int code=1;
		String url="user_main";
		String msg="";
		List<UserInfo> resultList=new ArrayList<UserInfo>();
		
		String sUserId=(String)request.getSession().getAttribute("sUserId");
		UserInfo sUser=userService.findUser(sUserId);
		
		resultList.add(sUser);
		
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
		
		UserInfo sUser=userService.findUser(sUserId);
		resultList.add(sUser);
		
		resultMap.put("code", code);
		resultMap.put("url", url);
		resultMap.put("msg", msg);
		resultMap.put("data",resultList);
		return resultMap;
	}
	
	@LoginCheck
	@PostMapping("/user_update_address_range_json")
	public Map user_update_address_range_json(HttpServletRequest request, @ModelAttribute Address address) throws Exception{
		System.out.println(address);
		Map resultMap=new HashMap();
		int code=0;
		String url="user_main";
		String msg="update_address 실패";
		List<UserInfo> resultList=new ArrayList<UserInfo>();

		System.out.println("RestController-user_update_address_range_json() 호출");
		/***********수정 필요***********/
		code = userService.updateAddressRange(address);
		if(code==1) msg="update_address 성공"; //request.getSession().setAttribute("sAddress", address);
		//System.out.println("sAddress :"+address);
		/******************************/
		
		resultMap.put("code", code);
		resultMap.put("url", url);
		resultMap.put("msg", msg);
		resultMap.put("data",resultList);
		return resultMap;
	}
	
	
	@LoginCheck
	@PostMapping("/user_update_profile_json")
	public Map user_update_profile_json(@ModelAttribute UserInfo userInfo) throws Exception{
		Map resultMap=new HashMap();
		int code=0;
		String url="user_update_profile";
		String msg="update_profile 실패";
		List<UserInfo> resultList=new ArrayList<UserInfo>();

		System.out.println("RestController-user_update_profile_json() 호출");
		/***********수정 필요***********/
		code = userService.updateProfile(userInfo);
		if(code==1) msg="update_profile 성공";

		/******************************/
		
		resultMap.put("code", code);
		resultMap.put("url", url);
		resultMap.put("msg", msg);
		resultMap.put("data",resultList);
		return resultMap;
	}
	
	@LoginCheck
	@PostMapping("/user_remove_address_json")
	public Map user_remove_address_json(HttpServletRequest request, @ModelAttribute Address address) throws Exception{
		System.out.println(address);
		Map resultMap=new HashMap();
		int code=0;
		String url="user_main";
		String msg="remove_address 실패";
		List<UserInfo> resultList=new ArrayList<UserInfo>();
		
		System.out.println("RestController-user_remove_address_json() 호출");
		/***********수정 필요***********/
		code = userService.removeAddress(address);
		if(code==1)
		msg="remove_address 성공";
		/******************************/
		//sAddress와 일치하는 address를 삭제했다면,
		Address sAddress= (Address)request.getSession().getAttribute("sAddress");
		System.out.println("before : "+sAddress);
		if(sAddress.getAddress_no()==address.getAddress_no()) request.getSession().setAttribute("sAddress", null);
		System.out.println("after : "+sAddress);
		
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
		UserInfo sUser=(UserInfo)request.getSession().getAttribute("sUser");
		
		System.out.println("RestController-user_insert_address_json() 호출");
		System.out.println("sUserId >>>>>>>>>"+sUserId);
		/***********수정 필요***********/
		address.setUser_id(sUserId);
		//최초 입력시에만 address_range=3
		if(sUser.getAddressList().size()!=0) {
			address.setAddress_range(0);
		}else {
			address.setAddress_range(3);
		}
		
		System.out.println("insert_addrss: "+address);
		//System.out.println(address);
		code=userService.createAddress(address);
		if(code==1) {
			msg="insert_address 성공";
			if(sUser.getAddressList()!=null) {
				for(Address address2: sUser.getAddressList()) {
					if(address2.getAddress_range()>0) {
					request.getSession().setAttribute("sAddress", address);
					}
				}
			}
		
		}
		/******************************/
		//변경사항 저장
		sUser=userService.findUser(sUserId);
		resultList.add(sUser);
		
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
		UserInfo sUser=userService.findUser(sUserId);
		resultList.add(sUser);
		
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
			UserInfo sUser=userService.findUser(sUserId);
			resultList.add(sUser);
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
	public Map user_write_action_json(@ModelAttribute(value = "fuser") UserInfo user, Address address, Invitation invitation, Model model) 
			throws Exception{
		System.out.println(invitation);
		
		Map resultMap=new HashMap();
		int code=0;
		String url="user_main";
		String msg="세션존재함";
		List<UserInfo> resultList=new ArrayList<UserInfo>();
		/*
		 *  0:아이디중복
		 *  1:회원가입성공
		 *  2:초대코드로 회원가입
		 *  3:존재하지 않는 초대코드로 회원가입 
		 */
		if(address!=null) address.setAddress_range(3);
		int result=userService.create(user,address,invitation);
		if(result==0) {
			code=0;
			url="user_write_form";
			msg= user.getUser_id()+" 는 이미 존재하는 아이디 입니다.";
			
		}else if(result==1) {
			
			code=1;
			url="user_login_form";
			msg= "회원가입성공";
		}else if (result==2) {
			//초대코드로 회원가입시 포인트 부여
			//int updatePointResult= userService.updatePoint(user, invitation);
			code=2;
			url="user_login_form";
			msg= "회원가입성공& point적립";
		}else if (result==3) {
			code=3;
			url="user_login_form";
			msg= "회원가입성공& 존재하지않는코드";
		}
		
		resultMap.put("code", code);
		resultMap.put("url", url);
		resultMap.put("msg", msg);
		resultMap.put("data",resultList);
		return resultMap;
	}
	
	/*
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
	*/
	
	/*
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
	*/
	
	
	/*
	@RequestMapping("/user_kakaologin_json")
	public Map user_kakaologin_json(@RequestParam("code") String _code,Model model,HttpServletRequest request) throws Exception{
		Map resultMap=new HashMap();
		int code=1;
		String url="user_kakaologin_json";
		String msg="";
		
		System.out.println("user_kakaologin_json() - code: "+_code);
		
		KakaoRestJsonService restJsonService = new KakaoRestJsonService();
		
		//access_token이 포함된 JSON String을 받아온다.
        String accessTokenJsonData = restJsonService.getAccessTokenJsonData(_code);
        if(accessTokenJsonData=="error") msg= "error";

        //JSON String -> JSON Object
        JSONObject accessTokenJsonObject = new JSONObject(accessTokenJsonData);

        //access_token 추출
        String accessToken = accessTokenJsonObject.get("access_token").toString();
        System.out.println("user_kakaologin_json() - access_token: "+accessToken);
        
        model.addAttribute("access_token", accessToken);
		
        
        //유저 정보가 포함된 JSON String을 받아온다.
        KakaoUserGetService getUserInfoService = new KakaoUserGetService();
        String userInfo = getUserInfoService.getUserInfo(accessToken);

        //JSON String -> JSON Object
        JSONObject userInfoJsonObject = new JSONObject(userInfo);

        //유저의 Email 추출
        JSONObject kakaoAccountJsonObject = (JSONObject)userInfoJsonObject.get("kakao_account");
        String email = kakaoAccountJsonObject.get("email").toString();

        //View에서 사용할 변수 설정
        model.addAttribute("email", email);

        //(test)
        String profile = kakaoAccountJsonObject.get("profile").toString();
        model.addAttribute("profile", profile);

        String id = (String)userInfoJsonObject.get("id").toString();
        //model.addAttribute("id", id);
        
		resultMap.put("code", code);
		resultMap.put("url", url);
		resultMap.put("msg", msg);
		resultMap.put("data",model);
		resultMap.put("id",id+"K");
		return this.user_kakaologin_action_json(resultMap,request);
	}
	
	@PostMapping(value = "/user_kakaologin_action_json")
	public Map user_kakaologin_action_json(Map map,HttpServletRequest request) throws Exception{
		int code=0;
		String url="";
		String msg="";
		Map resultMap=new HashMap();
		List<UserInfo> resultList=new ArrayList<UserInfo>();
		System.out.println("user_kakaologin_action_json - map: "+map);
		
		//Model model = (Model)map.get("data");
		//String user_id= (String)model.getAttribute("id");
		String user_id= (String)map.get("id");
		
		UserInfo kakaoUser= userService.findUser(user_id);
		
		if(kakaoUser!=null) {
			request.getSession().setAttribute("sUserId",kakaoUser.getUser_id());
			request.getSession().setAttribute("sUser", kakaoUser);
			
			if(kakaoUser.getAddressList()!=null) {
				for(Address address: kakaoUser.getAddressList()) {
					if(address.getAddress_range()>0) {
						request.getSession().setAttribute("sAddress", address);
					}
				}
			}
			code=2;
			url="user_main";
			msg="로그인 성공";
			resultList.add(kakaoUser);
		}

		resultMap.put("code", code);
		resultMap.put("url", url);
		resultMap.put("msg", msg);
		resultMap.put("data",resultList);
		return resultMap;
	}
	*/
	
}
