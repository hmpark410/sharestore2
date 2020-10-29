package com.sharestore2.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sharestore2.service.ProductService;
import com.sharestore2.vo.ProductVO;
import com.sharestore2.vo.SellerVO;

public class SellerPrdlistController implements Controller{
	public void execute (HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		
		HttpSession session = request.getSession();
		SellerVO seller = (SellerVO) session.getAttribute("seller");
		String sellerId = seller.getSellerId();

		ProductService service = ProductService.getInstance();		
		ArrayList<ProductVO> sellerPrdlist = service.sellerPrdlist(sellerId);
		
		request.setAttribute("sellerPrdlist", sellerPrdlist);
		HttpUtil.forward(request, response, "/sellerPrdlist.jsp");
		
	}
}
