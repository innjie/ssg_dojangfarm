<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!--  commit test -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<link href="../templated-vegetable/style.css" rel="stylesheet"
	type="text/css" media="screen" />
<title>공동구매 참여 수정</title>
</head>
<body>
	<%@ include file="../IncludeTop.jsp"%>
	<div id="page">
		<div id="content">
			<div class="post">
				<h2>${common.title }신청 수정 폼</h2>
				<c:set var="targetUrI">
					<c:url value="/commonJoin/update.do" />
				</c:set>
				<form:form action='${targetUrI }' commandName="cjCommand"
					method="POST">
					<form:label path="common.saleNo">상품번호</form:label>
					<form:input path="common.saleNo" value="${common.saleNo }"
						readonly="true" />
					<form:errors path="common.saleNo" />
					<br>


					<form:label path="count">개수</form:label>
					<form:input path="count" />
					<form:errors path="count" />
					<br>

					<form:hidden path="cjNo" value="${commonJoin.cjNo }" />
					<input type="submit" value="추가" />
				</form:form>
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