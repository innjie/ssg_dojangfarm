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
	<form:form action="${targetUrI}" commandName="normalCommand" method = "POST"
	enctype = "multipart/form-data">
		<form:label path="title">제목</form:label>
		<form:input path="title" />
		<form:errors path="title" />
		<br>
		
		사진 : <input type = "file" name = "image"/>
		<br> <br>
		
		<form:label path="price">가격</form:label>
		<form:input path="price" />
		<form:errors path="price" />
		<br>
		
		<form:label path="count">개수</form:label>
		<form:input path="count"/>
		<form:errors path="count"/>
		<br>

		<form:label path="product.pNo">품목 </form:label>
		<form:select path="product.pNo">
			<c:forEach var = "product" items = "${product }">
				<form:option value="${product.pNo}">${product.pName }</form:option>
			</c:forEach>
		</form:select>

		<form:errors path="product.pNo" />
		<br>

		<form:label path="info">설명</form:label>
		<form:input path="info" />
		<form:errors path="info" />
		<br>
		
		<form:label  path = "regidDate">판매 마감 날짜 </form:label>
		<form:input path = "regidDate"/>
		<form:errors path = "regidDate"/>
		<br>

		<input type="submit" value="추가" />


	</form:form>
</body>
</html>