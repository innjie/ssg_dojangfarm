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
<title>카드 추가</title>
</head>
<body>
	<%@ include file="../IncludeTop.jsp" %>
<div id="page">
		<div id="content">
		<div class = "post">
	<form:form commandName="cardCommand">
		<form:label path="bank">은행</form:label>
		<form:input path="bank" />
		<form:errors path="bank" />
		<br><br>
		
		<form:label path="type">종류</form:label>
		<form:select path="type" items="${types}"/>
		<form:errors path="type" />
		<br><br>
		
		<form:label path="cardPayNo">카드번호</form:label>
		<form:input path="cardPayNo" />
		<form:errors path="cardPayNo" />
		<br><br>
		
		<form:label path="period">유효기간</form:label>
		<form:input path="period" />
		<form:errors path="period" />
		<br>*유효기간은 YYYY-MM-DD 포맷으로 입력해주세요
		<br><br>
		
		<form:label path="cvc">cvc</form:label>
		<form:input path="cvc" />
		<form:errors path="cvc" />
		<br><br>
		
		<form:label path="cardPW">비밀번호 </form:label>
		<form:password path="cardPW" />
		<form:errors path="cardPW" />
		<br><br>
		
	
		<input type="submit" value="추가" />&nbsp;&nbsp;
		<a href="<c:url value='/card/viewCardList.do' />">이전</a>
		
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