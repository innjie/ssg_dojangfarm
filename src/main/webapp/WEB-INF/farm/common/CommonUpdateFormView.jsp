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
<title>공동구매 수정 폼</title>
</head>
<c:set var="targetUrI">
	<c:url value="/common/updateCommon.do" />
</c:set>

<body>
	<%@ include file="../IncludeTop.jsp"%>
	<div id="page">
		<div id="content">
			<div class="post">
				<form:form commandName="commonCommand" action="${targetUrI }"
					method="POST">
					<form:label path="title">제목</form:label>
					<form:input path="title" value="${common.title }" readonly="true" />
					<form:errors path="title" />
					<br>

					<form:label path="price">가격</form:label>
					<form:input path="price" value="${common.price }" />
					<form:errors path="price" />
					<br>

					<form:label path="info">설명</form:label>
					<form:input path="info" value="${common.info }" />
					<form:errors path="info" />
					<br>

					<form:label path="min">최소인원 </form:label>
					<form:input path="min" value="${common.min }" />
					<form:errors path="min" />
					<br>

					<form:label path="deadline">마감기한 </form:label>
					<form:input path="deadline" />
					<form:errors path="deadline" />
					<br>

					<form:hidden path="saleNo" value="${common.saleNo }" />
					<a href="<c:url value = '/common/userList.do' /> ">[이전으로]</a>
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