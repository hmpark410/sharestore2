package com.sharestore2.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.sharestore2.service.MemberService;
import com.sharestore2.service.SellerService;
import com.sharestore2.vo.MemberVO;
import com.sharestore2.vo.SellerVO;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MemberLoginController implements Controller {
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String memberType = request.getParameter("memberType");
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		// 유효성 검사
		if (id.isEmpty()) {
			out.println("<script>alert('아이디를 입력해주세요.'); location.href='login.jsp';</script>");
		}

		if (passwd.isEmpty()) {
			out.println("<script>alert('비밀번호를 입력해주세요.'); location.href='login.jsp';</script>");
		}
		
		// adminLogin
		if (id.equals("admin") && passwd.equals("admin")) {
			out.println("<script>location.href='adminPage.jsp';</script>");
		}
		
		// BuyerLogin
		if (memberType.equals("buyer")) {
			// service 객체 메소드 호출
			MemberService service = MemberService.getInstance();
			MemberVO member = service.memberLogin(id, passwd);

			if (member == null) {
				out.println("<script>alert('아이디 또는 비밀번호가 일치하지 않습니다'); location.href='login.jsp';</script>");
			}

			// 출력 페이지 이동
			if (member != null) {
				// HttpSession 모든 서블릿에서 유지
				HttpSession session = request.getSession();
				session.setAttribute("member", member);
				request.setAttribute("member", member);
				// HttpUtil.forward(request, response, "/mainhome.jsp");
				out.println("<script>location.href='mainhome.jsp';</script>");
			}
		}
		
		// SellerLogin
		else if (memberType.equals("seller")) {
			// service 객체 메소드 호출
			SellerService service = SellerService.getInstance();
			SellerVO seller = service.sellerLogin(id, passwd);

			if (seller == null) {
				out.println("<script>alert('아이디 또는 비밀번호가 일치하지 않습니다'); location.href='login.jsp';</script>");
			}

			// 출력 페이지 이동
			if (seller != null) {
				// HttpSession 모든 서블릿에서 유지
				HttpSession session = request.getSession();
				session.setAttribute("seller", seller);
				request.setAttribute("seller", seller);
				// HttpUtil.forward(request, response, "/sellerPage.jsp");
				out.println("<script>location.href='sellerPage.jsp';</script>");
			}
		}
		
		out.close();
	}

}
