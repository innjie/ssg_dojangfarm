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
<title>환불목록 보기</title>
</head>
<body>
<table border="1">
<tr>
	<td>환불번호</td>
	<td>주문번호 </td>
</tr>
<c:forEach var="refund" items="${refundList}" >
	<tr>
	<td>${refund.refundNo}</td>
	<td><a href="<c:url value='/refund/view.do'> 
						<c:param name='refundNo' value='${refund.refundNo}'/>
						</c:url>">${refund.refundNo}</a>
	</td>
	<td>${refund.order.orderNo }</td>
	</tr>

</c:forEach>
</table>
</body>
</html>