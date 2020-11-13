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
import com.sharestore2.vo.MemberVO;
import com.sharestore2.vo.ProductVO;

public class CartListController implements Controller{
	public void execute (HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		ArrayList<CartVO> cartProductList = new ArrayList<>();
		
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member");
		String memberId = member.getId();
		
		CartService service = CartService.getInstance();		
		ArrayList<CartVO> cartList = service.cartList(memberId);
		if(!cartList.isEmpty()){
			for(int i = 0; i < cartList.size(); i++){
				CartVO cart = cartList.get(i);
				int productNumber = cart.getProductNumber();
				int count = cart.getCount();
				int cartNumber = cart.getCartNumber();
				
				ProductService service2 = ProductService.getInstance();
				ProductVO product = service2.productView(productNumber);
				
				CartVO cartProduct = new CartVO();
				cartProduct.setProduct(product);
				cartProduct.setProductNumber(productNumber);
				cartProduct.setCount(count);
				cartProduct.setCartNumber(cartNumber);
				cartProductList.add(cartProduct);
				
				request.setAttribute("cartProductList", cartProductList);
			}
		} else {
			cartProductList.isEmpty();
			request.setAttribute("cartProductList", cartProductList);
		}
		HttpUtil.forward(request, response, "/cart.jsp");
	}
}