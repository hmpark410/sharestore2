package com.sharestore2.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sharestore2.service.ProductService;
import com.sharestore2.vo.ProductVO;

public class BagAllController implements Controller{
	public void execute (HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		
		ProductService service = ProductService.getInstance();
		ArrayList<ProductVO> productPageAllList2 = service.productPageAllList2();
	
		request.setAttribute("productList", productPageAllList2);
		//request.setAttribute("paging", paging);
		HttpUtil.forward(request, response, "/bagAll.jsp");
	}
	
}