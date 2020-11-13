package com.sharestore2.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sharestore2.service.CartService;
import com.sharestore2.service.ProductService;
import com.sharestore2.vo.CartVO;
import com.sharestore2.vo.ProductVO;

//장바구니 넣기 
public class CartInsertController implements Controller {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int productNumber =  Integer.parseInt(request.getParameter("productNumber"));
		int count = Integer.parseInt(request.getParameter("count"));
		String memberId = request.getParameter("memberId");
		String sellerId = request.getParameter("sellerId");
		
		CartService service = CartService.getInstance();		
		ArrayList<CartVO> cartList = service.cartList(memberId);	
		CartVO cart = new CartVO();
		if(!cartList.isEmpty()) {
			for(int i = 0; i < cartList.size(); i++) {
				
				cart = cartList.get(i);
				if(cart.getProductNumber() == productNumber) {
					count += cart.getCount();
					int cartNumber = cart.getCartNumber();
					System.out.println(cartNumber);
					cart.setCartNumber(cartNumber);
					service.cartDelete(cart);
					
				}
			}
		}
		
		cart.setProductNumber(productNumber);
		cart.setCount(count);
		cart.setMemberId(memberId);
		cart.setSellerId(sellerId);
		service.cartInsert(cart);
		
		request.setAttribute("cart", cart); 
		HttpUtil.forward(request, response, "/cartList.do");
	}

}