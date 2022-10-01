package com.itwill.brown_carrot_market.dto;

public class Orders {
	private int orders_no;
	private Product p_no;
	private UserInfo user_id;
	public Orders() {
		super();
	}
	
	public Orders(int orders_no, Product p_no, UserInfo user_id) {
		super();
		this.orders_no = orders_no;
		this.p_no = p_no;
		this.user_id = user_id;
	}

	public int getOrders_no() {
		return orders_no;
	}
	public void setOrders_no(int orders_no) {
		this.orders_no = orders_no;
	}
	public Product getP_no() {
		return p_no;
	}
	public void setP_no(Product p_no) {
		this.p_no = p_no;
	}
	public UserInfo getUser_id() {
		return user_id;
	}
	public void setUser_id(UserInfo user_id) {
		this.user_id = user_id;
	}
	
	@Override
	public String toString() {
		return "Orders [orders_no=" + orders_no + ", p_no=" + p_no + ", user_id=" + user_id + "]";
	}
	
	
	
}
