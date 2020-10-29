package com.sharestore2.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sharestore2.service.ProductService;
import com.sharestore2.vo.ProductVO;

public class AdminPrdDeleteController implements Controller{
	public void execute (HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String[] chk = request.getParameterValues("class");
		
		for(String productNumber : chk) {
			ProductVO SellerPrdDelete = new ProductVO(productNumber);
			
			ProductService service= ProductService.getInstance();
			service.SellerPrdDelete(SellerPrdDelete);
			
			request.setAttribute("SellerPrdDelete", SellerPrdDelete);
		}

		HttpUtil.forward(request, response, "/result/adminPrdDeleteOut.jsp");
		
	}
}
