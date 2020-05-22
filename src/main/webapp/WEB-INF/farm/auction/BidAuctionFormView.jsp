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
	<form:form modelAttribute="bid" action='<c:url value="/auction/registerAuction.do"/>'>
		<form:label path="auction.title">제목 </form:label>
		${bid.auction.title}
		<br>
		
		<form:label path="product.pName">품목 </form:label>
		${bid.auction.product.pName}
		<br>
		
		<form:label path="auction.bidPrice">최소 가격 </form:label>
		${bid.auction.minPrice}
		<br>
		
		<form:label path="auction.bidPrice">현재 입찰 가격 </form:label>
		${bid.auction.bidPrice}
		<br>
		
		<form:label path="deadline">기간 </form:label>
		${bid.auction.deadline}
		<br>
		
		<form:label path="bidPrice">입찰 가격 </form:label>
		<form:checkbox path="bidPrice" />
		<form:errors path="bidPrice" />
		<br>
		
		<input type="submit" value="추가" />
		
	</form:form>
</body>
</html>