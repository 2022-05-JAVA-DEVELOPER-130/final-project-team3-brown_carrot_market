package com.itwill.brown_carrot_market.dto;

import java.util.List;

public class Orders {
	private int orders_no;
	private Product product;
	private String user_id;
	
	private List<Orders> ordersList;
	
	public Orders() {

	}

	public Orders(int orders_no, Product product, String user_id, List<Orders> ordersList) {
		super();
		this.orders_no = orders_no;
		this.product = product;
		this.user_id = user_id;
		this.ordersList = ordersList;
	}

	public int getOrders_no() {
		return orders_no;
	}

	public void setOrders_no(int orders_no) {
		this.orders_no = orders_no;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public List<Orders> getOrdersList() {
		return ordersList;
	}

	public void setOrdersList(List<Orders> ordersList) {
		this.ordersList = ordersList;
	}

	@Override
	public String toString() {
		return "Orders [orders_no=" + orders_no + ", product.p_no=" + product.p_no + ", user_id=" + user_id + "]";
	}

	
}
