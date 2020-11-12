<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.sharestore2.vo.MemberVO" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="style.css" rel="stylesheet" type="text/css">
	<title>· SHARESTORE ·</title>
</head>
<body>
	<%
		String selected = request.getParameter("pageChange");
		if (selected == null) {
			selected = "adminPage.jsp";
		}
	%>
	<jsp:include page="<%=selected%>" flush="false">
		<jsp:param name="" value="" />
	</jsp:include>
	<div class="admbuyer_frame">
		<h3>Buyer</h3>
		<form action="adminBuyerDelete.do" method="post">
			<div class="admin_btn">
			 	<input type="submit" name="delete_btn" class="delete_btn" value="삭제">
			</div>
			<div class="buyerlist">
				<table id="table" class="cols tbl_product" style="z-index:1; border-bottom: 1px solid #b5b5b5;">
				    <colgroup>
				        <col style="width: 125px;">
					     <col style="width: 125px;">
					     <col style="width: 125px;">
					     <col style="width: 125px;">
					     <col style="width: 125px;">
					     <col style="width: 125px;">
					     <col style="width: 125px;">
					     <col style="width: 75px;">
				    </colgroup>
				    <thead>
				        <tr>
				            <th>아이디</th>
				            <th>비밀번호</th>
				            <th>이름</th>        
				            <th>휴대폰번호</th>
				            <th>이메일</th>
				            <th>성별</th>
				            <th>주소</th>	
				            <th></th>
				        </tr>
				    </thead>
				    <% ArrayList<MemberVO> memberList = (ArrayList<MemberVO>) request.getAttribute("memberList");
					if(!memberList.isEmpty()){%>
					<% 
						for(int i = 0; i < memberList.size(); i++){
							MemberVO list = memberList.get(i);	
					%>
					<tbody>
						<tr>  
							<th><%=list.getId() %></th>
							<th><%=list.getPasswd() %></th>
							<th><%=list.getName() %></th>    
							<th><%=list.getPhone() %></th>
							<th><%=list.getMail()%></th>
							<th><%=list.getGender()%></th>
							<th><%=list.getRoadAddress()%></th>
							<th><input type="checkbox" name="class" value=<%=list.getId() %>></th> 
						</tr>
					<%} 
					}
					else{%>
						<tr>
			            	<th colspan="8"><p style="text-align: center;">회원이 없습니다.<p></th>
			         	</tr>
					</tbody>		
				</table><%} %>
			</div>
		</form>		    
	</div>	
</body>
</html>