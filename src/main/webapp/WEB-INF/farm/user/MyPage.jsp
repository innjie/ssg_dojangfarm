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
<title>마이페이지</title>
</head>
<body>
	<%@ include file="../IncludeTop.jsp" %>
	<a href="<c:url value='/user/myPage.do'><c:param name="type" value="user" /></c:url>">회원 정보</a>&nbsp;&nbsp;&nbsp;&nbsp;		
	<c:if test="${param.type == 'user'}">
		<a href="<c:url value='/user/getUser.do' />">나의 정보</a>&nbsp;&nbsp;
		<a href="<c:url value='/address/getAddressList.do' />">나의 주소록</a>&nbsp;&nbsp;
		<a href="<c:url value='/card/viewCardList.do' />">나의 카드</a>&nbsp;&nbsp;
	</c:if>
	<br><br>
	<a href="<c:url value='/user/myPage.do'><c:param name="type" value="normal" /></c:url>">나의 일반 판매</a>&nbsp;&nbsp;&nbsp;&nbsp;
	<c:if test="${param.type == 'normal'}">
		<a href="<c:url value='/normal/userList.do'/>">나의 판매</a>&nbsp;&nbsp;
		<a href="<c:url value = '/order/list.do'/>">나의 구매</a>&nbsp;&nbsp;
		<a href = "<c:url value = '/refund/list.do'/> "> 환불 목록 </a> &nbsp;&nbsp;
	</c:if>
	<br><br>
	<a href="<c:url value='/user/myPage.do'><c:param name="type" value="auction" /></c:url>">나의 경매</a>&nbsp;&nbsp;&nbsp;&nbsp;
	<c:if test="${param.type == 'auction'}">
		<a href="<c:url value='/auction/viewMyAuctionList.do' />">나의 경매</a>&nbsp;&nbsp;
		<a href="<c:url value='/auction/viewMyBidList.do' />">나의 입찰</a>&nbsp;&nbsp;
		<a href="<c:url value='/auction/viewMySBidList.do' />">나의 낙찰</a>&nbsp;&nbsp;
		<a href="<c:url value='/auction/viewMyImPurList.do' />">나의 즉시구매</a>&nbsp;&nbsp;
	</c:if>
	<br><br>
	<a href="<c:url value='/user/myPage.do'><c:param name="type" value="common" /></c:url>">나의 공동구매</a>&nbsp;&nbsp;&nbsp;&nbsp;
	<c:if test="${param.type == 'common'}">
		<a href="<c:url value = '/common/userList.do'/>">나의 공동구매</a>&nbsp;&nbsp;
		<a href="<c:url value = '/commonJoin/userList.do'/> ">나의 공구 신청</a>&nbsp;&nbsp;
		<a href="<c:url value = '/commonNotice/userList.do'/>" >나의 공지</a>&nbsp;&nbsp;
	</c:if>
	<br><br>
</body>
</html>