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
<title>환불 정보 입력</title>
</head>
<body>
<%@ include file="../IncludeTop.jsp" %>
<div id="page">
		<div id="content">
		<div class = "post">
<c:set var="targetUrI">
		<c:url value="/order/cancel.do" />
	</c:set>
	<form:form action="${targetUrI}" commandName="refundCommand" method = "POST">
		
		<form:label path="order.orderNo" ></form:label>
		<form:input path="order.orderNo" value = "${order.orderNo }" readonly = "true"/>
		
		<br>
		
		<form:label path="bank">은행</form:label>
		<form:input path="bank" />
		<form:errors path="bank" />
		<br>
		
		<form:label path="account">계좌</form:label>
		<form:input path="account"/>
		<form:errors path="account"/>
		<br>

		<form:label path="name">이름 </form:label>
		<form:input path = "name"/>
		<form:errors path="name" />
		<br>

		<form:label path="refundType">환불종류</form:label>
		<form:input path="refundType"  value = "계좌"  readonly = "true"/>
		
		<br>
		

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
	<p>&copy; Untitled. All rights reserved. Design by <a href="http://templated.co" rel="nofollow">TEMPLATED</a>.</p>
</div>
</body>
</html>