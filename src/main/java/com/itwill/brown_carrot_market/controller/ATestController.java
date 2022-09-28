package com.itwill.brown_carrot_market.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ATestController {
	@Autowired
	// private HelloService helloService;

	public ATestController() {
		System.out.println(">> ATestController생성");
	}

	@RequestMapping(value = "main")
	public String main() {
		// System.out.println(">>>>>>>HelloService:"+helloService);
		// helloService.main();
		return "main";
	}

}