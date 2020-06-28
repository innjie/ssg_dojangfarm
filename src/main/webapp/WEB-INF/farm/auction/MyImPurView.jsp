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
<title>나의 즉시구매</title>
</head>
<body>
	<%@ include file="../IncludeTop.jsp" %>

	<table border='1'>
		<tr>
			<td>경매</td>
			<td>
				<a href="<c:url value='/auction/viewAuction.do'>
							<c:param name='aNo' value='${imPur.auction.aNo}' />
						</c:url>">
				${imPur.auction.title}</a>
			</td>
		</tr>
		<tr>
			<td>즉시구매 가격</td>
			<td>${imPur.auction.imPurPrice}</td>
		</tr>
	</table>
	<br><br>
	<table border='1'>
		<tr>
			<td>배송</td>
			<td>주소</td>
			<td>상태</td>
		</tr>
		<tr>
			<td>${imPur.delivery.dNo}</td>
			<td>
				<a href="<c:url value='/address/getAddress.do'>
							<c:param name='addrNo' value='${imPur.delivery.address.addrNo}' />
						</c:url>">
				${imPur.delivery.address.addr}</a>
			</td>
			<td>${imPur.delivery.status}</td>
		</tr>
	</table>
	<br><br>
	<table border='1'>
		<tr>
			<td>결제</td>
			<td>결제방법</td>
			<td>카드</td>
			<td>결제일</td>
			<td>결제금액</td>
		</tr>
		<tr>
			<td>${imPur.payment.payNo}</td>
			<td>${imPur.payment.method}</td>
			<td>
				<a href="<c:url value='/card/viewCard.do'> 
							<c:param name='cardNo' value='${imPur.payment.card.cardNo}' />
						</c:url>">
				${imPur.payment.card.cardPayNo}</a>
			</td>
			<td>${imPur.payment.pDate}</td>
			<td>${imPur.payment.totalPrice}</td>
		</tr>
	</table>
	<br><br>
	<a href="<c:url value='/auction/viewMyImPurList.do' />">이전</a>
	
</body>
</html>