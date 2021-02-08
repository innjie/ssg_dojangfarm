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
<title>배송 현황</title>
</head>
<body>
	<%@ include file="../IncludeTop.jsp"%>
	<div id="page">
		<div id="content">
			<div class="post">
<table border = "1">
<tr>
<td>배송번호</td>
<td>전화번호</td>
<td>주소등록번호</td>
<td>배송상태</td>
</tr>

<c:forEach var = "delivery" items = "${dList.pageList }">
<tr>
<td><a href = "<c:url value = '/delivery/view.do'>
	<c:param name = 'dNo' value = '${delivery.dNo }'/> </c:url> "> ${delivery.dNo} </a></td>
<td>${delivery.phone }</td>
<td>${delivery.address.addrNo }</td>
<td>${delivery.status }</td>
</tr>
</c:forEach>
</table>
<c:if test="${!dList.firstPage}">
    		<a href='<c:url value="/delivery/list2.do">
        				<c:param name="page" value="previous"/>
        			</c:url>'>
        	Prev</a>
    	</c:if> 
    	<c:if test="${!dList.lastPage}">
    		<a href='<c:url value="/delivery/list2.do">
        				<c:param name="page" value="next"/>
        			</c:url>'>
        	Next</a>
    	</c:if>
<a href="<c:url value = '/index.do'/>">[메인으로]</a>
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