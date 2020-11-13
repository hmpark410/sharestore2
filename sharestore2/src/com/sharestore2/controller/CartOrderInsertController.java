package com.sharestore2.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sharestore2.service.CartService;
import com.sharestore2.service.OrderProductService;
import com.sharestore2.service.OrderService;
import com.sharestore2.service.ProductService;
import com.sharestore2.vo.CartVO;
import com.sharestore2.vo.MemberVO;
import com.sharestore2.vo.OrderProductVO;
import com.sharestore2.vo.OrderVO;
import com.sharestore2.vo.ProductVO;

public class CartOrderInsertController implements Controller {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member");
		ArrayList<CartVO> cartConfirmList = (ArrayList<CartVO>) session.getAttribute("cartConfirmList");
		String memberId = member.getId();

		// OrderVO
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		String ym = year + new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);
		String ymd = ym + new DecimalFormat("00").format(cal.get(Calendar.DATE));
		String orderNumber = null;
		SimpleDateFormat sdfCurrent = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		String orderDate = sdfCurrent.format(ts);
		String status = "주문완료";
		int totalPrice = 0;
		String sellerId = null;
		int productNumber = 0;
		Timestamp deliveryDate = null;
		CartVO cart = new CartVO();
	
		if (!cartConfirmList.isEmpty()) {
			for (int i = 0; i < cartConfirmList.size(); i++) {
				cart = cartConfirmList.get(i);
				productNumber = cart.getProductNumber();
				ProductService productService = ProductService.getInstance();
				ProductVO product = productService.productView(productNumber);
				totalPrice = cart.getCount() * product.getPrice();
				
				sellerId = product.getSellerId();
				System.out.println(sellerId);
				
				String subNum = "";
				for (int j = 1; j <= 6; j++) {
					subNum += (int) (Math.random() * 10);
				}
				orderNumber = ymd + "_" + subNum;
				OrderService orderService = OrderService.getInstance();
				ArrayList<OrderVO> list = orderService.sOrderList(sellerId, orderDate);
				
				if (!list.isEmpty()) {
					for (int j = 0; j < list.size(); j++) {
						OrderVO vo = list.get(j);
						String orderNumber1 = vo.getOrderNumber();
						int totalPrice1 = totalPrice + vo.getTotalPrice();

						if (vo.getSellerId().equals(sellerId) && vo.getOrderDate().equals(orderDate)) {
							OrderVO order = new OrderVO();
							order.setOrderNumber(orderNumber1);
							order.setTotalPrice(totalPrice1);
							orderService.cartUpdate(order);

							// OrderProductVO
							OrderProductVO orderProduct2 = new OrderProductVO();
							orderProduct2.setOrderNumber(orderNumber1);
							orderProduct2.setProductNumber(productNumber);
							orderProduct2.setCount(cart.getCount());
							OrderProductService orderProductService = OrderProductService.getInstance();
							orderProductService.OrderProductInsert(orderProduct2);
						} else {
							OrderVO order = new OrderVO();
							order.setOrderNumber(orderNumber);
							order.setOrderDate(orderDate);
							order.setTotalPrice(totalPrice);
							order.setStatus(status);
							order.setMemberId(memberId);
							order.setSellerId(sellerId);
							order.setDeliveryDate(deliveryDate);
							orderService.orderInsert(order);

							// OrderProductVO
							OrderProductVO orderProduct2 = new OrderProductVO();
							orderProduct2.setOrderNumber(orderNumber1);
							orderProduct2.setProductNumber(productNumber);
							orderProduct2.setCount(cart.getCount());
							OrderProductService orderProductService = OrderProductService.getInstance();
							orderProductService.OrderProductInsert(orderProduct2);
						}
					}
				} 
				else {
					OrderVO order = new OrderVO();
					order.setOrderNumber(orderNumber);
					order.setOrderDate(orderDate);
					order.setTotalPrice(totalPrice);
					order.setStatus(status);
					order.setMemberId(memberId);
					order.setSellerId(sellerId);
					order.setDeliveryDate(deliveryDate);
					orderService.orderInsert(order);

					// OrderProductVO
					OrderProductVO orderProduct2 = new OrderProductVO();
					orderProduct2.setOrderNumber(orderNumber);
					orderProduct2.setProductNumber(productNumber);
					orderProduct2.setCount(cart.getCount());
					OrderProductService orderProductService = OrderProductService.getInstance();
					orderProductService.OrderProductInsert(orderProduct2);
				}
			}
			CartService cartService = CartService.getInstance();
			cartService.cartDelete(cart);
		}	
		HttpUtil.forward(request, response, "/result/orderInsertOut.jsp");
	}
}
