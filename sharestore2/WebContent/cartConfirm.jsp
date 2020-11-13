<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.sharestore2.vo.CartVO"%>
<%@ page import="com.sharestore2.vo.MemberVO"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="style.css" rel="stylesheet" type="text/css">
	<title>· SHARESTORE ·</title>
</head>
<body>
	<div id="page">
		<form method="post">
		<header>
			<div id="top">
				<div class="logo">
					<a href="mainhome.jsp"> <img src="./data/logo.png" />
					</a>
				</div>
				<div class="top_search">
					<input type="text" id="tsearch" name="search" placeholder="검색어를 입력하세요.">
					<button type="submit" name="button" onclick="javascript: form.action='search.do';">검색</button>
				</div>
				<div class="top_menu">
					<li class="menu-item"><a href="result/logout.jsp"> <span
							class="icon icon-logout"></span> <strong>LOGOUT</strong>
					</a></li>
					<li class="menu-item"><a href="cartList.do"> <span
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
					<h2 class="sub_title">Order Confirmation</h2>
				</div>
				<div class="confirm_frame">
					<div class="confirm_cont">
						<table class="cols tbl_product shopping">
							<colgroup>
								<col style="width: 450px;">
								<col style="width: 250px;">
								<col style="width: 270px;">
								<col style="width: 270px;">
							</colgroup>
							<thead>
								<tr>
									<th>상품정보</th>
									<th>수량</th>
									<th>판매가</th>
									<th>합계</th>
								</tr>
							</thead>
							
							<%
							
							MemberVO member = (MemberVO) session.getAttribute("member");
							ArrayList<CartVO> cartConfirmList = (ArrayList<CartVO>) session.getAttribute("cartConfirmList");
							
							
								if (!cartConfirmList.isEmpty()) { 
									int totalPrice = 0;
									for (int i = 0; i < cartConfirmList.size(); i++) {
										CartVO cart = cartConfirmList.get(i);
										totalPrice += (cart.getPrice() * cart.getCount());
										String url = "./data/" + cart.getFilename1();
							%>
							<tbody>
								<tr>
									<th>
										<a href="productView.do?productNumber=<%=cart.getProductNumber()%>">
											<img style="width: 60px; height: 80px; background-size: 60px 80px; background-repeat: no-repeat;" src="<%=url%>" />
										</a>
										<p><%=cart.getProduct().getName()%> ( <%=cart.getProduct().getSize()%> )</p>
									</th>
									<th><%=cart.getCount()%></th>
									<th><%=cart.getPrice()%></th>
									<th><%=cart.getPrice() * cart.getCount()%></th>
								</tr>
								<%} %>
								<tr>
									<th colspan="4" class="total_price"><p>총 금액  : <span><%=totalPrice%></span>원</p></th>
								</tr>
							</tbody>
						</table>
						<div class="bx_btn">
							<button type="button" id="btnCancel" name="button" class="btn"
								onclick="history.back(-1);">취소</button>
								<input type="hidden" name="totalPrice" value="<%=totalPrice%>"/>
							
							<button type="submit" id="btnConfirm" name="button" class="btn black" onclick="javascript: form.action='kakaopay.jsp';">결제하기</button>
						</div>
					</div>
				</div>
				<%} %>
			</section>
		</form>
	</div>
</body>
</html>