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
						<input type="text" id="tsearch" placeholder="검색어를 입력하세요.">
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
	
			<section id="slideshow">
				<div class="slideshow-container">
					<div class="mySlides fade">
						 <img src="./data/p1.jpg" style="width:100%">
					</div>	
					<div class="mySlides fade">
						 <img src="./data/p2.jpg" style="width:100%">
					</div>				
					<div class="mySlides fade">
						 <img src="./data/p3.jpg" style="width:100%">
					</div>
					<div class="mySlides fade">
						 <img src="./data/p4.jpg" style="width:100%">
					</div>			
					<a class="prev" onclick="plusSlides(-1)">&#10094;</a>
					<a class="next" onclick="plusSlides(1)">&#10095;</a>	
				</div>
					
				<div style="text-align: center">
					 <span class="dot" onclick="currentSlide(1)"></span> 
					 <span class="dot" onclick="currentSlide(2)"></span> 
					 <span class="dot" onclick="currentSlide(3)"></span>
					 <span class="dot" onclick="currentSlide(4)"></span> 
				</div>
				<script type="text/javascript">
					var slideIndex = 1;
					showSlides(slideIndex);
				
					function plusSlides(n) {
					  showSlides(slideIndex += n);
					}
				
					function currentSlide(n) {
					  showSlides(slideIndex = n);
					}
				
					function showSlides(n) {
					  var i;
					  var slides = document.getElementsByClassName("mySlides");
					  var dots = document.getElementsByClassName("dot");
					  if (n > slides.length) {slideIndex = 1}    
					  if (n < 1) {slideIndex = slides.length}
					  for (i = 0; i < slides.length; i++) {
					      slides[i].style.display = "none";  
					  }
					  for (i = 0; i < dots.length; i++) {
					      dots[i].className = dots[i].className.replace(" active", "");
					  }
					  slides[slideIndex-1].style.display = "block";  
					  dots[slideIndex-1].className += " active";
					}
				</script>
			</section>
		</form>
	</div>
</body>
</html>