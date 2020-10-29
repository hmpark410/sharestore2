<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.sharestore2.vo.ProductVO" %>
<!DOCTYPE html>
<html>
<head>
	<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="style.css" rel="stylesheet" type="text/css">
	<title>· SHARESTORE ·</title>
</head>
<body>
	<%
		String selected = request.getParameter("pageChange");
		if (selected == null) {
			selected = "sellerPage.jsp";
			
		} %>
	<jsp:include page="<%=selected%>" flush="false">
		<jsp:param name="" value="" />
	</jsp:include>
	<div class="sellerprdlist_frame">
     	<h3>상품목록</h3>
     	<form method="post">
     		<div class="admin_btn">
			    <input type="submit" name="update_btn" class="update_btn" value="수정" onclick="javascript: form.action='sellerPrdUpdatelist.do';"> 
			 	<input type="submit" name="delete_btn" class="delete_btn" value="삭제" onclick="javascript: form.action='sellerPrdDelete.do';">
			</div>	
			<div class="productlist">
				<table id="table" class="cols tbl_product" style="z-index:1; border-bottom: 1px solid #b5b5b5;" >
					<colgroup>
					     <col style="width: 125px;">
					     <col style="width: 125px;">
					     <col style="width: 125px;">
					     <col style="width: 125px;">
					     <col style="width: 125px;">
					     <col style="width: 125px;">
					     <col style="width: 125px;">
					     <col style="width: 75px;">
					</colgroup>
					<thead>
						<tr>
						    <th>상품 ID</th>
						    <th>카테고리 ID</th>        
						    <th>상품명</th>
						    <th>사이즈</th>
						    <th>수량</th>
						    <th>가격</th>
						    <th>상태</th>	
						    <th></th>
						</tr>
					</thead>
					<% ArrayList<ProductVO> sellerPrdlist = (ArrayList<ProductVO>) request.getAttribute("sellerPrdlist");
					if(!sellerPrdlist.isEmpty()){%>
					<% 
						for(int i = 0; i < sellerPrdlist.size(); i++){
							ProductVO prdlist = sellerPrdlist.get(i);	
					%>
					<tbody>
						<tr>  
							<th><%=prdlist.getproductNumber() %></th>
							<th><%=prdlist.getCategory() %></th>
							<th><%=prdlist.getName() %></th>    
							<th><%=prdlist.getSize() %></th>
							<th><%=prdlist.getStock()%></th>
							<th><%=prdlist.getPrice()%></th>
							<% 
								if(prdlist.getStock()!=0) {	
							%>
								<th>재고 있음</th>
							<%
								} else {
							%>
								<th>품절</th>
							<%
								}
							%>
							<th><input type="checkbox" name="class" value=<%=prdlist.getproductNumber() %>></th> 
						</tr>
					<%} 
					}
					else{%>
						<tr>
			            	<th colspan="8"><p style="text-align: center;">상품이 없습니다.<p></th>
			         	</tr>
					</tbody>		
				</table><%} %>
			</div>
		</form>
	</div>			    		
</body>
</html>