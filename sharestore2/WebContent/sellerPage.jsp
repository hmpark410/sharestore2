<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.sharestore2.vo.MemberVO"%>
<%@ page import="com.sharestore2.vo.SellerVO"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="style.css" rel="stylesheet" type="text/css">
<title>· SHARESTORE ·</title>
</head>
<body>
	<%
		SellerVO seller = (SellerVO) session.getAttribute("seller");
	%>
	<div id="page">
		<header>
			<div id="top">
				<div class="logo">
					<a href="sellerPage.jsp"> <img src="./data/logo.png" />
					</a>
				</div>
				<div class="top_menu">
					<li class="menu-item"><a href="result/logout.jsp"> <span
							class="icon icon-logout"></span> <strong>LOGOUT</strong>
					</a></li>
				</div>
			</div>
		</header>
		<section id="container_seller">
			<div class="seller_frame">
				<nav>
					<ul class="nav-sellercont">
						<li style="background-color: #f2f2f2;">
							<h3>
								<strong>${seller.store}</strong>님 안녕하세요 :)
								<a class="sdelete" style="color:#000; font-size:10px; font-weight:normal; margin-left: 7px;" onClick="location.href='sellerDelete.do'">회원탈퇴</a>
							</h3>
						</li>
						<li><a href="sellerPrdreg.jsp">상품 등록</a></li>
						<li><a href="sellerPrdlist.do">상품 목록</a></li>
						<li><a href="sellerOrdermgt.do">주문 관리</a></li>
					</ul>
				</nav>
			</div>
		</section>
	</div>
</body>
</html>