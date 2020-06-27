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
<title>Q&A</title>
</head>
<body>
	<%@ include file="../IncludeTop.jsp" %>

	<%-- post일 때 질문 등록하게.. --%>
	<form action="<c:url value="/normal/questionQnA.do"/>">
		<input type="checkbox" name="secret" value="true">비밀글&nbsp;
		<textarea name="question"></textarea>&nbsp;&nbsp;
		<input type="hidden" name="saleNo" value="${saleNo}">
		<input type="submit" value="질문하기">
	</form>
	<br>
	<c:if test="${message} != null">
		${message}<br><br>
	</c:if>
	<br>
	<table border="1">
		<tr>
			<td>순번</td>		<%-- not cardNo, not cardPayNo, just No --%>
			<td>작성자</td>
			<td>작성일</td>
			<td>질문</td>
		</tr>
		<c:forEach var="q" items="${qnaList.pageList}" varStatus="status">
		<%-- 비밀글이 아니거나 자기 질문 나옴 , 판매자는 다 --%>
			<c:if test="${(q.secret == '0') ||(q.qUser.id == user.id) ||(q.aUser.id == user.id)}">
				<tr>
					<td>${status.count}</td>
					<td>${q.qUser.id}</td>
					<td>${q.qDate}</td>
					<td>
						<c:if test="${q.answer != null}">
							<a href="<c:url value='/normal/viewQnAList2.do'>
										<c:param name='ques' value='click' />
										<c:param name='saleNo' value='${q.normal.saleNo}' />
										<c:param name='quesNo' value='${q.qNo}' />
									</c:url>">
							${q.question}</a>
						</c:if>
						<c:if test="${q.answer == null}">
							${q.question}
						</c:if>
					</td>
					<%-- 질문 클릭하면 해당 질문 답변 나옴 --%>
					<c:if test="${(ques == 'click') && (quesNo == q.qNo) }">
						<tr>
							<td>답변</td>
							<td colspan="3">${q.answer}</td>
						<tr>
					</c:if>
					<%-- 답변 없고 판매자면 답변 버튼 생김 --%>
					<c:if test="${(q.answer == NULL) && (user.id == q.aUser.id) }">
						<td>
							<a href="<c:url value='/normal/answerQnA.do'>
										<c:param name='saleNo' value='${q.normal.saleNo}' />
										<c:param name='qNo' value='${q.qNo}' />
									</c:url>">
							답변</a>
						</td>
					</c:if>
				</tr>
			</c:if>
		</c:forEach>
	</table>
	<br><br>
	<c:if test="${!qnaList.firstPage}">
    	<a href='<c:url value="/normal/viewQnAList2.do">
        			<c:param name="page" value="previous"/>
        			<c:param name="saleNo" value="${saleNo}"/>
        		</c:url>'>
        Prev</a>
    </c:if> 
    <c:if test="${!qnaList.lastPage}">
    	<a href='<c:url value="/normal/viewQnAList2.do">
        			<c:param name="page" value="next"/>
        			<c:param name="saleNo" value="${saleNo}"/>
        		</c:url>'>
        Next</a>
    </c:if>&nbsp;&nbsp;
    <a href="<c:url value='/normal/viewNormal.do'>
				<c:param name="saleNo" value="${saleNo}" />
			</c:url>">
	이전</a>
</body>
</html>