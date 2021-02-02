<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문 상세 보기</title>
</head>
<body>
<%@ include file="../IncludeTop.jsp" %>
	<table border="1" >
			<tr>
				<td>주문번호</td>
				<td>${order.orderNo }</td>
			</tr>
			
			<tr>
			<td>판매종류</td>
			<td>${order.saleType}</td>
			</tr>

			<tr>
			<td>판매번호</td>
			<td>
				<a href="<c:url value='/normal/viewNormal.do'>
							<c:param name="saleNo" value="${order.saleNo}"/>
						</c:url>">
				${order.saleNo }</a>
			</td>
			</tr>
			
			<tr>
				<td>수량</td>
				<td>${ order.quantity}</td>
			</tr>

			<tr>
				<td>결제번호</td>
				<td>${order.payment.payNo }</td>
			</tr>
		
	</table>
	<!--  session확인해서 본인일 시 취소버튼 만들기 -->

	<c:if test="${ (loginUser.userNo == order.user.userNo) && (order.saleType == 'Normal')
	&& (delivery.status == '배송전')}">
		<a href="<c:url value='/order/cancel.do'>
		<c:param name='orderNo' value='${order.orderNo}'/>
</c:url>"> 환불 및 주문 취소하기 </a><br>
	</c:if>
	

</body>
</html>