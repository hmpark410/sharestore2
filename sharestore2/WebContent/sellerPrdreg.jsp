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
	<%
		String selected = request.getParameter("pageChange");
		if (selected == null) {
			selected = "sellerPage.jsp";
		}
	%>
	<jsp:include page="<%=selected%>" flush="false">
		<jsp:param name="" value="" />
	</jsp:include>
	<div class="sellerprdreg_frame">
		<div class="sellerprd_cont">
			<h3>상품등록</h3>
			<form action="productInsert.do" method="post" enctype="multipart/form-data" style="border-top: 2px solid #1a2e88;">
				<table>
					<tbody>
						<tr>
							<th>카테고리</th>
							<td>
								<div class="select_box_wrap">
									<div class="select_box category_box">
										<select id="category" name="category" style="width: 124px;"
											class="normal">
											<option>카테고리</option>
											<optgroup label="WOMEN">
												<option value="1001">APPAREL</option>
												<option value="1002">BAG</option>
												<option value="1003">SHOES</option>
												<option value="1004">ACC</option>
											</optgroup>
											<optgroup label="MEN">
												<option value="2001">APPPAREL</option>
												<option value="2002">BAG</option>
												<option value="2003">SHOES</option>
												<option value="2004">ACC</option>
											</optgroup>
											<optgroup label="LIFE">
												<option value="3005">ALL</option>
											</optgroup>
										</select>
									</div>
								</div>
							</td>
						</tr>
						<tr>
							<th>상품명</th>
							<td><input type="text" name="name" maxlength="30"
								placeholder="ex)핑크 플라워 미니 원피스" style="width: 600px;"></td>
						</tr>
						<tr>
							<th>사이즈</th>
							<td><input type="text" name="size" maxlength="10"
								placeholder="ex) S" style="width: 400px;"></td>
						</tr>
						<tr>
							<th>가격</th>
							<td>
								<p>
									<input type="number" name="price" min="1" value ="1" id="price" maxlength="10"
										placeholder="ex) 50000"
										style="width: 400px; margin-right: 5px;" /> 원
								</p>
							</td>
						</tr>
						<tr>
							<th>수량</th>
							<td><input type="number" name="stock" id="
								stock" min="1" value ="1" maxlength="10" placeholder="ex) 10"
								style="width: 400px;"></td>
						</tr>
						<tr>
							<th>상품설명</th>
							<td><input type="text" name="exp" id="exp" maxlength="50"
								placeholder="색상과 상품 상세내용을 50자 이내로 적어주세요." style="width: 600px;"></td>
						</tr>
						<tr>
							<th>대표 이미지</th>
							<td><input type="file" accept=".gif, .png, .jpg, .jpeg"
								name="filename1" id="prdimg1" style="width: 400px;">
								<p>- 권장이미지 : 500px * 500px / 10M 이하 / gif, png, jpg(jpeg)</p></td>
						</tr>
						<tr>
							<th>추가 이미지1</th>
							<td><input type="file" accept=".gif, .png, .jpg, .jpeg"
								name="filename2" id="prdimg2" style="width: 200px;"></td>
						</tr>
						<tr>
							<th>추가 이미지2</th>
							<td><input type="file" accept=".gif, .png, .jpg, .jpeg"
								name="filename3" id="prdimg3" style="width: 200px;"></td>
						</tr>
					</tbody>
				</table>
				${error}
				<div class="prdreg_btn_wrap">
					<input type="hidden" name="sellerId" value="${seller.sellerId }" />
					<button type="button" id="btnCancel" name="button" class="btn"
						onclick="location.href='sellerPage.jsp';">취소</button>
					<button type="submit" id="btnConfirm" name="button"
						class="btn black" onclick="WCKMember.JoinSubmit();">확인</button>
				</div>

	</div>
</body>
</html>