package com.sharestore2.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sharestore2.service.CategoryKeywordService;
import com.sharestore2.service.ProductService;
import com.sharestore2.vo.CategoryKeywordVO;
import com.sharestore2.vo.ProductVO;

public class testController implements Controller{
	public void execute (HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String search = request.getParameter("search");
		
		ProductService service = ProductService.getInstance();
		CategoryKeywordService service2 = CategoryKeywordService.getInstance();
		ArrayList<CategoryKeywordVO> ctgkwSelect = service2.ctgkwSelect(search);
		if(!ctgkwSelect.isEmpty()) {
			for (int i = 0; i < ctgkwSelect.size(); i++) {
				CategoryKeywordVO ctgkw = ctgkwSelect.get(i);
				String category = ctgkw.getCategory();
				System.out.println(category);
				ArrayList<ProductVO> productPageList = service.productPageList(category);
				request.setAttribute("allProduct", productPageList);
			}
		} else {
			ArrayList<ProductVO> pdtSelect = service.pdtSelect(search);
			request.setAttribute("allProduct", pdtSelect);
		}
		
		HttpUtil.forward(request, response, "/test.jsp");
	}
	
}