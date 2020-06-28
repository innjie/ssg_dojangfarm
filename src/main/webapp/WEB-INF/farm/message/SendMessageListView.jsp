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
	<%@ include file="../IncludeTop.jsp" %>

	<a href="<c:url value='/message/viewSendMessageList.do' />">전송함</a>&nbsp;
	<a href="<c:url value='/message/viewReceiveMessageList.do' />">수신함</a>
	<br>
	<c:if test="${title != null}">
		검색어 : ${title}
	</c:if>
	<br>
	<table border="1">
		<tr>
			<td>순번</td>		<%-- not cardNo, not cardPayNo, just No --%>
			<td>받는사람</td>
			<c:if test="${find != null}">
				<td>보내는사람</td>
			</c:if>
			<td>제목</td>
			<td>날짜</td>
			<td>읽음</td>
		</tr>
		<c:if test="${find == null}">
			<c:forEach var="m" items="${sendMessageList.pageList}" varStatus="status">
				<c:if test="${m.rUser.id != user.id}">
					<tr>
						<td>${status.count}</td>	<%-- delete한거도 count될듯... --%>
						<td>${m.rUser.id}</td>
						<td>
							<a href="<c:url value='/message/viewMessage.do'>
										<c:param name='msgNo' value='${m.msgNo}' />
										<c:param name='type' value='send' />
									</c:url>">
							${m.title}</a>
						</td>
						<td>${m.sDate}</td>
						<td>${m.read}</td>
					</tr>
				</c:if>
			</c:forEach>
		</c:if>
		<c:if test="${find != null}">
			<c:forEach var="m" items="${findMessageList.pageList}" varStatus="status">
				<tr>
					<td>${status.count}</td>	<%-- delete한거도 count될듯... --%>
					<td>${m.rUser.id}</td>
					<td>${m.sUser.id}</td>
					<td>
						<a href="<c:url value='/message/viewMessage.do'>
									<c:param name='msgNo' value='${m.msgNo}' />
									<c:param name='type' value='send' />
								</c:url>">
						${m.title}</a>
					</td>
					<td>${m.sDate}</td>
					<td>${m.read}</td>
				</tr>
			</c:forEach>
		</c:if>
			
	</table>
	<br><br>
	<c:if test="${find == null}">
		<c:if test="${!sendMessageList.firstPage}">
    		<a href='<c:url value="/message/viewSendMessageList2.do">
        				<c:param name="page" value="previous"/>
        			</c:url>'>
        	Prev</a>
    	</c:if> 
    	<c:if test="${!sendMessageList.lastPage}">
    		<a href='<c:url value="/message/viewSendMessageList2.do">
        				<c:param name="page" value="next"/>
        			</c:url>'>
        	Next</a>
    	</c:if>
	</c:if>
	<c:if test="${find != null}">
		<c:if test="${!findMessageList.firstPage}">
    		<a href='<c:url value="/message/viewFindMessageList2.do">
        				<c:param name="page" value="previous"/>
        				<c:param name="title" value="${title}"/>
        			</c:url>'>
        	Prev</a>
    	</c:if> 
    	<c:if test="${!findMessageList.lastPage}">
    		<a href='<c:url value="/message/viewFindMessageList2.do">
        				<c:param name="page" value="next"/>
        				<c:param name="title" value="${title}"/>
        			</c:url>'>
        	Next</a>
    	</c:if>
	</c:if>
	<br><br>
	<form action="<c:url value="/message/findMessageList.do"/>">
		제목 <input type="text" name="title">&nbsp;
		<input type="submit" value="찾기">
	</form>
</body>
</html>