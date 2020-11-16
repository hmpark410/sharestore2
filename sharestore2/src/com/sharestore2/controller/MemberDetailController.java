package com.sharestore2.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sharestore2.service.MemberService;
import com.sharestore2.vo.MemberVO;

public class MemberDetailController implements Controller {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<MemberVO> memberList = new ArrayList<>();
		String memberId = request.getParameter("memberId");
		
		MemberService service = MemberService.getInstance();
		ArrayList<MemberVO> memberDetail = service.memberDetail(memberId);
		if(!memberDetail.isEmpty()){
			for(int i = 0; i < memberDetail.size(); i++){
				MemberVO vo = memberDetail.get(i);
				String name = vo.getName();
				String phone = vo.getPhone();
				String postCode = vo.getPostCode();
				String roadAddress = vo.getRoadAddress();
				String detailAddress = vo.getDetailAddress();
				
				MemberVO member = new MemberVO();
				member.setName(name);
				member.setPhone(phone);
				member.setPostCode(postCode);
				member.setRoadAddress(roadAddress);
				member.setDetailAddress(detailAddress);
				memberList.add(member);
				
				request.setAttribute("memberList", memberList);
			}
		}
		HttpUtil.forward(request, response, "/result/memberDetailOut.jsp");
	}

}
