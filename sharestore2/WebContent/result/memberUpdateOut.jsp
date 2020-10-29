<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.sharestore2.vo.MemberVO" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>· SHARESTORE ·</title>
</head>
<body>
	<script>
		alert('회원이 수정되었습니다.');
		opener.parent.location="./mainhome.jsp";
		window.close();
	</script>
</body>
</html>