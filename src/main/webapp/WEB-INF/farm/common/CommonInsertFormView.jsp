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
<title>공동구매 추가</title>
</head>
<body>
	<c:set var="targetUrI">
		<c:url value="/common/insertCommon.do" />
	</c:set>
	<form:form commandName="commonCommand" action="${targetUrI}">
	

		<input type="submit" value="추가" />
	</form:form>
</body>
</html>