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
<title>나의 즉시구매</title>
</head>
<body>
	<%@ include file="../IncludeTop.jsp" %>
<div id="page">
		<div id="content">
		<div class = "post">
	<table border='1'>
		<tr>
			<td>경매</td>
			<td>
				<a href="<c:url value='/auction/viewAuction.do'>
							<c:param name='aNo' value='${imPur.auction.aNo}' />
						</c:url>">
				${imPur.auction.title}</a>
			</td>
		</tr>
		<tr>
			<td>즉시구매 가격</td>
			<td>${imPur.auction.imPurPrice}</td>
		</tr>
	</table>
	<br><br>
	결제
	<table border='1'>
		<c:if test="${imPur.payment.method == '카드'}">
			<tr>
				<td>결제방법</td>
				<td>카드</td>
				<td>결제일</td>
				<td>결제금액</td>
			</tr>
			<tr>
				<td>${imPur.payment.method}</td>
				<td>
					<a href="<c:url value='/card/viewCard.do'> 
								<c:param name='cardNo' value='${imPur.payment.card.cardNo}' />
							</c:url>">
					${imPur.payment.card.cardPayNo}</a>
				</td>
				<td>${pDate}</td>
				<td>${imPur.payment.totalPrice}</td>
			</tr>
		</c:if>
		<c:if test="${imPur.payment.method == '카카오페이'}">
			<tr>
				<td>결제방법</td>
				<td>결제일</td>
				<td>결제금액</td>
			</tr>
			<tr>
				<td>${imPur.payment.method}</td>
				<td>${pDate}</td>
				<td>${imPur.payment.totalPrice}</td>
			</tr>
		</c:if>
	</table>
	<br><br>
	배송
	<table border='1'>
		<tr>
			<td>주소</td>
			<td>전화번호</td>
			<td>상태</td>
		</tr>
		<tr>
			<td>
				<a href="<c:url value='/address/getAddress.do'>
							<c:param name='addrNo' value='${imPur.delivery.address.addrNo}' />
						</c:url>">
				${imPur.delivery.address.addr}</a>
			</td>
			<td>${imPur.delivery.phone}</td>
			<td>${imPur.delivery.status}</td>
		</tr>
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
	<p>&copy; Untitled. All rights reserved. Design by <a href="http://templated.co" rel="nofollow">TEMPLATED</a>.</p>
</div>
</body>
</html>