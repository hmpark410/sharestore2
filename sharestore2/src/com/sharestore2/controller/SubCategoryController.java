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
		
		String subCategory = request.getParameter("subCategory");
		ProductService service = ProductService.getInstance();
		
		if(subCategory.equals("111") || subCategory.equals("112") || subCategory.equals("113") || subCategory.equals("114") || subCategory.equals("115") || subCategory.equals("116") || subCategory.equals("117") || subCategory.equals("121")
				|| subCategory.equals("122") || subCategory.equals("123") || subCategory.equals("124") || subCategory.equals("125") || subCategory.equals("126") || subCategory.equals("127")) {
			ArrayList<ProductVO> productPageAllList1Sub = service.productPageAllList1Sub(subCategory);
			request.setAttribute("productList", productPageAllList1Sub);
		} else if(subCategory.equals("217")) {
			ArrayList<ProductVO> productPageAllList1Sub = service.productPageAllList1Sub(subCategory);
			request.setAttribute("productList", productPageAllList1Sub);
		}
		
		HttpUtil.forward(request, response, "/apparelAll.jsp");
	}
	
}
