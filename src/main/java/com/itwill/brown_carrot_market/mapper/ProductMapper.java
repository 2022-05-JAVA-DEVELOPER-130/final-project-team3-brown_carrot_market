package com.itwill.brown_carrot_market.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.itwill.brown_carrot_market.dto.Product;

@Mapper
public interface ProductMapper {
	public List<Product> selectProductAll();
	
	public List<Product> selectAllByCtgr();
	
	public List<Product> selectListByRange();
	
	public List<Product> selectListByRangeCtgr();
	
	public List<Product> selectByUserId();
	
	public Product selectByOne();
	
	public int deleteByPNo(int p_no);
	
	public int updateProductCount(int p_no);

	public int updateProduct(Product product);
	
	public int updateProductWishCount(int p_no); 
	
/***********************	
	
	//insert
	
*************************/	
	
}
