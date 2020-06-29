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
<title>답변하기</title>
</head>
<body>
<%@ include file="../IncludeTop.jsp" %>
	<form action="<c:url value="/normal/answerQnA.do"/>" method="post">
		<table border='1'>
			<tr>
				<td>작성자</td>
				<td>${qna.qUser.id}</td>
			</tr>
			<tr>
				<td>작성일</td>
				<td>${qna.qDate}</td>
			</tr>
			<tr>
				<td>질문</td>
				<td>${qna.question}</td>
			</tr>
			<tr>
				<td>답변</td>
				<td>
					<textarea name="answer" ></textarea>
				</td>
			</tr>
		</table>
		<br><br>
		<input type="hidden" name="saleNo" value="${qna.normal.saleNo}">
		<input type="hidden" name="qNo" value="${qna.qNo}">
		<c:if test="${param.message != null}">
			${param.message}<br><br>
		</c:if>
		<input type="submit" value="답변하기">&nbsp;&nbsp;
		<a href="<c:url value='/normal/viewQnAList.do'>
					<c:param name="saleNo" value="${qna.normal.saleNo}" />
				</c:url>">
		이전</a>
	</form>
</body>
</html>