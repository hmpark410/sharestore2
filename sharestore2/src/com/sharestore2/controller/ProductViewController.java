package com.sharestore2.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sharestore2.service.ProductService;
import com.sharestore2.vo.MemberVO;
import com.sharestore2.vo.ProductVO;

public class ProductViewController implements Controller {
	
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		int productNumber = Integer.parseInt(request.getParameter("productNumber"));
				
		//Service 객체의 메소드 호출
		ProductService service = ProductService.getInstance();
		ProductVO product = service.productView(productNumber);
		
	
		//Output 페이지 이동
		request.setAttribute("product", product);
		HttpUtil.forward(request, response, "/pdtPage.jsp");
		
	
	}

}
