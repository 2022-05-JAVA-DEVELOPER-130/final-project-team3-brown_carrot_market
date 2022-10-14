package com.itwill.brown_carrot_market.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.brown_carrot_market.dao.SearchDao;
import com.itwill.brown_carrot_market.dto.Address;
import com.itwill.brown_carrot_market.dto.Product;
@Service
public class SearchServiceImpl implements SearchService {
	@Autowired
	SearchDao searchDao;

	@Override
	public List<Product> selectListSearch(String search_keyword, Address address) {
		// TODO Auto-generated method stub
		return searchDao.selectListSearch(search_keyword, address);
	}

}
