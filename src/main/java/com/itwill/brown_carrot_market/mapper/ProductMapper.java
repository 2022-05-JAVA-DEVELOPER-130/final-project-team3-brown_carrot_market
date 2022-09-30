package com.itwill.brown_carrot_market.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.itwill.brown_carrot_market.dto.Product;

@Mapper
public interface ProductMapper {
	public List<Product> selectProductAll();
	
	public List<Product> selectAllByCtgr();
	
}
