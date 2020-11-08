package com.sharestore2.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sharestore2.service.ProductService;
import com.sharestore2.vo.OrderProductVO;
import com.sharestore2.vo.ProductVO;
//장바구니 넣기 
public class CartInsertController implements Controller {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 주문번호(자동생성), member_id(FK), 결제금액, 주문일자, 상태

		// 세션에서 상품 리스트를 받아옴
		HttpSession session = request.getSession(true);
		ArrayList<OrderProductVO> orderProductList = 
				(ArrayList<OrderProductVO>) session.getAttribute("orderProductList");

		// 리스트가 없을경우 리스트를 생성
		if (orderProductList == null)
			orderProductList = new ArrayList<OrderProductVO>();

		int productNumber =  Integer.parseInt(request.getParameter("productNumber"));
		int count = Integer.parseInt(request.getParameter("count"));
		
		// Service
		// 선택한 상품 정보 불러오기
		ProductService service = ProductService.getInstance();
		ProductVO product = service.productView(productNumber);
		
		//OrderProductVO 객체
		OrderProductVO orderProduct = new OrderProductVO();
		orderProduct.setProduct(product);
		orderProduct.setProductNumber(productNumber);
		
		orderProduct.setCount(count);
		
		//추가된 상품 객체를 리스트에 담음
		orderProductList.add(orderProduct);
		session.setAttribute("orderProductList", orderProductList);
		response.sendRedirect("cart.jsp");
	}

}
