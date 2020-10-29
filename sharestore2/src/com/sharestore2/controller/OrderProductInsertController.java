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

import com.sharestore2.service.ProductService;
import com.sharestore2.service.OrderProductService;
import com.sharestore2.service.OrderService;
import com.sharestore2.vo.OrderProductVO;
import com.sharestore2.vo.OrderVO;
import com.sharestore2.vo.ProductVO;
//주문하기 (상품에서 바로 주문, 장바구니에서 주문)
public class OrderProductInsertController implements Controller {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		
		String productNumber = request.getParameter("productNumber");
		String memberId = request.getParameter("memberId");
		int count = Integer.parseInt(request.getParameter("count"));
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
		Timestamp orderDate = new Timestamp(System.currentTimeMillis());
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
		
		OrderService orderService = OrderService.getInstance();
		orderService.orderInsert(order);
	
		//주문한 상품에도 주문번호 입력 
		orderProduct.setOrderNumber(orderNumber);
		OrderProductService orderProductService = OrderProductService.getInstance();
		orderProductService.OrderProductInsert(orderProduct);
	
		//CartVO 객체에 멤버변수 저장 
		//OrderProductList
		//ArrayList<OrderProductVO> orderProductList = new ArrayList<OrderProductVO>();
		//orderProductList.add(orderProduct);
		//cart.setOrderProductList(orderProductList);
		
		//HttpSession session = request.getSession();
		//session.setAttribute("orderProductList", orderProductList);
		//response.sendRedirect("cart.jsp");
		HttpUtil.forward(request, response, "/result/orderInsertOut.jsp");
	}
}