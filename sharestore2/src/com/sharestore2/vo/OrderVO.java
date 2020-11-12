package com.sharestore2.vo;

import java.sql.Timestamp;
import java.util.ArrayList;


public class OrderVO {
	//주문번호, 주문일, 총가격, 상태, memberId, sellerId, 배송완료일 
	private String orderNumber;
	private String orderDate;
	private int totalPrice;
	private String status;
	private String memberId;
	private String sellerId;
	private Timestamp deliveryDate;
	// 주문한 상품
	private ArrayList<OrderProductVO> orderProductList;

	public ArrayList<OrderProductVO> getOrderProduct() {
		return orderProductList;
	}

	public void setOrderProduct(ArrayList<OrderProductVO> orderProductList) {
		this.orderProductList = orderProductList;
	}
	
	public OrderVO() {}
	
	public OrderVO(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public String getSellerId() {
		return sellerId;
	}
	public Timestamp getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Timestamp deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
}
