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
</head>
<body>
	<div id="orderdetail">
		<table class="cols tbl_product shopping" style="border-bottom: 1px solid #b5b5b5;">
			<colgroup>
				<col style="width: 150px;">
				<col style="width: 150px;">
				<col style="width: 150px;">
				<col style="width: 150px;">
				<col style="width: 150px;">
			</colgroup>
			<thead>
				<tr>
					<th>상품명</th>
					<th>사이즈</th>
					<th>판매가</th>
					<th>수량</th>
					<th>합계</th>
				</tr>
			</thead>
			<tbody>
			<%
			ArrayList<OrderProductVO> orderProductList = (ArrayList<OrderProductVO>) request.getAttribute("orderProductList");
			if (orderProductList != null) { %>
				<%
				for (int i = 0; i < orderProductList.size(); i++) {
					OrderProductVO orderProduct = orderProductList.get(i);
				%>
				<tr>
					<th><%=orderProduct.getName()%></th>
					<th><%=orderProduct.getSize()%></th>
					<th><%=orderProduct.getPrice()%></th>
					<th><%=orderProduct.getCount()%></th>
					<th><%=orderProduct.getPrice() * orderProduct.getCount()%></th>
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