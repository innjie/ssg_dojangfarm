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
<h2><a href="<c:url value='/' />" >도장팜</a>에 오시면 혜택이 팜팜</h2><br>
	<a href="<c:url value='/user/myPage'><c:param name="type" value="user" /></c:url>">회원 정보</a>&nbsp;&nbsp;&nbsp;&nbsp;		
	<c:if test="${param.type == 'user'}">
		<a href="<c:url value='/user/getUser' />">나의 정보</a>&nbsp;&nbsp;
		<a href="<c:url value='/user/getAddressList' />">나의 주소록</a>&nbsp;&nbsp;
		<a href="<c:url value='/user/viewCardList' />">나의 카드</a>&nbsp;&nbsp;
	</c:if>
	<br><br>
	<a href="<c:url value='/user/myPage'><c:param name="type" value="normal" /></c:url>">나의 일반 판매</a>&nbsp;&nbsp;&nbsp;&nbsp;
	<c:if test="${param.type == 'normal'}">
		<a href="">나의 판매</a>&nbsp;&nbsp;
		<a href="">나의 구매</a>&nbsp;&nbsp;
	</c:if>
	<br><br>
	<a href="<c:url value='/user/myPage'><c:param name="type" value="auction" /></c:url>">나의 경매</a>&nbsp;&nbsp;&nbsp;&nbsp;
	<c:if test="${param.type == 'auction'}">
		<a href="<c:url value='/auction/viewMyAuctionList' />">나의 경매</a>&nbsp;&nbsp;
		<a href="<c:url value='/auction/viewMyBidList' />">나의 입찰</a>&nbsp;&nbsp;
		<a href="<c:url value='/auction/viewMySBidList' />">나의 낙찰</a>&nbsp;&nbsp;
		<a href="<c:url value='/auction/viewMyImPurList' />">나의 즉시구매</a>&nbsp;&nbsp;
	</c:if>
	<br><br>
	<a href="<c:url value='/user/myPage'><c:param name="type" value="common" /></c:url>">나의 공동구매</a>&nbsp;&nbsp;&nbsp;&nbsp;
	<c:if test="${param.type == 'common'}">
		<a href="">나의 공동구매</a>&nbsp;&nbsp;
		<a href="">나의 공구 신청</a>&nbsp;&nbsp;
	</c:if>
	<br><br>
</body>
</html>