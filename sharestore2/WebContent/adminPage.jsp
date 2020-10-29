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
					<a href="adminPage.jsp">
						<img src="./data/logo.png"/>
					</a>
				</div>
				
				<div class="top_menu">
					<li class="menu-item">
						<a href="result/logout.jsp">
							<span class="icon icon-logout"></span>
	                        <strong>LOGOUT</strong>
						</a>
					</li>
				</div>
			</div>
		</header>
		
		<section id="container_adm">
			<div class="admin_frame">
				<nav>
					<ul class="nav-admcont">
						<li>
							<a href="#">회원 관리</a>
							<ul class="second-nav">
								<li class="buyer-nav">
									<a href="adminBuyer.do">BUYER</a>
								</li>
								<li class="seller-nav">
									<a href="adminSeller.do">SELLER</a>
								</li>
							</ul>
						</li>
						<li>
							<a href="adminProduct.do">상품 관리</a>
						</li>
					</ul>
				</nav>
	        </div>			
		</section>
	</div>
</body>
</html>