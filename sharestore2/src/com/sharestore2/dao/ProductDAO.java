package com.sharestore2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.sharestore2.vo.ProductVO;

public class ProductDAO {
	private static ProductDAO dao = new ProductDAO();

	private ProductDAO() {

	}

	public static ProductDAO getInstance() {
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

	// 상품등록
	public void productInsert(ProductVO product) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = connect();
			String sql = "insert into sharestore.product"
					+ "(name, size, price, stock, category, exp, seller_id, filename1, filename2, filename3) "
					+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getName());
			pstmt.setString(2, product.getSize());
			pstmt.setInt(3, product.getPrice());
			pstmt.setInt(4, product.getStock());
			pstmt.setString(5, product.getCategory());
			pstmt.setString(6, product.getExp());
			pstmt.setString(7, product.getSellerId());
			pstmt.setString(8, product.getFilename1());
			pstmt.setString(9, product.getFilename2());
			pstmt.setString(10, product.getFilename3());
			pstmt.executeUpdate();

		} catch (Exception ex) {
			System.out.println("오류 발생 : " + ex);
		} finally {
			close(conn, pstmt);
		}
	}

	// 상품리스트
	public ArrayList<ProductVO> productList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ProductVO product = null;
		ArrayList<ProductVO> productList = new ArrayList<>();

		try {
			conn = connect();
			pstmt = conn.prepareStatement("SELECT * FROM sharestore.product");

			rs = pstmt.executeQuery();
			while (rs.next()) {
				product = new ProductVO();
				product.setproductNumber(rs.getInt(1));
				product.setName(rs.getString(2));
				product.setSize(rs.getString(3));
				product.setPrice(rs.getInt(4));
				product.setStock(rs.getInt(5));
				product.setCategory(rs.getString(6));
				product.setSubCategory(rs.getString(7));
				product.setExp(rs.getString(8));
				product.setSellerId(rs.getString(9));
				product.setFilename1(rs.getString(10));
				product.setFilename2(rs.getString(11));
				product.setFilename3(rs.getString(12));
				productList.add(product);
			}
		} catch (Exception ex) {
			System.out.println("오류 발생 : " + ex);
		} finally {
			close(conn, pstmt, rs);
		}
		return productList;
	}
	
	//페이지 상품리스트
	public ArrayList<ProductVO> productPageList(String category) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ProductVO product = null;
		ArrayList<ProductVO> productPageList = new ArrayList<>();

		try {
			conn = connect();
			pstmt = conn.prepareStatement("SELECT * FROM sharestore.product where category=?");
			pstmt.setString(1, category);
			rs = pstmt.executeQuery();
			// paging 
			// "SELECT @ROWNUM := @ROWNUM + 1 AS ROWNUM, A.* FROM"
			// + "(SELECT * FROM sharestore.product ORDER BY product_number ASC) AS A"
			// + ",(SELECT @ROWNUM := 0) B"

			while (rs.next()) {
				product = new ProductVO();
				product.setproductNumber(rs.getInt(1));
				product.setName(rs.getString(2));
				product.setSize(rs.getString(3));
				product.setPrice(rs.getInt(4));
				product.setStock(rs.getInt(5));
				product.setCategory(rs.getString(6));
				product.setSubCategory(rs.getString(7));
				product.setExp(rs.getString(8));
				product.setSellerId(rs.getString(9));
				product.setFilename1(rs.getString(10));
				product.setFilename2(rs.getString(11));
				product.setFilename3(rs.getString(12));
				productPageList.add(product);
			}
		} catch (Exception ex) {
			System.out.println("오류 발생 : " + ex);
		} finally {
			close(conn, pstmt, rs);
		}
		return productPageList;
	}
	
	//페이지all_1 상품리스트
	public ArrayList<ProductVO> productPageAllList1() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ProductVO product = null;
		ArrayList<ProductVO> productPageAllList1 = new ArrayList<>();

		try {
			conn = connect();
			pstmt = conn.prepareStatement("SELECT * FROM sharestore.product where category LIKE '%1' ");
			// paging 
			// "SELECT @ROWNUM := @ROWNUM + 1 AS ROWNUM, A.* FROM"
			// + "(SELECT * FROM sharestore.product ORDER BY product_number ASC) AS A"
			// + ",(SELECT @ROWNUM := 0) B"

			rs = pstmt.executeQuery();
			while (rs.next()) {
				product = new ProductVO();
				product.setproductNumber(rs.getInt(1));
				product.setName(rs.getString(2));
				product.setSize(rs.getString(3));
				product.setPrice(rs.getInt(4));
				product.setStock(rs.getInt(5));
				product.setCategory(rs.getString(6));
				product.setSubCategory(rs.getString(7));
				product.setExp(rs.getString(8));
				product.setSellerId(rs.getString(9));
				product.setFilename1(rs.getString(10));
				product.setFilename2(rs.getString(11));
				product.setFilename3(rs.getString(12));
				productPageAllList1.add(product);
			}
		} catch (Exception ex) {
			System.out.println("오류 발생 : " + ex);
		} finally {
			close(conn, pstmt, rs);
		}
		return productPageAllList1;
	}
	
	//페이지all_1 sub상품리스트
	public ArrayList<ProductVO> productPageAllList1Sub(String subCategory) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ProductVO product = null;
		ArrayList<ProductVO>productPageAllList1Sub = new ArrayList<>();

		try {
			conn = connect();
			pstmt = conn.prepareStatement("SELECT * FROM sharestore.product where category LIKE '%1' and sub_category=?");
			pstmt.setString(1, subCategory);
			rs = pstmt.executeQuery();
			// paging 
			// "SELECT @ROWNUM := @ROWNUM + 1 AS ROWNUM, A.* FROM"
			// + "(SELECT * FROM sharestore.product ORDER BY product_number ASC) AS A"
			// + ",(SELECT @ROWNUM := 0) B"

			rs = pstmt.executeQuery();
			while (rs.next()) {
				product = new ProductVO();
				product.setproductNumber(rs.getInt(1));
				product.setName(rs.getString(2));
				product.setSize(rs.getString(3));
				product.setPrice(rs.getInt(4));
				product.setStock(rs.getInt(5));
				product.setCategory(rs.getString(6));
				product.setSubCategory(rs.getString(7));
				product.setExp(rs.getString(8));
				product.setSellerId(rs.getString(9));
				product.setFilename1(rs.getString(10));
				product.setFilename2(rs.getString(11));
				product.setFilename3(rs.getString(12));
				productPageAllList1Sub.add(product);
			}
		} catch (Exception ex) {
			System.out.println("오류 발생 : " + ex);
		} finally {
			close(conn, pstmt, rs);
		}
		return productPageAllList1Sub;
	}
	
	//페이지all_2 상품리스트
	public ArrayList<ProductVO> productPageAllList2() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ProductVO product = null;
		ArrayList<ProductVO> productPageAllList2 = new ArrayList<>();

		try {
			conn = connect();
			pstmt = conn.prepareStatement("SELECT * FROM sharestore.product where category LIKE '%2' ");
			// paging 
			// "SELECT @ROWNUM := @ROWNUM + 1 AS ROWNUM, A.* FROM"
			// + "(SELECT * FROM sharestore.product ORDER BY product_number ASC) AS A"
			// + ",(SELECT @ROWNUM := 0) B"

			rs = pstmt.executeQuery();
			while (rs.next()) {
				product = new ProductVO();
				product.setproductNumber(rs.getInt(1));
				product.setName(rs.getString(2));
				product.setSize(rs.getString(3));
				product.setPrice(rs.getInt(4));
				product.setStock(rs.getInt(5));
				product.setCategory(rs.getString(6));
				product.setSubCategory(rs.getString(7));
				product.setExp(rs.getString(8));
				product.setSellerId(rs.getString(9));
				product.setFilename1(rs.getString(10));
				product.setFilename2(rs.getString(11));
				product.setFilename3(rs.getString(12));
				productPageAllList2.add(product);
			}
		} catch (Exception ex) {
			System.out.println("오류 발생 : " + ex);
		} finally {
			close(conn, pstmt, rs);
		}
		return productPageAllList2;
	}
	
	//페이지all_3 상품리스트
	public ArrayList<ProductVO> productPageAllList3() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ProductVO product = null;
		ArrayList<ProductVO> productPageAllList3 = new ArrayList<>();

		try {
			conn = connect();
			pstmt = conn.prepareStatement("SELECT * FROM sharestore.product where category LIKE '%3' ");
			// paging 
			// "SELECT @ROWNUM := @ROWNUM + 1 AS ROWNUM, A.* FROM"
			// + "(SELECT * FROM sharestore.product ORDER BY product_number ASC) AS A"
			// + ",(SELECT @ROWNUM := 0) B"

			rs = pstmt.executeQuery();
			while (rs.next()) {
				product = new ProductVO();
				product.setproductNumber(rs.getInt(1));
				product.setName(rs.getString(2));
				product.setSize(rs.getString(3));
				product.setPrice(rs.getInt(4));
				product.setStock(rs.getInt(5));
				product.setCategory(rs.getString(6));
				product.setSubCategory(rs.getString(7));
				product.setExp(rs.getString(8));
				product.setSellerId(rs.getString(9));
				product.setFilename1(rs.getString(10));
				product.setFilename2(rs.getString(11));
				product.setFilename3(rs.getString(12));
				productPageAllList3.add(product);
			}
		} catch (Exception ex) {
			System.out.println("오류 발생 : " + ex);
		} finally {
			close(conn, pstmt, rs);
		}
		return productPageAllList3;
	}
	
	//페이지all_4 상품리스트
	public ArrayList<ProductVO> productPageAllList4() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ProductVO product = null;
		ArrayList<ProductVO> productPageAllList4 = new ArrayList<>();

		try {
			conn = connect();
			pstmt = conn.prepareStatement("SELECT * FROM sharestore.product where category LIKE '%4' ");
			// paging 
			// "SELECT @ROWNUM := @ROWNUM + 1 AS ROWNUM, A.* FROM"
			// + "(SELECT * FROM sharestore.product ORDER BY product_number ASC) AS A"
			// + ",(SELECT @ROWNUM := 0) B"

			rs = pstmt.executeQuery();
			while (rs.next()) {
				product = new ProductVO();
				product.setproductNumber(rs.getInt(1));
				product.setName(rs.getString(2));
				product.setSize(rs.getString(3));
				product.setPrice(rs.getInt(4));
				product.setStock(rs.getInt(5));
				product.setCategory(rs.getString(6));
				product.setSubCategory(rs.getString(7));
				product.setExp(rs.getString(8));
				product.setSellerId(rs.getString(9));
				product.setFilename1(rs.getString(10));
				product.setFilename2(rs.getString(11));
				product.setFilename3(rs.getString(12));
				productPageAllList4.add(product);
			}
		} catch (Exception ex) {
			System.out.println("오류 발생 : " + ex);
		} finally {
			close(conn, pstmt, rs);
		}
		return productPageAllList4;
	}
	
	// 셀러상품리스트
	public ArrayList<ProductVO> sellerPrdlist(String sellerId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ProductVO product = null;
		ArrayList<ProductVO> sellerPrdlist = new ArrayList<>();
		try {
			conn = connect();
			pstmt = conn.prepareStatement("SELECT * from product where seller_id=?;");
			pstmt.setString(1, sellerId);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				product = new ProductVO();
				product = new ProductVO();
				product.setproductNumber(rs.getInt(1));
				product.setName(rs.getString(2));
				product.setSize(rs.getString(3));
				product.setPrice(rs.getInt(4));
				product.setStock(rs.getInt(5));
				product.setCategory(rs.getString(6));
				product.setSubCategory(rs.getString(7));
				product.setExp(rs.getString(8));
				product.setSellerId(rs.getString(9));
				product.setFilename1(rs.getString(10));
				product.setFilename2(rs.getString(11));
				product.setFilename3(rs.getString(12));
				sellerPrdlist.add(product);
			}
		} catch (Exception ex) {
			System.out.println("오류 발생 : " + ex);
		} finally {
			close(conn, pstmt, rs);
		}
		return sellerPrdlist;
	}
	
	//셀러상품삭제
	public void SellerPrdDelete(ProductVO product) {
	      Connection conn = null;
	      PreparedStatement pstmt = null;
	      try {
	    	conn = connect();
			String sql = "delete from product where product_number=?;";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, product.getproductNumber());
			pstmt.executeUpdate();
	      }
	      catch(Exception ex){
				System.out.println("오류 발생 : " + ex);
		}
		finally {
			close(conn, pstmt);
		}
	}
	//셀러상품수정리스트
	public ArrayList<ProductVO> sellerPrdUpdatelist(String sellerId, String productNumber) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ProductVO product = null;
		ArrayList<ProductVO> sellerPrdUpdatelist = new ArrayList<>();
		try {
			conn = connect();
			pstmt = conn.prepareStatement("SELECT * from product where seller_id=? and product_number=?;");
			pstmt.setString(1, sellerId);
			pstmt.setString(2, productNumber);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				product = new ProductVO();
				product.setproductNumber(rs.getInt(1));
				product.setName(rs.getString(2));
				product.setSize(rs.getString(3));
				product.setPrice(rs.getInt(4));
				product.setStock(rs.getInt(5));
				product.setCategory(rs.getString(6));
				product.setSubCategory(rs.getString(7));
				product.setExp(rs.getString(8));
				product.setSellerId(rs.getString(9));
				product.setFilename1(rs.getString(10));
				product.setFilename2(rs.getString(11));
				product.setFilename3(rs.getString(12));
				sellerPrdUpdatelist.add(product);
			}
		} catch (Exception ex) {
			System.out.println("오류 발생 : " + ex);
		} finally {
			close(conn, pstmt, rs);
		}
		return sellerPrdUpdatelist;
	}
	
	//셀러상품수정
	public void SellerPrdUpdate(ProductVO product) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = connect();
			String sql = "update product set name=?, size=?, price=?, stock=?, category=?, exp=?where product_number=?;";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getName());
			pstmt.setString(2, product.getSize());
			pstmt.setInt(3, product.getPrice());
			pstmt.setInt(4, product.getStock());	
			pstmt.setString(5, product.getCategory());
			pstmt.setString(6, product.getExp());
			pstmt.setInt(7, product.getproductNumber());
			
			pstmt.executeUpdate();
		}
		catch(Exception ex){
			System.out.println("오류 발생 : " + ex);
		}
		finally {
			close(conn, pstmt);
		}
	}
	
	//수량수정
		public void stockUpdate(ProductVO product) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			try {
				conn = connect();
				String sql = "update product set stock=? where product_number=?;";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, product.getStock());	
				pstmt.setInt(2, product.getproductNumber());
				pstmt.executeUpdate();
			}
			catch(Exception ex){
				System.out.println("오류 발생 : " + ex);
			}
			finally {
				close(conn, pstmt);
			}
		}
	
	//관리자상품수정리스트
	public ArrayList<ProductVO> adminPrdUpdatelist(int productNumber) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ProductVO product = null;
		ArrayList<ProductVO> adminPrdUpdatelist = new ArrayList<>();
		try {
			conn = connect();
			pstmt = conn.prepareStatement("SELECT * from product where product_number=?;");
			pstmt.setInt(1, productNumber);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				product = new ProductVO();
				product.setproductNumber(rs.getInt(1));
				product.setName(rs.getString(2));
				product.setSize(rs.getString(3));
				product.setPrice(rs.getInt(4));
				product.setStock(rs.getInt(5));
				product.setCategory(rs.getString(6));
				product.setSubCategory(rs.getString(7));
				product.setExp(rs.getString(8));
				product.setSellerId(rs.getString(9));
				product.setFilename1(rs.getString(10));
				product.setFilename2(rs.getString(11));
				product.setFilename3(rs.getString(12));
				adminPrdUpdatelist.add(product);
			}
		} catch (Exception ex) {
			System.out.println("오류 발생 : " + ex);
		} finally {
			close(conn, pstmt, rs);
		}
		return adminPrdUpdatelist;
	}

	// 상품 갯수
	public int getCount() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int count = 0;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("SELECT COUNT(*) FROM sharestore.product;");
			rs = pstmt.executeQuery();

			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception ex) {
			System.out.println("오류 발생 : " + ex);
		} finally {
			close(conn, pstmt, rs);
		}
		return count; // 총 레코드 수 리턴
	}

	// 상품상세보기
	public ProductVO productView(int productNumber) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ProductVO product = null;
		try {
			conn = connect();
			String sql = "SELECT * FROM sharestore.product " 
			+ "WHERE product_number =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, productNumber);
			// select문 실행 결과값
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				product = new ProductVO();
				product.setproductNumber(rs.getInt(1));
				product.setName(rs.getString(2));
				product.setSize(rs.getString(3));
				product.setPrice(rs.getInt(4));
				product.setStock(rs.getInt(5));
				product.setCategory(rs.getString(6));
				product.setSubCategory(rs.getString(7));
				product.setExp(rs.getString(8));
				product.setSellerId(rs.getString(9));
				product.setFilename1(rs.getString(10));
				product.setFilename2(rs.getString(11));
				product.setFilename3(rs.getString(12));
			}

		} catch (Exception ex) {
			System.out.println("오류 발생 : " + ex);
		} finally {
			close(conn, pstmt);
		}
		return product;
	}
}