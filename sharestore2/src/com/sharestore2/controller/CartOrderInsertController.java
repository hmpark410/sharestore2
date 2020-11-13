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
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
				
		//HttpSession session = request.getSession();
		//MemberVO member = (MemberVO) session.getAttribute("member");
		//String memberId = member.getId();
		
		
		String memberId = request.getParameter("memberId");
		String[] varChk = request.getParameterValues("class");
		int[] chk = new int[varChk.length];
		for(int i = 0; i < varChk.length; i ++) {
			   chk[i] = Integer.parseInt(varChk[i]);
		}	
		for(int cartNumber : chk) {
			//OrderVO
			Calendar cal = Calendar.getInstance();
			int year = cal.get(Calendar.YEAR);
			String ym = year + new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);
			String ymd = ym + new DecimalFormat("00").format(cal.get(Calendar.DATE));  
		    String orderNumber = null;
			SimpleDateFormat sdfCurrent = new SimpleDateFormat ("yyyy-MM-dd hh:mm");
			Timestamp ts = new Timestamp(System.currentTimeMillis());
			String orderDate = sdfCurrent.format(ts);
			String status = "주문완료";
			int totalPrice = 0;
			String sellerId = null;
			int stock = 0;
			int productNumber = 0;
			Timestamp deliveryDate = null;
			CartService service = CartService.getInstance();		
			ArrayList<CartVO> cartNumberList = service.cartNumberList(cartNumber);
			if(!cartNumberList.isEmpty()){
				for(int i = 0; i < cartNumberList.size(); i++){
					CartVO cart = cartNumberList.get(i);
					productNumber = cart.getProductNumber();
					ProductService service2 = ProductService.getInstance();
					ProductVO product = service2.productView(productNumber);
					totalPrice = cart.getCount() * product.getPrice();
					sellerId = cart.getSellerId();
					
					String subNum = "";
					for (int j = 1; j <= 6; j++) {
						subNum += (int) (Math.random() * 10);
					}
					orderNumber = ymd + "_" + subNum;
					OrderService service3 = OrderService.getInstance();
					ArrayList<OrderVO> list = service3.sOrderList(sellerId, orderDate);
					if(!list.isEmpty()) {
					    for (int j = 0; j < list.size(); j++) {
					       OrderVO vo = list.get(j);
					       String orderNumber1 = vo.getOrderNumber();
					       int totalPrice1 = totalPrice + vo.getTotalPrice();
					      
					       if(vo.getSellerId().equals(sellerId) && vo.getOrderDate().equals(orderDate)) {
					          OrderVO order = new OrderVO();
					          order.setOrderNumber(orderNumber1);
					          order.setTotalPrice(totalPrice1);
					          service3.cartUpdate(order);
					          
					          //OrderProductVO
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
						      service3.orderInsert(order);
					      
						      //OrderProductVO
						      OrderProductVO orderProduct2 = new OrderProductVO();
						      orderProduct2.setOrderNumber(orderNumber1);
						      orderProduct2.setProductNumber(productNumber);
						      orderProduct2.setCount(cart.getCount());
						      OrderProductService orderProductService = OrderProductService.getInstance();
						      orderProductService.OrderProductInsert(orderProduct2);
					       }
					    }
					 } else {
					    OrderVO order = new OrderVO();
					    order.setOrderNumber(orderNumber);
					    order.setOrderDate(orderDate);
					    order.setTotalPrice(totalPrice);
					    order.setStatus(status);
					    order.setMemberId(memberId);
					    order.setSellerId(sellerId);
					    order.setDeliveryDate(deliveryDate);
					    service3.orderInsert(order);
					    
					    //OrderProductVO
					    OrderProductVO orderProduct2 = new OrderProductVO();
					    orderProduct2.setOrderNumber(orderNumber);
					    orderProduct2.setProductNumber(productNumber);
					    orderProduct2.setCount(cart.getCount());
					    OrderProductService orderProductService = OrderProductService.getInstance();
					    orderProductService.OrderProductInsert(orderProduct2);
					 }
				}
			}
			CartVO cart = new CartVO(cartNumber);	
			CartService service2= CartService.getInstance();
			service2.cartDelete(cart);
		}
		HttpUtil.forward(request, response, "/result/orderInsertOut.jsp");
	}  
}