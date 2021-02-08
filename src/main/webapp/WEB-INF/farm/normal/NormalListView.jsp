<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<meta charset="UTF-8">
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<link href="../templated-vegetable/style.css" rel="stylesheet"
	type="text/css" media="screen" />
<title>일반판매 전체보기</title>
</head>
<body>
<%@ include file="../IncludeTop.jsp" %>
	<div id="page">
		<div id="content">
		<div class = "post">
	<form action="<c:url value = '/normal/searchNormal.do'/>">
		<input type="text" name="word"> &nbsp; <input type="submit"
			value="검색">
	</form>
	<br>
	<br>

	<!--  category -->
	<c:forEach var="category" items="${categoryList }">
		<a
			href="<c:url value='/normal/cateList.do'> 
				<c:param name = 'cateNo' value = '${category.cateNo}'/></c:url>">${category.kind }</a>&nbsp;&nbsp;
</c:forEach>
	<!--  normal List  -->
	<table border="1">
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>작성자</td>
		</tr>
		<c:forEach var="normal" items="${normalList.pageList}"
			varStatus="status">
			<c:if test = "${(normal.saleState != 'CLOSE') }" >
			<tr>
				<td><a
					href="<c:url value='/normal/viewNormal.do'> 
						<c:param name='saleNo' value='${normal.saleNo}'/>
						</c:url>">${normal.saleNo}</a></td>
				<td>${normal.title}</td>
				<td>${normal.user.name}</td>
			</tr>
			</c:if>
		</c:forEach>

	</table>
	<c:if test="${search == null }">
		<c:if test="${!normalList.firstPage}">
			<a
				href='<c:url value="/normal/list2.do">
        				<c:param name="page" value="previous"/>
        			</c:url>'>
				Prev</a>
		</c:if>
		<c:if test="${!normalList.lastPage}">
			<a
				href='<c:url value="/normal/list2.do">
        				<c:param name="page" value="next"/>
        			</c:url>'>
				Next</a>
		</c:if>
	</c:if>
	<c:if test="${search != null }">
		<c:if test="${!normalList.firstPage}">
			<a
				href='<c:url value="/normal/lsearchNormal2.do">
        				<c:param name="page" value="previous"/>
        			</c:url>'>
				Prev</a>
		</c:if>
		<c:if test="${!normalList.lastPage}">
			<a
				href='<c:url value="/normal/lsearchNormal2.do">
        				<c:param name="page" value="next"/>
        			</c:url>'>
				Next</a>
		</c:if>
	</c:if>

	<br>
	<a href="<c:url value='/normal/insertNormal.do'/>"> 등록</a>
	<br>
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