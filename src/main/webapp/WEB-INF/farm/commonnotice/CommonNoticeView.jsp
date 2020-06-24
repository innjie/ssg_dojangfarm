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
	<table border="1px">
		<tr>
			<td>공지번호</td>
			<td>${cn.CNNO }</td>
		</tr>
		<tr>
			<td>제목</td>
			<td>${cn.title}</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td>${cn.user.name}</td>
		</tr>
		<td colspan="2">${cn.info }</td>
		</tr>
	</table>

	<c:if test="${(loginUser.userNo == cn.user.userNo) }">
		<a
			href="<c:url value = '/commonNotice/update.do'>
	<c:param name = 'CNNO'  value = '${cn.CNNO }'/></c:url>">수정하기</a>
		<br>
	</c:if>
	<a href="<c:url value = '/commonNotice/list.do'/>">[이전 단계로]</a>
	<c:if test="${(session.id == commonNotice.user.id)} ">
		<a
			href='<c:url value="/commonNotice/delete.do">
					<c:param name="CNNo" value="${commonNotice.CNNo}"/>
					</c:url>'>
			삭제</a>

	</c:if>
</body>
</html>