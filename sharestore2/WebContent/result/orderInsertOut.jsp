<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.sharestore2.vo.OrderProductVO"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="style.css" rel="stylesheet" type="text/css">
	<title>· SHARESTORE ·</title>

<body>
	<script>
	MemberVO member = (MemberVO) session.getAttribute("member");
	alert('주문이 완료되었습니다.');
	location.href="../orderList.do";
	</script>
</body>
</html>