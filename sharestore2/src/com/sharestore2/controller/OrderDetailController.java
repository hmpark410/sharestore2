package com.sharestore2.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sharestore2.service.OrderProductService;
import com.sharestore2.service.ProductService;
import com.sharestore2.vo.OrderProductVO;
import com.sharestore2.vo.ProductVO;

public class OrderDetailController implements Controller {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<OrderProductVO> orderProductList = new ArrayList<>();
		String orderNumber = request.getParameter("orderNumber");
		
		OrderProductService service = OrderProductService.getInstance();
		ArrayList<OrderProductVO> orderDetail = service.orderDetail(orderNumber);
		if(!orderDetail.isEmpty()){
			for(int i = 0; i < orderDetail.size(); i++){
				OrderProductVO orderProduct = orderDetail.get(i);
				String productNumber = orderProduct.getProductNumber();
				int count = orderProduct.getCount();
				
				ProductService service2 = ProductService.getInstance();
				ProductVO product = service2.productView(productNumber);
				
				OrderProductVO orderProduct2 = new OrderProductVO();
				orderProduct2.setProduct(product);
				orderProduct2.setProductNumber(productNumber);
				orderProduct2.setCount(count);

				orderProductList.add(orderProduct2);
				request.setAttribute("orderProductList", orderProductList);
			}
		}
		HttpUtil.forward(request, response, "/result/orderDetailOut.jsp");
	}

}