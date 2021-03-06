<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문 리스트 보기</title>
</head>
<body>
<%@ include file="../IncludeTop.jsp" %>
<div id="page">
		<div id="content">
		<div class = "post">
<table border="1">
<tr>
	<td>주문번호</td>
	<td>수량</td>
	<td>상품 타입</td>
	<td>상품번호</td>
	<td>주문자</td>
	<td>배송번호</td>
</tr>
<c:forEach var="order" items="${orderList.pageList}"  varStatus = "status">

	<tr>
	<td><a href="<c:url value='/order/view.do'> 
						<c:param name='orderNo' value='${order.orderNo}'/>
						</c:url>">${order.orderNo}</a>
	</td>
	<td>${order.quantity }</td>
	<td>${order.saleType}</td>
	<td>
		<a href="<c:url value='/normal/viewNormal.do'>
					<c:param name="saleNo" value="${order.saleNo}"/>
				</c:url>">
		${order.saleNo}</a>
	</td>
	<td>${order.user.name}</td>
	<td>
	<c:if test = "${(order.saleType == 'Normal') }">
	 <a href = "<c:url value ='/normal/viewDelivery.do'>
	 <c:param name = 'orderNo' value = '${order.orderNo }'/>
	 </c:url>"> ${order.delivery.dNo }</a>
	</c:if>
	
	<c:if test = "${(order.saleType == 'Common') }">
	<a href = "<c:url value ='/common/viewDelivery.do'>
	 <c:param name = 'orderNo' value = '${order.orderNo }'/>
	 </c:url>"> ${order.delivery.dNo }</a>
	</c:if>
	</td>
	</tr>
</c:forEach>
</table>
<c:if test="${!orderList.firstPage}">
			<a href='<c:url value="/order/list2.do">
        				<c:param name="page" value="previous"/>
        			</c:url>'>
				Prev</a>
		</c:if>
		<c:if test="${!orderList.lastPage}">
			<a href='<c:url value="/order/list2.do">
        				<c:param name="page" value="next"/>
        			</c:url>'>
				Next</a>
		</c:if>

	</div>
	</div>
	<div style="clear: both;">&nbsp;</div>
	</div>
	<div id="footer-menu">
	<ul>
		<li class="current_page_item"><a href="#">Homepage</a></li>
		<li><a href="#">Blog</a></li>
		<li><a href="#">Photos</a></li>
		<li><a href="#">About</a></li>
		<li><a href="#">Contact</a></li>
	</ul>
</div>
<div id="footer">
	<p>&copy; Untitled. All rights reserved. Design by <a href="http://templated.co" rel="nofollow">TEMPLATED</a>.</p>
</div>
</body>
</html>