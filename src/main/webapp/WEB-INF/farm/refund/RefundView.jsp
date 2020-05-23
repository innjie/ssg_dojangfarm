<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>환불정보 상세보기</title>
</head>
<body>
<table border="1" width="600" height="800">
	<tr>
	<td>환불번호</td>
	<td>환불날짜</td>
	<tr>
	<td>${refund.refundNo}</td>
	<td>${refund.refundDate }
	</tr>
</table>
<a href="RefundListView" >[이전 페이지로]</a>

</body>
</html>