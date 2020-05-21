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
<title>나의 주소록</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>순번</td>		<%-- not cardNo, not cardPayNo, just No --%>
			<td>이름</td>
			<td>주소</td>
		</tr>
		<c:forEach var="addr" items="${address}" varStatus="status">
			<tr>
				<td>${status.count}</td>
				<td>
					<a href="<c:url value='/user/getAddress.do'>
								<c:param name='addrNo' value='${addr.addrNo}' />
							</c:url>">
					${addr.name}</a>
				</td>
				<td>${addr.address}</td>
				<td>
					<a href="<c:url value='/user/deleteAddress.do'>
								<c:param name='addrNo' value='${addr.addrNo}' />
							</c:url>">
					삭제</a>
				</td>	
			</tr>
		</c:forEach>
	</table>
	<br><br>
	<a href="<c:url value='/user/createAddress.do' />">주소 추가</a>
</body>
</html>