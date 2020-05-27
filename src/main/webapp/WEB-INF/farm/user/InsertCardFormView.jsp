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
	<form action='<c:url value="/user/insertCard.do"/>'>
		은행	<input type="text" value="bank" />
		<br>
		
		종류	<input type="text" value="type" />
		<br>
		
		카드번호  <input type="text" value="cardPayNo" />
		<br>
		
		유효기간  <input type="text" value="period" />
		<br>
		
		cvc	<input type="text" value="cvc" />
		<br>
		
		비밀번호 <input type="text" value="cardPW" />
		<br>
		
		은행	<input type="text" value="bank" />
		<br>
	
		<input type="submit" value="추가" />
		
	</form>
</body>
</html>