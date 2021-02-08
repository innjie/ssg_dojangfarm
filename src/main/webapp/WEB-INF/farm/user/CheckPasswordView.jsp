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
<title>비밀번호확인</title>
</head>
<body>
	<c:set var="targetUrl"><c:url value="/user/checkPW.do" /></c:set>

	<form:form modelAttribute="login" action="${targetUrl}">
		<br>
			
		<form:label path="id">아이디 </form:label>
		<c:out value="${login.id}" />
		<br><br>
		
		<form:label path="password">암호 </form:label>
		<form:password path="password" />
		<form:errors path="password" />
		<br><br>
		
		<input type="submit" value="삭제" />&nbsp;&nbsp;
		<a href="<c:url value='/user/getUser.do' />">이전</a>
		
	</form:form>
</body>
</html>