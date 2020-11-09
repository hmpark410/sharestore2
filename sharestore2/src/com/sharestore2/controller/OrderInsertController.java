package com.sharestore2.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;

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

//장바구니 상품 주문하기 
public class OrderInsertController implements Controller {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String memberId = request.getParameter("memberId");
		ArrayList<OrderProductVO> orderProductList = (ArrayList<OrderProductVO>)session.getAttribute("orderProductList");

		// 리스트가 없을 경우 리스트를 생성
		if (orderProductList == null)
			orderProductList = new ArrayList<OrderProductVO>();	
		
		ArrayList<OrderVO> ordertList = new ArrayList<OrderVO>();
		OrderVO order = new OrderVO();
		//OrderVO 
		//주문번호 생성
		
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		String yearMonth = year + new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);
		String yearMonthDay = yearMonth + new DecimalFormat("00").format(cal.get(Calendar.DATE));
		String subNum = "";
		for (int i = 1; i <= 6; i++) {
			subNum += (int) (Math.random() * 10);
		}
		String orderNumber = yearMonthDay + "_" + subNum;
		String ym = year + new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);
		String ymd = ym + new DecimalFormat("00").format(cal.get(Calendar.DATE));
		String orderNumber = null;
		Timestamp orderDate = new Timestamp(System.currentTimeMillis());
		String status = "주문완료";
		int totalPrice = 0;
		String sellerId = null;
		Timestamp deliveryDate = null;
			
		order.setOrderNumber(orderNumber);
		order.setOrderDate(orderDate);
		order.setStatus(status);
		order.setMemberId(memberId);
		//주문번호, 주문일, 총가격, 상태, memberId, sellerId, 배송완료일 
		//주문상품 
		int stock = 0;
		int productNumber = 0;
		Timestamp deliveryDate = null;

		for (int i = 0; i < orderProductList.size(); i++) {
			OrderProductVO orderProduct = orderProductList.get(i);
			totalPrice += orderProduct.getCount() * orderProduct.getPrice();
			sellerId = orderProduct.getProduct().getSellerId();
			stock = orderProduct.getProduct().getStock();
			productNumber = (int) orderProduct.getProduct().getproductNumber();
			ProductVO product2 = new ProductVO();
			int udStock = stock - orderProduct.getCount();
			product2.setproductNumber(productNumber);
			product2.setStock(udStock);
			ProductService service = ProductService.getInstance();
			service.stockUpdate(product2);
			
			String subNum = "";
			for (int j = 1; j <= 6; j++) {
				subNum += (int) (Math.random() * 10);
			}
			orderNumber = ymd + "_" + subNum;
			OrderVO order = new OrderVO();
			order.setOrderNumber(orderNumber);
			order.setOrderDate(orderDate);
			order.setTotalPrice(totalPrice);
			order.setStatus(status);
			order.setMemberId(memberId);
			order.setSellerId(sellerId);
			order.setDeliveryDate(deliveryDate);
			OrderService orderService = OrderService.getInstance();
			orderService.orderInsert(order);
			request.setAttribute("order", order);
		order.setTotalPrice(totalPrice);
	
		order.setSellerId(sellerId);
		order.setDeliveryDate(deliveryDate);
		OrderService orderService = OrderService.getInstance();
		orderService.orderInsert(order);

		HttpUtil.forward(request, response, "/result/orderInsertOut.jsp");
	}
}