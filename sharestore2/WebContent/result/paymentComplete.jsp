<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.sharestore2.vo.CartVO"%>
<%@ page import="com.sharestore2.vo.MemberVO"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<body>
	<%
	MemberVO member = (MemberVO) session.getAttribute("member");
	ArrayList<CartVO> cartConfirmList = (ArrayList<CartVO>) session.getAttribute("cartConfirmList");
	String memberId = member.getId();
	%>
	<script>
		alert('주문이 완료되었습니다.');
		location.href="../cartOrderInsert.do?memberId=<%=memberId%>"
				
	</script>
</body>
</html>