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
<!--  환불한 내역 보는 페이지 -->
<title>환불정보 상세보기</title>
</head>
<body>
<%@ include file="../IncludeTop.jsp" %>
<div id="page">
		<div id="content">
		<div class = "post">
<h2>환불목록 상세보기</h2>
<table border="1" >
	<tr>
	<td>계좌</td>
	<td>${refund.account}</td>
	</tr>
	
	<tr>
	<td>은행</td>
	<td>${refund.bank }</td>
	<tr>
	
	<td>물품명</td>
	<td>${refund.order.title }</td>
	</tr>
	
	<tr>
	<td>가격</td>
	<td>${refund.order.price }</td>
	</tr>
	
	<tr>
	<td>환불날짜</td>
	<td>${refund.refundDate }
	</tr>
	
	
</table>

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