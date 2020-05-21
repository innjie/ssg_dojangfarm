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
<title>나의 주소록</title>
</head>
<body>
	<table border='1'>
		<tr>
			<td>이름</td>
			<td>${address.aName}</td>
		</tr>
		<tr>
			<td>우편번호</td>
			<td>${address.zipcode}</td>
		</tr>
		<tr>
			<td>주소</td>
			<td>${address.address}</td>
		</tr>
		<tr>
			<td>상세</td>
			<td>${address.detail}</td>
		</tr>
	</table>
	<br><br>
	<a href="<c:url value='/user/modifyAddress.do'>
				<c:param name='addrNo' value='${address.addrNo}' />
			</c:url>">
	수정</a>&nbsp;&nbsp;
	<a href="<c:url value='/user/deleteAddress.do'>
				<c:param name='addrNo' value='${address.addrNo}' />
			</c:url>">
	삭제</a>
</body>
</html>