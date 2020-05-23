<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <!--  commit test -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공동구매 참여 수정</title>
</head>
<body>
<h2>${common.title } 신청 폼</h2>
<form:form modelAttribute="commonJoin"
action='<c:url value="/commonJoin/insertJoin.do"/>'>
<!--  blocked 처리해야함 -->
<form:label path="commonJoin.common.CNNO">상품번호</form:label>
<form:input path="commonJoin.common.CNNO" value="${commonJoin.common.CNNO }"/>
<form:error path="commonJoin.common.CNNO"/>
<br>

<form:label path="commonJoin.user.name">주문자</form:label>
<form:input path="commonJoin.user.name" value="${commonJoin.user.name }"/>
<form:error path="commonJoin.user.name"/>
<br>

<form:label path="count">개수</form:label>
<form:input path="count" value="${commonJoin.count }"/>
<form:error path="count"/>
<br>
	<input type="submit" value="추가" />
</form:form>
</body>
</html>