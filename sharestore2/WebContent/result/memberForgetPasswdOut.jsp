<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.sharestore2.vo.MemberVO"%>
<%
     request.setCharacterEncoding("UTF-8");
 %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="style.css" rel="stylesheet" type="text/css">
	<title>· SHARESTORE ·</title>
</head>
<body>
	<%MemberVO member = (MemberVO)request.getAttribute("member");
		if(member != null) {%>
			<script type="text/javascript">
				alert("${member.name}님의 비밀번호는 ${member.passwd}입니다.");
				document.location.href="login.jsp";
			</script>
		<% } else {%>
			<script type="text/javascript">
				alert("회원이 아닙니다.");
				document.location.href="login.jsp";
			</script>
	<%} %>
</body>
</html>