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
<title>경매 리스트</title>
</head>
<body>
	<a href="<c:url value='/auction/registerAuction.do' />">경매 추가</a>
	<br><br>
	<table border="1">
		<tr>
			<td>순번</td>
			<td>제목</td>
			<td>최소 가격</td>
			<td>입찰 가격</td>
			<td>즉시구매 가격</td>
			<td>기간</td>
		</tr>
		<c:forEach var="auc" items="${auctionList}" varStatus="status">
			<c:if test="${auc.finish != true}">
				<tr>
					<td>${status.count}</td>
					<td>
						<a href="<c:url value='/auction/viewAuction.do'>
									<c:param name='aNo' value='${auc.aNo}' />
								</c:url>">
						${auc.title}</a>
					</td>
					<td>${auc.minPrice}</td>
					<td>
						<c:if test="${auc.bidPrice != 0}">
							${auc.bidPrice}
						</c:if>
					</td>
					<td>${auc.imPurPrice}</td>
					<td>${auc.deadline}</td>						
				</tr>
			</c:if>
		</c:forEach>
	</table>
	<br><br>
	<form action="<c:url value="/auction/findAuctionList.do"/>">	<%-- 컨트롤러에서 type에 따라 다른 dao 사용 --%>
		<select name="type">
			<option value="title">제목</option>
			<option value="pName">품목</option>
		</select>
		<input type="text" name="text">&nbsp;	<%-- text - title or pName --%>
		<input type="submit" value="찾기">
	</form>
</body>
</html>