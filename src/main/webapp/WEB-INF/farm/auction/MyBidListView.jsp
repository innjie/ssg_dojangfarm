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
<title>나의 입찰</title>
</head>
<body>
	<%@ include file="../IncludeTop.jsp" %>

	<table border="1">
		<tr>
			<td>순번</td>
			<td>경매</td>
			<td>입찰 가격</td>
			<td>남은시간</td>
			<td>주소</td>
			<td>카드</td>
			<td>상태</td>
		</tr>
		<c:forEach var="bid" items="${bidList.pageList}" varStatus="status">
			<tr>
				<td>${status.count}</td>
				<td>
					<a href="<c:url value='/auction/viewAuction.do'>
								<c:param name='aNo' value='${bid.auction.aNo}' />
							</c:url>">
					${bid.auction.title}</a>
				</td>
				<td>${bid.bidPrice}</td>
				<td>${bid.auction.deadline}</td>
				<td>
					<a href="<c:url value='/address/getAddress.do'>
								<c:param name='addrNo' value='${bid.address.addrNo}' />
							</c:url>">
					${bid.address.addrNo}</a>
				</td>
				<td>
					<a href="<c:url value='/card/viewCard.do'>
								<c:param name='cardNo' value='${bid.card.cardNo}' />
							</c:url>">
					${bid.card.cardNo}</a>
				</td>
				<td>${bid.state}</td>		
				<c:if test="${(bid.state == '실패') && (bid.auction.deadline < SYSDATE)}"	>
					<a href="<c:url value='/auction/bidAuction.do'>
								<c:param name="aNo" value="${bid.auction.aNo}"/>
							</c:url>">
					재입찰</</a>
				</c:if>				
			</tr>
		</c:forEach>
	</table>
	<br><br>
	<c:if test="${!bidList.firstPage}">
    	<a href='<c:url value="/auction/viewMyBidList2.do">
        			<c:param name="page" value="previous"/>
        		</c:url>'>
        Prev</a>
    </c:if> 
    <c:if test="${!bidList.lastPage}">
    	<a href='<c:url value="/auction/viewMyBidList2.do">
        			<c:param name="page" value="next"/>
        		</c:url>'>
        Next</a>
    </c:if>
</body>
</html>