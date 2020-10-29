package com.sharestore2.service;
import java.util.ArrayList;

import com.sharestore2.dao.MemberDAO;
import com.sharestore2.vo.MemberVO;
import com.sharestore2.vo.ProductVO;

public class MemberService {

	private static MemberService service = new MemberService();
	public MemberDAO dao = MemberDAO.getInstance();
	
	private MemberService() {}
	
	//Service 외부 사용 
	public static MemberService getInstance() {
		return service;
	}
	//회원가입 
	public void memberInsert(MemberVO member) {
		dao.memberInsert(member);
	}
	//로그인 
	public MemberVO memberLogin(String id, String passwd) {
		MemberVO member = dao.memberLogin(id, passwd);
		return member;
	}
	//아이디찾기
	public MemberVO forgetId(MemberVO vo) {
		MemberVO member = dao.forgetId(vo);
		return member;
	}
	//비밀번호찾기
	public MemberVO forgetPasswd(MemberVO vo) {
		MemberVO member = dao.forgetPasswd(vo);
		return member;
	}
	//정보수정
	public void memberUpdate(MemberVO member) {
		dao.memberUpdate(member);
	}
	//정보삭제
	public void memberDelete(MemberVO member) {
		dao.memberDelete(member);
	}
	//리스트
	public ArrayList<MemberVO> memberList() {
		ArrayList<MemberVO> memberList = dao.memberList();
		return memberList;
	}	
}
