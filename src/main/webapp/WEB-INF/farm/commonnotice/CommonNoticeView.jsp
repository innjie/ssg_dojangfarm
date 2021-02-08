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
<link href="../templated-vegetable/style.css" rel="stylesheet"
	type="text/css" media="screen" />
<title>공동구매 공지 보기</title>
</head>
<body>
	<%@ include file="../IncludeTop.jsp"%>
	<div id="page">
		<div id="content">
			<div class="post">
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
					<a
						href='<c:url value="/commonNotice/delete.do">
					<c:param name="CNNO" value="${commonNotice.CNNO}"/>
					</c:url>'>
						삭제</a>
				</c:if>

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
		<p>
			&copy; Untitled. All rights reserved. Design by <a
				href="http://templated.co" rel="nofollow">TEMPLATED</a>.
		</p>
	</div>
</body>
</html>