package com.sharestore2.vo;

import java.util.ArrayList;

public class CartVO {
	private int cartNumber;
	private int productNumber;
	private int count;
	private int totalPrice;
	private String memberId;
	private String sellerId;
	private ProductVO product;
	
	public CartVO() {}
	
	public CartVO(int cartNumber) {
		this.cartNumber = cartNumber;
	}

	private ArrayList<CartVO> cartProductList;
	public ArrayList<CartVO> cartProductList(){
		return cartProductList;
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
	
	public String getFilename1() {
		return product.getFilename1();
	}
	
	public int getCartNumber() {
		return cartNumber;
	}

	public void setCartNumber(int cartNumber) {
		this.cartNumber = cartNumber;
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
	
	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
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

}
