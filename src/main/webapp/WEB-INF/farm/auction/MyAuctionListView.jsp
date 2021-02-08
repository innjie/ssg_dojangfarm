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
<title>나의 경매</title>
</head>
<body>
	<%@ include file="../IncludeTop.jsp"%>
	<div id="page">
		<div id="content">
			<div class="post">
				<table border="1">
					<tr>
						<td>순번</td>
						<td>제목</td>
						<td>최소 가격</td>
						<td>입찰 가격</td>
						<td>즉시구매 가격</td>
						<td>기간</td>
						<td>종료</td>
					</tr>
					<c:forEach var="auc" items="${auctionList.pageList}"
						varStatus="status">
						<tr>
							<td>${status.count}</td>
							<td><a
								href="<c:url value='/auction/viewAuction.do'>
								<c:param name='aNo' value='${auc.aNo}' />
								<c:param name='my' value='my' />
							</c:url>">
									${auc.title}</a></td>
							<td>${auc.minPrice}</td>
							<td>${auc.bidPrice}</td>
							<td>${auc.imPurPrice}</td>
							<td>${auc.sDeadline}</td>
							<td>${auc.finish}</td>
						</tr>
					</c:forEach>
				</table>
				<br>
				<br>
				<c:if test="${!auctionList.firstPage}">
					<a
						href='<c:url value="/auction/viewMyAuctionList2.do">
        			<c:param name="page" value="previous"/>
        		</c:url>'>
						Prev</a>
				</c:if>
				<c:if test="${!auctionList.lastPage}">
					<a
						href='<c:url value="/auction/viewMyAuctionList2.do">
        			<c:param name="page" value="next"/>
        		</c:url>'>
						Next</a>
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