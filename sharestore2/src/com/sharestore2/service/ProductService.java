package com.sharestore2.service;

import java.util.ArrayList;

import com.sharestore2.dao.ProductDAO;

import com.sharestore2.vo.ProductVO;

public class ProductService {
	
	private static ProductService service = new ProductService();
	public ProductDAO dao = ProductDAO.getInstance();
	//생성자 
	private ProductService() {}
	
	//Service 외부 사용 
	public static ProductService getInstance() {
		return service;
	}
	//상품등록 
	public void productService(ProductVO product) {
		dao.productInsert(product);
	}
	//상품리스트 출력 
	public ArrayList<ProductVO> productList() {
		ArrayList<ProductVO> productList = dao.productList();
		return productList;
	}
	//페이지리스트 출력 
	public ArrayList<ProductVO> productPageList(String category) {
		ArrayList<ProductVO> productPageList = dao.productPageList(category);
		return productPageList;
	}
	//페이지리스트 sub 출력 
	public ArrayList<ProductVO> productPageSubList(String category, String subCategory) {
		ArrayList<ProductVO> productPageSubList = dao.productPageSubList(category, subCategory);
		return productPageSubList;
	}
	//페이지all_1 상품리스트
	public ArrayList<ProductVO> productPageAllList1(){
		ArrayList<ProductVO> productPageAllList1 = dao.productPageAllList1();
		return productPageAllList1;
	}
	//페이지all_1 상품리스트 sub
	public ArrayList<ProductVO> productPageAllList1Sub(String subCategory){
		ArrayList<ProductVO> productPageAllList1Sub = dao.productPageAllList1Sub(subCategory);
		return productPageAllList1Sub;
	}
	//페이지all_2 상품리스트
	public ArrayList<ProductVO> productPageAllList2(){
		ArrayList<ProductVO> productPageAllList2 = dao.productPageAllList2();
		return productPageAllList2;
	}
	//페이지all_2 상품리스트 sub
	public ArrayList<ProductVO> productPageAllList2Sub(String subCategory){
		ArrayList<ProductVO> productPageAllList2Sub = dao.productPageAllList2Sub(subCategory);
		return productPageAllList2Sub;
	}
	//페이지all_3 상품리스트
	public ArrayList<ProductVO> productPageAllList3(){
		ArrayList<ProductVO> productPageAllList3 = dao.productPageAllList3();
		return productPageAllList3;
	}
	//페이지all_3 상품리스트 sub
	public ArrayList<ProductVO> productPageAllList3Sub(String subCategory){
		ArrayList<ProductVO> productPageAllList3Sub = dao.productPageAllList3Sub(subCategory);
		return productPageAllList3Sub;
	}
	//페이지all_4 상품리스트
	public ArrayList<ProductVO> productPageAllList4(){
		ArrayList<ProductVO> productPageAllList4 = dao.productPageAllList4();
		return productPageAllList4;
	}
	//페이지all_4 상품리스트 sub
	public ArrayList<ProductVO> productPageAllList4Sub(String subCategory){
		ArrayList<ProductVO> productPageAllList4Sub = dao.productPageAllList4Sub(subCategory);
		return productPageAllList4Sub;
	}
	//셀러상품리스트
	public ArrayList<ProductVO> sellerPrdlist(String sellerId) {
		ArrayList<ProductVO> sellerPrdlist = dao.sellerPrdlist(sellerId);
		return sellerPrdlist;
	}
	//셀러상품삭제
	public void SellerPrdDelete(ProductVO product) {
		dao.SellerPrdDelete(product);
	}
	//셀러상품수정리스트
	public ArrayList<ProductVO> sellerPrdUpdatelist(String sellerId, String productNumber) {
		ArrayList<ProductVO> sellerPrdUpdatelist = dao.sellerPrdUpdatelist(sellerId, productNumber);
		return sellerPrdUpdatelist;
	}
	//셀러상품수정
	public void SellerPrdUpdate(ProductVO product) {
		dao.SellerPrdUpdate(product);
	}
	//수량 수정
	public void stockUpdate(ProductVO product) {
		dao.stockUpdate(product);
	}
	//관리자상품수정리스트
	public ArrayList<ProductVO> adminPrdUpdatelist(int productNumber) {
		ArrayList<ProductVO> adminPrdUpdatelist = dao.adminPrdUpdatelist(productNumber);
		return adminPrdUpdatelist;
	}
	//상세상품 가져오기  
	public ProductVO productView(int productNumber) {
		ProductVO product  = dao.productView(productNumber);
		return product;
	}
}