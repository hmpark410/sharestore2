package com.sharestore2.vo;

public class ProductVO {
	//상품_ID, 상품명, 사이즈, 가격, 수량, 상태, 셀러_ID(FK), 카테고리_ID(FK)
	private String productNumber;
	private String name;
	private String size;
	private int price;
	private int stock;
	private String category;
	private String exp;
	private String sellerId;
	private String filename1;
	private String filename2;
	private String filename3;
	
	public ProductVO() {}
	
	public ProductVO(String productNumber) {
		this.productNumber = productNumber;
	}
	public String getproductNumber() {
		return productNumber;
	}
	public void setproductNumber(String productNumber) {
		this.productNumber = productNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String categori) {
		this.category = categori;
	}
	public void setExp(String exp) {
		this.exp = exp;
	}
	public String getExp() {
		return exp;
	}
	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}
	public String getSellerId() {
		return sellerId;
	}
	public void setFilename1(String filename1) {
		this.filename1 = filename1;
	}
	public String getFilename1() {
		return filename1;
	}
	public void setFilename2(String filename2) {
		this.filename2 = filename2;
	}
	public String getFilename2() {
		return filename2;
	}
	public void setFilename3(String filename3) {
		this.filename3 = filename3;
	}
	public String getFilename3() {
		return filename3;
	}
	
}
