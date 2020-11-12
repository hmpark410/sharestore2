<%@ page import = "com.sharestore2.vo.MemberVO" %>
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
	<% MemberVO member = (MemberVO)session.getAttribute("member");%>
	<section id="container_mupdate">
		<div class="sub_title_wrap3">
			<h2 class="sub_title3"> MEMBER UPDATE </h2>
        </div>
        <div class="mupdate_frame">
        	<div class="mupdate_cont">
            	<a class="mdelete" onClick="location.href='memberDelete.do'">회원탈퇴</a>
				<form action="memberUpdate.do" method="post">
					<table>
						<tbody>
				        	<tr>
				        		<th>아이디</th>
				        		<td>
				        			<p class="email va_m">
						            <input type="text" name="id" id="custid" value = "${member.id}" maxlength="50" readonly></p>
				        		</td>
				       		</tr>
					        <tr>
					        	<th>비밀번호<span>*</span> </th>
					         	<td>
					          		<input type="password" name="passwd" id="pw" value = "${member.passwd}"  maxlength="16"  placeholder="영문+숫자 조합 8~16자리">
					          	</td>
					        </tr>
						    <tr>
						    	<th>비밀번호 확인<span>*</span></th>
						        <td>
						        	<input type="password" name="check_passwd" id="pwConfirm" maxlength="16">
						        </td>
							</tr>
							<tr>
						    	<th>이름</th>
						        <td>
						        	<p class="join_name va_m">
                       				<input type="text" name="name" id="join_name" maxlength="10" value="${member.name}" readonly></p>
						        </td>
							</tr>
							<tr>
						    	<th>휴대폰번호<span>*</span></th>
						        <td>
					          		<input type="text" name="phone" id="phone" value = "${member.phone}" maxlength="13" placeholder="하이픈(-)을 포함하여 입력해주세요.">
					          	</td>
							</tr>
							<tr>
						    	<th>주소<span>*</span></th>
								<td>
									<input type="text" name="postCode" id="postCode" style="width:100px; margin: 10px 8px 0 0;" readonly>
									<input type="button" onclick="DaumPostcode()" value="우편번호 찾기">
									<br>
									<input type="text" name="roadAddress" id="roadAddress" name="roadAddress" placeholder="도로명주소" style="margin: 8px 0 0 0;" readonly>
									<br>
									<input type="text" name="detailAddress" id="detailAddress" name="detailAddress"placeholder="상세주소" style="margin: 8px 0 10px;">
								</td>
							</tr>
							<tr>
						    	<th>이메일</th>
						        <td>
					          		<input type="text" name="mail" id="mail" value = "${member.mail}"  maxlength="30" placeholder="@을 포함하여 입력해주세요.">
					          	</td>
							</tr>
							<tr>
						    	<th>성별</th>
						        <td>
					          		<input type="text" name="gender" id="gender" value="${member.gender}" readonly>
					          	</td>
							</tr>
							<tr>
						    	<th>생년월일</th>
						        <td>
                       				<input type="text" name="birth" id="birth" value="${member.birth_y}. ${member.birth_m}. ${member.birth_d}" readonly>
						        </td>
							</tr>
				        </tbody>
					</table>
					<div class="update_btn_wrap">
		                <button type="submit" id="btnConfirm" name="button" class="btn black">확인</button>
		            </div> 
			    </form>
			</div>
	   	</div>
	</section>
	<script type="text/javascript">
		function DaumPostcode() {
			new daum.Postcode({
				oncomplete : function(data) {
					var roadAddr = data.roadAddress; // 도로명 주소 변수
					// 우편번호와 주소 정보를 해당 필드에 넣는다.
					document.getElementById('postCode').value = data.zonecode;
					document.getElementById("roadAddress").value = roadAddr;
					detailAddress
				}
			}).open();
		}
	</script>
</body>
</html>