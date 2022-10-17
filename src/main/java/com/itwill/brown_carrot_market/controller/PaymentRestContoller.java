package com.itwill.brown_carrot_market.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itwill.brown_carrot_market.dto.Payment;
import com.itwill.brown_carrot_market.service.PaymentService;

public class PaymentRestContoller {
	private PaymentService paymentService;
	@PostMapping("/payment_complate")
	  public @ResponseBody void transfer_complete_json (HttpServletRequest request, Payment payment) {
		Map resultMap = new HashMap();
		String url = "https://api.iamport.kr/kakao/payment/orders?payment_request_date=20221017&cid=TC0ONETIME&page=1&_token=ccbf1726c92ab47f51b5527bbd29ea779a24bb91";
		resultMap.put("url", url);
	}
}
