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
<title>일반판매 수정 폼</title>
</head>
<body>
	<%@ include file="../IncludeTop.jsp" %>
<div id="page">
		<div id="content">
		<div class = "post">
<c:set var="targetUrI">
		<c:url value="/normal/updateNormal.do" />
	</c:set>
		<form:form action="${targetUrI}" commandName="normal" method = "POST">
		<form:label path="title" >제목</form:label>
		<form:input path="title"  value="${normal.title }" readonly = "true"/>
		<form:errors path="title" />
		<br>

		<form:label path="price">가격</form:label>
		<form:input path="price"  value="${normal.price}" />
		<form:errors path="price" />
		<br>
		
		<form:label path="count">개수</form:label>
		<form:input path="count"/>
		<form:errors path="count"/>
		<br>

		<form:label path="product.pName">품목 </form:label>
		<form:input path="product.pName"  value = "${normal.product.pName }" disabled = "true"/>
		<form:errors path="product.pName" />
		<br>

		<form:label path="info">설명</form:label>
		<form:input path="info" value="${normal.info}" />
		<form:errors path="info" />
		<br>
		
		<form:label path = "regidDate">판매 마감 기한 </form:label>
		<form:input path = "regidDate"/>
		<form:errors path = "regidDate"/>
		<br>
		
		<form:hidden path = "saleNo" value = "${normal.saleNo }"/>
		<input type="submit" value="수정" />


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