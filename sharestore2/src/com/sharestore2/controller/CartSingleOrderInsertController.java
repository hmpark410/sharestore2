package com.sharestore2.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
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

public class CartSingleOrderInsertController implements Controller {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member");
		String memberId = member.getId();
		int productNumber = Integer.parseInt(request.getParameter("productNumber"));
		int count = Integer.parseInt(request.getParameter("count"));
		int cartNumber = Integer.parseInt(request.getParameter("orderbtn"));
		
		//Service
		//선택한 상품 정보 불러오기 
		ProductService service = ProductService.getInstance();
		ProductVO product = service.productView(productNumber);
		
		//OrderProductVO 객체
		OrderProductVO orderProduct = new OrderProductVO();
		orderProduct.setProduct(product);
		orderProduct.setProductNumber(productNumber);
		orderProduct.setCount(count);
		
		//OrderVO 객체 
		//주문번호 생성(주문날짜 + 랜던번호) 
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		String ym = year + new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);
		String ymd = ym +  new DecimalFormat("00").format(cal.get(Calendar.DATE));
		String subNum = "";
		 for(int i = 1; i <= 6; i ++) {
		  subNum += (int)(Math.random() * 10);
		 }
		String orderNumber = ymd + "_" + subNum;
		SimpleDateFormat sdfCurrent = new SimpleDateFormat ("yyyy-MM-dd hh:mm");
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		String orderDate = sdfCurrent.format(ts);
		int totalPrice = orderProduct.getCount() * orderProduct.getPrice();
		String status = "주문완료";
		String sellerId = product.getSellerId();
		OrderVO order = new OrderVO();
		order.setOrderNumber(orderNumber);
		order.setOrderDate(orderDate);
		order.setTotalPrice(totalPrice);
		order.setStatus(status);
		order.setMemberId(memberId);
		order.setSellerId(sellerId);
		order.setDeliveryDate(null);
		
		OrderService orderService = OrderService.getInstance();
		orderService.orderInsert(order);
	
		//주문한 상품에도 주문번호 입력 
		orderProduct.setOrderNumber(orderNumber);
		OrderProductService orderProductService = OrderProductService.getInstance();
		orderProductService.OrderProductInsert(orderProduct);
		
		CartVO cart = new CartVO(cartNumber);	
		CartService service2= CartService.getInstance();
		service2.cartDelete(cart);

		HttpUtil.forward(request, response, "/orderList.do");
	}
}
