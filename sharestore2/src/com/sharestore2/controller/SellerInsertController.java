package com.sharestore2.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.sharestore2.service.SellerService;
import com.sharestore2.vo.SellerVO;

public class SellerInsertController implements Controller {	
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String sellerId = request.getParameter("sellerId");
		String passwd = request.getParameter("passwd");
		String check_passwd = request.getParameter("check_passwd");
		String store = request.getParameter("store");
		String phone = request.getParameter("phone");
		String sellerName = request.getParameter("sellerName");
		Pattern pwd = Pattern.compile("^(?=.*[0-9])(?=.*[A-Za-z]).{8,16}$");
	    Matcher m = pwd.matcher(passwd);
		
	    response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		if(sellerId.isEmpty() || check_passwd.isEmpty() || passwd.isEmpty() || 
				store.isEmpty() ||  phone.isEmpty() || sellerName.isEmpty()) {
			out.println("<script>alert('필수항목을 빠짐없이 입력해주세요.'); location.href='sellerInsert.jsp';</script>");
		}
		
		if (passwd.length() < 8 || passwd.length() > 16) {
			out.println("<script>alert('비밀번호를 8~16자로 작성해주세요'); location.href='memberInsert.jsp';</script>");
		} else if (!m.find()) {
			out.println("<script>alert('비밀번호를 영문+숫자 조합 8~16자리로 작성해주세요.'); location.href='sellerInsert.jsp';</script>");
		}
		
		if(sellerId.equals("admin")) {
			out.println("<script>alert('다른 아이디를 사용해주세요.'); location.href='sellerInsert.jsp';</script>");
		}
		
		if(!passwd.equals(check_passwd)) {
			out.println("<script>alert('비밀번호가 일치하지 않습니다.'); location.href='sellerInsert.jsp';</script>");
		}
		
		//VO 객체에 멤버변수 저장 
		SellerVO seller = new SellerVO();
		seller.setSellerId(sellerId);
		seller.setPasswd(passwd);
		seller.setStore(store);
		seller.setPhone(phone);
		seller.setSellerName(sellerName);
		
		//Service 객체의 메소드 호출
		SellerService service = SellerService.getInstance();
		service.sellerInsert(seller);
		
		//Output 페이지 이동
		request.setAttribute("sellerId", sellerId);
		out.println("<script>location.href='result/memberInsertOut.jsp';</script>");
		out.close();
		
	}

}
