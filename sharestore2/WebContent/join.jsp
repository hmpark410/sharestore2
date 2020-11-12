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
						<a href="lifeAll.do">LIFE</a>
					</li>
				</ul>
			</nav>
		</header>
		<section id="container">
			<div class="sub_title_wrap">
				<h2 class="sub_title">JOIN</h2>
			</div>
			<div class="member_frame">
				<div class="join_btn_wrap">
					<button type="button"  name="button" class="btn" onclick="location.href='memberInsert.jsp'">Buyer</button>
					<button type="button"  name="button" class="btn" onclick="location.href='sellerInsert.jsp'">Seller</button>
				</div>
			</div>
		</section>
		</form>
	</div>
</body>
</html>