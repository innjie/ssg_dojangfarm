<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<h3><font color="red">Error!</font></h3>

<%@ include file="../IncludeTop.jsp" %>
<b><c:out value="${message}" default="No further information was provided."/></b>
<a href="<c:url value='/normal/list.do'/>">일반판매 리스트로 돌아가기</a>&nbsp;&nbsp;