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
<title>카드 추가</title>
</head>
<body>
	<form:form modelAttribute="card" action='<c:url value="/user/insertCard.do"/>'>
		<form:label path="bank">은행</form:label>
		<form:input path="bank" />
		<form:errors path="bank" />
		<br>
			
		<form:label path="type">종류 </form:label>
		<form:password path="type" />
		<form:errors path="type" />
		<br>
		
		<form:label path="cardPayNo">카드번호 </form:label>
		<form:password path="cardPayNo" />
		<form:errors path="cardPayNo" />
		<br>
		
		<form:label path="period">유효기간 </form:label>
		<form:input path="period" />
		<form:errors path="period" />
		<br>
			
		<form:label path="cvc">cvc </form:label>
		<form:input path="cvc" />
		<form:errors path="cvc" />
		<br>
		
		<form:label path="cardPW">비밀번호 </form:label>
		<form:password path="cardPW" />
		<form:errors path="cardPW" />
		<br>
	
		<input type="submit" value="추가" />
		
	</form:form>
</body>
</html>