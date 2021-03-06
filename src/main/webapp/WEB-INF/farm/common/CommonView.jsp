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
<title>공동구매 보기</title>
</head>
<body>
	<%@ include file="../IncludeTop.jsp"%>
	<div id="page">
		<div id="content">
			<div class="post">
				<b><c:out value="${message}" /></b>
				<table border="1">
					<tr>
						<td colspan="3">${common.title }</td>
					</tr>

					<tr>
						<td rowspan="5"><img src="../${common.image }" /></td>
					</tr>

					<tr>
						<td>가격</td>
						<td>${ common.price}</td>
					</tr>

					<tr>
						<td>최소인원</td>
						<td>${common.min }</td>
					</tr>

					<tr>
						<td>마감일시</td>
						<td>${common.deadline }</td>
					</tr>
					<tr>
						<td>상태</td>
						<td>${common.saleState }</td>
					</tr>
					<tr>
						<td colspan="4">${common.info }</td>
					</tr>
				</table>

				<c:if test="${ (loginUser.userNo == common.user.userNo)}">
					<c:if test="${(common.saleState == 'OPEN') }">
						<a
							href="<c:url value ='/common/updateCommon.do' > 
		<c:param name = 'saleNo'  value = '${common.saleNo}'/>
		</c:url> ">수정하기</a>
						<br>
						<a
							href="<c:url value ='/common/payCommon.do' > 
		<c:param name = 'saleNo'  value = '${common.saleNo}'/>
		</c:url> ">공동구매
							진행하기</a>
						<br>
					</c:if>
					<a
						href="<c:url value = '/commonJoin/viewList.do'><c:param name = 'saleNo' value = '${common.saleNo }'/>
		</c:url>">
						신청자 목록보기</a>
					<br>
				</c:if>

				<br>
				<br>
				<c:if test="${(loginUser.userNo != common.user.userNo) }">
					<a
						href="<c:url value = '/commonjoin/join.do'><c:param name = 'saleNo' value = '${common.saleNo }'/>
	</c:url> ">신청</a>
				</c:if>
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