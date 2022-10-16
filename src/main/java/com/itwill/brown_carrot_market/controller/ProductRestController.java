package com.itwill.brown_carrot_market.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.itwill.brown_carrot_market.dto.Address;
import com.itwill.brown_carrot_market.dto.Product;
import com.itwill.brown_carrot_market.dto.ProductCategory;
import com.itwill.brown_carrot_market.dto.ProductImage;
import com.itwill.brown_carrot_market.dto.UserInfo;
import com.itwill.brown_carrot_market.service.ProductService;
import com.itwill.brown_carrot_market.upload_file.service.FilesStorageServiceProduct;

@RestController
public class ProductRestController {
		@Autowired
		private ProductService productService;
		
		@Autowired
		@Qualifier(value="FilesStorageServiceImplProduct")
		FilesStorageServiceProduct storageService;
		
	@PostMapping("product_write_action_json")
	public Map product_write_action_json(@RequestParam("files") MultipartFile[] files,@RequestParam Map<String, Object> map, Model model, HttpSession session)throws Exception{
		int code = 0;
		String url = "product_list"; //어디로 보내야지?
		String message="product_write 실패";
		String newFileName= "";
		
		//사진저장
		Map<String,Object> resultMap = new HashMap();
		try {
			List<String> fileNames = new ArrayList<>();

			for (MultipartFile file : files) {
				System.out.println(file.isEmpty());
				if (!file.isEmpty()) {
					newFileName= storageService.save(file);
					//fileNames.add(file.getOriginalFilename());
					fileNames.add(newFileName);
					
					System.out.println(fileNames);
					message = "Uploaded the files successfully: " + fileNames+" newFileName"+newFileName;
				}else {
					message="Please select a valid mediaFile..";
				}
			}
			//사진 이름 리스트화
			
									
			
			//resultMap.put("message", message);
			//resultMap.put("newFileName", newFileName);
		
		
		//map.put("productImageList", fileNames.get(0));
		
		String sUserId = (String)session.getAttribute("sUserId");
		//map.put("user_id", sUserId);
		Address sAddress = (Address)session.getAttribute("sAddress");
		map.put("address", sAddress);
		UserInfo userInfo = new UserInfo(sUserId, sUserId, sUserId, sUserId, null, 0, 0, sUserId, null);
		map.put("userInfo", userInfo);	
		ProductCategory productCategory = new ProductCategory(Integer.parseInt(map.get("p_ctgr_no").toString()), "");
		map.put("productCategory", productCategory);
		map.put("ImageNameList", fileNames);
		
		
		map.remove("p_ctgr_no");
		
		
		
		Product resultList = new Product();
		
		System.out.println("RestController-user_update_profile_json() 호출");
		
		code = productService.insertProduct(map);
		if(code==1) message="product_write 성공";
		
		System.out.println("restController>>>"+map);
		
		resultMap.put("code", code);
		resultMap.put("url", url);
		resultMap.put("message", message);
		resultMap.put("data",resultList);
		
		
		return resultMap;
		
		} catch (Exception e) {
			e.printStackTrace();
			message = "Fail to upload files!";
			resultMap.put("message", message);
			
			//return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
			return resultMap;
		}
	}
}
