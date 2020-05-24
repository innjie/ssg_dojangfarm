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
	<form action="<c:url value="/normal/answerQnA.do"/>" method="post">
		<table border='1'>
			<tr>
				<td>작성자</td>
				<td>${qna.user.id}</td>
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
					<textarea name="answer" rows="100" cols="100"></textarea>
				</td>
			</tr>
		</table>
		<br><br>
		<input type="hidden" name="saleNo" value="${qna.normal.saleNo}">
		<input type="hidden" name="qNo" value="${qna.qNo}">
		<input type="submit" value="질문하기">
	</form>
</body>
</html>