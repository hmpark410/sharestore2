package com.sharestore2.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sharestore2.service.OrderService;
import com.sharestore2.service.ProductService;
import com.sharestore2.vo.MemberVO;
import com.sharestore2.vo.OrderVO;
import com.sharestore2.vo.ProductVO;
import com.sharestore2.vo.SellerVO;

public class SellerOrdermgtController implements Controller{
	public void execute (HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		SellerVO seller = (SellerVO) session.getAttribute("seller");
		String sellerId = seller.getSellerId();

		OrderService service2 = OrderService.getInstance();		
		ArrayList<OrderVO> sellerOrderList = service2.sellerOrderList(sellerId);
		
		request.setAttribute("sellerOrderList", sellerOrderList);
		HttpUtil.forward(request, response, "/sellerOrdermgt.jsp");
		
	}
		
}
