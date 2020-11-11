package com.sharestore2.controller;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.*;
import javax.servlet.http.*;
import com.sharestore2.service.MemberService;
import com.sharestore2.vo.MemberVO;
public class MemberInsertController implements Controller {	
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		String check_passwd = request.getParameter("check_passwd");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String mail = request.getParameter("mail");
		String gender = request.getParameter("gender");
		int birth_y = Integer.parseInt(request.getParameter("select_year"));
		int birth_m = Integer.parseInt(request.getParameter("select_month"));
		int birth_d = Integer.parseInt(request.getParameter("select_day"));
		String roadAddress = request.getParameter("roadAddress");
		String detailAddress = request.getParameter("detailAddress");
		String address = roadAddress +  "," + detailAddress;
		Pattern pwd = Pattern.compile("^(?=.*[0-9])(?=.*[A-Za-z]).{8,16}$");
	    Matcher m = pwd.matcher(passwd);
	    
	    response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		if(id.isEmpty() || passwd.isEmpty() || check_passwd.isEmpty() || name.isEmpty() ||  phone.isEmpty() || gender.isEmpty()
				|| Integer.toString(birth_y).isEmpty() || Integer.toString(birth_m).isEmpty() || Integer.toString(birth_d).isEmpty()) {
			out.println("<script>alert('필수항목을 빠짐없이 입력해주세요.'); location.href='memberInsert.jsp';</script>");
		}
		if (passwd.length() < 8 || passwd.length() > 16) {
			out.println("<script>alert('비밀번호를 8~16자로 작성해주세요'); location.href='memberInsert.jsp';</script>");
		} else if (!m.find()) {
			out.println("<script>alert('비밀번호를 영문+숫자 조합 8~16자리로 작성해주세요.'); location.href='memberInsert.jsp';</script>");
		}
		if(id.equals("admin")) {
			out.println("<script>alert('다른 아이디를 사용해주세요.'); location.href='memberInsert.jsp';</script>");
		}
		if(!passwd.equals(check_passwd)) {
			out.println("<script>alert('비밀번호가 일치하지 않습니다.'); location.href='memberInsert.jsp';</script>");
		}
		
		
		//VO 객체에 멤버변수 저장 
		MemberVO member = new MemberVO();
		member.setId(id);
		member.setPasswd(passwd);
		member.setName(name);
		member.setPhone(phone);
		member.setMail(mail);
		member.setGender(gender);
		member.setBirth_y(birth_y);
		member.setBirth_m(birth_m);
		member.setBirth_d(birth_d);
		member.setAddress(address);
		
		//Service 객체의 메소드 호출
		MemberService service = MemberService.getInstance();
		service.memberInsert(member);
		
		//Output 페이지 이동
		request.setAttribute("id", id);
		out.println("<script>location.href='result/memberInsertOut.jsp';</script>");
		out.close();

	}

}
