package com.sharestore2.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sharestore2.service.SellerService;
import com.sharestore2.vo.SellerVO;

public class AdminSellerController implements Controller{
	public void execute (HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		SellerService service = SellerService.getInstance();		
		ArrayList<SellerVO> sellerList = service.sellerList();
		
		request.setAttribute("sellerList", sellerList);
		HttpUtil.forward(request, response, "/adminSeller.jsp");
		
	}
}
