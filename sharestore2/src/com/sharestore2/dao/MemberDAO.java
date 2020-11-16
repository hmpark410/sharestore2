package com.sharestore2.dao;
import java.sql.*;
import java.util.ArrayList;

import com.sharestore2.vo.MemberVO;
import com.sharestore2.vo.ProductVO;

public class MemberDAO {	
	private static MemberDAO dao = new MemberDAO();
	private MemberDAO() {
		
	}
	public static MemberDAO getInstance() {
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
		}
		catch(Exception e) {}
		return conn;
	}
	
	//자원 해제 
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
	public void memberInsert(MemberVO member) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = connect();
			String sql = "insert into member values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPasswd());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getPhone());
			pstmt.setString(5, member.getMail());
			pstmt.setString(6, member.getGender());
			pstmt.setInt(7, member.getBirth_y());
			pstmt.setInt(8, member.getBirth_m());
			pstmt.setInt(9, member.getBirth_d());
			pstmt.setString(10, member.getPostCode());
			pstmt.setString(11, member.getRoadAddress());
			pstmt.setString(12, member.getDetailAddress());
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
	public MemberVO memberLogin(String id, String passwd) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVO member = null;
		
		try {
			conn = connect();			
			pstmt = conn.prepareStatement("select * from member where id = ? and passwd = ?");
			pstmt.setString(1, id);
			pstmt.setString(2, passwd);
			
			//select문 실행 결과값 
			rs = pstmt.executeQuery();
			
			//member 정보 저장 
			if(rs.next()) {
				member = new MemberVO();
				member.setId(rs.getString(1));
				member.setPasswd(rs.getString(2));
				member.setName(rs.getString(3));
				member.setPhone(rs.getString(4));
				member.setMail(rs.getNString(5));
				member.setGender(rs.getString(6));
				member.setBirth_y(rs.getInt(7));
				member.setBirth_m(rs.getInt(8));
				member.setBirth_d(rs.getInt(9));
				member.setPostCode(rs.getString(10));
				member.setRoadAddress(rs.getString(11));
				member.setDetailAddress(rs.getString(12));
			}
		}
		catch(Exception ex){
			System.out.println("오류 발생 : " + ex);
		}
		finally {
			close(conn, pstmt, rs);
		}
		return member;
	}
	
	//아이디찾기
	public MemberVO forgetId(MemberVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVO member = null;
		
		try {
			conn = connect();			
			pstmt = conn.prepareStatement("select * from member where name = ? and phone = ?");
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPhone());
			
			//select문 실행 결과값 
			rs = pstmt.executeQuery();
			
			//member 정보 저장 
			if(rs.next()) {
				member = new MemberVO();
				member.setId(rs.getString(1));
				member.setPasswd(rs.getString(2));
				member.setName(rs.getString(3));
				member.setPhone(rs.getString(4));
				member.setMail(rs.getNString(5));
				member.setGender(rs.getString(6));
				member.setBirth_y(rs.getInt(7));
				member.setBirth_m(rs.getInt(8));
				member.setBirth_d(rs.getInt(9));
				member.setPostCode(rs.getString(10));
				member.setRoadAddress(rs.getString(11));
				member.setDetailAddress(rs.getString(12));
			}
		}
		catch(Exception ex){
			System.out.println("오류 발생 : " + ex);
		}
		finally {
			close(conn, pstmt, rs);
		}
		return member;
	}
	
	//비밀번호찾기
	public MemberVO forgetPasswd(MemberVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVO member = null;
		
		try {
			conn = connect();			
			pstmt = conn.prepareStatement("select * from member where id = ? and name = ? and phone = ?");
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getPhone());
			
			//select문 실행 결과값 
			rs = pstmt.executeQuery();
			
			//member 정보 저장 
			if(rs.next()) {
				member = new MemberVO();
				member.setId(rs.getString(1));
				member.setPasswd(rs.getString(2));
				member.setName(rs.getString(3));
				member.setPhone(rs.getString(4));
				member.setMail(rs.getNString(5));
				member.setGender(rs.getString(6));
				member.setBirth_y(rs.getInt(7));
				member.setBirth_m(rs.getInt(8));
				member.setBirth_d(rs.getInt(9));
				member.setPostCode(rs.getString(10));
				member.setRoadAddress(rs.getString(11));
				member.setDetailAddress(rs.getString(12));
			}
		}
		catch(Exception ex){
			System.out.println("오류 발생 : " + ex);
		}
		finally {
			close(conn, pstmt, rs);
		}
		return member;
	}
	
	//정보수정  
	public void memberUpdate(MemberVO member) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = connect();
			String sql = "update member set passwd = ?, phone = ?, mail = ?, postcode=?, roadAddress=?, detailAddress=? where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getPasswd());
			pstmt.setString(2, member.getPhone());
			pstmt.setString(3, member.getMail());
			pstmt.setString(4, member.getPostCode());
			pstmt.setString(5, member.getRoadAddress());
			pstmt.setString(6, member.getDetailAddress());
			pstmt.setString(7, member.getId());	
			pstmt.executeUpdate();
		}
		catch(Exception ex){
			System.out.println("오류 발생 : " + ex);
		}
		finally {
			close(conn, pstmt);
		}
	}
	
	//정보삭제
	public void memberDelete(MemberVO member) {
	      Connection conn = null;
	      PreparedStatement pstmt = null;
	      try {
	    	conn = connect();
			String sql = "delete from member where id=?;";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getId());
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
	public ArrayList<MemberVO> memberList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVO member = null;
		ArrayList<MemberVO> memberList = new ArrayList<>();
		try {
			conn = connect();
			pstmt = conn.prepareStatement("SELECT * from member;");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				member = new MemberVO();
				member.setId(rs.getString(1));
				member.setPasswd(rs.getString(2));
				member.setName(rs.getString(3));
				member.setPhone(rs.getString(4));
				member.setMail(rs.getString(5));
				member.setGender(rs.getString(6));
				member.setRoadAddress(rs.getString(11));
				memberList.add(member);
			}
		} catch (Exception ex) {
			System.out.println("오류 발생 : " + ex);
		} finally {
			close(conn, pstmt, rs);
		}
		return memberList;
	}
	
	public ArrayList<MemberVO> memberDetail(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVO member = null;
		ArrayList<MemberVO> memberDetail = new ArrayList<>();
		try {
			conn = connect();
			pstmt = conn.prepareStatement("SELECT * from member where id=?;");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				member = new MemberVO();
				member.setId(rs.getString(1));
				member.setPasswd(rs.getString(2));
				member.setName(rs.getString(3));
				member.setPhone(rs.getString(4));
				member.setMail(rs.getNString(5));
				member.setGender(rs.getString(6));
				member.setBirth_y(rs.getInt(7));
				member.setBirth_m(rs.getInt(8));
				member.setBirth_d(rs.getInt(9));
				member.setPostCode(rs.getString(10));
				member.setRoadAddress(rs.getString(11));
				member.setDetailAddress(rs.getString(12));
				memberDetail.add(member);
			}
		} catch (Exception ex) {
			System.out.println("오류 발생 : " + ex);
		} finally {
			close(conn, pstmt, rs);
		}
		return memberDetail;
	}
	
}
