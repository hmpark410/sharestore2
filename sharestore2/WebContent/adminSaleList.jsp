<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.sharestore2.vo.OrderVO" %>
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
			
	} %>
	<jsp:include page="<%=selected%>" flush="false">
		<jsp:param name="" value="" />
	</jsp:include>
	<div class="salelist_frame">
     	<h3>SaleList</h3>
		<div class="orderlist">
			<form name="form1" method="post">
				<table id="table" class="cols tbl_product" style="z-index:1; border-bottom: 1px solid #b5b5b5;" >
					<colgroup>
					     <col style="width: 185px;">
					     <col style="width: 187px;">
					     <col style="width: 185px;">
					     <col style="width: 185px;">
					     <col style="width: 185px;">
					     <col style="width: 185px;">
					</colgroup>
					<thead>
						<tr>
							<th>주문번호</th>
							<th>주문일</th>
							<th>총금액</th>
							<th>진행상황</th>
							<th>회원아이디</th>
							<th>판매자아이디</th>
						</tr>
					</thead>
					<% ArrayList<OrderVO> saleList = (ArrayList<OrderVO>) request.getAttribute("saleList");
					if(!saleList.isEmpty()){%>
					<% 
						for(int i = 0; i <saleList.size(); i++){
							OrderVO list = saleList.get(i);	
					%>
					<tbody>
						<tr>
							<th><button type="submit" class="hiddenbtn" name="orderNumber" onclick='showPopup2()' value="<%=list.getOrderNumber() %>"><%=list.getOrderNumber() %></button></th>
							<th><%=list.getOrderDate() %></th>
							<th><%=list.getTotalPrice() %></th>    
							<th><%=list.getStatus() %></th>
							<th><%=list.getMemberId()%></th>
							<th><%=list.getSellerId() %></th>   
						</tr>
					<%} 
					}
					else{%>
						<tr>
			            	<th colspan="6"><p style="text-align: center;">판매 목록이 없습니다.<p></th>
			         	</tr>
					</tbody>		
				</table><%} %>
				<script type="text/javascript">
					function showPopup2(){
						var check =document.form1;
						window.open('', 'POP',"width=750, height=400, top=45, left=535");
						check.action='orderDetail.do';
						check.target='POP';
						check.submit();
					}	
				</script>
			</form>
		</div>
	</div>
</body>
</html>