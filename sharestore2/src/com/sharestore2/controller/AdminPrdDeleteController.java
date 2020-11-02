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
		 String[] varChk = request.getParameterValues("class");
		   int[] chk = new int[varChk.length];
		   
		   for(int i = 0; i < varChk.length; i ++) {
			   chk[i] = Integer.parseInt(varChk[i]);
		   }
		for(int productNumber : chk) {
			ProductVO SellerPrdDelete = new ProductVO(productNumber);
			
			ProductService service= ProductService.getInstance();
			service.SellerPrdDelete(SellerPrdDelete);
			
			request.setAttribute("SellerPrdDelete", SellerPrdDelete);
		}

		HttpUtil.forward(request, response, "/result/adminPrdDeleteOut.jsp");
		
	}
}
