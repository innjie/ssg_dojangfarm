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
	<form action='<c:url value="/auction/viewMyImPurList.do"/>'>
		제목  ${imPur.auction.title}<br>	
		품목  ${imPur.auction.product.pName}<br>	
		가격   ${imPur.auction.imPurPrice}<br>
		우편번호  ${imPur.delivery.address.zip}<br>
		주소  ${imPur.delivery.address.addr}<br>
		상세주소 ${imPur.delivery.address.detail}<br>
		카드  ${imPur.payment.card.cardNo}<br>
		
		<input type="submit" value="확인" />&nbsp;&nbsp;
	</form>
</body>
</html>