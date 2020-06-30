<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h2><a href="<c:url value='/' />" >도장팜</a>에 오시면 혜택이 팜팜</h2><br>
<c:if test="${user != null}">
	<a href="<c:url value='/user/getUser.do' />">${user.id}</a>님 반갑습니다.
</c:if>
<br><br>
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