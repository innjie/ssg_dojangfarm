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
<title>공동구매 공지 보기</title>
</head>
<body>
	<table>
		<tr>
			<td>${commonNotice.title}</td>
			<td>${commonNotice.user.name}</td>
		</tr>

		<tr colspan="2">
			<td>${commonNotice.info }</td>
		</tr>
	</table>
	<a href="CommonNoticeListView">[이전 단계로]</a> 
	<c:if test ="${(session.id == commonNotice.user.id)} ">
		<a href='<c:url value="/commonNotice/delete.do">
					<c:param name="CNNo" value="${commonNotice.CNNo}"/>
					</c:url>'>
		삭제</a>
		
	</c:if>
</body>
</html>