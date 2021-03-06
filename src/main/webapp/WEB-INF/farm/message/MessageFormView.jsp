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
<title>메세지 보내기</title>
</head>
<body>
	<%@ include file="../IncludeTop.jsp" %>
<div id="page">
		<div id="content">
		<div class = "post">
	<form action='<c:url value="/message/sendMsg.do"/>' method="post">
		받는사람&nbsp;
		<c:if test="${cMsg != null}">	<!-- first message -->
			${cMsg.sUser.id}<br>
		</c:if>
		<c:if test="${normal != null}">	<!-- reply message -->
			${normal.user.id}<br>
		</c:if>
		관련 상품&nbsp;
		<c:if test="${cMsg != null}">	<!-- first message -->
			${cMsg.normal.saleNo}<br>
		</c:if>
		<c:if test="${normal != null}">	<!-- reply message -->
			${normal.saleNo}<br>
		</c:if>
		제목&nbsp; 
		<input type="text" name="title" /><br>
		내용&nbsp; 
		<c:if test="${cMsg != null}">
			<textarea name="content">re: ${cMsg.content}
			</textarea>
		</c:if>
		<c:if test="${cMsg == null}">
			<textarea name="content"></textarea>
		</c:if>
		<br>
		<c:if test="${param.message != null}">
			${param.message}
		</c:if>
		<br>

		<input type="hidden" name="cMsgNo" value="${cMsg.msgNo}" />
		<input type="hidden" name="saleNo" value="${normal.saleNo}" />
		<input type="submit" value="보내기" />&nbsp;&nbsp;
	
		<c:if test='${normal != null}'>
			<a href="<c:url value='/normal/viewNormal.do'>
						<c:param name="saleNo" value="${normal.saleNo}" />
					</c:url>">
			이전</a>
		</c:if>
		<c:if test='${cMsg != null}'>
			<a href="<c:url value='/message/viewMessage.do'>
						<c:param name="msgNo" value="${cMsg.msgNo}" />
						<c:param name="type" value="receive" />
					</c:url>">
			이전</a>		
		</c:if>	
	</form>
	
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