package com.sharestore2.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sharestore2.service.ProductService;
import com.sharestore2.vo.ProductVO;

public class ShoesAllController implements Controller{
	public void execute (HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		
		ProductService service = ProductService.getInstance();
		ArrayList<ProductVO> productPageAllList3 = service.productPageAllList3();
	
		request.setAttribute("productList", productPageAllList3);
		//request.setAttribute("paging", paging);
		HttpUtil.forward(request, response, "/shoesAll.jsp");
	}
	
}
