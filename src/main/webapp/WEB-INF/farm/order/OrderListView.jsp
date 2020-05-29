<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>주문 리스트 보기</title>
</head>
<body>
<table border="1">
<tr>
	<td>주문번호</td>
	<td>주문자</td>
</tr>
<c:forEach var="order" items="${orderList}" >
	<tr>
	<td><a href="<c:url value='/order/view.do'> 
						<c:param name='order' value='${order.orderNo}'/>
						</c:url>">${order.orderNo}</a>
	</td>
	<td>${order.user.name}</td>
	</tr>
</c:forEach>
</table>
<a href="/index" >[메인으로]</a>
</body>
</html>