package com.itwill.brown_carrot_market.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.brown_carrot_market.dto.Address;
import com.itwill.brown_carrot_market.dto.Product;
import com.itwill.brown_carrot_market.mapper.ProductMapper;

@Repository(value = "productDaoImpl")
public class ProductDaoImpl implements ProductDao{
	
	@Autowired(required = true)
	private ProductMapper productMapper;
	
	public ProductDaoImpl() {
		System.out.println("### ProductDaoImpl() : 디폴트생성자 호출");
	}
	
	public ProductMapper getProductMapper() {
		return productMapper;
	}
	
	public void setProductMapper(ProductMapper productMapper) {
		System.out.println("### ProductDaoImpl() : setProductMapper() 메소드 호출");
		this.productMapper = productMapper;
	}
	

	@Override
	public List<Product> selectProductAll() throws Exception{
		System.out.println("### ProductDaoImpl : selectProductAll 호출");
		
		return productMapper.selectProductAll();
	}

	@Override
	public List<Product> selectAllByCtgr(int p_ctgr_no) throws Exception {
		System.out.println("### ProductDaoImpl : selectAllByCtgr 호출");
		return productMapper.selectAllByCtgr(p_ctgr_no);
	}

	@Override
	public List<Product> selectListByRange(Address address) throws Exception {
		System.out.println("###ProductDaoImpl : selectListByRange 호출");
		return productMapper.selectListByRange(address);
	}

	@Override
	public List<Product> selectListByRangeCtgr(int p_ctgr_no, Address address) throws Exception {
		System.out.println("###ProductDaoImpl : selectListByRangeCtgr 호출");
		return productMapper.selectListByRangeCtgr(p_ctgr_no, address);
	}

	@Override
	public List<Product> selectByUserId(String user_id) throws Exception {
		System.out.println("###ProductDaoImpl : selectByUserId 호출");
		return productMapper.selectByUserId(user_id);
	}

	@Override
	public Product selectByOne(int p_no) throws Exception {
		System.out.println("###ProductDaoImpl : selectByOne 호출");
		return productMapper.selectByOne(p_no);
	}

	@Override
	public int deleteByPNo(int p_no) throws Exception {
		System.out.println("###ProductDaoImpl : deleteByPNo 호출");
		return productMapper.deleteByPNo(p_no);
	}
	
	@Override
	public int updateProduct(Product product)throws Exception {
		System.out.println("###ProductDaoImpl : updateProduct 호출");
		return productMapper.updateProduct(product);
	}

	@Override
	public int updateProductCount(int p_no)throws Exception {
		System.out.println("###ProductDaoImpl : updateProductCount 호출");
		return productMapper.updateProductCount(p_no);
	}
	
	@Override
	public int insertProduct(Map map) {
		System.out.println("###ProductDaoImpl : insertProduct 호출");
		productMapper.insertProduct(map);
		System.out.println(map);
		//System.out.println(map.get("p_no"));
		//map.get("p_no");
		return (int) map.get("p_no");
	}
	
	
	@Override
	public int updateProductWishCount(int p_no) throws Exception {
		System.out.println("###ProductDaoImpl : updateProductWishCount 호출");
		return productMapper.updateProductWishCount(p_no);
	}

	@Override
	public Map selectProductAddress(String user_id, int address_no) {
		Map paramMap=new HashMap();
		paramMap.put("user_id", user_id);
		paramMap.put("address_no", address_no);
		
		Map aa=productMapper.selectProductAddress(paramMap);
		System.out.println(aa);
		return aa;
	}

	@Override
	public int updateProductSell(int p_sell, int p_no) throws Exception {
		// TODO Auto-generated method stub
		return productMapper.updateProductSell(p_sell, p_no);
	}
	
	
	
	
	
	
}
