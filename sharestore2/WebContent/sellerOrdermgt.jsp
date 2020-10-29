<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.sharestore2.vo.OrderVO" %>
<%  request.setCharacterEncoding("UTF-8");%>
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
		}
	%>
	<jsp:include page="<%=selected%>" flush="false">
		<jsp:param name="" value="" />
	</jsp:include>
	<div class="sellerodmgt_frame">
  		<h3>나의 주문처리 현황</h3>
  		<div class="state">
			<ul class="order">
  		<% 
  			int cnt1 = 0;
  			int cnt2 = 0;
  			int cnt3 = 0;
  			ArrayList<OrderVO> sellerOrderList = (ArrayList<OrderVO>) request.getAttribute("sellerOrderList");%>		
				<li>
					<h4>배송준비</h4>
					<%if(!sellerOrderList.isEmpty()){
						for(int i = 0; i < sellerOrderList.size(); i++){
							OrderVO orderlist = sellerOrderList.get(i);
							if(orderlist.getStatus().equals("배송준비")) {
								cnt1++;
							}					
						}%>
						<span><%=cnt1 %></span>
					<%} else {%>
					<span>0</span>
					<%} %>
				</li>
				<li>
					<h4>배송중</h4>
					<%if(!sellerOrderList.isEmpty()){
						for(int i = 0; i < sellerOrderList.size(); i++){
							OrderVO orderlist = sellerOrderList.get(i);	
							if(orderlist.getStatus().equals("배송중")) {
								cnt2++;
							}
						}%>
						<span><%=cnt2 %></span>
					<%} else {%>
					<span>0</span>
					<%} %>
				</li>
				<li>
					<h4>배송완료</h4>								
					<%if(!sellerOrderList.isEmpty()){
						for(int i = 0; i < sellerOrderList.size(); i++){
							OrderVO orderlist = sellerOrderList.get(i);	
							if(orderlist.getStatus().equals("배송완료")) {
								cnt3++;
							}
						}%>
						<span><%=cnt3 %></span>
					<%} else {%>
					<span>0</span>
					<%} %>
				</li>					
			</ul>
		</div>
		<h3>주문내역</h3>
		<div class="orderlist">
			<form action="sellerOrderUpdate.do" method="post">
				<table id="table1" class="cols tbl_product shopping">
					<colgroup>
					     <col style="width: 150px;">
					     <col style="width: 150px;">
					     <col style="width: 150px;">
					     <col style="width: 150px;">
					     <col style="width: 150px;">
					     <col style="width: 150px;">
					     <col style="width: 150px;">
					     <col style="width: 80px;">
					</colgroup>
					<thead>
					    <tr>
					        <th>주문일</th>
					        <th>주문번호</th>
					        <th>상품ID</th>          
					        <th>금액</th>
					        <th>아이디</th>
					        <th>진행상황</th>
					        <th></th>
					        <th><Button type="submit" id="ddddd" name="update_status" class="update_status">수정</Button></th>	
					    </tr>
					</thead>
					<% 
								if(!sellerOrderList.isEmpty()){		
								for(int i = 0; i < sellerOrderList.size(); i++){
									OrderVO orderlist = sellerOrderList.get(i);
					%>
					<tbody>
						<tr>
							<th><input type="text" name="orderDate" class="txt" value = "<%=orderlist.getOrderDate() %>"></th>
							<th><input type="text" name="orderNumber" class="txt" value = "<%=orderlist.getOrderNumber() %>" readonly></th>
							<th><input type="text" name="productNumber" class="txt" value = "" readonly></th>
							<th><input type="text" name="totalPrice" class="txt" value = "<%=orderlist.getTotalPrice() %>" readonly></th>
							<th><input type="text" name="memberId" class="txt" value = "<%=orderlist.getMemberId() %>" readonly></th>
							<th><input type="text" name="status" class="txt" value = "<%=orderlist.getStatus() %>" readonly></th>
							<th>
								<div class="select_box_wrap">
									<div class="select_box orderstatus_box">
										<select id="orderstatus" name="orderstatus" style="width: 110px;" class="orderstatus">
											<option value="<%=orderlist.getStatus() %>">진행</option>
												<option value="배송준비">배송준비</option>
												<option value="배송중">배송중</option>
												<option value="배송완료">배송완료</option>
										</select>
									</div>
								</div>
							</th>
							<th>
								<input type="checkbox" id="num_btn" name="chk1" checked="checked" style="display:none;" value=<%=orderlist.getOrderNumber() %>>
								<input type="checkbox" id="status_btn" name="chk2" onclick="value_check();">
							</th>
							<script>
							    function value_check() {
							    	
							        var check_count = document.getElementsByName("chk2").length;
							        for (var i=0; i<check_count; i++) {
							            if (document.getElementsByName("chk2")[i].checked == true) {
							            	var target = document.getElementById("orderstatus");
							            	document.getElementsByName("chk2")[i].value = target.options[target.selectedIndex].value;
							            }
							        }
							    }
							</script>
						</tr>
						<%} 
						}
						else{%>
				        <tr>
				        	<td colspan="7" style="text-align:center;"><p>구매 내역이 없습니다.<p></td>
				        </tr>
					</tbody>
					<%} %>
				</table>
			</form>
		</div>
    </div>
</body>
</html>