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
<title>나의 낙찰</title>
</head>
<body>
	<%@ include file="../IncludeTop.jsp" %>

	<table border="1">
		<tr>
			<td>순번</td>
			<td>낙찰 번호</td>
			<td>경매</td>
			<td>입찰 가격</td>
			<td>지불상태</td>
		</tr>
		<c:forEach var="sBid" items="${sBidList.pageList}" varStatus="status">
			<tr>
				<td>${status.count}</td>
				<td>
					<a href="<c:url value='/auction/viewMySBid.do'>
								<c:param name='sBidNo' value='${sBid.sBidNo}' />
							</c:url>">
					${sBid.sBidNo}</a>
				</td>
				<td>
					<a href="<c:url value='/auction/viewAuction.do'>
								<c:param name='aNo' value='${sBid.bid.auction.aNo}' />
							</c:url>">
					${sBid.bid.auction.title}</a>
				</td>
				<td>${sBid.bid.bidPrice}</td>
				<td>${sBid.payState}</td>		
				<c:if test="${sBid.payState == '결제예정'}"	>
					<a href="<c:url value='/delivery/addDelivery.do'>
								<%-- <c:param name="sBidNo" value="${sBid.sBidNo}"/> --%>
							</c:url>">
					결제</</a>
				</c:if>				
			</tr>
		</c:forEach>
	</table>
	<br><br>
	<c:if test="${!sBidList.firstPage}">
    	<a href='<c:url value="/auction/viewMySBidList2.do">
        			<c:param name="page" value="previous"/>
        		</c:url>'>
        Prev</a>
    </c:if> 
    <c:if test="${!sBidList.lastPage}">
    	<a href='<c:url value="/auction/viewMySBidList2.do">
        			<c:param name="page" value="next"/>
        		</c:url>'>
        Next</a>
    </c:if>
</body>
</html>