package com.sharestore2.service;

import java.util.ArrayList;

import com.sharestore2.dao.SellerDAO;
import com.sharestore2.vo.MemberVO;
import com.sharestore2.vo.SellerVO;

public class SellerService {
	private static SellerService service = new SellerService();
	public SellerDAO dao = SellerDAO.getInstance();
	
	private SellerService() {}
	
	//Service 외부 사용 
	public static SellerService getInstance() {
		return service;
	}
	//회원가입 
	public void sellerInsert(SellerVO seller) {
		dao.sellerInsert(seller);
	}
	
	//로그인 
	public SellerVO sellerLogin(String sellerId, String passwd) {
		SellerVO seller = dao.sellerLogin(sellerId, passwd);
		return seller;
	}
	//아이디찾기
	public SellerVO forgetId(SellerVO vo) {
		SellerVO seller = dao.forgetId(vo);
		return seller;
	}
	//비밀번호찾기
	public SellerVO forgetPasswd(SellerVO vo) {
		SellerVO seller = dao.forgetPasswd(vo);
		return seller;
	}
	//정보삭제
	public void sellerDelete(SellerVO seller) {
		dao.sellerDelete(seller);
	}
	//리스트
	public ArrayList<SellerVO> sellerList() {
		ArrayList<SellerVO> sellerList = dao.sellerList();
		return sellerList;
	}
}
