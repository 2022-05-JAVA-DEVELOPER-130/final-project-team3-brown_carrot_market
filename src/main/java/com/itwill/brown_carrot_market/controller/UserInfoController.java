package com.itwill.brown_carrot_market.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwill.brown_carrot_market.dto.Address;
import com.itwill.brown_carrot_market.dto.UserInfo;
import com.itwill.brown_carrot_market.service.UserInfoService;


@Controller
public class UserInfoController {
	@Autowired
	private UserInfoService userService;

	@RequestMapping(value = "/user_main")
	public String user_main() {
		return "user_main";
	}
	@RequestMapping("/user_write_form")
	public String user_write_form() {
		System.out
				.println("user_write_form 컨트롤러 호출-userService: " + userService);
		return "user_write_form";
	}
/*
	@RequestMapping(value = "/user_write_action", method = RequestMethod.POST)
	public String user_write_action_post(@ModelAttribute(value = "fuser") UserInfo user, @ModelAttribute(value = "address") Address address, Model model)
			throws Exception {
		System.out.println("parameter로 전달받은"+user);

		String forward_path = "";
		 // -1:아이디중복 1:회원가입성공
		int result = userService.create(user,address);
		if (result == -1) {
			model.addAttribute("msg",
					user.getUser_id() + " 는 이미 존재하는 아이디 입니다.");
			model.addAttribute("fuser", user);
			forward_path = "user_write_form";
		} else if (result == 1) {
			forward_path = "redirect:user_main";
		}
		return forward_path;
	}
*/
	@RequestMapping("/user_login_form")
	public String user_login_form() {
		//return "user_login_form";
		return "user_login";
	}

	@RequestMapping(value = "/user_login_action", method = RequestMethod.POST)
	public String user_login_action_post(
			@ModelAttribute(value = "fuser") UserInfo user,
			HttpServletRequest request) throws Exception {
		String forwardPath = "";
		
		int result = userService.login(user.getUser_id(), user.getUser_pw());
		
		System.out.println("user_login_action_post호출-result: "+result);
		
		/*
		 * 회원로그인 0:아이디존재안함 1:패쓰워드 불일치 2:로그인성공(세션)
		 */
		switch (result) {
			case 0 :
				request.setAttribute("msg1",
						user.getUser_id() + " 는 존재하지않는 아이디 입니다.");
				//forwardPath = "user_login_form";
				forwardPath = "user_login";
				break;
			case 1 :
				request.setAttribute("msg2", "패쓰워드가 일치하지 않습니다.");
				//forwardPath = "user_login_form";
				forwardPath = "user_login";
				break;
			case 2 :
				request.getSession().setAttribute("sUserId", user.getUser_id());
				forwardPath = "redirect:user_my-account";
				break;
		}
		return forwardPath;
	}

	@LoginCheck
	@RequestMapping("/user_my_account")
	public String user_my_account(HttpServletRequest request) throws Exception{
		/**************login check**************/
		
		String sUserId=(String)request.getSession().getAttribute("sUserId");
		UserInfo loginUser=userService.findUser(sUserId);
		request.setAttribute("loginUser", loginUser);
		return "user_my-account";
	}

	@LoginCheck
	@RequestMapping("/user_view")
	public String user_view(HttpServletRequest request) throws Exception{
		/**************login check**************/
		
		String sUserId=(String)request.getSession().getAttribute("sUserId");
		UserInfo loginUser=userService.findUser(sUserId);
		request.setAttribute("loginUser", loginUser);
		return "user_view";
	}
	@LoginCheck
	@RequestMapping(value = "/user_modify_form",method=RequestMethod.POST)
	public String user_modify_form_post(HttpServletRequest request)throws Exception {
		/**************login check**************/
		
		String sUserId=(String)request.getSession().getAttribute("sUserId");
		UserInfo loginUser=userService.findUser(sUserId);
		request.setAttribute("loginUser", loginUser);
		return "user_modify_form";
	}
	@LoginCheck
	@RequestMapping(value = "/user_modify_action",method = RequestMethod.POST)
	public String user_modify_action_post(@ModelAttribute UserInfo user) throws Exception{
		/**************login check**************/
		int rowCount=userService.update(user);
		return "redirect:user_view";
	}
	@LoginCheck
	@RequestMapping(value = "/user_remove_action",method = RequestMethod.POST)
	public String user_remove_action_post(HttpSession session) throws Exception{
		/**************login check**************/
		String sUserId=(String)session.getAttribute("sUserId");
		int rowCount=userService.remove(sUserId);
		session.invalidate();
		return "redirect:user_main";
	}
	@LoginCheck
	@RequestMapping(value = "/user_logout_action")
	public String user_logout_action(HttpSession session) {
		session.invalidate();
		return "redirect:index.jsp";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping(value = {"/user_modify_form",
							 "/user_login_action",
							 "/user_write_action",
							 "/user_modify_action",
							 "/user_remove_action"},
					method = RequestMethod.GET)
	public String user_action_get() {
	return "redirect:user_main";
	}

	@ExceptionHandler(Exception.class)
	public String handle_exception(Exception e) {
		return "user_error";
	}

}