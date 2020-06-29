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
	<%@ include file="../IncludeTop.jsp" %>

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
			<td>사진</td>
			<td><img src="../${auction.image}" /></td>
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
			<td>${deadline}</td>
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
	<c:if test="${(auction.finish == true) && (user.id == auction.user.id)}">
		<table border='1'>
	 		<c:if test="${sBid != null}">
				<table border='1'>
					<tr>
						<td>낙찰자</td>
						<td>입찰 가격</td>
						<td>지불상태</td>
					</tr>
					<tr>
						<td>${sBid.bid.user.id}</td> 
						<td>${sBid.bid.bidPrice}</td>
						<td>${sBid.payState}</td>
					</tr>
				</table><br>
				<table border='1'>
					<tr>
						<td>결제번호</td>
						<td>결제방법</td>
						<td>결제일</td>
						<td>카드번호</td>
						<td>결제상태</td>
					</tr>
					<tr>
						<td>${sBid.payment.payNo}</td>
						<td>${sBid.payment.method}</td>
						<td>${pDate}</td>
						<td>${sBid.payment.card.cardPayNo}</td>
						<td>${sBid.payment.payCheck}</td>
					</tr>
				</table><br>
				<table border='1'>
					<tr>
						<td>배송번호</td>
						<td>주소</td>
						<td>상세주소</td>
						<td>우편번호</td>
						<td>전화번호</td>
						<td>배송상태</td>
					</tr>
					<tr>
						<td>${sBid.delivery.dNo}</td>
						<td>${sBid.delivery.address.addr}</td>
						<td>${sBid.delivery.address.detail}</td>
						<td>${sBid.delivery.address.zip}</td>
						<td>${sBid.delivery.phone}</td>
						<td>${sBid.delivery.status}</td>
						<c:if test="${sBid.delivery.status != '배송완료'}">
							<td>
								<a href="<c:url value='/auction/auctionDeliveryStateChange.do'>
											<c:param name='dNo' value='${sBid.delivery.dNo}' />
											<c:param name='aNo' value='${auction.aNo}' />
											<c:param name='status' value='${sBid.delivery.status}' />
										</c:url>">
								배송상태변경</a>
							</td>
						</c:if>
					</tr>
				</table>	
			</c:if> 
			<c:if test="${imPur != null}">
				<table border='1'>
					<tr>
						<td>즉시구매자</td>
						<td>즉시구매 가격</td>
					</tr>
					<tr>
						<td>${imPur.user.id}</td> 
						<td>${imPur.auction.imPurPrice}</td>
					</tr>
				</table><br>
				<table border='1'>
					<tr>
						<td>결제번호</td>
						<td>결제방법</td>
						<td>결제일</td>
						<td>카드번호</td>
						<td>결제상태</td>
					</tr>
					<tr>
						<td>${imPur.payment.payNo}</td>
						<td>${imPur.payment.method}</td>
						<td>${pDate}</td>
						<td>${imPur.payment.card.cardPayNo}</td>
						<td>${imPur.payment.payCheck}</td>
					</tr>
				</table><br>
				<table border='1'>
					<tr>
						<td>배송번호</td>
						<td>주소</td>
						<td>상세주소</td>
						<td>우편번호</td>
						<td>전화번호</td>
						<td>배송상태</td>
					</tr>
					<tr>
						<td>${imPur.delivery.dNo}</td>
						<td>${imPur.delivery.address.addr}</td>
						<td>${imPur.delivery.address.detail}</td>
						<td>${imPur.delivery.address.zip}</td>
						<td>${imPur.delivery.phone}</td>
						<td>${imPur.delivery.status}</td>
						<c:if test="${imPur.delivery.status != '배송완료'}">
							<td>
								<a href="<c:url value='/auction/auctionDeliveryStateChange.do'>
											<c:param name='dNo' value='${imPur.delivery.dNo}' />
											<c:param name='aNo' value='${auction.aNo}' />
											<c:param name='status' value='${imPur.delivery.status}' />
										</c:url>">
								배송상태변경</a>
							</td>
						</c:if>
					</tr>
				</table>
				
			</c:if>
		</table>
	</c:if>
	
</body>
</html>