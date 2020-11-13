package com.sharestore2.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sharestore2.service.ProductService;
import com.sharestore2.vo.ProductVO;

public class BagAllSubController implements Controller{
	public void execute (HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String subCategory = request.getParameter("subCategory");
		ProductService service = ProductService.getInstance();
		
		ArrayList<ProductVO> productPageAllList2Sub = service.productPageAllList2Sub(subCategory);
		request.setAttribute("productList", productPageAllList2Sub);

		HttpUtil.forward(request, response, "/bagAll.jsp");
	}
	
}

