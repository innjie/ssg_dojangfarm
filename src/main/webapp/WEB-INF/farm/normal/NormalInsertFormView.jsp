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
<title>일반판매 추가</title>
</head>
<body>
	<c:set var="targetUrI">
		<c:url value="/normal/insertNormal.do" />
	</c:set>
	<form:form action="${targetUrI}" commandName="normalCommand">
		<form:label path="title">제목</form:label>
		<form:input path="title" />
		<form:errors path="title" />
		<br>

		<form:label path="price">가격</form:label>
		<form:input path="price" />
		<form:errors path="price" />
		<br>
		
		<form:label path="count">개수</form:label>
		<form:input path="count"/>
		<form:errors path="count"/>
		<br>

		<form:label path="product.pName">품목 </form:label>
		<form:select path="product.pName">
			<option value="과일">사과</option>
			<option value="채소">오렌지</option>
		</form:select>

		<form:errors path="product.pName" />
		<br>

		<form:label path="info">설명</form:label>
		<form:input path="info" />
		<form:errors path="info" />
		<br>

		<input type="submit" value="추가" />


	</form:form>
</body>
</html>