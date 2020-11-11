package com.sharestore2.dao;

import java.sql.*;
import com.sharestore2.vo.OrderVO;
import java.util.ArrayList;

public class OrderDAO {
	private static OrderDAO dao = new OrderDAO();

	private OrderDAO() {

	}

	public static OrderDAO getInstance() {
		return dao;
	}

	// 자원연결
	public Connection connect() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/sharestore?serverTimezone=UTC";
			String user = "root";
			String password = "cs12345678";
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
		}
		return conn;
	}

	// 자원해제
	public void close(Connection conn, PreparedStatement ps, ResultSet rs) {
		if (ps != null) {
			try {
				ps.close();
			} catch (Exception e) {
				System.out.println("Error:close1" + e);
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				System.out.println("Error:close2" + e);
			}
		}
	}

	public void close(Connection conn, PreparedStatement ps) {
		if (ps != null) {
			try {
				ps.close();
			} catch (Exception ex) {
				System.out.println("오류 발생 : " + ex);
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception ex) {
				System.out.println("오류 발생 : " + ex);
			}
		}
	}
	
	//판매리스트
	public ArrayList<OrderVO> saleList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		OrderVO order = null;
		ArrayList<OrderVO> saleList = new ArrayList<>();
		try {
			conn = connect();
			pstmt = conn.prepareStatement("SELECT * FROM sharestore.order ORDER BY order_date;");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				order = new OrderVO();
				order.setOrderNumber(rs.getString(1));
				order.setOrderDate(rs.getString(2));
				order.setTotalPrice(rs.getInt(3));
				order.setStatus(rs.getString(4));
				order.setMemberId(rs.getString(5));
				order.setSellerId(rs.getString(6));
				order.setDeliveryDate(rs.getTimestamp(7));
				saleList.add(order);
			}

		} catch (Exception ex) {
			System.out.println("오류 발생 : " + ex);
		} finally {
			close(conn, pstmt, rs);
		}
		return saleList;
	}

	// 주문리스트
	public ArrayList<OrderVO> orderList(String memberId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		OrderVO order = null;
		ArrayList<OrderVO> orderList = new ArrayList<>();
		try {
			conn = connect();
			pstmt = conn.prepareStatement("SELECT * FROM sharestore.order where member_id = ? ORDER BY order_date;");
			pstmt.setString(1, memberId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				order = new OrderVO();
				order.setOrderNumber(rs.getString(1));
				order.setOrderDate(rs.getString(2));
				order.setTotalPrice(rs.getInt(3));
				order.setStatus(rs.getString(4));
				order.setMemberId(rs.getString(5));
				order.setSellerId(rs.getString(6));
				order.setDeliveryDate(rs.getTimestamp(7));
				orderList.add(order);
			}
		} catch (Exception ex) {
			System.out.println("오류 발생 : " + ex);
		} finally {
			close(conn, pstmt, rs);
		}
		return orderList;
	}

	// 셀러주문리스트
	public ArrayList<OrderVO> sellerOrderList(String sellerId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		OrderVO order = null;
		ArrayList<OrderVO> sellerOrderList = new ArrayList<>();
		try {
			conn = connect();
			pstmt = conn.prepareStatement("SELECT * from sharestore.order where seller_id=? ORDER BY order_date;");
			pstmt.setString(1, sellerId);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				order = new OrderVO();
				order.setOrderNumber(rs.getString(1));
				order.setOrderDate(rs.getString(2));
				order.setTotalPrice(rs.getInt(3));
				order.setStatus(rs.getString(4));
				order.setMemberId(rs.getString(5));
				order.setSellerId(rs.getNString(6));
				order.setDeliveryDate(rs.getTimestamp(7));
				sellerOrderList.add(order);
			}

		} catch (Exception ex) {
			System.out.println("오류 발생 : " + ex);
		} finally {
			close(conn, pstmt, rs);
		}
		return sellerOrderList;
	}

	// 셀러주문리스트수정
	public void orderUpdate(OrderVO order) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = connect();
			String sql = "update sharestore.order set status=?, delivery_date=? "
					+ "where order_number=?;";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, order.getStatus());
			pstmt.setTimestamp(2, order.getDeliveryDate());
			pstmt.setString(3, order.getOrderNumber());
			pstmt.executeUpdate();
		} catch (Exception ex) {
			System.out.println("오류 발생 : " + ex);
		} finally {
			close(conn, pstmt);
		}
	}
	
	//주문 
		public OrderVO getOrder(String sellerId, String orderNumber ) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			OrderVO order = null;
			try {
				conn = connect();
				String sql = "selcet * from sharestore.order where order_number=? and sellerId=?;";
				rs = pstmt.executeQuery();
				pstmt.setString(1, sellerId);
				pstmt.setString(2, orderNumber);
				if (rs.next()) {
					order = new OrderVO();
					order.setOrderNumber(rs.getString(1));
					order.setOrderDate(rs.getString(2));
					order.setTotalPrice(rs.getInt(3));
					order.setStatus(rs.getString(4));
					order.setMemberId(rs.getString(5));
					order.setSellerId(rs.getNString(6));
					order.setDeliveryDate(rs.getTimestamp(7));
				}
			} catch (Exception ex) {
				System.out.println("오류 발생 : " + ex);
			} finally {
				close(conn, pstmt);
			}
			return order;
		}
	
	// 주문리스트
	public ArrayList<OrderVO> sOrderList(String sellerId, String orderDate) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		OrderVO order = null;
		ArrayList<OrderVO> sOrderList = new ArrayList<>();
		try {
			conn = connect();
			pstmt = conn.prepareStatement("SELECT * from sharestore.order where seller_id=? && order_date=? ORDER BY order_date;");
			pstmt.setString(1, sellerId);
			pstmt.setString(2, orderDate);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				order = new OrderVO();
				order.setOrderNumber(rs.getString(1));
				order.setOrderDate(rs.getString(2));
				order.setTotalPrice(rs.getInt(3));
				order.setStatus(rs.getString(4));
				order.setMemberId(rs.getString(5));
				order.setSellerId(rs.getNString(6));
				order.setDeliveryDate(rs.getTimestamp(7));
				sOrderList.add(order);
			}

		} catch (Exception ex) {
			System.out.println("오류 발생 : " + ex);
		} finally {
			close(conn, pstmt, rs);
		}
		return sOrderList;
	}
	
	// 주문수정
	public void cartUpdate(OrderVO order) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = connect();
			String sql = "update sharestore.order set total_price=? where order_number=?;";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, order.getTotalPrice());
			pstmt.setString(2, order.getOrderNumber());
			pstmt.executeUpdate();
		} catch (Exception ex) {
			System.out.println("오류 발생 : " + ex);
		} finally {
			close(conn, pstmt);
		}
	}
	


	// 주문하기 
	// 주문번호, 바이어_ID(FK), 결제금액, 주문일자, 상태
	public void orderInsert(OrderVO order) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = connect();
			String sql ="INSERT into sharestore.order VALUES (?, ?, ?, ?, ?, ?, ?);";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, order.getOrderNumber());	
			pstmt.setString(2, order.getOrderDate());
			pstmt.setInt(3, order.getTotalPrice());
			pstmt.setString(4, order.getStatus());
			pstmt.setString(5, order.getMemberId());
			pstmt.setString(6, order.getSellerId());
			pstmt.setTimestamp(7, order.getDeliveryDate());
			pstmt.executeUpdate();
		}
		catch(Exception ex){
			System.out.println("오류 발생 : " + ex);
		}
		finally {
			close(conn, pstmt);
		}
	}
}