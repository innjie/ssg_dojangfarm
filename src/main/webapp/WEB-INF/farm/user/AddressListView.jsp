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
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<link href="../templated-vegetable/style.css" rel="stylesheet"
	type="text/css" media="screen" />
<title>나의 주소록</title>
</head>
<body>
	<%@ include file="../IncludeTop.jsp" %>
<div id="page">
		<div id="content">
		<div class = "post">
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
		</div>
	</div>
	<div style="clear: both;">&nbsp;</div>
	</div>
	<div id="footer-menu">
	<ul>
		<li class="current_page_item"><a href="#">Homepage</a></li>
		<li><a href="#">Blog</a></li>
		<li><a href="#">Photos</a></li>
		<li><a href="#">About</a></li>
		<li><a href="#">Contact</a></li>
	</ul>
</div>
<div id="footer">
	<p>&copy; Untitled. All rights reserved. Design by <a href="http://templated.co" rel="nofollow">TEMPLATED</a>.</p>
</div>
</body>
</html>