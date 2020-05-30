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
	<form:form modelAttribute="login" action='<c:url value="/user/login.do"/>' method="Post">	
		<br>
	
		<form:errors path="userId" />
		<br><br>
		
		<form:label path="userId">아이디 </form:label>
		<form:input path="userId" />
		<br>
		
		<form:label path="password">암호 </form:label>
		<form:password path="password" />
		<form:errors path="password" />
		<br><br>
		
		<input type="submit" value="로그인" />
		
		<c:if test="${message} != null">
			${message}<br><br>
		</c:if>
	</form:form>
</body>
</html>