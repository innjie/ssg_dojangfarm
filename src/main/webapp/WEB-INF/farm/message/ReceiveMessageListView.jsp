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
	<title>받은 메세지</title>
</head>
<body>
<%@ include file="../IncludeTop.jsp"%>
	<div id="page">
		<div id="content">
			<div class="post">
	<a href="<c:url value='/message/viewSendMessageList.do' />">전송함</a>&nbsp;
	<a href="<c:url value='/message/viewReceiveMessageList.do' />">수신함</a>
	<br>
	<c:if test="${title != null}">
		검색 : ${title}
	</c:if>
	<br>
	<table border="1">
		<tr>
			<td>순번</td>		<%-- not cardNo, not cardPayNo, just No --%>
			<td>보낸사람</td>
			<td>제목</td>
			<td>날짜</td>
			<td>읽음</td>
		</tr>
		<c:forEach var="m" items="${receiveMessageList.pageList}" varStatus="status">
			<c:if test="${m.sUser.id != user.id}">
				<tr>
					<td>${status.count}</td>	<%-- delete한거도 count될듯... --%>
					<td>${m.sUser.id}</td>
					<td>
						<a href="<c:url value='/message/viewMessage.do'>
									<c:param name='msgNo' value='${m.msgNo}' />
									<c:param name='type' value='receive' />
								</c:url>">
						${m.title}</a>
					</td>
					<td>${m.sDate}</td>
					<td>${m.read}</td>
				</tr>
			</c:if>
		</c:forEach>
	</table>
	<br><br>
	<c:if test="${!receiveMessageList.firstPage}">
    	<a href='<c:url value="/message/viewReceiveMessageList2.do">
       				<c:param name="page" value="previous"/>
       			</c:url>'>
       	Prev</a>
    </c:if> 
    <c:if test="${!receiveMessageList.lastPage}">
    	<a href='<c:url value="/message/viewReceiveMessageList2.do">
       				<c:param name="page" value="next"/>
       			</c:url>'>
       	Next</a>
    </c:if>
	<br><br>
	<form action="<c:url value="/message/findMessageList.do"/>">
		제목 <input type="text" name="title">&nbsp;
		<input type="submit" value="찾기">
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
		<p>
			&copy; Untitled. All rights reserved. Design by <a
				href="http://templated.co" rel="nofollow">TEMPLATED</a>.
		</p>
	</div>
</body>
</html>