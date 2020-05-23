<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�ֹ� ����Ʈ ����</title>
</head>
<body>
<table border="1">
<tr>
	<td>�ֹ���ȣ</td>
	<td>�ֹ���</td>
</tr>
<c:forEach var="order" items="${orderList}" >
	<tr>
	<td><a href="<c:url value='/order/viewOrder.do'> 
						<c:param name='order' value='${order.orderNo}'/>
						</c:url>">${order.orderNo}</a>
	</td>
	<td>${order.user.name}</td>
	</tr>
</c:forEach>
</table>
</body>
</html>