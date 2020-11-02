package com.sharestore2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.sharestore2.vo.CategoryKeywordVO;

public class CategoryKeywordDAO {
	private static CategoryKeywordDAO dao = new CategoryKeywordDAO();

	private CategoryKeywordDAO() {

	}

	public static CategoryKeywordDAO getInstance() {
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
	
	//검색기능
	public ArrayList<CategoryKeywordVO> ctgkwSelect(String selectTxt) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CategoryKeywordVO ctgkw = null;
		ArrayList<CategoryKeywordVO> ctgkwSelect = new ArrayList<>();
		try {
			conn = connect();
			pstmt = conn.prepareStatement("SELECT category from category_keyword where keyword1=?;");
			pstmt.setString(1, selectTxt);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ctgkw = new CategoryKeywordVO();
				ctgkw.setCategory(rs.getString(1));
				ctgkwSelect.add(ctgkw);
			}
		} catch (Exception ex) {
			System.out.println("오류 발생 : " + ex);
		} finally {
			close(conn, pstmt, rs);
		}
		return ctgkwSelect;
	}
}
