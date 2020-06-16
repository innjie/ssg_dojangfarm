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
 <table border="1" >
	<tr>
	<td  colspan="3">${common.title }</td>
	</tr>

	<tr >
	<td rowspan="4">사진</td>
	</tr>
	
	<tr>
	<td>가격</td>
	<td>${ common.price}</td>
	</tr>
	
	<tr>
	<td>최소인원</td>
	<td>${common.min }</td>
	</tr>
	
	<tr>
	<td>마감일시</td>
	<td>${common.deadline }</td>
	</tr>

	<tr>
	<td colspan="4">${common.info }</td>
	</tr>
</table>
<a href= "<c:url value = '/common/list.do'/> ">[이전 단계로]</a> <br>
	<c:if test="${ (loginUser.userNo == common.user.userNo)}">
	<a href = "<c:url value ='/common/updateCommon.do' > 
	<c:param name = 'saleNo'  value = '${common.saleNo}'/></c:url> ">수정하기</a><br>
	</c:if>

	<br><br>
	<c:if test = "${(loginUser.userNo != common.user.userNo) }">
	<a href = "<c:url value = '/commonjoin/join.do'><c:param name = 'saleNo' value = '${common.saleNo }'/>
	</c:url> ">신청</a>
	</c:if>	

</body>
</html>