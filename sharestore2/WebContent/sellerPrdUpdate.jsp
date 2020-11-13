<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.sharestore2.vo.SellerVO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import = "com.sharestore2.vo.ProductVO" %>
<!DOCTYPE html>
<html>
<head>
	<script type="text/javascript">
		window.open("/", "상품수정", "width=850, height=900, top=45, left=535");
	</script>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="style.css" rel="stylesheet" type="text/css">
	<title>· SHARESTORE ·</title>
</head>
<body>
	<%
		SellerVO seller = (SellerVO) session.getAttribute("seller");
	%>
	<section id="container_pupdate">
		<div class="sub_title_wrap3">
			<h2 class="sub_title3"> PRODUCT UPDATE </h2>
        </div>
        <div class="pupdate_frame">
        	<div class="pupdate_cont">
				<form action="sellerPrdUpdate.do" method="post">
					<% ArrayList<ProductVO> sellerPrdUpdatelist = (ArrayList<ProductVO>) request.getAttribute("sellerPrdUpdatelist");
					if(!sellerPrdUpdatelist.isEmpty()){%>
					<% 
						for(int i = 0; i < sellerPrdUpdatelist.size(); i++){
							ProductVO prdlist = sellerPrdUpdatelist.get(i);	
					%>
					<table>
						<tbody>
				        	<tr>
				        		<th>상품 ID</th>
				        		<td>
				        			<p class="productNumber">
						            <input type="text" name="productNumber" id="productNumber" value = "<%=prdlist.getproductNumber() %>" maxlength="50" readonly></p>
				        		</td>
				       		</tr>
					        <tr>
					        	<th>카테고리 ID</th>
					         	<td>
						          	<div class="select_box_wrap" style="display: inline-block;">
										<select id="category" name="category" style="width: 124px;" class="normal" onchange="doChange(this, 'sub_category')">
											<option value="<%=prdlist.getCategory()%>">카테고리</option>
											<optgroup label="WOMEN">
												<option value="1001">APPPAREL</option>
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
												<option value="3001">ALL</option>
											</optgroup>
										</select>
									</div>
									<div class="select_box_wrap" style="display: inline-block;">
									<select id="sub_category" name="sub_category" style="width: 124px; class="normal">
										<option value="<%=prdlist.getSubCategory()%>">카테고리</option>
									</select>
								</div>
					          	</td>
					        </tr>
						    <tr>
						    	<th>상품명</th>
						        <td>
						        	<input type="text" name="name" id="name" value = "<%=prdlist.getName() %>" maxlength="30">
						        </td>
							</tr>
							<tr>
						    	<th>사이즈</th>
						        <td>
						        	<p class="join_name va_m">
                       				<input type="text" name="size" maxlength="10" value = "<%=prdlist.getSize()%>"></p>
						        </td>
							</tr>
							<tr>
						    	<th>가격</th>
						        <td>
					          		<input type="number" name="price" id="price" maxlength="10" min="1" value ="<%=prdlist.getPrice()%>">
					          	</td>
							</tr>
							<tr>
						    	<th>수량</th>
						        <td>
					          		<input type="number" name="stock" id="stock" maxlength="10" min="1" value ="<%=prdlist.getStock()%>">
					          	</td>
							</tr>
							<tr>
						    	<th>상품설명</th>
						        <td>
					          		<input type="text" name="exp" id="exp" maxlength="50" value = "<%=prdlist.getExp()%>">
					          	</td>
							</tr>
				        </tbody>
					</table>
					<%} 
					}%>
					<div class="update_btn_wrap">
		                <input type="submit" id="btnConfirm" name="button" value="확인" class="btn black">
		            </div>  
			    </form>
			</div>
	   	</div>
	</section>
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
</body>
</html>