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
<title>주소 추가</title>
</head>
<body>
	<form:form modelAttribute="addressCommand" >
		
		<form:label path="aName">주소 이름 </form:label>
		<form:input path="aName" />
		<form:errors path="aName" />
		<br>
		
		<form:label path="zip">우편번호 </form:label>
		<form:input path="zip" />
		<form:errors path="zip" />
		<br>
		
		<form:label path="addr">주소 </form:label>
		<form:input path="addr" />
		<form:errors path="addr" />
		<br>
		
		<form:label path="detail">상세 </form:label>
		<form:input path="detail" />
		<form:errors path="detail" />
		<br>
		
		<input type="submit" value="추가" />
		
	</form:form>
</body>
</html>