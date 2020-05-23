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
<title>공동구매 등록 폼</title>
</head>
<body>
<form:form modelAttriute="common"
		action='<c:url value="/common/insertCommon.do"/>'>
		<form:label path="title">제목</form:label>
		<form:input path="title" />
		<form:errors path="title" />
		<br>

		<form:label path="price">가격</form:label>
		<form:input path="price" />
		<form:error path="price" />
		<br>

		<form:label path="product.pName">품목 </form:label>
		<form:input path="product.pName" />
		<%-- select or radiobuttons --%>
		<form:errors path="product.pName" />
		<br>

		<form:label path="info">설명</form:label>
		<form:input path="info" />
		<form:error path="info" />
		<br>
		
		<form:label path="min">최소인원 </form:label>
		<form:input path="min"/>
		<form:errors path="min"/>
		<br>
		
		<a href="CommonListView">[이전으로]</a>
		<input type="submit" value="추가" />


	</form:form>
</body>
</html>