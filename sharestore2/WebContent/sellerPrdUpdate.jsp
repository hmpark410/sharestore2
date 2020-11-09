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
						          	<div class="select_box_wrap">
										<div class="select_box birth_box">
											<select id="category" name="category" style="width: 124px;"
												class="normal">
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
					          		<input type="number" name="price" id="price" maxlength="10" min="1" value ="1" "<%=prdlist.getPrice()%>">
					          	</td>
							</tr>
							<tr>
						    	<th>수량</th>
						        <td>
					          		<input type="number" name="stock" id="stock" maxlength="10" min="1" value ="1" "<%=prdlist.getStock()%>">
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
</body>
</html>