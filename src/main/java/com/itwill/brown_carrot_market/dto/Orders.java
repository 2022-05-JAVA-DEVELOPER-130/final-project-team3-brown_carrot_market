package com.itwill.brown_carrot_market.dto;

/*
이름        널?       유형           
--------- -------- ------------ 
ORDERS_NO NOT NULL NUMBER(10)   
P_NO               NUMBER(20)   
USER_ID            VARCHAR2(10) 
 */
public class Orders {
	private int orders_no;
	private Product product;
	private String user_id;
	
	public Orders() {

	}

	public Orders(int orders_no, Product product, String user_id) {
		super();
		this.orders_no = orders_no;
		this.product = product;
		this.user_id = user_id;
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

	@Override
	public String toString() {
		return "\nOrders [orders_no=" + orders_no + ", product=" + product + ", user_id=" + user_id + "]";
	}

	
}
