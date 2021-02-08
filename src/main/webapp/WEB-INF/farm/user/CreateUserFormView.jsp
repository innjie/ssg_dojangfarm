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
<title>회원 가입</title>
</head>
<body>
<%@ include file="../IncludeTop.jsp" %>
<div id="page">
		<div id="content">
		<div class = "post">
	<h1><a href="<c:url value='/' />">도장팜</a> 회원가입</h1>
	<form:form modelAttribute="userCommand" >
		<form:label path="id">ID</form:label>
		<form:input path="id" />
		<form:errors path="id" />
		<br><br>
		
		<form:label path="name">이름 </form:label>
		<form:input path="name" />
		<form:errors path="name" />
		<br><br>
		
		<form:label path="password">암호 </form:label>
		<form:password path="password" />
		<form:errors path="password" />
		<br><br>
		
		<form:label path="confirmPassword">암호 학인 </form:label>
		<form:password path="confirmPassword" />
		<form:errors path="confirmPassword" />
		<br><br>
		
		<form:label path="phone">전화번호 </form:label>
		<form:input path="phone" />
		<form:errors path="phone" />
		<br><br>
		
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