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
<title>registrationConfirm</title>
</head>
<body>
	다음 정보로 등록하시겠습니까?
	<form:form modelAttribute="auctionCommand" action="registerAuctionConfirm.do">
		<ul>
			<li>제목: ${auctionCommand.title}</li>
			<li>품목: ${auctionCommand.product.pName}</li>
			<li>상세 정보: ${auctionCommand.detail}</li>
			<li>최소 가격: ${auctionCommand.minPrice}
			<li>기간: ${auctionCommand.deadline}</li>
			<li>즉시구매 가능여부: ${auctionCommand.imPurAva}</li>
			<c:if test="${auctionCommand.imPurAva==true}">
				<li>즉시구매 가격: ${auctionCommand.imPurPrice}</li>
			</c:if>
		</ul> 	
		<br><br>
		
		<input type="submit" value="확인" />
	</form:form>
</body>
</html>