<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!--  환불한 내역 보는 페이지 -->
<title>환불정보 상세보기</title>
</head>
<body>
<table border="1" width="600" height="800">
	<tr>
	<td>환불번호</td>
	<td>${refund.refundNo}</td>
	</tr>
	
	<tr>
	<td>물품명</td>
	<td>${refund.order.normal.title }</td>
	</tr>
	
	<tr>
	<td>가격</td>
	<td><!--  어떻게가져오지,, --></td>
	</tr>
	
	<tr>
	<td>환불날짜</td>
	<td>${refund.refundDate }
	</tr>
	
	
</table>
<a href="RefundListView" >[이전 페이지로]</a>

</body>
</html>