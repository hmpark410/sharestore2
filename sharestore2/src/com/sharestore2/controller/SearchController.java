package com.sharestore2.controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sharestore2.service.ProductService;
import com.sharestore2.vo.ProductVO;

public class SearchController implements Controller{
	public void execute (HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String search = request.getParameter("search");
		ProductService service = ProductService.getInstance();
		
		if(search.isEmpty()) {
			ArrayList<ProductVO> allProduct = service.productList();
			request.setAttribute("allProduct", allProduct);
		} else {
			ArrayList<ProductVO> pdtSelect = service.pdtSelect(search);
			request.setAttribute("allProduct", pdtSelect);
		}

		HttpUtil.forward(request, response, "/selectPage.jsp");
	}
	
}
