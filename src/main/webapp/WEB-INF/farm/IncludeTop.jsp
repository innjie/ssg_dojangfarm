<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<link href="templated-vegetable/style.css" rel="stylesheet"
	type="text/css" media="screen" />
</head>
<div id="header">
	<div id="logo">
		<h1>
			<a href="<c:url value='/' />">도장팜에 오시면 혜택이 팜팜 </a>
		</h1>
		<c:if test="${user != null}">
			<a href="<c:url value='/user/getUser.do' />">${user.id} 님 반갑습니다.</a>
			</c:if>

	</div>
</div>
<div id="wrapper">
	<div id="menu">
		<ul>
			<c:if test="${user == null}">
				<li><a href="<c:url value='/user/login.do' />">로그인</a></li>
				<li><a href="<c:url value='/user/createUser.do' />">회원가입</a></li>
			</c:if>
			<c:if test="${user != null}">
				<li><a href="<c:url value='/user/myPage.do' />">마이페이지</a></li>
				<li><a href="<c:url value='/message/viewSendMessageList.do' />">쪽지함</a></li>
				<li><a href="<c:url value='/user/logout.do' />">로그아웃</a></li>
			</c:if>
		</ul>
		
	</div>
	
	
</div>
