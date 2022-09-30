package com.itwill.brown_carrot_market.dao;

import java.util.List;

import com.itwill.brown_carrot_market.dto.Product;

public interface ProductDao {

	List<Product> selectProductAll() throws Exception;

}
