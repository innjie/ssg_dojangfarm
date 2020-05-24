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
<title>보낸 메세지</title>
</head>
<body>
	<a href="<c:url value='/message/viewSendMessageList.do' />">전송함</a>&nbsp;
	<a href="<c:url value='/message/viewReceiveMessageList.do' />">수신함</a>
	<br><br>
	<table border="1">
		<tr>
			<td>순번</td>		<%-- not cardNo, not cardPayNo, just No --%>
			<td>받는사람</td>
			<td>제목</td>
			<td>날짜</td>
			<td>읽음</td>
		</tr>
		<c:forEach var="m" items="${messageList}" varStatus="status">
			<c:if test="${m.deleteState == false}">
				<tr>
					<td>${status.count}</td>	<%-- delete한거도 count될듯... --%>
					<td>${m.rUser.id}</td>
					<td>
						<a href="<c:url value='/message/viewMessage.do'>
									<c:param name='msgNo' value='${m.msgNo}' />
								</c:url>">
						$m.title}</a>
					</td>
					<td>${m.sDate}</td>
					<td>${m.read}</td>
				</tr>
			</c:if>
		</c:forEach>
	</table>
	<br><br>
	<form action="<c:url value="/message/findMessageList.do"/>">
		제목 <input type="text" name="title">&nbsp;
		<input type="hidden" name="type" value="send">
		<input type="submit" value="찾기">
	</form>
</body>
</html>