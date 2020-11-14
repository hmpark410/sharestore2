<%@ page import="java.util.ArrayList"%>
<%@ page import=" java.sql.Timestamp"%>
<%@ page import="com.sharestore2.vo.OrderVO"%>
<%@ page import="com.sharestore2.vo.MemberVO"%>
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
   MemberVO member = (MemberVO) session.getAttribute("member");
   if (member == null) {
      response.sendRedirect("login.jsp");
   } 
   else {
   %>
   <div id="page">
      <header>
         <div id="top">
            <div class="logo">
               <a href="mainhome.jsp"> <img src="./data/logo.png" />
               </a>
            </div>

            <div class="top_menu">
               <li class="menu-item"><a href="result/logout.jsp"> <span
                     class="icon icon-logout"></span> <strong>LOGOUT</strong>
               </a></li>
               <li class="menu-item"><a href="cartList.do"> <span
                     class="icon icon-cart"></span> <strong>CART</strong>
               </a></li>
               <li class="menu-item"><a href="orderList.do"> <span
                     class="icon icon-mypage"></span> <strong>MYPAGE</strong>
               </a></li>
            </div>
         </div>
         <nav>
				<ul class="nav-container">
					<li class="nav-item">
						<a href="apparelAll.do">APPAREL</a>
						<p>|</p>
					</li>
					<li class="nav-item">
						<a href="bagAll.do">BAG</a>
						<p>|</p>
					</li>
					<li class="nav-item">
						<a href="shoesAll.do">SHOES</a>
						<p>|</p>
					</li>
					<li class="nav-item">
						<a href="accAll.do">ACC</a>
						<p>|</p>
					</li>
					<li class="nav-item">
						<a href="category.do?category=3005">LIFE</a>
					</li>
				</ul>
			</nav>
      </header>
      <section id="container">
         <div class="sub_title_wrap">
            <h2 class="sub_title">MY PAGE</h2>
         </div>
         <div class="member_frame">
            <div class="member_cont">
               <div class="mymember">
                  <div class="info">
                     <h3>
                        <strong>${member.name}</strong>님 안녕하세요 :)
                     </h3>
                     <a href="#" class="member_update" onclick="showPopup();">정보관리</a>
                     <script type="text/javascript">
                        function showPopup() {
                           window
                                 .open("memberUpdate.jsp", "정보관리",
                                       "width=850, height=900, top=45, left=535");
                        }
                     </script>
                     <span class="mypage_icon member"></span>
                  </div>
                  <ul>
                     <li><a><h4>총 주문</h4>
                           <p><span> 
                           <%ArrayList<OrderVO> orderList = (ArrayList<OrderVO>) request.getAttribute("orderList");
                           int sum = 0;
                           if (!orderList.isEmpty()) {
                              for (int i = 0; i < orderList.size(); i++) {
                                 OrderVO order = orderList.get(i);
                                 sum += order.getTotalPrice();
                              }
                           %> 
                           <%=sum%></span> 원 ( <span><%=orderList.size()%></span> 회)
                           </p> 
                           <%}else {%> 
                           <span>0</span> 원 ( <span>0</span> 회)
                           <%}%>
                     </a></li>
                  </ul>
               </div>
               <h3>주문내역</h3>
               <div class="orderlist">
                  <form name="form1" method="post">
                     <table class="cols tbl_product shopping">
                        <colgroup>
                           <col style="width: 280px;">
                           <col style="width: 280px;">
                           <col style="width: 280px;">
                           <col style="width: 280px;">
                           <col style="width: 120px;">
                        </colgroup>
                        <thead>
                           <tr>
                              <th>주문번호</th>
                              <th>주문일</th>
                              <th>총금액</th>
                              <th>진행상황</th>
                              <th>선택</th>
                           </tr>
                        </thead>
                        <%
                           if (!orderList.isEmpty()) {
                           for (int i = 0; i < orderList.size(); i++) {
                              OrderVO order = orderList.get(i);
                              String status = order.getStatus();
                        %>
                        <tbody>
                           <tr>
                              <th><button type="submit" class="hiddenbtn"
                              name="orderNum" onclick='showPopup2()'
                              value="<%=order.getOrderNumber()%>"><%=order.getOrderNumber()%></button>
                              </th>
                              <th><%=order.getOrderDate()%></th>
                              <th><%=order.getTotalPrice()%></th>
                              <th><%=order.getStatus()%></th>                             
                                <form name="form2" method="post"> 
                                <th><input type="hidden" name="orderNumber"
                                 value="<%=order.getOrderNumber()%>"> 
                                 <%if (status.equals("주문완료")) {%>
                                 <button type="submit" name="update_status" value="주문취소"
                                    class="update_btn"
                                    onclick="javascript: form.action='memberOrderUpdate.do';">주문취소</button>
                                 <%
                                  }
                                 %> 
                                 <%if (order.getDeliveryDate()!=null) {
                                   Timestamp current = new Timestamp(System.currentTimeMillis());
                                   long today = current.getTime();                                   
                                   long deliveryDate = order.getDeliveryDate().getTime();
                                   long validity = (today - deliveryDate) / (24 * 60 * 60 * 1000); 
                                   //7일 이전 환불신청
                                   if (validity < 7) {%>
                                   <button type="submit" name="update_status" value="환불신청" 
                                     class="update_btn" onclick="javascript:form.action='memberOrderUpdate.do';">환불신청</button>
                                 <%} 
                                 } 
                                 %>                                
                                 </th>                                 
                                 </form>
                                 </tr> 
                           <%}
                           }else{
                           %>
                           <tr>
                              <th colspan="5" style="text-align: center;">
                              <p>구매 내역이 없습니다.<p></th>
                           </tr>
                           <%
                           }
                           %>
                        </tbody>
                     </table>
                     <script type="text/javascript">
                        function showPopup2() {
                           var check = document.form1;
                           window.open('', 'POP',"width=750, height=400, top=45, left=535");
                           check.action = 'orderDetail.do';
                           check.target = 'POP';
                           check.submit();
                        }
                     </script>
                  </form>
               </div>
            </div>
      </section>
   </div>
   <%} %>
</body>