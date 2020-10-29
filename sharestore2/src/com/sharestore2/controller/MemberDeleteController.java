package com.sharestore2.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.sharestore2.service.MemberService;
import com.sharestore2.vo.MemberVO;


public class MemberDeleteController implements Controller {	
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member");
		String memberId = member.getId();

		MemberVO memberDelete = new MemberVO(memberId);
		
		MemberService service= MemberService.getInstance();
		service.memberDelete(memberDelete);
		
		request.setAttribute("memberDelete", memberDelete);

		HttpUtil.forward(request, response, "/result/memberDeleteOut.jsp");
		
	}

}
