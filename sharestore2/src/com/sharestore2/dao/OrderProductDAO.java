package com.sharestore2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.sharestore2.vo.OrderProductVO;
import com.sharestore2.vo.OrderVO;

public class OrderProductDAO {
	private static OrderProductDAO dao = new OrderProductDAO();

	private OrderProductDAO() {
	}

	public static OrderProductDAO getInstance() {
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
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception ex) {
				System.out.println("오류 발생 : " + ex);
			}
		}
		close(conn, ps);
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
	//주문 상품 
	public void orderProductInsert(OrderProductVO orderProduct) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = connect();
			String sql ="INSERT into sharestore.order_product VALUES (?, ?, ?);";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, orderProduct.getOrderNumber());
			pstmt.setInt(2, orderProduct.getProductNumber());
			pstmt.setInt(3, orderProduct.getCount());	
			pstmt.executeUpdate();
			
		}
		catch(Exception ex){
			System.out.println("오류 발생 : " + ex);
		}
		finally {
			close(conn, pstmt);
		}
	
	}
	
	//주문 상품리스트
	public ArrayList<OrderProductVO> orderDetail(String orderNumber) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		OrderProductVO orderProduct = null;
		ArrayList<OrderProductVO> orderDetail = new ArrayList<>();
		try {
			conn = connect();
			pstmt = conn.prepareStatement("SELECT * from order_product where order_number=?;");
			pstmt.setString(1, orderNumber);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				orderProduct = new OrderProductVO();
				orderProduct.setOrderNumber(rs.getString(1));
				orderProduct.setProductNumber(rs.getInt(2));
				orderProduct.setCount(rs.getInt(3));
				orderDetail.add(orderProduct);
			}

		} catch (Exception ex) {
			System.out.println("오류 발생 : " + ex);
		} finally {
			close(conn, pstmt, rs);
		}
		return orderDetail;
	}
}