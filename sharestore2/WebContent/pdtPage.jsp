<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.sharestore2.vo.MemberVO"%>
<%@ page import="com.sharestore2.vo.ProductVO"%>
<%@ page import="com.sharestore2.vo.OrderProductVO"%>
<%@ page import="com.sharestore2.dao.ProductDAO"%>
<%@ page import="com.sharestore2.dao.OrderProductDAO"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="style.css" rel="stylesheet" type="text/css">
<title>· SHARESTORE ·</title>
</head>
<body>
	<section id="pdt_container">
		<div class="pdtimg">
			<div class="mySlides fade">
				<img src="./data/${product.filename1 }"
					style="width: 600px; height: 800px;">
			</div>
			<div class="mySlides fade">
				<img src="./data/${product.filename2 }"
					style="width: 600px; height: 800px;">
			</div>
			<div class="mySlides fade">
				<img src="./data/${product.filename3 }"
					style="width: 600px; height: 800px;">
			</div>
			<a class="prev" onclick="plusSlides(-1)">&#10094;</a> <a class="next"
				onclick="plusSlides(1)">&#10095;</a>
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
				if (n > slides.length) {
					slideIndex = 1
				}
				if (n < 1) {
					slideIndex = slides.length
				}
				for (i = 0; i < slides.length; i++) {
					slides[i].style.display = "none";
				}
				slides[slideIndex - 1].style.display = "block";
			}
		</script>
		<%
		MemberVO member = (MemberVO) session.getAttribute("member");
		ProductVO product = new ProductVO();
		ArrayList<OrderProductVO> orderProductList = (ArrayList<OrderProductVO>) session.getAttribute("orderProductList");
		%>
		
		<div class="pdtexp">
		<form method="post">
			<div class="pdtexp_top"
				style="margin-bottom: 20px; border-bottom: 2px solid #e6e6e6;">
				<h2 style="font-weight: bolder; font-size: 35px;">${product.name }</h2>
				<p style="font-size: 25px;">${product.price }</p>
				<p style="margin-top: -10px; margin-bottom: 15px; font-size: 12px;">${product.exp }</p>
			</div>
			<div class="pdtexp_middle" style="margin-bottom: 50px;">
				<select id="pdtsize" name="pdtsize" style="width: 100%"
					class="normal">
					<option value="">사이즈</option>
					<option value="${product.size}">${product.size}</option>
				</select>
				<input type="number" name="count" placeholder="수량" style="width: 100%; margin-top:15px;"/>
				<input
				type="hidden" name="memberId" value="${member.id}" /> <input
				type="hidden" name="productNumber" value="${product.productNumber}" />
			</div>
			
				 

			<div class="pdtexp_bottom">
				<button type="submit" name="button" class="btn"
					style="width: 100%; margin-bottom: 10px;"
					onclick="javascript:form.action='cartInsert.do';">장바구니</button>
				<script type="text/javascript">
					function cartClick() {
						opener.parent.location="form.action='cartInsert.do'";
						window.close();
					}
				</script>
				<%
			
					if (member == null) {
				%>
				<button type="button" name="button" class="btn sky"
					style="width: 100%" onclick="window.location='login.jsp'">구매하기</button>
				<%
					} else {
				%>
			
				<button type="submit" name="button" class="btn sky"
					style="width: 100%"
					onclick="javascript: form.action='orderProductInsert.do';">구매하기</button>
			
			</div>
			<%
				}
			%>
			</form>
		</div>

	</section>
</body>
</html>