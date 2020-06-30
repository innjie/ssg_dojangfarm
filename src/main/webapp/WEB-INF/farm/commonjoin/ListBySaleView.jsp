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
<%@ include file="../IncludeTop.jsp" %>
<table border = "1">
<tr>
<td>번호</td>
<td>신청자</td>
<td>연락처</td>
<td>개수</td>
<td>주소</td>
</tr>

<c:forEach var = "commonJoin" items = "${cjList.pageList }">
<tr>
<td> <a href = "<c:url value = '/commonJoin/view.do'>
<c:param name = 'cjNo' value = '${commonJoin.cjNo }'/>
</c:url>"> ${commonJoin.cjNo }</a></td>
<td>${commonJoin.user.name }</td>
<td> ${commonJoin.delivery.phone }</td>
<td>${commonJoin.count }</td>
<td>${commonJoin.delivery.address.addr }</td>

</tr>
</c:forEach>
<c:if test="${!cjList.firstPage}">
		<a
			href='<c:url value="/commonJoin/viewList2.do">
        				<c:param name="page" value="previous"/>
        			</c:url>'>
			Prev</a>
	</c:if>
	<c:if test="${!cjList.lastPage}">
		<a
			href='<c:url value="/commonJoin/viewList2.do">
        				<c:param name="page" value="next"/>
        			</c:url>'>
			Next</a>
	</c:if>
</table>
</body>
</html>