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
<title>참여한 공동구매 리스트</title>
</head>
<body>
<table border="1">
<tr>
	<td>번호</td>
	<td>제목</td>
	<td>수량</td>
	<td>상태</td>
</tr>
<c:forEach var="cj" items="${cjList}" >
	<tr>
	<td><a href="<c:url value='/commonJoin/view.do'> 
						<c:param name='cjNo' value='${cj.cjNo}'/>
						</c:url>">${cj.cjNo}</a></td>
	<td>${cj.common.title}</td>
	<td>${cj.count}</td>
	<td>${cj.cjState }
	</tr>
</c:forEach>
</table>
<a href="/index" >[메인으로]</a>
</body>
</html>