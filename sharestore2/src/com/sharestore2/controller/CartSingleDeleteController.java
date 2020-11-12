package com.sharestore2.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sharestore2.service.CartService;
import com.sharestore2.vo.CartVO;

public class CartSingleDeleteController implements Controller {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int cartNumber = Integer.parseInt(request.getParameter("deletebtn"));
		CartVO cart = new CartVO(cartNumber);
		
		CartService service= CartService.getInstance();
		service.cartDelete(cart);
		
		request.setAttribute("cart", cart);
		HttpUtil.forward(request, response, "/cartList.do");
	}
}