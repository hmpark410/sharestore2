<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
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
						<input type="text" id="tsearch" name="search"
							placeholder="검색어를 입력하세요.">
						<button type="submit" name="button"
							onclick="javascript: form.action='search.do';">검색</button>
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
			<section id="container">
				<div class="sub_title_wrap">
					<h2 class="sub_title">JOIN MEMBER</h2>
				</div>
				<div class="member_frame">
					<div class="member_cont">
						<p class="table_notice">
							<span>*</span> 필수 입력 항목
						</p>
						<table>
							<tbody>
								<tr>
									<th>아이디<span>*</span></th>
									<td>
										<p class="email va_m">
											<input type="text" name="id" id="id" maxlength="50"
												style="ime-mode: disabled">
										</p>
									</td>
								</tr>
								<tr>
									<th>비밀번호 <span>*</span></th>
									<td><input type="password" name="passwd" id="passwd"
										maxlength="16" placeholder="영문+숫자 조합 8~16자리"></td>
								</tr>
								<tr>
									<th>비밀번호 확인 <span>*</span></th>
									<td><input type="password" name="check_passwd"
										id="check_passwd" maxlength="16"></td>
								</tr>
								<tr>
									<th>이름 <span>*</span></th>
									<td>
										<p class="join_name va_m">
											<input type="text" name="name" id="name" maxlength="10"
												placeholder="ex) 홍길동" />
										</p>
									</td>
								</tr>
								<tr>
									<th>휴대폰번호<span>*</span></th>
									<td><input type="text" name="phone" id="phone"
										maxlength="11" placeholder="하이픈(-)을 제외하고 입력해주세요."></td>
								</tr>
								<tr>
									<th>주소</th>
									<td>
									<label> 우편번호 </label>
									<input type="text" id="postcode" placeholder="우편번호" style="margin: 10px;">
									<input type="button" onclick="DaumPostcode()" 
										value="우편번호 찾기">
									<br>
									<label>주소</label>	
									<input type="text" id="roadAddress" name="roadAddress" placeholder="도로명주소" style="margin: 10px">
									<br>
									<label>상세 주소 입력</label>
									<input type="text" id="detailAddress" name="detailAddress"placeholder="상세주소" style="margin: 10px">
									</td>
								</tr>
								<tr>
									<th>이메일</th>
									<td><input type="text" name="mail" id="mail"
										maxlength="30" placeholder="@을 포함하여 입력해주세요."></td>
								</tr>
								<tr>
									<th>성별<span>*</span></th>
									<td><span class="input_button"> <input type="radio"
											name="gender" id="gender" value="female" /> <label
											for="female">여성</label>
									</span> <span class="input_button"> <input type="radio"
											name="gender" id="gender" value="male" /> <label for="male">남성</label>
									</span></td>
								</tr>
								<tr>
									<th>생년월일<span>*</span></th>
									<td>
										<div class="select_box_wrap">
											<div class="select_box birth_box">
												<select id="birth" name="select_year" style="width: 124px;"
													class="normal">
													<option value="0">년도</option>
													<option value="2006">2006</option>
													<option value="2005">2005</option>
													<option value="2004">2004</option>
													<option value="2003">2003</option>
													<option value="2002">2002</option>
													<option value="2001">2001</option>
													<option value="2000">2000</option>
													<option value="1999">1999</option>
													<option value="1998">1998</option>
													<option value="1997">1997</option>
													<option value="1996">1996</option>
													<option value="1995">1995</option>
													<option value="1994">1994</option>
													<option value="1993">1993</option>
													<option value="1992">1992</option>
													<option value="1991">1991</option>
													<option value="1990">1990</option>
													<option value="1989">1989</option>
													<option value="1988">1988</option>
													<option value="1987">1987</option>
													<option value="1986">1986</option>
													<option value="1985">1985</option>
													<option value="1984">1984</option>
													<option value="1983">1983</option>
													<option value="1982">1982</option>
													<option value="1981">1981</option>
													<option value="1980">1980</option>
													<option value="1979">1979</option>
													<option value="1978">1978</option>
													<option value="1977">1977</option>
													<option value="1976">1976</option>
													<option value="1975">1975</option>
													<option value="1974">1974</option>
													<option value="1973">1973</option>
													<option value="1972">1972</option>
													<option value="1971">1971</option>
													<option value="1970">1970</option>
													<option value="1969">1969</option>
													<option value="1968">1968</option>
													<option value="1967">1967</option>
													<option value="1966">1966</option>
													<option value="1965">1965</option>
													<option value="1964">1964</option>
													<option value="1963">1963</option>
													<option value="1962">1962</option>
													<option value="1961">1961</option>
													<option value="1960">1960</option>
													<option value="1959">1959</option>
													<option value="1958">1958</option>
													<option value="1957">1957</option>
													<option value="1956">1956</option>
													<option value="1955">1955</option>
													<option value="1954">1954</option>
													<option value="1953">1953</option>
													<option value="1952">1952</option>
													<option value="1951">1951</option>
													<option value="1950">1950</option>
													<option value="1949">1949</option>
													<option value="1948">1948</option>
													<option value="1947">1947</option>
													<option value="1946">1946</option>
													<option value="1945">1945</option>
													<option value="1944">1944</option>
													<option value="1943">1943</option>
													<option value="1942">1942</option>
													<option value="1941">1941</option>
													<option value="1940">1940</option>
													<option value="1939">1939</option>
													<option value="1938">1938</option>
													<option value="1937">1937</option>
													<option value="1936">1936</option>
													<option value="1935">1935</option>
													<option value="1934">1934</option>
													<option value="1933">1933</option>
													<option value="1932">1932</option>
													<option value="1931">1931</option>
													<option value="1930">1930</option>
													<option value="1929">1929</option>
													<option value="1928">1928</option>
													<option value="1927">1927</option>
													<option value="1926">1926</option>
													<option value="1925">1925</option>
													<option value="1924">1924</option>
													<option value="1923">1923</option>
													<option value="1922">1922</option>
													<option value="1921">1921</option>
													<option value="1920">1920</option>
													<option value="1919">1919</option>
													<option value="1918">1918</option>
													<option value="1917">1917</option>
													<option value="1916">1916</option>
													<option value="1915">1915</option>
													<option value="1914">1914</option>
													<option value="1913">1913</option>
													<option value="1912">1912</option>
													<option value="1911">1911</option>
													<option value="1910">1910</option>
													<option value="1909">1909</option>
													<option value="1908">1908</option>
													<option value="1907">1907</option>
													<option value="1906">1906</option>
												</select> <select id="select_month" name="select_month"
													style="width: 124px;" class="normal">
													<option value="0">월</option>
													<option value="01">1</option>
													<option value="02">2</option>
													<option value="03">3</option>
													<option value="04">4</option>
													<option value="05">5</option>
													<option value="06">6</option>
													<option value="07">7</option>
													<option value="08">8</option>
													<option value="09">9</option>
													<option value="10">10</option>
													<option value="11">11</option>
													<option value="12">12</option>
												</select> <select id="select_day" name="select_day"
													style="width: 124px;" class="normal">
													<option value="0">일</option>
													<option value="01">1</option>
													<option value="02">2</option>
													<option value="03">3</option>
													<option value="04">4</option>
													<option value="05">5</option>
													<option value="06">6</option>
													<option value="07">7</option>
													<option value="08">8</option>
													<option value="09">9</option>
													<option value="10">10</option>
													<option value="11">11</option>
													<option value="12">12</option>
													<option value="13">13</option>
													<option value="14">14</option>
													<option value="15">15</option>
													<option value="16">16</option>
													<option value="17">17</option>
													<option value="18">18</option>
													<option value="19">19</option>
													<option value="20">20</option>
													<option value="21">21</option>
													<option value="22">22</option>
													<option value="23">23</option>
													<option value="24">24</option>
													<option value="25">25</option>
													<option value="26">26</option>
													<option value="27">27</option>
													<option value="28">28</option>
													<option value="29">29</option>
													<option value="30">30</option>
													<option value="31">31</option>
												</select>
											</div>
										</div>
									</td>
								</tr>
							</tbody>
						</table>
						${error}
						<div class="join_btn_wrap">
							<button type="button" id="btnCancel" name="button" class="btn"
								onclick="history.back(-1);">취소</button>
							<button type="submit" id="btnConfirm" name="button"
								class="btn black"
								onclick="javascript: form.action='memberInsert.do';">확인</button>
						</div>
					</div>
				</div>
			</section>
		</form>
	</div>
	<script type="text/javascript">
		function DaumPostcode() {
			new daum.Postcode({
				oncomplete : function(data) {
					var roadAddr = data.roadAddress; // 도로명 주소 변수
					// 우편번호와 주소 정보를 해당 필드에 넣는다.
					document.getElementById('postcode').value = data.zonecode;
					document.getElementById("roadAddress").value = roadAddr;
					detailAddress
				}
			}).open();
		}
	</script>
	<script type="text/javascript">
		document.addEventListener('keydown', function(event) {
			if (event.keyCode === 13) {
				event.preventDefault();
			}
		}, true);
	</script>
</body>
</html>