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
	<%@ include file="../IncludeTop.jsp" %>

	<table border="1">
		<tr>
			<td>순번</td>		<%-- not cardNo, not cardPayNo, just No --%>
			<td>이름</td>
			<td>주소</td>
		</tr>
		<c:forEach var="a" items="${addressList.pageList}" varStatus="status">
			<tr>
				<td>${status.count}</td>
				<td>
					<a href="<c:url value='/address/getAddress.do'>
								<c:param name='addrNo' value='${a.addrNo}' />
							</c:url>">
					${a.aName}</a>
				</td>
				<td>${a.addr}</td>
				<td>
					<a href="<c:url value='/address/deleteAddress.do'>
								<c:param name='addrNo' value='${a.addrNo}' />
							</c:url>">
					삭제</a>
				</td>	
			</tr>
		</c:forEach>
	</table>
	<br><br>
	<c:if test="${!addressList.firstPage}">
    	<a href='<c:url value="/address/getAddressList2.do">
        			<c:param name="page" value="previous"/>
        		</c:url>'>
        Prev</a>
    </c:if> 
    <c:if test="${!addressList.lastPage}">
    	<a href='<c:url value="/address/getAddressList2.do">
        			<c:param name="page" value="next"/>
        		</c:url>'>
        Next</a>
    </c:if>
	<br><br>
	<a href="<c:url value='/address/createAddress.do' />">주소 추가</a>
</body>
</html>