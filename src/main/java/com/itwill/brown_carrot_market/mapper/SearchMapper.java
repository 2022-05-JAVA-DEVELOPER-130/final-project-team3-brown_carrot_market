package com.itwill.brown_carrot_market.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.itwill.brown_carrot_market.dto.Address;
import com.itwill.brown_carrot_market.dto.Product;
@Mapper
public interface SearchMapper {
	public List<Product> selectListSearch(String search_keyword, Address address);
	
	
	public List<Product> selectListNotLogin(String search_keyword,int pageStart,int pageEnd);
	
	public int selectListNotLoginCount(String search_keyword);
}
