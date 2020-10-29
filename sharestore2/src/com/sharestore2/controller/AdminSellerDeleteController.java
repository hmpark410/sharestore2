package com.sharestore2.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sharestore2.service.SellerService;
import com.sharestore2.vo.SellerVO;

public class AdminSellerDeleteController implements Controller{
	public void execute (HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String[] chk = request.getParameterValues("class");
		
		for(String sellerId : chk) {
			
			SellerVO sellerDelete = new SellerVO(sellerId);
			
			SellerService service= SellerService.getInstance();
			service.sellerDelete(sellerDelete);
			
			request.setAttribute("sellerDelete", sellerDelete);
		}

		HttpUtil.forward(request, response, "/result/adminMemberDeleteOut.jsp");
		
	}
}
