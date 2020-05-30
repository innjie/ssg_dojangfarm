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
	<table border="1">
		<tr>
			<td>주문번호</td>
			<td>주문자 번호</td>
			<td>주문자</td>
		</tr>
		<c:forEach var="order" items="${orderUserList}">
			<tr>
				<td>${order.orderNo }</td>
				<td><a
					href="<c:url value='/order/view.do'>
	<c:param name='orderNo' value='${order.orderNo }'/>
	</c:url>">${order.orderNo }</a>
				</td>
				<td>${order.user.userNo }</td>
				<td>${order.user.name }</td>
			</tr>
		</c:forEach>
	</table>
	<!--  매핑 확인하고 수정 -->
	<a href="OrderListView">[이전 단계로]</a>
</body>
</html>