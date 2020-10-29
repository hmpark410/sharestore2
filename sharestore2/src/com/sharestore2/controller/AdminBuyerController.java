package com.sharestore2.controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sharestore2.service.MemberService;
import com.sharestore2.vo.MemberVO;

public class AdminBuyerController implements Controller{
	public void execute (HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		MemberService service = MemberService.getInstance();		
		ArrayList<MemberVO> memberList = service.memberList();
		
		request.setAttribute("memberList", memberList);
		HttpUtil.forward(request, response, "/adminBuyer.jsp");
		
	}
}
