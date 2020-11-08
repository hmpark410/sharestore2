package com.sharestore2.service;

import com.sharestore2.dao.OrderDAO;
import com.sharestore2.vo.OrderVO;
import java.sql.Timestamp;
import java.util.ArrayList;

public class OrderService {
	private static OrderService service = new OrderService();
	public OrderDAO dao = OrderDAO.getInstance();
	//생성자 
	private OrderService() {}
	
	//Service 외부 사용 
	public static OrderService getInstance() {
		return service;
	}
	//판매리스트
	public ArrayList<OrderVO> saleList() {
		ArrayList<OrderVO> saleList = dao.saleList();
		return saleList;
	}
	
	//주문리스트 
	public ArrayList<OrderVO> orderList(String memberId) {
		ArrayList<OrderVO> orderList = dao.orderList(memberId);
		return orderList;
	}
	
	//셀러주문리스트
	public ArrayList<OrderVO> sellerOrderList(String sellerId) {
		ArrayList<OrderVO> sellerOrderList = dao.sellerOrderList(sellerId);
		return sellerOrderList;
	}
	
	public ArrayList<OrderVO> sOrderList(String sellerId, String orderDate) {
		ArrayList<OrderVO> sOrderList = dao.sOrderList(sellerId, orderDate);
		return sOrderList;
	}
	
	public void OrderUpdate(OrderVO order) {
		dao.orderUpdate(order);
	}
	
	public void cartUpdate(OrderVO order) {
		dao.cartUpdate(order);
	}

	//상품주문 
	public void orderInsert(OrderVO order) {
		dao.orderInsert(order);
	}
}
