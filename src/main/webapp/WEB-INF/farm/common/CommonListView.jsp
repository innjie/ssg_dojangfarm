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
<title>공동구매 전체보기</title>
</head>
<body>
<form:form action='<c:url value="/common/searchNormal.do"/>' method = "GET"">
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
<c:forEach var="common" items="${commonList}" >
	<tr>
	<td>${common.saleNo}</td>
	<td><a href="<c:url value='/common/viewCommon.do'> 
						<c:param name='saleNo' value='${common.saleNo}'/>
						</c:url>">${common.title}</a>
	</td>
	<td>${common.user.name}</td>
	</tr>
</c:forEach>
</table>
</body>
</html>