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
<title>나의 카드</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>순번</td>		<%-- not cardNo, not cardPayNo, just No --%>
			<td>은행</td>
			<td>카드번호</td>
		</tr>
		<c:forEach var="c" items="${cardList}" varStatus="status">
			<tr>
				<td>${status.count}</td>
				<td>${c.bank}</td>
				<td>
					<a href="<c:url value='/card/viewCard.do'>
								<c:param name='cardNo' value='${c.cardNo}' />
							</c:url>">
					${c.cardPayNo}</a>
				</td>
				<td>
					<a href="<c:url value='/card/deleteCard.do'>
								<c:param name='cardNo' value='${c.cardNo}' />
							</c:url>">
					삭제</a>
				</td>	
			</tr>
		</c:forEach>
	</table>
	<br><br>
	<a href="<c:url value='/card/insertCard.do' />">카드 추가</a>
</body>
</html>