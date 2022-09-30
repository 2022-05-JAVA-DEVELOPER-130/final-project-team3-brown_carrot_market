package com.itwill.brown_carrot_market.dto;

/*
 이름      널?       유형           
------- -------- ------------ 
PI_NO   NOT NULL NUMBER(10)   
PI_NAME          VARCHAR2(50) 
P_NO             NUMBER(20)  
*/

public class ProductImage {
	public int pi_no;
	public String pi_name;
	public Product product;
	
	public ProductImage() {		
	}

	public ProductImage(int pi_no, String pi_name, Product product) {
		super();
		this.pi_no = pi_no;
		this.pi_name = pi_name;
		this.product = product;
	}

	public int getPi_no() {
		return pi_no;
	}

	public void setPi_no(int pi_no) {
		this.pi_no = pi_no;
	}

	public String getPi_name() {
		return pi_name;
	}

	public void setPi_name(String pi_name) {
		this.pi_name = pi_name;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "ProductImage [pi_no=" + pi_no + ", pi_name=" + pi_name + ", product=" + product + "]";
	}
	
	
}
