package com.sharestore2.controller;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sharestore2.service.OrderService;
import com.sharestore2.vo.OrderVO;

public class SellerOrderUpdateController implements Controller{
	public void execute (HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String orderNumber = request.getParameter("orderNumber");
		String status = request.getParameter("update_status");
		//주문완료,배송준비,배송중,배송완료,취소,환불
		
		OrderVO order = new OrderVO();
		order.setOrderNumber(orderNumber);
		order.setStatus(status);
		System.out.println("orderNum" + order.getOrderNumber());
		System.out.println("orderSatus" + order.getStatus());
		
		if(status.equals("배송준비")) {
		
		}
		//배송완료
		if(status.equals("배송완료")) {
			Timestamp deliveryDate = new Timestamp(System.currentTimeMillis());
			order.setDeliveryDate(deliveryDate);
		}
		else {
			order.setDeliveryDate(null);
		}
		OrderService service = OrderService.getInstance();	
		service.OrderUpdate(order);
		request.setAttribute("orderNumber", orderNumber);
		HttpUtil.forward(request, response, "/result/sellerOrderUpdateOut.jsp");
	}
}