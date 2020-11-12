package com.sharestore2.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sharestore2.service.CartService;
import com.sharestore2.service.OrderService;
import com.sharestore2.vo.CartVO;
import com.sharestore2.vo.OrderVO;

public class MemberOrderUpdateController implements Controller{
	public void execute (HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String orderNumber = request.getParameter("orderNumber");
		String status = request.getParameter("update_status");
		
		OrderService service = OrderService.getInstance();	
		
		if(status.equals("주문취소")) {
			OrderVO order = new OrderVO(orderNumber);
			service.orderDelete(order);
			HttpUtil.forward(request, response, "/result/memberOrderDeleteOut.jsp");
		} else {
			OrderVO order2 = new OrderVO();
			order2.setOrderNumber(orderNumber);
			order2.setStatus(status);
			service.OrderUpdate(order2);
			HttpUtil.forward(request, response, "/result/memberOrderUpdateOut.jsp");
		}
	}
}