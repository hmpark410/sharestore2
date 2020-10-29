package com.sharestore2.controller;

import java.io.IOException;

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
		String address = request.getParameter("address");
		
		if(id.isEmpty() || passwd.isEmpty() || name.isEmpty()
				||  phone.isEmpty()) {
			request.setAttribute("error","빠짐없이 입력해주시기 바랍니다." );
			HttpUtil.forward(request, response, "/memberUpdate.jsp");
			return;
		}
		if(!passwd.equals(check_passwd)) {
			request.setAttribute("error","비밀번호가 일치하지 않습니다." );
			HttpUtil.forward(request, response, "/memberUpdate.jsp");
			return;
		}

		//VO 객체 바인딩 
		MemberVO member = new MemberVO();
		member.setId(id);
		member.setPasswd(passwd);
		member.setPhone(phone);
		member.setMail(mail);
		member.setAddress(address);
		
		//service 객체 메소드 호출
		MemberService service = MemberService.getInstance();
		service.memberUpdate(member);
		
		request.setAttribute("id", id);
		HttpUtil.forward(request, response, "/result/memberUpdateOut.jsp");
		
	}

}
