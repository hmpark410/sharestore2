package com.sharestore2.service;

import java.util.ArrayList;

import com.sharestore2.dao.CartDAO;
import com.sharestore2.vo.CartVO;

public class CartService {
	private static CartService service = new CartService();
	public CartDAO dao = CartDAO.getInstance();
	//생성자 
	private CartService() {}
	
	//Service 외부 사용 
	public static CartService getInstance() {
		return service;
	}
	
	public void cartInsert(CartVO cart) {
		dao.cartInsert(cart);
	}
	
	public ArrayList<CartVO> cartList(String memberId) {
		ArrayList<CartVO> cartList = dao.cartList(memberId);
		return cartList;
	}
	
	public ArrayList<CartVO> cartNumberList(int cartNumber) {
		ArrayList<CartVO> cartNumberList = dao.cartNumberList(cartNumber);
		return cartNumberList;
	}
	
	public void cartDelete(CartVO cart) {
		dao.cartDelete(cart);
	}
}
