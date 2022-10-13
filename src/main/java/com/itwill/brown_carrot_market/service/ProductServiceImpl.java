package com.itwill.brown_carrot_market.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.itwill.brown_carrot_market.dao.ProductDao;
import com.itwill.brown_carrot_market.dao.ProductImageDao;
import com.itwill.brown_carrot_market.dto.Address;
import com.itwill.brown_carrot_market.dto.Product;
import com.itwill.brown_carrot_market.dto.ProductImage;
import com.itwill.brown_carrot_market.dto.ReviewImage;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	@Qualifier("productDaoImpl")
	private ProductDao productDao;
	/**************채팅방*********************/
	@Autowired
	@Qualifier("productImageDaoImpl")
	private ProductImageDao productImageDao;
	/****************************************/
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
		return productDao.selectAllByCtgr(p_ctgr_no);
	}

	@Override
	public List<Product> selectListByRange(Address address) throws Exception {
		// TODO Auto-generated method stub
		return productDao.selectListByRange(address);
	}

	@Override
	public List<Product> selectListByRangeCtgr(int p_ctgr_no, Address address) throws Exception {
		// TODO Auto-generated method stub
		return productDao.selectListByRangeCtgr(p_ctgr_no, address);
	}

	@Override
	public List<Product> selectByUserId(String user_id) throws Exception {
		// TODO Auto-generated method stub
		return productDao.selectByUserId(user_id);
	}

	@Override
	public Product selectByOne(int p_no) throws Exception {
		// TODO Auto-generated method stub
		return productDao.selectByOne(p_no);
	}

	@Override
	public int deleteByPNo(int p_no) throws Exception {
		// TODO Auto-generated method stub
		return productDao.deleteByPNo(p_no);
	}

	@Override
	public int updateProduct(Product product) throws Exception {
		// TODO Auto-generated method stub
		return productDao.updateProduct(product);
	}

	@Override
	public int updateProductCount(int p_no) throws Exception {
		// TODO Auto-generated method stub
		return productDao.updateProductCount(p_no);
	}

	@Override
	public int insertProduct(Map map) throws Exception {
		int result = 0;
		int p_no = productDao.insertProduct(map);
		//Product product = (Product)map;
		/*
		if(product.getProductImagesList()!=null) {
		List<ProductImage> productImageList = new ArrayList();
		for (ProductImage productImage : product.getProductImagesList()) {
			productImage.setP_no(p_no);
			productImageList.add(productImage);
			}
		result = productImageDao.insertProductListImg(productImageList);
		}
		 */
		return result;
	}
	// 채팅에서 사용 
	@Override
	public List<ProductImage> selectProductImgList(int p_no) throws Exception{
		
		return productImageDao.selectProductImgList(p_no);
	}

	@Override
	public int updateProductSell(int p_sell, int p_no) throws Exception {
		// TODO Auto-generated method stub
		return productDao.updateProductSell(p_sell, p_no);
	}
	
	
	
}
