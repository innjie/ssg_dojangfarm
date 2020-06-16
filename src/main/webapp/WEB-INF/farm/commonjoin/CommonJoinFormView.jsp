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
<title>공동구매 참여</title>
</head>
<body>
<h2>${common.title } 신청 폼</h2>

	<c:set var="targetUrI">
		<c:url value="/commonjoin/join.do" />
	</c:set>
<form:form action=' ${targetUrI }' commandName="cjCommand"   method = "POST">

<form:label path="common.saleNo">상품번호</form:label>
<form:input path="common.saleNo" value="${common.saleNo }" readonly = "true" />
<form:errors path="common.saleNo"/>
<br>


<form:label path="count">개수</form:label>
<form:input path="count"/>
<form:errors path="count"/>
<br>
	<input type="submit" value="추가" />
</form:form>

</body>
</html>