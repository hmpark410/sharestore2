package com.sharestore2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.sharestore2.vo.CartVO;

public class CartDAO {
	private static CartDAO dao = new CartDAO();

	private CartDAO() {

	}

	public static CartDAO getInstance() {
		return dao;
	}

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
		if(ps != null) {
			try {
				ps.close();
			}catch(Exception e) {
				System.out.println("Error:close1"+ e);
			}
		}
		if(conn != null) {
			try {
				conn.close();
			}catch(Exception e) {
				System.out.println("Error:close2"+ e);
			}
		}
	}
	// 자원해제
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
	
	public void cartInsert(CartVO cart) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = connect();
			String sql ="INSERT into cart(product_number, count, member_id, seller_id) VALUES (?, ?, ?, ?);";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cart.getProductNumber());
			pstmt.setInt(2, cart.getCount());
			pstmt.setString(3, cart.getMemberId());
			pstmt.setString(4, cart.getSellerId());
			pstmt.executeUpdate();
		}
		catch(Exception ex){
			System.out.println("오류 발생 : " + ex);
		}
		finally {
			close(conn, pstmt);
		}
	}
	
	public ArrayList<CartVO> cartList(String memberId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CartVO cart = null;
		ArrayList<CartVO> cartList = new ArrayList<>();
		try {
			conn = connect();
			pstmt = conn.prepareStatement("SELECT * FROM cart where member_id = ?;");
			pstmt.setString(1, memberId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				cart = new CartVO();
				cart.setCartNumber(rs.getInt(1));
				cart.setProductNumber(rs.getInt(2));
				cart.setCount(rs.getInt(3));
				cart.setMemberId(rs.getString(4));
				cart.setSellerId(rs.getString(5));
				cartList.add(cart);
			}
		} catch (Exception ex) {
			System.out.println("오류 발생 : " + ex);
		} finally {
			close(conn, pstmt, rs);
		}
		return cartList;
	}
	
	public void cartDelete(CartVO cart) {
	      Connection conn = null;
	      PreparedStatement pstmt = null;
	      try {
	    	conn = connect();
			String sql = "delete from cart where cart_number=?;";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cart.getCartNumber());
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
