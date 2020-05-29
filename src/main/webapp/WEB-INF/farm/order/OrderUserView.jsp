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
<title>주문자 리스트 보기</title>
</head>
<body>
<table border = "1">
<tr>
	<td>주문자</td>
	</tr>
	<c:forEach var="user" items="${userNames}">
	<tr>
	<td><a href="<c:url value='/order/viewOrder.do'>
	<c:param name='user' value='${user.name}'/>
	</c:url>">${user.name}</a>
	</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>