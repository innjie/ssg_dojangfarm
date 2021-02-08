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
<title>입찰</title>
</head>
<body>
	<%@ include file="../IncludeTop.jsp" %>
<div id="page">
		<div id="content">
		<div class = "post">
	<form action='<c:url value="/auction/viewMyBidList.do"/>'>
		제목  ${bid.auction.title}<br>	
		품목  ${bid.auction.product.pName}<br>	
		최소 가격   ${bid.auction.minPrice}<br>
		현재 입찰 가격  ${bid.auction.bidPrice}<br>
		기간  ${bid.auction.sDeadline}<br>
		가격  ${bid.bidPrice}<br>
		우편번호  ${bid.address.zip}<br>
		주소  ${bid.address.addr}<br>
		상세주소 ${bid.address.detail}<br>
		카드  ${bid.card.cardNo}<br>
		
		<input type="submit" value="확인" />&nbsp;&nbsp;
	</form>
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