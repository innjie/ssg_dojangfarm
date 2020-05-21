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
<title>회원 정보 수정</title>
</head>
<body>
	<form:form modelAttribute="user" action='<c:url value="/user/modifyUser.do"/>'>
		<form:label path="id">ID</form:label>
		<form:input path="id" />
		<form:errors path="id" />
		<br>
		
		<form:label path="name">이름 </form:label>
		<form:input path="name" />
		<form:errors path="name" />
		<br>
		
		<form:label path="password">암호 </form:label>
		<form:password path="password" />
		<form:errors path="password" />
		<br>
		
		<form:label path="confirmPassword">암호 학인 </form:label>
		<form:password path="confirmPassword" />
		<form:errors path="confirmPassword" />
		<br>
		
		<form:label path="phone">전화번호 </form:label>
		<form:input path="phone" />
		<form:errors path="phone" />
		<br>
		
		<input type="submit" value="수정" />
		
	</form:form>
</body>
</html>