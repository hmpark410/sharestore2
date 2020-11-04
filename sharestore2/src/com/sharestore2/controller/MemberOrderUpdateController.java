package com.sharestore2.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sharestore2.service.OrderService;
import com.sharestore2.vo.OrderVO;

public class MemberOrderUpdateController implements Controller{
	public void execute (HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String orderNumber = request.getParameter("orderNumber");
		String status = request.getParameter("update_status");
		
		OrderVO order = new OrderVO();
		order.setOrderNumber(orderNumber);
		order.setStatus(status);
		
		
		System.out.println("orderNum" + order.getOrderNumber());
		System.out.println("orderStatus" + order.getStatus());
		
		OrderService service = OrderService.getInstance();	
		service.OrderUpdate(order);
		HttpUtil.forward(request, response, "/result/memberOrderUpdateOut.jsp");
		
	}
}