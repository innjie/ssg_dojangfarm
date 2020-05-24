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
<title>주소 수정</title>
</head>
<body>
	<form:form modelAttribute="address" action='<c:url value="/user/modifyAddress.do"/>'>
		
		<form:label path="address.aName">주소 이름 </form:label>
		<form:input path="address.aName" />
		<form:errors path="address.aName" />
		<br>
		
		<form:label path="address.zipcode">우편번호 </form:label>
		<form:input path="address.zipcode" />
		<form:errors path="address.zipcode" />
		<br>
		
		<form:label path="address.address">주소 </form:label>
		<form:input path="address.address" />
		<form:errors path="address.address" />
		<br>
		
		<form:label path="address.detail">상세 </form:label>
		<form:input path="address.detail" />
		<form:errors path="address.detail" />
		<br>
		
		<input type="submit" value="수정" />
		
	</form:form>
</body>
</html>