<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="UTF-8">
<title>도장팜</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<link href="../templated-vegetable/style.css" rel="stylesheet"
	type="text/css" media="screen" />
</head>
<body>
	<%@ include file="../IncludeTop.jsp"%>
	<div id="page">
	<div id="content">
		<div class="post">
				<h2><font color="white" >메뉴</font></h2>
			<ul>
				<li><a href="<c:url value='/normal/list.do'/>">일반판매</a></li>
				<li><a href="<c:url value='/common/list.do'/> ">공동구매</a></li>
				<li><a href="<c:url value='/auction/viewAuctionList.do' />">경매</a></li>
				<li><a href="<c:url value='/commonNotice/list.do'/>">공동구매 공지</a></li>
			</ul>
			<div style = "clear : both;"> &nbsp;</div>
			</div>
		</div>
	<!-- end #sidebar -->
	<div style="clear: both;">&nbsp;</div>
</div>
<!-- end #page -->
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
<!-- end #footer -->
</body>
</html>