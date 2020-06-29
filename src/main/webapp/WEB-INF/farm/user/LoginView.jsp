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
<title>로그인</title>
</head>
<body>
	<h1><a href="<c:url value='/' />">도장팜</a> 로그인</h1>
	<c:set var="targetUrl"><c:url value="/user/login.do" /></c:set>

	<form:form modelAttribute="login" action="${targetUrl}">
		<br>
			
		<form:label path="id">아이디 </form:label>
		<form:input path="id" />
		<form:errors path="id" />
		<br><br>
		
		<form:label path="password">암호 </form:label>
		<form:password path="password" />
		<form:errors path="password" />
		<br><br>
		
		<input type="hidden" name="forwardAction" value="${login.forwardAction}"/>
		
		<input type="submit" value="로그인" />&nbsp;&nbsp;
		<a href="<c:url value='/user/createUser.do' />">회원가입</a>
	</form:form>
</body>
</html>