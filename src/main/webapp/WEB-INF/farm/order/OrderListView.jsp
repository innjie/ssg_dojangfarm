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
<table border="1">
<tr>
	<td>주문번호</td>
	<td>수량</td>
	<td>상품 타입</td>
	<td>상품번호</td>
	<td>주문자</td>
	<td>배송번호</td>
</tr>
<c:forEach var="order" items="${orderList.pageList}" >
<c:if test = "${(order.state != 'Refund') }">
	<tr>
	<td><a href="<c:url value='/order/view.do'> 
						<c:param name='orderNo' value='${order.orderNo}'/>
						</c:url>">${order.orderNo}</a>
	</td>
	<td>${order.quantity }</td>
	<td>${order.saleType}</td>
	<td>${order.saleNo} </td>
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
	</c:if>
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


</body>
</html>