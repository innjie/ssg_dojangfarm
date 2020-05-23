<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>공동구매 보기</title>
</head>
<body>
 <table border="1" width="600" height="800">
	<tr>
	<td  colspan="4">${common.title }</td>
	</tr>

	<tr >
	<td rowspan="4">사진</td>
	</tr>
	
	<tr>
	<td>품목</td>
	<td>${common.product.pName }</td>
	<td>가격</td>
	<td>${ common.price}</td>
	</tr>
	
	<tr>
	<td>최소인원</td>
	<td>${common.min }</td>
	<td>마감일시</td>
	<td>${common.daedline }</td>
	</tr>

	<tr>
	<td colspan="4">${common.info }</td>
	</tr>
</table>
<a href="CommonListView" >[이전 단계로]</a>

<!--  c:if test="${common.state == "판매중" : 문자열 에러남..,, -->
<input type="button" value="신청"/>	

</body>
</html>