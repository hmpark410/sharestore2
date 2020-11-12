package com.sharestore2.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sharestore2.service.MemberService;
import com.sharestore2.vo.MemberVO;
import com.sharestore2.vo.SellerVO;

public class MemberUpdateController implements Controller {	
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		//파라미터 
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		String check_passwd = request.getParameter("check_passwd");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String mail = request.getParameter("mail");
		String postCode = request.getParameter("postCode");
		String roadAddress = request.getParameter("roadAddress");
		String detailAddress = request.getParameter("detailAddress");
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		if(id.isEmpty() || passwd.isEmpty() || name.isEmpty()
				||  phone.isEmpty() || postCode.isEmpty() || detailAddress.isEmpty()) {
			out.println("<script>alert('필수항목을 빠짐없이 입력해주세요.'); location.href='memberUpdate.jsp';</script>");
		}
		if(!passwd.equals(check_passwd)) {
			out.println("<script>alert('비밀번호가 일치하지 않습니다.'); location.href='memberUpdate.jsp';</script>");
		}

		//VO 객체 바인딩 
		MemberVO member = new MemberVO();
		member.setId(id);
		member.setPasswd(passwd);
		member.setPhone(phone);
		member.setMail(mail);
		member.setPostCode(postCode);
		member.setRoadAddress(roadAddress);
		member.setDetailAddress(detailAddress);
		
		//service 객체 메소드 호출
		MemberService service = MemberService.getInstance();
		service.memberUpdate(member);
		
		request.setAttribute("id", id);
		out.println("<script>location.href='result/memberUpdateOut.jsp';</script>");
		out.close();
		
	}

}
