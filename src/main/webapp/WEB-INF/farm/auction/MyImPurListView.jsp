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
	<table border="1">
		<tr>
			<td>순번</td>
			<td>경매</td>
			<td>즉시구매 가격</td>
		</tr>
		<c:forEach var="imPur" items="${imPurList}" varStatus="status">
			<tr>
				<td>
					<a href="<c:url value='/auction/viewMyImpur.do'>
								<c:param name='imPurNo' value='${imPur.imPurNo}' />
							</c:url>">
					${status.count}</a>
				</td>
				<td>
					<a href="<c:url value='/auction/viewAuction.do'>
								<c:param name='aNo' value='${imPur.auction.aNo}' />
							</c:url>">
					${imPur.auction.title}</a>
				</td>
				<td>${imPur.auction.imPurPrice}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>