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
		<c:forEach var="q" items="${qnaList}" varStatus="status">
		<%-- 비밀글이 아니거나 자기 질문 나옴 , 판매자는 다 --%>
			<c:if test="${(q.secret == '0') ||(q.qUser.id == user.id) ||(q.aUser.id == user.id)}">
				<tr>
					<td>${status.count}</td>
					<td>${q.qUser.id}</td>
					<td>${q.qDate}</td>
					<td>
						<a href="<c:url value='/normal/viewQnAList.do'>
									<c:param name='ques' value='click' />
									<c:param name='saleNo' value='${q.normal.saleNo}' />
									<c:param name='quesNo' value='${q.qNo}' />
								</c:url>">
						${q.question}</a>
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
</body>
</html>