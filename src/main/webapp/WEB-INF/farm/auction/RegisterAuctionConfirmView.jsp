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
<title>경매 등록</title>
</head>
<body>
	<c:set var="targetUrl"><c:url value="/auction/registerAuction.do" /></c:set>
	
	<form:form modelAttribute="auctionCommand" method="post" action="${targetUrl}">
		<ul>
			<li>제목 ${auctionCommand.title}</li>	
			<li>품목 ${auctionCommand.product.pName}</li>	
			<li>사진 
				<c:if test="${not empty image}">
					<img src="<c:url value='../${auctionCommand.image}' />" /> 
				</c:if>
			</li>
			<li>상세 정보 ${auctionCommand.detail}</li>		
			<li>최소 가격 ${auctionCommand.minPrice}</li>		
			<li>기간 ${auctionCommand.deadline}</li>
			<li>즉시구매 가능 여부 ${auctionCommand.imPurAva}</li>		
			<li>즉시구매 가격 ${auctionCommand.imPurPrice}</li>
		</ul>
		<input type="submit" value="추가" />
		
	</form:form>
</body>
</html>