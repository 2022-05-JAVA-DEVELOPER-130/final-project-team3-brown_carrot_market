package com.itwill.brown_carrot_market.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.brown_carrot_market.dto.Address;
import com.itwill.brown_carrot_market.dto.Product;
import com.itwill.brown_carrot_market.mapper.SearchMapper;

@Repository
public class SearchDaoImpl implements SearchDao{
	
	@Autowired
	SearchMapper searchMapper;

	@Override
	public List<Product> selectListSearch(String search_keyword, Address address) {
		// TODO Auto-generated method stub
		return searchMapper.selectListSearch(search_keyword, address);
	}

}
