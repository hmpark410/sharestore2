<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.sharestore2.vo.SellerVO" %>
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
			selected = "adminPage.jsp";
		}
	%>
	<jsp:include page="<%=selected%>" flush="false">
		<jsp:param name="" value="" />
	</jsp:include>
    <div class="admseller_frame">
    	<h3>Seller</h3>
		<form action="adminSellerDelete.do" method="post">
			<div class="admin_btn">
			 	<input type="submit" name="delete_btn" class="delete_btn" value="삭제">
			</div>
		 	<div class="sellerlist">
				<table id="table" class="cols tbl_product" style="z-index:1; border-bottom: 1px solid #b5b5b5;">
				    <colgroup>
				         <col style="width: 175px;">
					     <col style="width: 175px;">
					     <col style="width: 175px;">
					     <col style="width: 175px;">
					     <col style="width: 175px;">
					     <col style="width: 75px;">
				    </colgroup>
				    <thead>
				        <tr>
				            <th>아이디</th>
				            <th>비밀번호</th>
				            <th>상점명</th>        
				            <th>휴대폰번호</th>
				            <th>담당자</th>	
				            <th></th>
				        </tr>
				    </thead>
				    <% ArrayList<SellerVO> sellerList = (ArrayList<SellerVO>) request.getAttribute("sellerList");
					if(!sellerList.isEmpty()){%>
					<% 
						for(int i = 0; i < sellerList.size(); i++){
							SellerVO list = sellerList.get(i);	
					%>
					<tbody>
						<tr>  
							<th><%=list.getSellerId() %></th>
							<th><%=list.getPasswd() %></th>
							<th><%=list.getStore() %></th>    
							<th><%=list.getPhone() %></th>
							<th><%=list.getSellerName()%></th>
							<th><input type="checkbox" name="class" value=<%=list.getSellerId() %>></th> 
						</tr>
					<%} 
					}
					else{%>
						<tr>
			            	<th colspan="8"><p style="text-align: center;">회원이 없습니다.<p></th>
			         	</tr>
					</tbody>		
				</table><%} %>
			</div>
		</form>		    
	</div>	
</body>
</html>