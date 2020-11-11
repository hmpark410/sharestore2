<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ page import="java.util.ArrayList"%>
<%@ page import="com.sharestore2.vo.OrderVO"%>
<%@ page import="com.sharestore2.vo.OrderProductVO"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
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
	<div class="sellerodmgt_frame">
		<h3>나의 주문처리 현황</h3>
		<div class="state">
			<ul class="order">
				<%
				int cnt1 = 0;
				int cnt2 = 0;
				int cnt3 = 0;
				int cnt4 = 0;
				int cnt5 = 0;
				ArrayList<OrderVO> sellerOrderList = (ArrayList<OrderVO>) request.getAttribute("sellerOrderList");
				%>
				<li>
					<h4>배송준비</h4> <%
				 	if (!sellerOrderList.isEmpty()) {
				 	for (int i = 0; i < sellerOrderList.size(); i++) {
				 		OrderVO orderlist = sellerOrderList.get(i);
				 		if (orderlist.getStatus().equals("배송준비")) {
				 	cnt1++;
				 		}
				 	}
				 %> <span><%=cnt1%></span> <%
				 	} else {
				 %> <span>0</span> <%
				 	}
				 %>
				</li>
				<li>
					<h4>배송중</h4> <%
				 	if (!sellerOrderList.isEmpty()) {
				 	for (int i = 0; i < sellerOrderList.size(); i++) {
				 		OrderVO orderlist = sellerOrderList.get(i);
				 		if (orderlist.getStatus().equals("배송중")) {
				 	cnt2++;
				 		}
				 	}
				 %> <span><%=cnt2%></span> <%
				 	} else {
				 %> <span>0</span> <%
				 	}
				 %>
				</li>
				<li>
					<h4>배송완료</h4> <%
				 	if (!sellerOrderList.isEmpty()) {
				 	for (int i = 0; i < sellerOrderList.size(); i++) {
				 		OrderVO orderlist = sellerOrderList.get(i);
				 		if (orderlist.getStatus().equals("배송완료")) {
				 	cnt3++;
				 		}
				 	}
				 %> <span><%=cnt3%></span> <%
				 	} else {
				 %> <span>0</span> <%
				 	}
				 %>
				</li>
				<li>
					<h4>환불</h4> <%
				 	if (!sellerOrderList.isEmpty()) {
				 	for (int i = 0; i < sellerOrderList.size(); i++) {
				 		OrderVO orderlist = sellerOrderList.get(i);
				 		if (orderlist.getStatus().equals("환불")) {
				 	cnt4++;
				 		}
				 	}
				 %> <span><%=cnt4%></span> <%
				 	} else {
				 %> <span>0</span> <%
				 	}
				 %>
				</li>
				<li>
					<h4>취소</h4> <%
				 	if (!sellerOrderList.isEmpty()) {
				 	for (int i = 0; i < sellerOrderList.size(); i++) {
				 		OrderVO orderlist = sellerOrderList.get(i);
				 		if (orderlist.getStatus().equals("취소")) {
				 	cnt5++;
				 		}
				 	}
				 %> <span><%=cnt5%></span> <%
				 	} else {
				 %> <span>0</span> <%
				 	}
				 %>
				</li>
			</ul>
		</div>
		<h3>주문내역</h3>

		<div class="orderlist">

			<table class="cols tbl_product shopping">
				<colgroup>
					<col style="width: 186px;">
					<col style="width: 186px;">
					<col style="width: 186px;">
					<col style="width: 186px;">
					<col style="width: 186px;">
					<col style="width: 200px;">
				</colgroup>
				<thead>
					<tr>
						<th>주문일</th>
						<th>주문번호</th>
						<th>상품</th>
						<th>금액</th>
						<th>아이디</th>
						<th>진행상황</th>
						<th></th>
					</tr>
				</thead>
				<%
					if (!sellerOrderList.isEmpty()) {
					for (int i = 0; i < sellerOrderList.size(); i++) {
						OrderVO orderlist = sellerOrderList.get(i);
				%>
				<tbody>
					<tr>
						<th><input type="text" name="orderDate" class="txt"
							value="<%=orderlist.getOrderDate()%>"></th>
						<th><input type="text" name="orderNumber" class="txt"
							value="<%=orderlist.getOrderNumber()%>" readonly></th>
						<th><input type="text" name="totalPrice" class="txt"
							value="<%=orderlist.getTotalPrice()%>" readonly></th>
						<th><input type="text" name="memberId" class="txt"
							value="<%=orderlist.getMemberId()%>" readonly></th>
						<th><input type="text" name="status" class="txt"
							value="<%=orderlist.getStatus()%>" readonly></th>
						<th>
							<form action="sellerOrderUpdate.do" method="post">
								<div class="select_box_wrap"
									style="float: left; margin-left: 5px;">
									<div class="select_box orderstatus_box">
									<input type="hidden" name="orderNumber" value="<%=orderlist.getOrderNumber()%>">
									<input type="hidden" name="sellerId" value="<%=orderlist.getSellerId()%>">
										<select id="orderstatus" name="update_status"
											style="width: 110px;" class="orderstatus">
											<option value="">상태변경</option>
											<option value="취소">취소</option>
											<option value="배송준비">배송준비</option>
											<option value="배송중">배송중</option>
											<option value="배송완료">배송완료</option>
											<option value="환불">환불</option>
										</select>
									</div>
								</div>
								
								<Button type="submit" name="update_status" class="update_status">수정</Button>
							</form>
						</th>
					</tr>
					<%
						}
					} else {
					%>
					<tr>
						<td colspan="6" style="text-align: center;"><p>구매 내역이
								없습니다.
							<p></td>
					</tr>
				</tbody>
				<%
					}
				%>
			</table>
		</div>
	</div>
</body>
</html>