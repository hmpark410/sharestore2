<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.sharestore2.vo.ProductVO"%>
<%@ page import="com.sharestore2.vo.CategoryKeywordVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
	<%
		ArrayList<ProductVO> allProduct = (ArrayList<ProductVO>) request.getAttribute("allProduct");
	if (!allProduct.isEmpty()) {
		for (int i = 0; i < allProduct.size(); i++) {
			ProductVO product = allProduct.get(i);
			String url = "./data/" + product.getFilename1();
			if (i % 2 == 0) {
	%>
		<colgroup>
			<col style="width: 400px;">
		</colgroup>
		<tr style="margin-left: 20px; margin-right: 20px;">
			<%
				}
			%>
			<td
				style="font-weight: bolder; border-bottom: 1px solid #fff; border-top: 1px solid #fff;">
				<% if(product.getStock()==0) {%>
				<a href="./result/soldoutAlertOut.jsp"><img style="opacity:0.5;" src="<%=url%>" /></a>
				<%} else { %>
				<a href="productView.do?productNumber=<%=product.getproductNumber()%>"><img src="<%=url%>" /></a>
				<%} %>
				</br> <%=product.getName()%></br> <%=product.getPrice()%></br>
				<%
				if (i % 2 == 1) {
				%>
			</td>
		</tr>
	<%
				}
		}
	} else {
	%>
		<colgroup>
			<col style="width: 400px;">
		</colgroup>
		<tr>
			<td style="border-bottom: 1px solid #fff; border-top: 1px solid #fff;">
				검색 결과가 없습니다.
			</td>
		</tr>
	<%
	}
	%>
	</table>
</body>
</html>