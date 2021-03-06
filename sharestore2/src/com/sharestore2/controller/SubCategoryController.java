package com.sharestore2.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sharestore2.service.ProductService;
import com.sharestore2.vo.ProductVO;

public class SubCategoryController implements Controller{
	public void execute (HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String category = request.getParameter("category");
		String subCategory = request.getParameter("subCategory");
		ProductService service = ProductService.getInstance();
		
		if(category.equals("1001")) {
			ArrayList<ProductVO> productPageSubList = service.productPageSubList(category, subCategory);
			request.setAttribute("productList", productPageSubList);
			HttpUtil.forward(request, response, "/apparelWomen.jsp");
		} else if(category.equals("2001")) {
			ArrayList<ProductVO> productPageSubList = service.productPageSubList(category, subCategory);
			request.setAttribute("productList", productPageSubList);
			HttpUtil.forward(request, response, "/apparelMen.jsp");
		} else if(category.equals("1002")) {
			ArrayList<ProductVO> productPageSubList = service.productPageSubList(category, subCategory);
			request.setAttribute("productList", productPageSubList);
			HttpUtil.forward(request, response, "/bagWomen.jsp");
		} else if(category.equals("2002")) {
			ArrayList<ProductVO> productPageSubList = service.productPageSubList(category, subCategory);
			request.setAttribute("productList", productPageSubList);
			HttpUtil.forward(request, response, "/bagMen.jsp");
		} else if(category.equals("1003")) {
			ArrayList<ProductVO> productPageSubList = service.productPageSubList(category, subCategory);
			request.setAttribute("productList", productPageSubList);
			HttpUtil.forward(request, response, "/shoesWomen.jsp");
		} else if(category.equals("2003")) {
			ArrayList<ProductVO> productPageSubList = service.productPageSubList(category, subCategory);
			request.setAttribute("productList", productPageSubList);
			HttpUtil.forward(request, response, "/shoesMen.jsp");
		} else if(category.equals("1004")) {
			ArrayList<ProductVO> productPageSubList = service.productPageSubList(category, subCategory);
			request.setAttribute("productList", productPageSubList);
			HttpUtil.forward(request, response, "/accWomen.jsp");
		} else if(category.equals("2004")) {
			ArrayList<ProductVO> productPageSubList = service.productPageSubList(category, subCategory);
			request.setAttribute("productList", productPageSubList);
			HttpUtil.forward(request, response, "/accMen.jsp");
		} else {
			ArrayList<ProductVO> productPageSubList = service.productPageSubList(category, subCategory);
			request.setAttribute("productList", productPageSubList);
			HttpUtil.forward(request, response, "/lifeAll.jsp");
		}
	}
	
}
