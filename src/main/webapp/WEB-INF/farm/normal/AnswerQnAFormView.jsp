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
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<link href="templated-vegetable/style.css" rel="stylesheet"
	type="text/css" media="screen" />
<title>답변하기</title>
</head>
<body>
<%@ include file="../IncludeTop.jsp" %>
<div id="page">
		<div id="content">
		<div class = "post">
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
		</div>
	</div>
	<div style="clear: both;">&nbsp;</div>
	</div>
	<div id="footer-menu">
	<ul>
		<li class="current_page_item"><a href="#">Homepage</a></li>
		<li><a href="#">Blog</a></li>
		<li><a href="#">Photos</a></li>
		<li><a href="#">About</a></li>
		<li><a href="#">Contact</a></li>
	</ul>
</div>
<div id="footer">
	<p>&copy; Untitled. All rights reserved. Design by <a href="http://templated.co" rel="nofollow">TEMPLATED</a>.</p>
</div>
</body>
</html>