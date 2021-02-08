<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<meta charset="UTF-8">
<title>나의 정보</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<link href="../templated-vegetable/style.css" rel="stylesheet"
	type="text/css" media="screen" />
</head>
<body>
	<%@ include file="../IncludeTop.jsp" %>
	<div id="page">
		<div id="content">
		<div class = "post">
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