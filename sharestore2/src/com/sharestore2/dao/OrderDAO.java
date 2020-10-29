package com.sharestore2.dao;

import java.sql.*;
import com.sharestore2.vo.OrderVO;
import com.sharestore2.vo.ProductVO;

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

	// 주문리스트
	public ArrayList<OrderVO> orderList(String memberId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		OrderVO order = null;
		ArrayList<OrderVO> orderList = new ArrayList<>();
		try {
			conn = connect();
			pstmt = conn.prepareStatement("SELECT * FROM sharestore.order where member_id = ?");
			pstmt.setString(1, memberId);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				order = new OrderVO();
				order.setOrderNumber(rs.getString(1));
				order.setOrderDate(rs.getTimestamp(2));
				order.setTotalPrice(rs.getInt(3));
				order.setStatus(rs.getString(4));
				order.setMemberId(rs.getString(5));
				orderList.add(order);

				if (!orderList.isEmpty()) {
					for (int i = 0; i < orderList.size(); i++) {
						order = orderList.get(i);
					}
				}
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
			pstmt = conn.prepareStatement("SELECT * from sharestore.order where seller_id=?;");
			pstmt.setString(1, sellerId);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				order = new OrderVO();
				order.setOrderNumber(rs.getString(1));
				order.setOrderDate(rs.getTimestamp(2));
				order.setTotalPrice(rs.getInt(3));
				order.setStatus(rs.getString(4));
				order.setMemberId(rs.getString(5));
				order.setSellerId(rs.getNString(6));
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
	public void SellerOrderUpdate(OrderVO order) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = connect();
			String sql = "update sharestore.order set status=? where order_number=?;";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, order.getStatus());
			pstmt.setString(2, order.getOrderNumber());

			pstmt.executeUpdate();
		} catch (Exception ex) {
			System.out.println("오류 발생 : " + ex);
		} finally {
			close(conn, pstmt);
		}
	}

	// 주문
	// 주문번호, 바이어_ID(FK), 결제금액, 주문일자, 상태
	public void orderInsert(OrderVO order) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = connect();
			String sql ="INSERT into sharestore.order VALUES (?, ?, ?, ?, ?, ?);";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, order.getOrderNumber());	
			pstmt.setTimestamp(2, order.getOrderDate());
			pstmt.setInt(3, order.getTotalPrice());
			pstmt.setString(4, order.getStatus());
			pstmt.setString(5, order.getMemberId());
			pstmt.setString(6, order.getSellerId());
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