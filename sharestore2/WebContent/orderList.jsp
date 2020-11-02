<%@ page import="java.util.ArrayList" %>
<%@ page import="com.sharestore2.vo.OrderVO" %>
<%@ page import="com.sharestore2.vo.MemberVO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="style.css" rel="stylesheet" type="text/css">
<title>· SHARESTORE ·</title>
</head>
<body>
	<div id="page">
		<header>
			<div id="top">
				<div class="logo">
					<a href="mainhomeLogin.jsp"> <img src="./data/logo.png" />
					</a>
				</div>

				<div class="top_menu">
					<li class="menu-item"><a href="result/logout.jsp"> <span
							class="icon icon-logout"></span> <strong>LOGOUT</strong>
					</a></li>
					<li class="menu-item"><a href="cart.jsp"> <span
							class="icon icon-cart"></span> <strong>CART</strong>
					</a></li>
					<li class="menu-item"><a href="orderList.do"> <span
							class="icon icon-mypage"></span> <strong>MYPAGE</strong>
					</a></li>
				</div>
			</div>
			<nav>
				<ul class="nav-container">
					<li class="nav-item"><a href="apparelAll.do">APPAREL</a>
						<p>|</p></li>
					<li class="nav-item"><a href="bagAll.do">BAG</a>
						<p>|</p></li>
					<li class="nav-item"><a href="shoesAll.do">SHOES</a>
						<p>|</p></li>
					<li class="nav-item"><a href="accAll.do">ACC</a>
						<p>|</p></li>
					<li class="nav-item"><a href="lifeAll.do">LIFE</a></li>
				</ul>
			</nav>
		</header>
		<section id="container">
			<div class="sub_title_wrap">
				<h2 class="sub_title">MY PAGE</h2>
			</div>
			<h3 style="text-align: center;">
				<a href="mypage.jsp">마이페이지</a>
				<a href="mypage.jsp">주문내역</a>
			</h3>
			
			<% ArrayList<OrderVO> orderList = (ArrayList<OrderVO>) request.getAttribute("orderList");
			if(!orderList.isEmpty()){%>
			<table border ="1" class="cols tbl_product shopping">
			<colgroup>
				<col style="width: 170px;">
				<col style="width: 170px;">
				<col style="width: 240px;">
				<col style="width: 150px;">
				<col style="width: 170px;">
				<col style="width: 170px;">
				<col style="width: 170px;">
			</colgroup>
			<thead>
				<tr>
				<th>주문번호</th>
				<th>주문일</th>
				<th>금액</th>
				<th>진행상황</th>
				</tr>
			</thead>
			<% 
			for(int i = 0; i < orderList.size(); i++){
				OrderVO order = orderList.get(i);	
			%>
			<thead>
				<tr>  
				<th><a href="#"><%=order.getOrderNumber() %></a></th>
				<th><%=order.getOrderDate() %></th>
				<th><%=order.getTotalPrice() %></th>    
				<th><%=order.getStatus() %></th>  
				</tr>
			</thead>
			<tbody>
			<%} 
			}
			else{%>
				<tr>
					<td colspan="8" style="text-align:center;"><p>구매 내역이 없습니다.<p></td>
				</tr>
			</tbody>		
			</table><%}%>
		</section>
	</div>
</body>