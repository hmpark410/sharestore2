package com.sharestore2.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sharestore2.service.ProductService;
import com.sharestore2.vo.ProductVO;

public class ApparelAllSubController implements Controller{
	public void execute (HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String subCategory = request.getParameter("subCategory");
		ProductService service = ProductService.getInstance();
		
		ArrayList<ProductVO> productPageAllList1Sub = service.productPageAllList1Sub(subCategory);
		request.setAttribute("productList", productPageAllList1Sub);

		HttpUtil.forward(request, response, "/apparelAll.jsp");
	}
	
}
