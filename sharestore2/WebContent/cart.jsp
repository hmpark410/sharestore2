<%@ page import="java.util.ArrayList"%>
<%@ page import="com.sharestore2.vo.CartVO"%>
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
		<form name="form1" method="post">
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

					<li class="menu-item"><a href="login.jsp"> <span
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
					<li class="menu-item"><a href="cartList.do"> <span
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
					<li class="nav-item">
						<a href="apparelAll.do">APPAREL</a>
						<p>|</p>
					</li>
					<li class="nav-item">
						<a href="bagAll.do">BAG</a>
						<p>|</p>
					</li>
					<li class="nav-item">
						<a href="shoesAll.do">SHOES</a>
						<p>|</p>
					</li>
					<li class="nav-item">
						<a href="accAll.do">ACC</a>
						<p>|</p>
					</li>
					<li class="nav-item">
						<a href="category.do?category=3005">LIFE</a>
					</li>
				</ul>
			</nav>
		</header>
			<section id="container_cart">
				<div class="sub_title_wrap2">
					<h2 class="sub_title">SHOPPING BAG</h2>
				</div>
				<%ArrayList<CartVO> cartProductList = (ArrayList<CartVO>) request.getAttribute("cartProductList");
						if (!cartProductList.isEmpty()) { %>
				<div class="cart_frame">
					<div class="cart_cont">
						<table class="cols tbl_product shopping">
							<colgroup>
								<col style="width: 10px;">
								<col style="width: 100px;">
								<col style="width: 20px;">
								<col style="width: 35px;">
								<col style="width: 35px;">
								<col style="width: 60px;">
							</colgroup>
							<thead>
								<tr>
									<th></th>
									<th>상품정보</th>
									<th>수량</th>
									<th>판매가</th>
									<th>합계</th>
									<th>선택</th>
								</tr>
							</thead>
							<tbody>
								<%
								int totalPrice = 0;
								for (int i = 0; i < cartProductList.size(); i++) {
									CartVO cart = cartProductList.get(i);
									totalPrice += (cart.getPrice() * cart.getCount());
									String url = "./data/" + cart.getFilename1();
								%>
								<tr>
									<th><input type="checkbox" id="class" name="class" value="<%=cart.getCartNumber()%>" onclick="value_check()"></th>
									<th>
										<a href="productView.do?productNumber=<%=cart.getProductNumber()%>">
											<img style="width: 60px; height: 80px; background-size: 60px 80px; background-repeat: no-repeat;" src="<%=url%>" />
										</a>
										<p><%=cart.getProduct().getName()%> ( <%=cart.getProduct().getSize()%> )</p>
									</th>
									<th><%=cart.getCount()%></th>
									<th><%=cart.getPrice()%></th>
									<th><%=cart.getPrice() * cart.getCount()%></th>
									<th>
										<input type="hidden" name="productNumber" value="<%=cart.getProductNumber()%>" />
										<input type="hidden" name="count" value="<%=cart.getCount()%>" />
										<input type="hidden" name="price" value="<%=cart.getPrice()%>" />
										<button type="submit" name="orderbtn" style="margin-bottom:5px;" value="<%=cart.getCartNumber()%>" onclick="javascript: form.action='cartSingleConfirm.do';">주문하기</button>
										<button type="submit" name="deletebtn" value="<%=cart.getCartNumber()%>" onclick="javascript: form.action='cartSingleDelete.do';">삭제하기</button>
									</th>
								</tr>
								<%
									}
								%>
							</tbody>
						</table>
						<div class="bx_btn" style="margin-top: -15px;">
							<button type="submit" name="button" class="btn"
								onclick="javascript: form.action='cartDelete.do';">선택상품
								삭제하기</button>
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
								<p style="margin-top:-8px;">
									<input type="text" name="tPrice" style="width:85px; text-align:right; background-color: #f2f2f2; border: #f2f2f2; font-size: 20px; color: #1a2e88;"/> 원
								</p>
							</li>
						</ul>

						<button type="submit" name="button" class="btn sky"
							style="width: 100%"
							onclick="javascript: form.action='cartConfirm.do';">선택상품 주문하기
						</button>
				</div>
				<%
					} else {
				%>
				<div class="cart_frame" style="border-top: 2px solid #1a2e88;">
					<table class="cols tbl_product shopping">
						<colgroup>
							<col style="width: 10px;">
							<col style="width: 100px;">
							<col style="width: 20px;">
							<col style="width: 35px;">
							<col style="width: 35px;">
							<col style="width: 60px;">
						</colgroup>
						<thead>
							<tr>
								<th></th>
								<th>상품정보</th>
								<th>수량</th>
								<th>판매가</th>
								<th>합계</th>
								<th>선택</th>
							</tr>
						</thead>
						<tbody>
							<tr>
					        	<td colspan="6" style="text-align:center;"><p>상품이 없습니다.<p></td>
					        </tr>
						</tbody>
					</table>
				</div>
				<%} %>
			</section>
		</form>
	</div>
	<script type="text/javascript">
		function value_check() {
	        var check_count = document.getElementsByName("class").length;
	        var totalPrice=0;
	        
	        for (var i=0; i<check_count; i++) {
	            if (document.getElementsByName("class")[i].checked == true) {
	                totalPrice += (document.getElementsByName("price")[i].value)*(document.getElementsByName("count")[i].value);  
	            }
	        }
	        document.form1.tPrice.value=totalPrice;
	    }
	</script>
</body>
</html>