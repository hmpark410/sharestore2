package com.sharestore2.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sharestore2.service.MemberService;
import com.sharestore2.service.SellerService;
import com.sharestore2.vo.MemberVO;
import com.sharestore2.vo.SellerVO;

public class ForgetIdController implements Controller {
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String memberType = request.getParameter("memberType");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		
		// BuyerId
		if (memberType.equals("buyer")) {

			MemberVO vo = new MemberVO();
			vo.setName(name);
			vo.setPhone(phone);
			
			MemberService service = MemberService.getInstance();
			MemberVO member = service.forgetId(vo);

			request.setAttribute("member", member);
			HttpUtil.forward(request, response, "/result/memberForgetIdOut.jsp");
		}
		
		// SellerId
		else if (memberType.equals("seller")) {

			SellerVO vo = new SellerVO();
			vo.setSellerName(name);
			vo.setPhone(phone);
			
			SellerService service = SellerService.getInstance();
			SellerVO seller = service.forgetId(vo);

			request.setAttribute("seller", seller);
			HttpUtil.forward(request, response, "/result/sellerForgetIdOut.jsp");
		}

	}

}