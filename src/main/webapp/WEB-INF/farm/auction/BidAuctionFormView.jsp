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
<title>입찰</title>
</head>
<body>
	<form action='<c:url value="/auction/bidAuction.do"/>' method="POST">
		제목  ${auction.title}<br>	
		품목  ${auction.product.pName}<br>	
		최소 가격   ${auction.minPrice}<br>
		현재 입찰 가격  ${auction.bidPrice}<br>
		기간  ${auction.deadline}<br>
		가격&nbsp;&nbsp;
		<input type="text" name="bidPrice" />
		<br>
		
		<input type="hidden" name="aNo" value="${auction.aNo}" />
		<input type="submit" value="추가" />
		
	</form>
</body>
</html>