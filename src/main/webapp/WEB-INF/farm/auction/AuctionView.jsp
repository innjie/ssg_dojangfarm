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
<title>경매 상세보기</title>
</head>
<body>
	<table border='1'>
		<tr>
			<td>제목</td>
			<td>${auction.title}</td>
		</tr>
		<tr>
			<td>품목</td>
			<td>${auction.product.pName}</td>
		</tr>
		<tr>
			<td>최소 가격</td>
			<td>${auction.minPrice}</td>
		</tr>
		<tr>
			<td>현재 입찰 가격</td>
			<td>${auction.bidPrice}</td>
		</tr>
		<c:if test="${auction.imPurAva == true}">
			<tr>
				<td>즉시구매 가격</td>
				<td>${auction.imPurPrice}</td>
			</tr>
		</c:if>
		<tr>
			<td>기간</td>
			<td>${auction.deadline}</td>
		</tr>
		<tr>
			<td>판매자</td>
			<td>${auction.user.id}</td>
		</tr>
		<tr>
			<td>내용</td>
			<td>${auction.detail}</td>
		</tr>

		
	</table>
	<br><br>
	
	<c:if test="${(auction.finish == false) && (user.id != auction.user.id)}">
		<a href='<c:url value="/auction/bidAuction.do">
					<c:param name="aNo" value="${auction.aNo}"/>
				</c:url>'>
		입찰</a>&nbsp;&nbsp;
		<c:if test="${auction.imPurAva == true}">
			<a href='<c:url value="/auction/immePurchase.do">
						<c:param name="aNo" value="${auction.aNo}"/>
					</c:url>'>
			즉시구매</a>&nbsp;&nbsp;
		</c:if>
	</c:if>
	
	<!-- 이 부분 처리하는 기능 컨트롤러에 추가 - 판매자일 때 낙찰/즉시구매자 정보 가져오기 -->
	<c:if test="${(auction.finish == false) && (user.id != auction.user.id)}">
		<table border='1'>
			<c:if test="${sBid != null}">
				<table border='1'>
					<tr>
						<td>낙찰자</td>
						<td>입찰 가격</td>
						<td>지불상태</td>
						<!-- 배송, 결제 관련 -->
					</tr>
					<tr>
						<td>
							<a href="<c:url value='/auction/viewMySBid.do'>
										<c:param name='sBidNo' value='${sBid.sBidNo}' />
									</c:url>">
							${sBid.bid.user.id}</a>
						</td> 
						<td>${sBid.bid.bidPrice}</td>
						<td>${sBid.payState}</td>
						<!-- 배송, 결제 관련 -->
					</tr>
				</table>	
			</c:if>
			<c:if test="${imPur != null}">
				<table border='1'>
					<tr>
						<td>즉시구매자</td>
						<td>즉시구매 가격</td>
						<!-- 배송, 결제 관련 -->
					</tr>
					<tr>
						<td>
							<a href="<c:url value='/auction/viewMyImpur.do'>
										<c:param name='imPurNo' value='${imPur.imPurNo}' />
									</c:url>">
							${imPur.user.id}</a>
						</td> 
						<td>${imPur.auction.imPurPrice}</td>
						<!-- 배송, 결제 관련 -->
					</tr>
				</table>
			</c:if>
		</table>
	</c:if>
</body>
</html>