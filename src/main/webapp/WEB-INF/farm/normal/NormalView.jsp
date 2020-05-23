<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>등록한 상품 보기</title>
</head>
<body>
 <table border="1" width="600" height="800">
	<tr>
	<td  colspan="3">${normal.title }</td>
	</tr>

	<tr >
	<td>사진</td>
	<td></td>
	</tr>
	
	<tr >
	<td>품목</td>
	<td>${normal.product.pName }</td>
	</tr>
	
	<tr>
	<td>${ normal.price}</td>
	</tr>

	<tr>
	<td colspan="3">${normal.info }</td>
	</tr>
</table>
<input type="button" value="장바구니"/>	
</body>
</html>