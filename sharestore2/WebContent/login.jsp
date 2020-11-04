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
				<h2 class="sub_title"> LOGIN </h2>
	        </div>
	        <div class="member_frame">
	        	<div class="member_cont">
	            	<div class="login_wrap" style="margin-top: 60px;">
						<div class="login_radio" style="margin-bottom: 5px;">
							<span class="input_button">
								<input type="radio" name="memberType" id="idSave" value="buyer" checked="checked">
								<label for="idSave">Buyer</label>
							</span>
							<span class="input_button" style="margin-left: -15px;">
								<input type="radio" name="memberType" id="idSave" value="seller">
								<label for="idSave">Seller</label>
							</span>
						</div>
						
						<div class="inp_group">
	                        <p>
	                            <label for="inp_id">아이디</label> 		                           
	                            <input type="text" name="id" id="custId" maxlength="50" class="full_width" value="">
	                        </p>
	                        
	                        <p class="mt20">
	                            <label for="inp_pw">비밀번호</label>		                         
	                            <input type="password" name="passwd" id="custPw" maxlength="20" class="full_width">	                     
	                        </p>
	                        <br />
	                    </div>
	                    <div class="btn_group">
	                        <button type="submit" class="btn full_width black" onclick="javascript: form.action='memberLogin.do';">로그인</button>
	                        <ul class="link">
	                            <li><a href="forgetId.jsp">아이디 찾기</a></li>
	                            <li>|</li>
	                            <li><a href="forgetPasswd.jsp">비밀번호 찾기</a></li>
	                        </ul>
		                    </div>
		             </div>
		         </div>
		   	</div>
		</section>
		</form>
	</div>
	<script type="text/javascript">
		document.addEventListener('keydown', function(event) {
		    if (event.keyCode === 13) {
		        event.preventDefault();
		    }
		}, true);
	</script>
</body>
</html>