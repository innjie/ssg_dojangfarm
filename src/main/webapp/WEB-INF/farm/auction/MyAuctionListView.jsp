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
<title>나의 경매</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>순번</td>
			<td>제목</td>
			<td>최소 가격</td>
			<td>입찰 가격</td>
			<td>즉시구매 가격</td>
			<td>기간</td>
			<td>종료</td>
		</tr>
		<c:forEach var="auc" items="${auctionList}" varStatus="status">
			<tr>
				<td>${status.count}</td>
				<td>
					<a href="<c:url value='/auction/viewAuction.do'>
								<c:param name='aNo' value='${auc.aNo}' />
							</c:url>">
					${auc.title}</a>
				</td>
				<td>${auc.minPrice}</td>
				<td>${auc.bidPrice}</td>
				<td>${auc.imPurPrice}</td>
				<td>${auc.deadline}</td>
				<td>${auc.finish}</td>							
			</tr>
		</c:forEach>
	</table>
</body>
</html>