<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.sharestore2.vo.ProductVO"%>
<%@ page import="com.sharestore2.dao.ProductDAO"%>
<%@ page import="com.oreilly.servlet.MultipartRequest"%>
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
		<header>
			<div id="top">
				<div class="logo">
					<a href="mainhome.jsp">
						<img src="./data/logo.png"/>
					</a>
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
		
		<section id="pdtlist_title">
			<div class="sub_title_wrap">
				<h2 class="sub_title"> BAG </h2>
	        </div>
		</section>
		
		<section id="pdtlist_sub_title">
			<nav>
				<ul>
					<li>
						<a href="bagAll.do">ALL</a>
					</li>
					<li>
						<a href="bagWomen.do">WOMEN</a>
					</li>
					<li>
						<a href="bagMen.do">MEN</a>
					</li>
				</ul>
			</nav>
		</section>
		
		<section id="pdtlist_block">
			<h1>HOME > BAG > ALL</h1>
			<%
				ArrayList<ProductVO> productList = (ArrayList<ProductVO>) request.getAttribute("productList");
			if (!productList.isEmpty()) {
				for (int i = 0; i < productList.size(); i++) {
					ProductVO product = productList.get(i);
					String url = "./data/" + product.getFilename1();
					if (i % 2 == 0) {
			%>
			<table>
				<colgroup>
					<col style="width: 400px;">
				</colgroup>
				<tr style="margin-left: 20px;">
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
						</br> <%=product.getName()%></br> <%=product.getPrice()%></br></td>
		
					<%
						if (i % 2 == 1) {
					%>
				</tr>
				
			</table>
			<%
						
					}
				}
			}

			%>
			</table>
		</section>
	</div>
</body>
</html>