package com.itwill.brown_carrot_market.dao;

import java.util.List;

import com.itwill.brown_carrot_market.dto.Address;
import com.itwill.brown_carrot_market.dto.Product;

public interface ProductDao {
	
	//비회원 상품 전체보기
	List<Product> selectProductAll() throws Exception;
	
	//비회원 카테고리별 상품 리스트 불러오기
	List<Product> selectAllByCtgr(int p_ctgr_no) throws Exception;
	
	//회원의 좌표값을 기준으로 범위 안의 모든 상품 불러오기
	List<Product> selectListByRange(Address address);

}
