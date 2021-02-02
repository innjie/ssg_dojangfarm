<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공동구매 신청 보기</title>
</head>
<body>
<%@ include file="../IncludeTop.jsp" %>
 <table border="1" >
 <tr>
 <td>신청번호</td>
 <td>${commonJoin.cjNo }</td>
 </tr>

<tr>
<td>신청품목</td>
<td>${commonJoin.common.title } </td>
</tr>

 <tr>
 <td>상태</td>
 <td>${commonJoin.cjState }</td>
 </tr>
 
 <tr>
 <td>수량</td>
 <td>${commonJoin.count }</td>
</tr>

</table>

<br>
<a href = <c:url value = '/commonJoin/userList.do'/>">리스트로 돌아가기</a><br>
<c:if test = "${(loginUser.userNo == commonJoin.user.userNo) && (commonJoin.common.saleState == 'OPEN')}">
<a href = "<c:url value = '/commonJoin/update.do'>
<c:param name = 'cjNo' value = '${commonJoin.cjNo }'/></c:url>"> 수정하기 </a><br>
<a href = "<c:url value = '/commonJoin/cancel.do'>
<c:param name = 'cjNo' value = ' ${commonJoin.cjNo}'/> </c:url>">취소하기</a><br>
</c:if>

</body>
</html>