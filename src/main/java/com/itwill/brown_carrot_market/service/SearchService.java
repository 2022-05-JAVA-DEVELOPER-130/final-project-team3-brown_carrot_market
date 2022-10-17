package com.itwill.brown_carrot_market.service;

import java.util.List;

import com.itwill.brown_carrot_market.dto.Address;
import com.itwill.brown_carrot_market.dto.Product;
import com.itwill.brown_carrot_market.util.PageMakerDto;

public interface SearchService {
	public List<Product> selectListSearch(String search_keyword, Address address);
	
	public PageMakerDto<Product> selectListNotLogin(String search_keyword,int currentPage);
	
	public int selectListNotLoginCount(String search_keyword);
}
