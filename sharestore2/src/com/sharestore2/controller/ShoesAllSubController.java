package com.sharestore2.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sharestore2.service.ProductService;
import com.sharestore2.vo.ProductVO;

public class ShoesAllSubController implements Controller{
	public void execute (HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String subCategory = request.getParameter("subCategory");
		ProductService service = ProductService.getInstance();
		
		ArrayList<ProductVO> productPageAllList3Sub = service.productPageAllList3Sub(subCategory);
		request.setAttribute("productList", productPageAllList3Sub);

		HttpUtil.forward(request, response, "/shoesAll.jsp");
	}
	
}

