package com.sharestore2.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sharestore2.service.MemberService;
import com.sharestore2.service.SellerService;
import com.sharestore2.vo.MemberVO;
import com.sharestore2.vo.SellerVO;

public class ForgetPasswdController implements Controller {
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String memberType = request.getParameter("memberType");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		
		// BuyerId
		if (memberType.equals("buyer")) {

			MemberVO vo = new MemberVO();
			vo.setId(id);
			vo.setName(name);
			vo.setPhone(phone);
			
			MemberService service = MemberService.getInstance();
			MemberVO member = service.forgetPasswd(vo);

			request.setAttribute("member", member);
			HttpUtil.forward(request, response, "/result/memberForgetPasswdOut.jsp");
		}
		
		// SellerId
		else if (memberType.equals("seller")) {

			SellerVO vo = new SellerVO();
			vo.setSellerId(id);
			vo.setSellerName(name);
			vo.setPhone(phone);
			
			SellerService service = SellerService.getInstance();
			SellerVO seller = service.forgetPasswd(vo);

			request.setAttribute("seller", seller);
			HttpUtil.forward(request, response, "/result/sellerForgetPasswdOut.jsp");
		}
	}

}