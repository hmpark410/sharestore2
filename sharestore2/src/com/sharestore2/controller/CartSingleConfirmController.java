package com.sharestore2.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sharestore2.service.CartService;
import com.sharestore2.service.ProductService;
import com.sharestore2.vo.CartVO;
import com.sharestore2.vo.ProductVO;

public class CartSingleConfirmController implements Controller {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int cartNumber = Integer.parseInt(request.getParameter("orderbtn"));
		ArrayList<CartVO> cartConfirmList = new ArrayList<>();
		
		CartService service= CartService.getInstance();
		ArrayList<CartVO> cartConfirm = service.cartNumberList(cartNumber);
		if(!cartConfirm.isEmpty()){
			for(int i = 0; i < cartConfirm.size(); i++){
				CartVO cart = cartConfirm.get(i);
				int productNumber = cart.getProductNumber();
				int count = cart.getCount();
				
				ProductService service2 = ProductService.getInstance();
				ProductVO product = service2.productView(productNumber);
				
				CartVO cartProduct = new CartVO();
				cartProduct.setProduct(product);
				cartProduct.setProductNumber(productNumber);
				cartProduct.setCount(count);
				cartProduct.setCartNumber(cartNumber);
				cartConfirmList.add(cartProduct);
			}
			HttpSession session = request.getSession();
			session.setAttribute("cartConfirmList", cartConfirmList);
		}
		HttpUtil.forward(request, response, "/cartConfirm.jsp");
	}
}

