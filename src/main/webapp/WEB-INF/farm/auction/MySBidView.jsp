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
	<table border='1'>
		<tr>
			<td>경매</td>
			<td>
				<a href="<c:url value='/auction/viewAuction.do'>
							<c:param name='aNo' value='${sBid.bid.auction.aNo}' />
						</c:url>">
				${sBid.bid.auction.title}</a>
			</td>
		</tr>
		<tr>
			<td>입찰 가격</td>
			<td>${sBid.bid.bidPrice}</td>
		</tr>
		<tr>
			<td>지불상태</td>
			<td>${sBid.payState}</td>
			<c:if test="${sBid.payState == '결제예정'}"	>
				<td>
					<a href="<c:url value='/delivery/addDelivery.do'>
								<%-- <c:param name="sBidNo" value="${sBid.sBidNo}"/> --%>
							</c:url>">
					결제</</a>
				</td>
			</c:if>		
		</tr>
	</table>
	<br><br>
	<table border='1'>
		<tr>
			<td>배송</td>
			
		</tr>
		<tr>
			
		</tr>
	</table>
	<br><br>
	<table border='1'>
		<tr>
			<td>결제</td>
			
		</tr>
		<tr>
			
		</tr>
	</table>
</body>
</html>