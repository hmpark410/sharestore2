package com.sharestore2.controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sharestore2.service.OrderProductService;
import com.sharestore2.service.OrderService;
import com.sharestore2.service.ProductService;
import com.sharestore2.vo.OrderProductVO;
import com.sharestore2.vo.OrderVO;
import com.sharestore2.vo.ProductVO;
import com.sharestore2.vo.SellerVO;

public class SellerOrdermgtController implements Controller {
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		SellerVO seller = (SellerVO) session.getAttribute("seller");
		String sellerId = seller.getSellerId();

		OrderService orderService = OrderService.getInstance();
		ArrayList<OrderVO> sellerOrderList = orderService.sellerOrderList(sellerId);
	
		String orderNumber = null;
		for (int i = 0; i < sellerOrderList.size(); i++) {
			// order(order_number)
			OrderVO order = sellerOrderList.get(i);
			orderNumber = order.getOrderNumber();

			// order_product(product_number)
			OrderProductService orderProductService = OrderProductService.getInstance();
			ArrayList<OrderProductVO> orderProductList = orderProductService.orderDetail(orderNumber);

			for (int j = 0; j < orderProductList.size(); j++) {
				OrderProductVO orderProduct = orderProductList.get(j);
				int productNumber = orderProduct.getProductNumber();

				// product(product_name)
				ProductService productService = ProductService.getInstance();
				ProductVO product = productService.productView(productNumber);
				orderProduct.setProduct(product);
				order.setOrderProduct(orderProductList);
			}
		}
		// 주문한 상품 정보 불러오기 (상품이름 포함)
		request.setAttribute("sellerOrderList", sellerOrderList);
		HttpUtil.forward(request, response, "/sellerOrdermgt.jsp");

	}
}
