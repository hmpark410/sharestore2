package com.sharestore2.dao;
import java.sql.*;
import java.util.ArrayList;

import com.sharestore2.vo.SellerVO;

public class SellerDAO {
	private static SellerDAO dao = new SellerDAO();
	private SellerDAO() {
		
	}
	public static SellerDAO getInstance() {
		return dao;
	}
	//자원연결 
	public Connection connect() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/sharestore?serverTimezone=UTC";
			String user = "root";
			String password = "cs12345678";
			conn = DriverManager.getConnection(url, user, password);
		}
		catch(Exception e) {}
		return conn;
	}
	
	//자원해제 
	public void close(Connection conn, PreparedStatement ps, ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			}
			catch(Exception ex){
				System.out.println("오류 발생 : " + ex);
			}
		}
		close(conn, ps);
	}
	
	public void close(Connection conn, PreparedStatement ps) {
		if(ps != null) {
			try {
				ps.close();
			}
			catch(Exception ex){
				System.out.println("오류 발생 : " + ex);
			}
		}
		if(conn != null) {
			try {
				conn.close();
			}
			catch(Exception ex){
				System.out.println("오류 발생 : " + ex);
			}
		}
	}
	//회원가입 
//	private String sellerId;
//	private String store;
//	private String passwd;
//	private String phone;
//	private String sellerName;
	
	public void sellerInsert(SellerVO seller) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = connect();
			String sql = "insert into sharestore.seller values(?, ?, ?, ?, ?);";
			pstmt = conn.prepareStatement(sql);
	
			pstmt.setString(1, seller.getSellerId());
			pstmt.setString(2, seller.getPasswd());
			pstmt.setString(3, seller.getStore());
			pstmt.setString(4, seller.getPhone());
			pstmt.setString(5, seller.getSellerName());
		
			pstmt.executeUpdate();
		}
		catch(Exception ex){
			System.out.println("오류 발생 : " + ex);
		}
		finally {
			close(conn, pstmt);
		}
	}
	//로그인 
	public SellerVO sellerLogin(String sellerId, String passwd) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		SellerVO seller = null;
		
		try {
			conn = connect();			
			pstmt = conn.prepareStatement("select * from seller where seller_id = ? and passwd = ?");
			pstmt.setString(1, sellerId);
			pstmt.setString(2, passwd);
			
			//select문 실행 결과
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				seller = new SellerVO();
				seller.setSellerId(rs.getString(1));
				seller.setPasswd(rs.getString(2));
				seller.setStore(rs.getString(3));
				seller.setPhone(rs.getString(4));
				seller.setSellerName(rs.getString(5));
				
			}
		}
		catch(Exception ex){
			System.out.println("오류 발생 : " + ex);
		}
		finally {
			close(conn, pstmt, rs);
		}
		return seller;
	}
	
	//아이디찾기
	public SellerVO forgetId(SellerVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		SellerVO seller = null;
		
		try {
			conn = connect();			
			pstmt = conn.prepareStatement("select * from seller where seller_name = ? and phone = ?");
			pstmt.setString(1, vo.getSellerName());
			pstmt.setString(2, vo.getPhone());
			
			//select문 실행 결과값 
			rs = pstmt.executeQuery();
			
			//member 정보 저장 
			if(rs.next()) {
				seller = new SellerVO();
				seller.setSellerId(rs.getString(1));
				seller.setPasswd(rs.getString(2));
				seller.setStore(rs.getString(3));
				seller.setPhone(rs.getString(4));
				seller.setSellerName(rs.getString(5));
			}
		}
		catch(Exception ex){
			System.out.println("오류 발생 : " + ex);
		}
		finally {
			close(conn, pstmt, rs);
		}
		return seller;
	}
	
	//비밀번호찾기
	public SellerVO forgetPasswd(SellerVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		SellerVO seller = null;
		
		try {
			conn = connect();			
			pstmt = conn.prepareStatement("select * from seller where seller_id=? and seller_name = ? and phone = ?");
			pstmt.setString(1, vo.getSellerId());
			pstmt.setString(2, vo.getSellerName());
			pstmt.setString(3, vo.getPhone());
			
			//select문 실행 결과값 
			rs = pstmt.executeQuery();
			
			//member 정보 저장 
			if(rs.next()) {
				seller = new SellerVO();
				seller.setSellerId(rs.getString(1));
				seller.setPasswd(rs.getString(2));
				seller.setStore(rs.getString(3));
				seller.setPhone(rs.getString(4));
				seller.setSellerName(rs.getString(5));
			}
		}
		catch(Exception ex){
			System.out.println("오류 발생 : " + ex);
		}
		finally {
			close(conn, pstmt, rs);
		}
		return seller;
	}
	
	//정보삭제
	public void sellerDelete(SellerVO seller) {
	      Connection conn = null;
	      PreparedStatement pstmt = null;
	      try {
	    	conn = connect();
			String sql = "delete from seller where seller_id=?;";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, seller.getSellerId());
			pstmt.executeUpdate();
	      }
	      catch(Exception ex){
				System.out.println("오류 발생 : " + ex);
		}
		finally {
			close(conn, pstmt);
		}
	}
	
	// 리스트
	public ArrayList<SellerVO> sellerList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		SellerVO seller = null;
		ArrayList<SellerVO> sellerList = new ArrayList<>();
		try {
			conn = connect();
			pstmt = conn.prepareStatement("SELECT * from seller;");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				seller = new SellerVO();
				seller.setSellerId(rs.getString(1));
				seller.setPasswd(rs.getString(2));
				seller.setStore(rs.getString(3));
				seller.setPhone(rs.getString(4));
				seller.setSellerName(rs.getString(5));
				sellerList.add(seller);
			}
		} catch (Exception ex) {
			System.out.println("오류 발생 : " + ex);
		} finally {
			close(conn, pstmt, rs);
		}
		return sellerList;
	}
}