package com.sharestore2.controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sharestore2.service.OrderService;
import com.sharestore2.vo.OrderVO;

public class AdminSaleListController implements Controller{
	public void execute (HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		OrderService service = OrderService.getInstance();		
		ArrayList<OrderVO> saleList = service.saleList();
		
		request.setAttribute("saleList", saleList);
		HttpUtil.forward(request, response, "/adminSaleList.jsp");
		
	}
	
		
}
