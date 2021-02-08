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
<title>나의 카드</title>
</head>
<body>
	<%@ include file="../IncludeTop.jsp"%>
	<div id="page">
		<div id="content">
			<div class="post">
				<table border='1'>
					<tr>
						<td>은행</td>
						<td>${card.bank}</td>
					</tr>
					<tr>
						<td>종류</td>
						<td>${card.type}</td>
					</tr>
					<tr>
						<td>카드번호</td>
						<td>${card.cardPayNo}</td>
					</tr>
					<tr>
						<td>유효기간</td>
						<td>${period}</td>
					</tr>
					<tr>
						<td>cvc</td>
						<td>${card.cvc}</td>
					</tr>
				</table>
				<br>
				<br> <a
					href="<c:url value='/card/deleteCard.do'>
				<c:param name='cardNo' value='${card.cardNo}' />
			</c:url>">
					삭제</a>&nbsp;&nbsp;
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