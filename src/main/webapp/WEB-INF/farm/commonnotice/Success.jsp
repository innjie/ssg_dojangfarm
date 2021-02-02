<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<%@ include file="../IncludeTop.jsp" %>
<b><c:out value="${message}" default="No further information was provided."/></b>

<br> <br>
<a href = "<c:url value = '/commonNotice/list.do'/> "> 목록으로 돌아가기</a>
