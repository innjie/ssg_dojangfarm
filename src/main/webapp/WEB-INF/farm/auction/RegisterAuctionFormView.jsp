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
<title>경매 등록</title>
</head>
<body>
	<form:form modelAttribute="auctionCommand">
		<form:label path="title">제목 </form:label>
		<form:input path="title" />
		<form:errors path="title" />
		<br>
		
		<form:label path="product.pName">품목 </form:label>
		<br>
		<form:radiobuttons path="product.pName" items="${pName}"/>
		<form:errors path="product.pName" />
		<br>
		
		<form:label path="detail">상세 정보 </form:label>
		<form:textarea path="detail" />
		<form:errors path="detail" />
		<br>
		
		<form:label path="minPrice">최소 가격 </form:label>
		<form:input path="minPrice" />
		<form:errors path="minPrice" />
		<br>
		 
		<form:label path="deadline">기간 </form:label>
		<form:input path="deadline" />
		<form:errors path="deadline" />
		<br>
		
		<form:label path="imPurAva">즉시구매 가능 여부 </form:label>
		<form:checkbox path="imPurAva" />
		<form:errors path="imPurAva" />
		<br>
		
		<form:label path="imPurPrice">즉시구매 가격 </form:label>
		<form:input path="imPurPrice" />
		<form:errors path="imPurPrice" />
		<br>
		
		<input type="submit" value="추가" />
		
	</form:form>
</body>
</html>