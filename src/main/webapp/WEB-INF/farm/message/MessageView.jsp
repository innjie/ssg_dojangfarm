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
<title>메세지 보기</title>
</head>
<body>
	<%@ include file="../IncludeTop.jsp" %>

	<table border='1'>
		<c:if test="${message.sUser.id != user.id}">
			<tr>
				<td>보낸사람</td>
				<td>${message.sUser.id}</td>
			</tr>
		</c:if>
		<c:if test="${message.rUser.id != user.id}">
			<tr>
				<td>받는사람</td>
				<td>${message.rUser.id}</td>
			</tr>
		</c:if>
		<tr>
			<td>관련 상품</td>
			<td>
				<a href="<c:url value='/normal/viewNormal.do'>
							<c:param name="saleNo" value="${message.normal.saleNo}"/>
						</c:url>">
					${message.normal.saleNo}</a>
			</td>
		</tr>
		<c:if test="${message.rUser.id != user.id}">
			<tr>
				<td>읽음</td>
				<td>${message.read}</td>
			</tr>
		</c:if>
		<tr>
			<td>제목</td>
			<td>${message.title}</td>
		</tr>
		<tr>
			<td>내용</td>
			<td>
				${message.content}
				<c:if test="${message.cMsg != null}">
					<br><br>
					re: ${message.cMsg.content}
				</c:if>
			</td>
		</tr>
		<tr>
			<td>보낸날짜</td>
			<td>${message.sDate}</td>
		</tr>
	</table>
	<br><br>
	<c:if test="${message.sUser.id != user.id}">
		<a href="<c:url value='/message/sendMsg.do'>
					<c:param name='msgNo' value='${message.msgNo}' />
				</c:url>">
		답장</a>&nbsp;&nbsp;
	</c:if>
	
	<a href="<c:url value='/message/deleteMsg.do'>
				<c:param name='msgNo' value='${message.msgNo}' />
				<c:param name='type' value='${param.type}' />
			</c:url>">
	삭제</a>
	
</body>
</html>