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
<title>배송 및 결제정보 보기</title>
</head>
<body>
<%@ include file="../IncludeTop.jsp" %>
<table border = "1">
<tr>
<td>배송번호</td>
<td>${delivery.dNo }</td>
</tr>

<tr>
<td>배송상태 </td>
<td>${delivery.status }</td>
</tr>

<tr>
<td>전화번호</td>
<td>${delivery.phone }</td>
</tr>

<tr>
<td>주소</td>
<td>${delivery.address.addr }</td>
</tr>

<tr>
<td>결제수단</td>
<td>${payment.method }</td>
</tr>

<tr>
<td>결제일</td>
<td>${payment.pDate }</td>
</tr>

<tr>
<td>결제금액</td>
<td>${payment.totalPrice }원</td>
</tr>
</table>
</body>
</html>