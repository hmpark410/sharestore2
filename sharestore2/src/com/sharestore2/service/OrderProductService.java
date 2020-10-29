package com.sharestore2.service;

import java.util.ArrayList;

import com.sharestore2.dao.OrderProductDAO;
import com.sharestore2.vo.OrderProductVO;
import com.sharestore2.vo.OrderVO;

public class OrderProductService {
	
	private static OrderProductService service = new OrderProductService();
	public OrderProductDAO dao = OrderProductDAO.getInstance();
	//생성자 
	private OrderProductService() {}
	
	//Service 외부 사용 
	public static OrderProductService getInstance() {
		return service;
	}
	public void OrderProductInsert(OrderProductVO orderProduct) {
		dao.orderProductInsert(orderProduct);
	}
	//주문상품리스트 
	public ArrayList<OrderProductVO> orderDetail(String orderNumber) {
		ArrayList<OrderProductVO> orderDetail = dao.orderDetail(orderNumber);
		return orderDetail;
	}

}
