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
<title>공동구매 공지 리스트 보기</title>
</head>
<body>
<table border="1">
<tr>
	<td>번호</td>
	<td>제목</td>
	<td>작성자</td>
</tr>
<c:forEach var="cn" items="${cnList}" >
	<tr>
	<td>${cn.CNNO}</td>
	<td><a href="<c:url value='/normal/viewNormal.do'> 
						<c:param name='saleNo' value='${cn.CNNO}'/>
						</c:url>">${cn.title}</a>
	</td>
	<td>${cn.user.name}</td>
	</tr>
</c:forEach>
</table>
</body>
</html>