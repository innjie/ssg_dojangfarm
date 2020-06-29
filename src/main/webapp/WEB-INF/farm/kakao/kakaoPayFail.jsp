<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <%@ include file="../IncludeTop.jsp" %>
 
카카오페이 결제 실패.
<br>
<%=request.getParameter("msg")%>

 
 
 
</body>
</html>
