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
<title>배송 현황</title>
</head>
<body>
<%@ include file="../IncludeTop.jsp" %>
<table border = "1">
<tr>
<td>배송번호</td>
<td>전화번호</td>
<td>주소등록번호</td>
<td>배송상태</td>
</tr>

<c:forEach var = "delivery" items = "${dList.pageList }">
<tr>
<td><a href = "<c:url value = '/delivery/view.do'>
	<c:param name = 'dNo' value = '${delivery.dNo }'/> </c:url> "> ${delivery.dNo} </a></td>
<td>${delivery.phone }</td>
<td>${delivery.address.addrNo }</td>
<td>${delivery.status }</td>
</tr>
</c:forEach>
</table>
<c:if test="${!dList.firstPage}">
    		<a href='<c:url value="/delivery/list2.do">
        				<c:param name="page" value="previous"/>
        			</c:url>'>
        	Prev</a>
    	</c:if> 
    	<c:if test="${!dList.lastPage}">
    		<a href='<c:url value="/delivery/list2.do">
        				<c:param name="page" value="next"/>
        			</c:url>'>
        	Next</a>
    	</c:if>
<a href="<c:url value = '/index.do'/>">[메인으로]</a>
</body>
</html>