package com.itwill.brown_carrot_market.service;

import java.util.List;

import com.itwill.brown_carrot_market.dto.Address;
import com.itwill.brown_carrot_market.dto.Product;

public interface ProductService {
	
	//비회원 상품 전체보기
		List<Product> selectProductAll() throws Exception;
		
		//비회원 카테고리별 상품 리스트 불러오기
		List<Product> selectAllByCtgr(int p_ctgr_no) throws Exception;
		
		//회원의 좌표값을 기준으로 범위 안의 모든 상품 불러오기
		List<Product> selectListByRange(Address address)throws Exception;
		
		//회원의 좌표값을 기준으로 범위와 선택한 카테고리 안의 모든 상품 불러오기
		List<Product> selectListByRangeCtgr(int p_ctgr_no, Address address)throws Exception;

		//회원이 올린 게시글 리스트 불러오기
		List<Product> selectByUserId(String user_id)throws Exception;
		
		//선택한 상품 하나 불러오기
		Product selectByOne(int p_no)throws Exception;
		
		//선택한 상품 삭제
		int  deleteByPNo(int p_no)throws Exception;
		
		//선택한 상품 업데이트
		int updateProduct(Product product)throws Exception;
		
		//상품 조회수 증가
		int updateProductCount(int p_no)throws Exception;
	
}
