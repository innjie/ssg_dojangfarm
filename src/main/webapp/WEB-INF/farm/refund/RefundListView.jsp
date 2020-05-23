<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>환불목록 보기</title>
</head>
<body>
<table border="1">
<tr>
	<td>번호</td>
	<td>제목</td>
	<td>작성자</td>
</tr>
<c:forEach var="refund" items="${refundList}" >
	<tr>
	<td>${refund.refundNo}</td>
	<td><a href="<c:url value='/refund/viewRefund.do'> 
						<c:param name='refundNo' value='${refund.refundNo}'/>
						</c:url>">${refund.refundNo}</a>
	</td>
	</tr>
</c:forEach>
</table>
</body>
</html>