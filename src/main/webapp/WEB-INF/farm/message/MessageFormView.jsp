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
	<form:form modelAttribute="message" action='<c:url value="/message/sendMsg.do"/>'>
		<form:label path="rUser.id">받는사람 </form:label>
		${rUser.id}
		<br>
		
		<form:label path="normal.saleNo">관련 상품 </form:label>
		${normal.saleNo}
		<br>
		
		<form:label path="title">제목 </form:label>
		<form:input path="title" />
		<form:errors path="title" />
		<br>
		
		<form:label path="content">내용 </form:label>
		<c:if test="${cMsg != null}">
			<br>
			re: ${cMsg.content}
		</c:if>
		<br>
		<form:textarea path="content" />
		<form:errors path="content" />
		<br>
		
		<form:hidden path="cMsg" />
		<form:hidden path="normal.saleNo" />
		<form:hidden path="rUser.userNo" />
		<input type="submit" value="추가" />
		
	</form:form>
</body>
</html>