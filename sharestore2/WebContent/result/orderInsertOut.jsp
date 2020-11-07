<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.sharestore2.vo.OrderProductVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<% 
		session = request.getSession(true);
		ArrayList<OrderProductVO> orderProductList = 
				(ArrayList<OrderProductVO>) session.getAttribute("orderProductList");
		orderProductList = null;
		session.setAttribute("orderProductList", orderProductList);
	%>
	<script>
		alert('주문이 완료되었습니다.');
		location.href="orderList.do";
	</script>
</body>
</html>