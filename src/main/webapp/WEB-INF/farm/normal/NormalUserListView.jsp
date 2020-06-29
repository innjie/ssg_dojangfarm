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
<title> 등록한 판매 리스트 보기</title>
</head>
<body>
<%@ include file="../IncludeTop.jsp" %>

<form action = "<c:url value = '/normal/searchNormal.do'/>">
<input type = "text" name = "word"> &nbsp;
<input type = "submit" value = "검색">
</form>

<table border="1">
<tr>
	<td>번호</td>
	<td>제목</td>
	<td>작성자</td>
</tr>
<c:forEach var="normal" items="${normalList.pageList}" >
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
<c:if test="${!normalList.firstPage}">
			<a
				href='<c:url value="/normal/userList2.do">
        				<c:param name="page" value="previous"/>
        			</c:url>'>
				Prev</a>
		</c:if>
		<c:if test="${!normalList.lastPage}">
			<a
				href='<c:url value="/normal/userList2.do">
        				<c:param name="page" value="next"/>
        			</c:url>'>
				Next</a>
		</c:if>

</body>
</html>