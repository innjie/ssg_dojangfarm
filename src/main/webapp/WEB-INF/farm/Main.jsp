<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="UTF-8">
<title>도장팜</title>
</head>
<body>
	<%@ include file="IncludeTop.jsp" %>
	<a href="<c:url value='/'><c:param name="menu" value="click" /></c:url>">메뉴</a>&nbsp;&nbsp;&nbsp;&nbsp;
	<c:if test="${param.menu == 'click'}">
		<a href="<c:url value='/normal/list.do'/>">일반판매</a>&nbsp;&nbsp;	
		<a href="<c:url value='/common/list.do'/> "> 공동구매</a>&nbsp;&nbsp;	
		<a href="<c:url value='/auction/viewAuctionList.do' />">경매</a>&nbsp;&nbsp;
		<a href= "<c:url value='/commonNotice/list.do'/>">공동구매 공지</a> &nbsp;&nbsp;
	</c:if>
	<br><br>
	
	
</body>
</html>
