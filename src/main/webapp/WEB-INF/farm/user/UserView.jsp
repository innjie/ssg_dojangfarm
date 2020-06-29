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
<title>나의 정보</title>
</head>
<body>
	<%@ include file="../IncludeTop.jsp" %>
	<table border='1'>
		<tr>
			<td>id</td>
			<td>${user.id}</td>
		</tr>
		<tr>
			<td>이름</td>
			<td>${user.name}</td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td>${user.phone}</td>
		</tr>
		<tr>
			<td>포인트</td>
			<td>${user.point}</td>
		</tr>
	</table>
	<br><br>
	<a href='<c:url value="/user/modifyUser.do" />'>수정</a>&nbsp;&nbsp;
	<a href='<c:url value="/user/checkPW.do" />'>탈퇴</a>&nbsp;&nbsp;
	
</body>
</html>