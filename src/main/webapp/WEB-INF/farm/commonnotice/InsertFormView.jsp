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
<title>공지 입력 폼</title>
</head>
<body>
<%@ include file="../IncludeTop.jsp" %>
<c:set var="targetUrI">
		<c:url value="/commonNotice/insertCN.do" />
	</c:set>
	<form:form commandName="commonNoticeCommand"
		action="${targetUrI }">

		<form:label path="title">제목</form:label>
		<form:input path="title" />
		<form:errors path="title" />
		<br>

		<form:label path="info">내용</form:label>
		<form:textarea path="info" />
		<form:errors path="info" />
		<br>

		<input type="submit" value="추가" />
	</form:form>
</body>
</html>