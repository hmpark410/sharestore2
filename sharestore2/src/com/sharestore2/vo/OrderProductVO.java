package com.sharestore2.vo;

import java.util.ArrayList;

public class OrderProductVO {
	// 주문번호, 상품번호(FK), 수량
	private String orderNumber;
	private int productNumber;
	private int count;
	
	// 선택한 상품 
	private ProductVO product;

	private ArrayList<OrderProductVO> orderProductList;
	public ArrayList<OrderProductVO> orderProductList(){
		return orderProductList;
	}
	
	public ProductVO getProduct() {
		return product;
	}

	public void setProduct(ProductVO product) {
		this.product = product;
	}

	public String getName() {
		return product.getName();
	}
	
	public String getSize() {
		return product.getSize();
	}

	public int getPrice() {
		return product.getPrice();
	}
	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public int getProductNumber() {
		return productNumber;
	}

	public void setProductNumber(int productNumber) {
		this.productNumber = productNumber;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
