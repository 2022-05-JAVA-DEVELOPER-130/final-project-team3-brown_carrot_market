package com.itwill.brown_carrot_market.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.itwill.brown_carrot_market.dto.Address;
import com.itwill.brown_carrot_market.dto.Product;

@Mapper
public interface ProductMapper {
	public List<Product> selectProductAll();
	
	public List<Product> selectAllByCtgr(int p_ctgr_no);
	
	public List<Product> selectListByRange(Address address);
	
	public List<Product> selectListByRangeCtgr(int p_ctgr_no, Address address);
	
	public List<Product> selectByUserId(String user_id);
	
	public Product selectByOne(int p_no);
	public int selectProductPK();
	
	
	public int deleteByPNo(int p_no);
	
	public int updateProductCount(int p_no);

	public int updateProduct(Map map);
	
	public int updateProductSell(int p_sell, int p_no);

	public int updateProductWishCount(int p_no); 
	
	public Map selectProductAddress(Map map);
	
	public int insertProduct(Map map);
	
	
}
