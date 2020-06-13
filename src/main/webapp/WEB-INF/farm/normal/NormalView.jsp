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
 <table border="1" >
 	<tr> <td colspan="3">제목</td></tr>
	<tr>
	<td  colspan="3">${normal.title }</td>
	</tr>

	<tr >
	<td rowspan="3" colspan = "1">사진</td>
	<td>판매상태</td>
	<td>${normal.saleState }</td>
	</tr>
	
	<tr >
	<td>수량</td>
	<td>${normal.count }</td>
	</tr>
	
	<tr>
	<td>가격</td>
	<td>${ normal.price}</td>
	</tr>

	<tr> <td colspan = "3">설명</td></tr>
	<tr>
	<td colspan="3">${normal.info }</td>
	</tr>
</table>
<a href="NormalListView" >[이전 단계로]</a>
	<c:if test="${ (session.id == normal.user.id)}">
	<a href = "<c:url value ='/normal/updateForm.do' />">수정하기</a><br>
	</c:if>
<input type="button" value="장바구니"/>
</body>
</html>