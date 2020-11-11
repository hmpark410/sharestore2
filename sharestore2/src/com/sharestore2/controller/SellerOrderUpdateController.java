package com.sharestore2.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sharestore2.service.OrderProductService;
import com.sharestore2.service.OrderService;
import com.sharestore2.service.ProductService;
import com.sharestore2.vo.OrderProductVO;
import com.sharestore2.vo.OrderVO;
import com.sharestore2.vo.ProductVO;

public class SellerOrderUpdateController implements Controller {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String orderNumber = request.getParameter("orderNumber");
		String sellerId = request.getParameter("sellerId");
		// 주문완료,배송준비,배송중,배송완료,취소,환불
		String status = request.getParameter("updateStatus");

		OrderVO order = new OrderVO();
		OrderService service = OrderService.getInstance();
		ArrayList<OrderVO> orderList = service.sellerOrderList(sellerId);
		// order
		int i;
		for (i = 0; i < orderList.size(); i++) {
			order = orderList.get(i);
			if (order.getOrderNumber().equals(orderNumber)) {
				order.setOrderNumber(orderNumber);
				order.setStatus(status);
				// 배송완료 (배송완료일)
				if (status.equals("배송완료")) {
					Timestamp deliveryDate = new Timestamp(System.currentTimeMillis());
					order.setDeliveryDate(deliveryDate);
				} else {
					order.setDeliveryDate(null);
				}
				service.OrderUpdate(order);
			}
			OrderProductVO orderProduct = new OrderProductVO();
			OrderProductService orderProductService = OrderProductService.getInstance();
			ArrayList<OrderProductVO> orderProductList = orderProductService.orderDetail(orderNumber);
			// orderProduct
			for (i = 0; i < orderProductList.size(); i++) {
				orderProduct = orderProductList.get(i);
				int productNumber = orderProduct.getProductNumber();
				ProductService productService = ProductService.getInstance();
				ProductVO product = productService.productView(productNumber);
				// product(배송준비 (-), 환불(+))
				if (product.getSellerId().equals(sellerId)) {
					int stock = product.getStock();
					int count = orderProduct.getCount();
					if (status.equals("배송준비")) {
						stock -= count;
						System.out.println(product.getName() + "(+)stock : " + stock);
					} 
					if (status.equals("환불")) {
						stock += count;
						System.out.println(product.getName() + "(-)stock : " + stock);
					}
					product.setproductNumber(productNumber);
					product.setStock(stock);
					productService.stockUpdate(product);
				}
			}
		}
		request.setAttribute("orderNumber", orderNumber);
		HttpUtil.forward(request, response, "/result/sellerOrderUpdateOut.jsp");
	}
}