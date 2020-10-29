<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.sharestore2.vo.OrderProductVO"%>
<%@ page import="com.sharestore2.dao.ProductDAO"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.sharestore2.vo.MemberVO"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% MemberVO member = (MemberVO) session.getAttribute("member");%>
	<table class="table">
		<thead class="thead-light">
			<tr>
				<th>#</th>
				<th>상품이름</th>
				<th>가격</th>
				<th>수량</th>
				<th>합계</th>
			</tr>
		</thead>
		<tbody>

			<%
			ArrayList<OrderProductVO> orderProductList = (ArrayList<OrderProductVO>) session.getAttribute("orderProductList");
			int totalPrice = 0;
			if (!orderProductList.isEmpty()) {
				for (int i = 0; i < orderProductList.size(); i++) {
					OrderProductVO orderProduct = orderProductList.get(i);
			%>
			<tr>
				<td><%=orderProductList.size()%></td>
				<td><%=orderProduct.getName()%></td>
				<td><%=orderProduct.getPrice()%></td>
				<td><%=orderProduct.getCount()%></td>
				<td><%=orderProduct.getPrice() * orderProduct.getCount()%></td>
			</tr>
		</tbody>
	
		<%
		totalPrice += (orderProduct.getPrice() * orderProduct.getCount()) ;
			}
		}
		%>
		<tfoot>
			<tr>
				<td colspan="4">총 금액 </td>
				
			</tr>
		</tfoot>
	</table>
	<form action="orderInsert.do" method="post">
		<input name="memberId" type="hidden" value="${member.id }" type="hidden" />
		<input name="orderProductList" type="hidden" value="<%=orderProductList %>" type="hidden" />
		<button type="submit" class="btn btn-lg btn-block btn-primary">주문하기</button>
	</form>


</body>
</html>