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
	<td> <a href = "<c:url value =''><c:param name = 'dNo'
	value = '${order.delivery.dNo}'/></c:url>"> ${order.delivery.dNo }</a></td> 
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

<a href="/index" >[메인으로]</a>
</body>
</html>