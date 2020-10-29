package com.sharestore2.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sharestore2.service.OrderService;
import com.sharestore2.vo.MemberVO;
import com.sharestore2.vo.OrderVO;
import com.sharestore2.vo.SellerVO;

public class OrderListController implements Controller{
	public void execute (HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member");
		String memberId = member.getId();
		
		OrderService service = OrderService.getInstance();		
		ArrayList<OrderVO> orderList = service.orderList(memberId);
		
		request.setAttribute("orderList", orderList);
		HttpUtil.forward(request, response, "/mypage.jsp");
		
	}
	
		
}
