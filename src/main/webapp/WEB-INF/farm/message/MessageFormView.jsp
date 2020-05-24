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
<title>메세지 보내기</title>
</head>
<body>
	<form action='<c:url value="/message/sendMsg.do"/>' method="post">
		받는사람&nbsp;
		<c:if test="${cMsg != null}">	<!-- first message -->
			${cMsg.rUser.id}<br>
		</c:if>
		<c:if test="${normal != null}">	<!-- reply message -->
			${normal.user.id}<br>
		</c:if>
		관련 상품&nbsp;
		<c:if test="${cMsg != null}">	<!-- first message -->
			${cMsg.normal.saleNo}<br>
		</c:if>
		<c:if test="${normal != null}">	<!-- reply message -->
			${normal.saleNo}<br>
		</c:if>
		제목&nbsp; 
		<input type="text" name="title" /><br>
		내용&nbsp; 
		<textarea name="content">
			<c:if test="${cMsg != null}">
				<br>
				re: ${cMsg.content}
			</c:if>
		</textarea>
		<br>
		
		<input type="hidden" name="cMsg" value="${cMsg}" />
		<input type="hidden" name="normal" value="${normal}" />
		<input type="submit" value="보내기" />	
	</form>
</body>
</html>