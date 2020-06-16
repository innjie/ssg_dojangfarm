<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>공동구매 신청자 리스트</title>
</head>
<body>
<table border = "1">
<tr>
<td>번호</td>
<td>신청자</td>
<td>개수</td>
</tr>

<c:forEach var = "commonJoin" items = "${cjList }">
<tr>
<td> <a href = "<c:url value = '/commonJoin/view.do'>
<c:param name = 'cjNo' value = '${commonJoin.cjNo }'/>
</c:url>"> ${commonJoin.cjNo }</a></td>
<td><a href = "<c:url value = ''>
<c:param name = 'userNo'  value = '${commonJoin.user.userNo }'/>
</c:url>">${commonJoin.user.name }</a></td>
<td>${commonJoin.count }</td>
</tr>
</c:forEach>
</table>
</body>
</html>