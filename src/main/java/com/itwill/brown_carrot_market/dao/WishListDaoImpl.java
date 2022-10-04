package com.itwill.brown_carrot_market.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.brown_carrot_market.dto.WishList;
import com.itwill.brown_carrot_market.mapper.WishListMapper;

@Repository(value = "wishListDaoImpl")
public class WishListDaoImpl implements WishListDao{
	
	@Autowired(required = true)
	private WishListMapper wishListMapper;
	
	public WishListDaoImpl() {
		System.out.println("### WishListDaoImpl() : 디폴트 생성자 호출");
	}
	
	public WishListMapper getWishListMapper() {
		return wishListMapper;
	}

	public void setWishListMapper(WishListMapper wishListMapper) {
		System.out.println("### wishListDaoImpl : setWishListMapper 호출");
		this.wishListMapper = wishListMapper;
	}

	@Override
	public List<WishList> selectWishListAll(String user_id) throws Exception {
		System.out.println("### wishListDaoImpl : selectWishListAll 호출");
		return wishListMapper.selectWishListAll(user_id);
	}

	@Override
	public WishList selectWishListOne(int wishlist_no) throws Exception {
		System.out.println("### wishListDaoImpl : selectWishListOne 호출");
		return wishListMapper.selectWishListOne(wishlist_no);
	}

	@Override
	public int selectWishListCount(String user_id) throws Exception {
		System.out.println("### wishListDaoImpl : selectWishListCount 호출");
		return wishListMapper.selectWishListCount(user_id);
	}

	@Override
	public int insertWishList(WishList wishList) throws Exception {
		System.out.println("### wishListDaoImpl : insertWishList 호출");
		return wishListMapper.insertWishList(wishList);
	}

	@Override
	public int deleteWishList(int wishlist_no) throws Exception {
		System.out.println("### wishListDaoImpl : deleteWishList 호출");
		return wishListMapper.deleteWishList(wishlist_no);
	}
	
	
	
}
