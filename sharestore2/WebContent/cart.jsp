<%@ page import="java.util.ArrayList"%>
<%@ page import="com.sharestore2.vo.OrderProductVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.sharestore2.vo.MemberVO"%>
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
					<%
						MemberVO member = (MemberVO) session.getAttribute("member");
					if (member == null) {
					%>
					<li class="menu-item"><a href="login.jsp"> <span
							class="icon icon-login"></span> <strong>LOGIN</strong>
					</a></li>

					<li class="menu-item"><a href="join.jsp"> <span
							class="icon icon-join"></span> <strong>JOIN</strong>
					</a></li>

					<li class="menu-item"><a href="cart.jsp"> <span
							class="icon icon-cart"></span> <strong>CART</strong>
					</a></li>

					<li class="menu-item"><a href="login.jsp"> <span
							class="icon icon-mypage"></span> <strong>MYPAGE</strong>
					</a></li>

					<%
						} else {
					%>
					<li class="menu-item"><a href="result/logout.jsp"> <span
							class="icon icon-logout"></span> <strong>LOGOUT</strong>
					</a></li>
					<li class="menu-item"><a href="cart.jsp"> <span
							class="icon icon-cart"></span> <strong>CART</strong>
					</a></li>
					<li class="menu-item"><a href="orderList.do"> <span
							class="icon icon-mypage"></span> <strong>MYPAGE</strong>
					</a></li>

					<%
						}
					%>
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
			<section id="container_cart">
				<div class="sub_title_wrap2">
					<h2 class="sub_title">SHOPPING BAG</h2>
				</div>
				<%ArrayList<OrderProductVO> orderProductList = (ArrayList<OrderProductVO>) session.getAttribute("orderProductList");
						if (orderProductList != null) { %>
				<div class="cart_frame">
					<div class="cart_cont">
						<table class="cols tbl_product shopping">
							<colgroup>
								<col style="width: 50px;">
								<col style="width: 50px;">
								<col style="width: 50px;">
								<col style="width: 50px;">
							</colgroup>
							<thead>
								<tr>
									<th>상품명</th>
									<th>판매가</th>
									<th>수량</th>
									<th>합계</th>
								</tr>
							</thead>
							<tbody>
								<%
								int totalPrice = 0;
								for (int i = 0; i < orderProductList.size(); i++) {
									OrderProductVO orderProduct = orderProductList.get(i);
									totalPrice += (orderProduct.getPrice() * orderProduct.getCount());
								%>
								<tr>
									<th><%=orderProduct.getName()%></th>
									<th><%=orderProduct.getPrice()%></th>
									<th><%=orderProduct.getCount()%></th>
									<th><%=orderProduct.getPrice() * orderProduct.getCount()%></th>
								</tr>
								<%
									}
								%>
							</tbody>
						</table>
						<h3 class="tit first_title">
						쇼핑백 상품 <span>(<em><%=orderProductList.size()%></em>)
						</span>
						</h3>
						<div class="bx_btn">
							<button type="submit" name="button" class="btn"
								onclick="javascript: form.action='cartDelete.do';">장바구니
								비우기</button>
							<button type="button" name="button" class="btn sky"
								onclick="window.location='mainhome.jsp'">쇼핑계속하기</button>
						</div>
					</div>
				</div>

				<div class="payment">
					<div class="bx_total">
						<h3>주문금액</h3>
						<ul>
							<li class="total"><strong>총 결제금액</strong>
								<p>
									<em id="counterTotalAmt"><%=totalPrice%></em>원
								</p>
							</li>
						</ul>

						<%
							if (member == null) {
						%>
						<button type="button" name="button" class="btn sky"
							style="width: 100%" onclick="window.location='login.jsp'">전체상품
						주문하기</button>
						<%
							} else {
						%>
						<input type="hidden" name="memberId" value="${member.id}" />
						<button type="submit" name="button" class="btn sky"
							style="width: 100%"
							onclick="javascript: form.action='orderInsert.do';">전체상품
					주문하기
						</button>
					</div>
					<%
						}
					%>
				</div>
				<%
					} else {
				%>
				<div class="cart_frame" style="border-top: 2px solid #1a2e88;">
					<table class="cols tbl_product shopping">
						<colgroup>
							<col style="width: 50px;">
							<col style="width: 50px;">
							<col style="width: 50px;">
							<col style="width: 50px;">
						</colgroup>
						<thead>
							<tr>
								<th>상품명</th>
								<th>판매가</th>
								<th>수량</th>
								<th>합계</th>
							</tr>
						</thead>
						<tbody>
							<tr>
					        	<td colspan="4" style="text-align:center;"><p>상품이 없습니다.<p></td>
					        </tr>
						</tbody>
					</table>
				</div>
				<%} %>
			</section>
		</form>
	</div>
</body>
</html>