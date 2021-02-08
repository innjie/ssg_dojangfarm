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
<title>공동구매 신청자 리스트</title>
</head>
<body>
	<%@ include file="../IncludeTop.jsp"%>
	<div id="page">
		<div id="content">
			<div class="post">
				<table border="1">
					<tr>
						<td>번호</td>
						<td>신청자</td>
						<td>연락처</td>
						<td>개수</td>
						<td>주소</td>
					</tr>

					<c:forEach var="commonJoin" items="${cjList.pageList }">
						<tr>
							<td><a
								href="<c:url value = '/commonJoin/view.do'>
<c:param name = 'cjNo' value = '${commonJoin.cjNo }'/>
</c:url>">
									${commonJoin.cjNo }</a></td>
							<td>${commonJoin.user.name }</td>
							<td>${commonJoin.delivery.phone }</td>
							<td>${commonJoin.count }</td>
							<td>${commonJoin.delivery.address.addr }</td>

						</tr>
					</c:forEach>
					<c:if test="${!cjList.firstPage}">
						<a
							href='<c:url value="/commonJoin/viewList2.do">
        				<c:param name="page" value="previous"/>
        			</c:url>'>
							Prev</a>
					</c:if>
					<c:if test="${!cjList.lastPage}">
						<a
							href='<c:url value="/commonJoin/viewList2.do">
        				<c:param name="page" value="next"/>
        			</c:url>'>
							Next</a>
					</c:if>
				</table>
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