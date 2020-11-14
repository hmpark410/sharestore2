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
								<div class="select_box_wrap" style="display: inline-block;">
									<select id="category" name="category" style="width: 124px;" class="normal" onchange="doChange(this, 'sub_category')">
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
								<div class="select_box_wrap" style="display: inline-block;">
									<select id="sub_category" name="sub_category" style="width: 124px; class="normal">
										<option>카테고리</option>
									</select>
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
				<script type="text/javascript">
					function doChange(srcE, targetId){
					    var val = srcE.options[srcE.selectedIndex].value;
					    var targetE = document.getElementById(targetId);
					    removeAll(targetE);
					
					    if(val == '1001' || val == '2001'){
					    	addOption('아우터', targetE);
					        addOption('원피스', targetE);
					        addOption('블라우스/셔츠', targetE);
					        addOption('니트', targetE);
					        addOption('상의/티', targetE);
					        addOption('하의/팬츠', targetE);
					        addOption('기타', targetE);
					    } else if(val == '1002' || val == '2002'){
					    	addOption('숄더백', targetE);
					        addOption('토트백', targetE);
					        addOption('클러치', targetE);
					        addOption('백팩', targetE);
					        addOption('지갑/파우치', targetE);
					        addOption('기타', targetE);
					    } else if(val == '1003' || val == '2003'){
					    	addOption('펌프스', targetE);
					        addOption('플랫/로퍼', targetE);
					        addOption('슬리퍼/뮬', targetE);
					        addOption('샌들', targetE);
					        addOption('부츠', targetE);
					        addOption('스니커즈', targetE);
					        addOption('기타', targetE);
					    } else if(val == '1004' || val == '2004'){
					    	addOption('주얼리', targetE);
					        addOption('모자', targetE);
					        addOption('시계', targetE);
					        addOption('스카프/머플러', targetE);
					        addOption('안경', targetE);
					        addOption('선글라스', targetE);
					        addOption('기타', targetE);
					    } else if(val == '3005'){
					    	addOption('가구/수납', targetE);
					        addOption('홈데코', targetE);
					        addOption('조명', targetE);
					        addOption('가전제품', targetE);
					        addOption('디지털기기', targetE);
					        addOption('펫용품', targetE);
					        addOption('문구', targetE);
					        addOption('기타', targetE);
					    }
					}
					
					function addOption(value, e){
					    var o = new Option(value);
					    try{
					        e.add(o);
					    }catch(ee){
					        e.add(o, null);
					    }
					}
					
					function removeAll(e){
					    for(var i = 0, limit = e.options.length; i < limit - 1; ++i){
					        e.remove(1);
					    }
					}
				</script>
				${error}
				<div class="prdreg_btn_wrap">
					<input type="hidden" name="sellerId" value="${seller.sellerId }" />
					<button type="button" id="btnCancel" name="button" class="btn"
						onclick="location.href='sellerPage.jsp';">취소</button>
					<button type="submit" id="btnConfirm" name="button"
						class="btn black" onclick="WCKMember.JoinSubmit();">확인</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>