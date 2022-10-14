package com.itwill.brown_carrot_market.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.itwill.brown_carrot_market.dto.Address;
import com.itwill.brown_carrot_market.dto.Product;
@Mapper
public interface SearchMapper {
	public List<Product> selectListSearch(String search_keyword, Address address);
}
