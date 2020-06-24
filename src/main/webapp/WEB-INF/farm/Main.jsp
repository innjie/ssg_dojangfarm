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
<h2><a href="<c:url value='/' />" >도장팜</a>에 오시면 혜택이 팜팜</h2><br>
	<c:if test="${user == null}"> 
		<a href="<c:url value='/user/login.do' />" >로그인</a>&nbsp;&nbsp;
	</c:if> 
	<c:if test="${user == null}">  
		<a href="<c:url value='/user/createUser.do' />" >회원가입</a>&nbsp;&nbsp;
	</c:if> 
	<c:if test="${user != null}">  
		<a href="<c:url value='/user/myPage.do' />" >마이페이지</a>&nbsp;&nbsp;
	</c:if> 
	<c:if test="${user != null}"> 
		<a href="<c:url value='/message/viewSendMessageList.do' />" >쪽지함</a>&nbsp;&nbsp;
	</c:if> 
	<c:if test="${user != null}"> 
		<a href="<c:url value='/user/logout.do' />" >로그아웃</a>&nbsp;&nbsp;
	</c:if>
	<br><br><br>
	
	<a href="<c:url value='/'><c:param name="menu" value="click" /></c:url>">메뉴</a>&nbsp;&nbsp;&nbsp;&nbsp;
	<c:if test="${param.menu == 'click'}">
		<a href="<c:url value='/normal/list.do'/>">일반판매</a>&nbsp;&nbsp;	
		<a href="<c:url value='/common/list.do'/> "> 공동구매</a>&nbsp;&nbsp;	
		<a href="<c:url value='/auction/viewAuctionList.do' />">경매</a>&nbsp;&nbsp;
		<a href= "<c:url value='/commonNotice/list.do'/>">공동구매 공지</a> &nbsp;&nbsp;
	</c:if>
	<br><br>
	<form method="post" action="<c:url value='/kakao/kakaoPay.do' />">
    	<input type="image" src="images/payment_icon_yellow_medium.png" />
	</form>
	
</body>
</html>
