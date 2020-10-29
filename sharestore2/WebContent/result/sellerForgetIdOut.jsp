<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.sharestore2.vo.SellerVO"%>
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
	<%SellerVO seller = (SellerVO)request.getAttribute("seller");
		if(seller != null) {%>
			<script type="text/javascript">
				alert("${seller.store}님의 아이디는 ${seller.sellerId}입니다.");
				document.location.href="../login.jsp";
			</script>
		<% } else {%>
			<script type="text/javascript">
				alert("회원이 아닙니다.");
				document.location.href="../login.jsp";
			</script>
	<%} %>
</body>
</html>