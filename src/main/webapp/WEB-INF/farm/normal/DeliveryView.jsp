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
<title>배송 및 결제정보 보기</title>
</head>
<body>
	<%@ include file="../IncludeTop.jsp"%>
	<div id="page">
		<div id="content">
			<div class="post">
				<table border="1">
					<tr>
						<td>배송번호</td>
						<td>${delivery.dNo }</td>
					</tr>

					<tr>
						<td>배송상태</td>
						<td>${delivery.status }</td>
					</tr>

					<tr>
						<td>전화번호</td>
						<td>${delivery.phone }</td>
					</tr>

					<tr>
						<td>주소</td>
						<td>${delivery.address.addr }</td>
					</tr>

					<tr>
						<td>결제수단</td>
						<td>${payment.method }</td>
					</tr>

					<tr>
						<td>결제일</td>
						<td>${payment.pDate }</td>
					</tr>

					<tr>
						<td>결제금액</td>
						<td>${payment.totalPrice }원</td>
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
		<p>
			&copy; Untitled. All rights reserved. Design by <a
				href="http://templated.co" rel="nofollow">TEMPLATED</a>.
		</p>
	</div>
</body>
</html>