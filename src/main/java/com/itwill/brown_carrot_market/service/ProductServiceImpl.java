package com.itwill.brown_carrot_market.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.itwill.brown_carrot_market.dao.ProductDao;
import com.itwill.brown_carrot_market.dto.Address;
import com.itwill.brown_carrot_market.dto.Product;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	@Qualifier("productDaoImpl")
	private ProductDao productDao;
	
	public ProductServiceImpl() throws Exception{
		System.out.println("### productServiceImpl : 기본생성자 호출");
	}

	@Override
	public List<Product> selectProductAll() throws Exception {
		// TODO Auto-generated method stub
		return productDao.selectProductAll();
	}

	@Override
	public List<Product> selectAllByCtgr(int p_ctgr_no) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> selectListByRange(Address address) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> selectListByRangeCtgr(int p_ctgr_no, Address address) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> selectByUserId(String user_id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product selectByOne(int p_no) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteByPNo(int p_no) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateProduct(Product product) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateProductCount(int p_no) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
