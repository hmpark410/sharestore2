package com.sharestore2.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sharestore2.vo.OrderProductVO;

public class CartDeleteController  implements Controller {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 주문번호(자동생성), member_id(FK), 결제금액, 주문일자, 상태
		// 세션에서 상품 리스트를 받아옴
		HttpSession session = request.getSession(true);
		ArrayList<OrderProductVO> orderProductList = 
				(ArrayList<OrderProductVO>) session.getAttribute("orderProductList");
		orderProductList = null;
		session.setAttribute("orderProductList", orderProductList);
		response.sendRedirect("cart.jsp");
	}
}
