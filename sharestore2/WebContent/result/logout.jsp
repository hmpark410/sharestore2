<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>· SHARESTORE ·</title>
</head>
<body>
	<% session.invalidate(); %>
	<script>
		alert('로그아웃이 완료되었습니다.');
		location.href="../mainhome.jsp";
	</script>
</body>
</html>