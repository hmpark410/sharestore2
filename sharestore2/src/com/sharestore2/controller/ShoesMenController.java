package com.sharestore2.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sharestore2.service.ProductService;
import com.sharestore2.vo.ProductVO;

public class ShoesMenController implements Controller{
	public void execute (HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		
		String category = "2003";
		ProductService service = ProductService.getInstance();
		ArrayList<ProductVO> productPageList = service.productPageList(category);
	
		request.setAttribute("productList", productPageList);
		//request.setAttribute("paging", paging);
		HttpUtil.forward(request, response, "/shoesMen.jsp");
	}
	
}
