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
<title>공동구매 공지 리스트 보기</title>
</head>
<body>
	<%@ include file="../IncludeTop.jsp"%>
	<div id="page">
		<div id="content">
			<table border="1">
				<tr>
					<td>번호</td>
					<td>제목</td>
					<td>작성자</td>
				</tr>
				<c:forEach var="cn" items="${cnList.pageList}">
					<tr>
						<td><a
							href="<c:url value='/commonNotice/view.do'> 
						<c:param name='CNNO' value='${cn.CNNO}'/>
						</c:url>">${cn.CNNO}</a>
						</td>
						<td>${cn.title }</td>
						<td>${cn.user.name}</td>
					</tr>
				</c:forEach>
			</table>
			<c:if test="${!cnList.firstPage}">
				<a
					href='<c:url value="/commonNotice/list2.do">
        				<c:param name="page" value="previous"/>
        			</c:url>'>
					Prev</a>
			</c:if>
			<c:if test="${!cnList.lastPage}">
				<a
					href='<c:url value="/commonNotice/list2.do">
        				<c:param name="page" value="next"/>
        			</c:url>'>
					Next</a>
			</c:if>
			<br>
			<br> <a href="<c:url value='/commonNotice/insertForm.do'/>">
				등록</a> <br>
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