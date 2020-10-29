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
					<a href="mainhome.jsp">
						<img src="./data/logo.png"/>
					</a>
				</div>			
				<div class="top_search">
					<input type="text" id="tsearch" placeholder="검색어를 입력하세요.">
					<button type="submit" name="button">검색</button>

				</div>
				<div class="top_menu">
					<li class="menu-item">
						<a href="login.jsp">
							<span class="icon icon-login"></span>
	                        <strong>LOGIN</strong>
						</a>
					</li>
					<li class="menu-item">
						<a href="join.jsp">
							<span class="icon icon-join"></span>
	                        <strong>JOIN</strong>
						</a>
					</li>
					<li class="menu-item">
						<a href="cart.jsp">
							<span class="icon icon-cart"></span>
	                        <strong>CART</strong>
						</a>
					</li>
					<li class="menu-item">
						<a href="mypage.jsp">
							<span class="icon icon-mypage"></span>
	                        <strong>MYPAGE</strong>
						</a>
					</li>
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
				<h2 class="sub_title"> JOIN SELLER </h2>
	        </div>
	        <div class="member_frame">
	        	<div class="member_cont">
	            	<p class="table_notice"><span>*</span> 필수 입력 항목</p>
					<form id="minsert" action="sellerInsert.do" method="post">
						<table>
							<tbody>
					        	<tr>
					        		<th>아이디<span>*</span></th>
					        		<td>
					        			<p class="email va_m">
							            <input type="text" name="sellerId" id="id" maxlength="50" style="ime-mode:disabled"></p>
					        		</td>
					       		</tr>
						        <tr>
						        	<th>비밀번호 <span>*</span></th>
						         	<td>
						          		<input type="password" name="passwd" id="passwd" maxlength="16" placeholder="영문+숫자 조합 8~16자리">
						          	</td>
						        </tr>
							    <tr>
							    	<th>비밀번호 확인 <span>*</span></th>
							        <td>
							        	<input type="password" name="check_passwd" id="check_passwd" maxlength="16">
							        </td>
								</tr>
								<tr>
							    	<th>상점명 <span>*</span></th>
							        <td>
							        	<p class="join_name va_m">
                        				<input type="text" name="store" id="name" maxlength="10" placeholder="STORENAME" /></p>
							        </td>
								</tr>
							<tr>
							    	<th>휴대폰번호<span>*</span></th>
							        <td>
						          		<input type="text" name="phone" id="phone" maxlength="13" placeholder="하이픈(-)을 제외하고 입력해주세요.">
						          	</td>
								</tr>
								<tr>
							    	<th>판매자이름 <span>*</span></th>
							        <td>
							        	<p class="join_name va_m">
                        				<input type="text" name="sellerName" id="name" maxlength="10" placeholder="ex) 홍길동" /></p>
							        </td>
								</tr>
					        </tbody>
						</table>
						 ${error}
						<div class="join_btn_wrap">
			                <button type="button" id="btnCancel" name="button" class="btn" onclick="history.back(-1);">취소</button>
			                <button type="submit" id="btnConfirm" name="button" class="btn black"  onclick="WCKMember.JoinSubmit();">확인</button>   
			            </div>
				    </form>
				</div>
		   	</div> 
		</section>
	</div>
</body>
</html>