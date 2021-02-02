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
	<form action='<c:url value="/auction/viewMyBidList.do"/>'>
		제목  ${bid.auction.title}<br>	
		품목  ${bid.auction.product.pName}<br>	
		최소 가격   ${bid.auction.minPrice}<br>
		현재 입찰 가격  ${bid.auction.bidPrice}<br>
		기간  ${bid.auction.sDeadline}<br>
		가격  ${bid.bidPrice}<br>
		주소  ${bid.address.addrNo}<br>
		카드  ${bid.card.cardNo}<br>
		
		<input type="submit" value="확인" />&nbsp;&nbsp;
	</form>
</body>
</html>