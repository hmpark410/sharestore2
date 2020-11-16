<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.sharestore2.vo.MemberVO"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="style.css" rel="stylesheet" type="text/css">
	<title>· SHARESTORE ·</title>
</head>
<body>
	<div id="memberdetail">
		<table class="cols tbl_product shopping">
			<colgroup>
				<col style="width: 75px;">
				<col style="width: 300px;">
				<col style="width: 75px;">
				<col style="width: 300px;">
			</colgroup>
			<thead>
				<tr>
					<th>이름</th>
					<th>휴대폰번호</th>
					<th>우편번호</th>
					<th>주소</th>
				</tr>
			</thead>
			<tbody>
			<%
			ArrayList<MemberVO> memberList = (ArrayList<MemberVO>) request.getAttribute("memberList");
			if (memberList != null) { %>
				<%
				for (int i = 0; i < memberList.size(); i++) {
					MemberVO member = memberList.get(i);
				%>
				<tr>
					<th><%=member.getName()%></th>
					<th><%=member.getPhone()%></th>
					<th><%=member.getPostCode()%></th>
					<th><%=member.getRoadAddress()+", "+member.getDetailAddress()%></th>
				</tr>
				<%
				}
			}
			%>
			</tbody>
		</table>
	</div>
</body>
</html>