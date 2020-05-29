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
<title>일반판매 전체보기</title>
</head>
<body>
<form:form action='<c:url value="/normal/searchNormal.do"/>' method = "GET"">
	<form:label path="word">검색</form:label>
	<form:input path="word"/>
	<form:errors path="word"/>
</form:form>
<table border="1">
<tr>
	<td>번호</td>
	<td>제목</td>
	<td>작성자</td>
</tr>
<c:forEach var="normal" items="${normalList}" >
	<tr>
	<td>${normal.saleNo}</td>
	<td><a href="<c:url value='/normal/viewNormal.do'> 
						<c:param name='saleNo' value='${normal.saleNo}'/>
						</c:url>">${normal.title}</a>
	</td>
	<td>${normal.user.name}</td>
	</tr>
</c:forEach>
</table>
<a href="/index" >[메인으로]</a>
</body>
</html>