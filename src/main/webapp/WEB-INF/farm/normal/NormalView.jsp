<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<link href="../templated-vegetable/style.css" rel="stylesheet"
	type="text/css" media="screen" />
<title>등록한 상품 보기</title>
</head>
<body>
<%@ include file="../IncludeTop.jsp" %>
<div id="page">
		<div id="content">
		<div class = "post">
 <table border="1" >
 	<tr> <td colspan="3">제목</td></tr>
	<tr>
	<td  colspan="3">${normal.title }</td>
	</tr>

	<tr >
	<td rowspan="3" colspan = "1"><img src = "../${normal.image }"/></td>
	<td>판매상태</td>
	<td>${normal.saleState }</td>
	</tr>
	
	<tr >
	<td>수량</td>
	<td>${normal.count }</td>
	</tr>
	
	<tr>
	<td>가격</td>
	<td>${ normal.price}</td>
	</tr>	
</table>
<br>
	
	<a href="<c:url value='/normal/viewNormal.do'> 
				<c:param name='saleNo' value='${normal.saleNo}'/>
			</c:url>">설명</a>&nbsp;&nbsp;
	<a href="<c:url value='/normal/viewQnAList.do'>
				<c:param name='saleNo' value='${normal.saleNo}'/>
				<c:param name="qnaMenu" value="click" />
			</c:url>">Q&A</a>
	<br>
			
	<c:if test="${qnaMenu != 'click'}"> 
		${normal.info}
	</c:if> 
	
	<c:if test="${qnaMenu == 'click'}"> 
		<%-- post일 때 질문 등록하게.. --%>
		<form action="<c:url value="/normal/questionQnA.do"/>">
			<input type="checkbox" name="secret" value="true">비밀글&nbsp;
			<textarea name="question"></textarea>&nbsp;&nbsp;
			<input type="hidden" name="saleNo" value="${qna.normal.saleNo}">
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
							${q.answer}
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
	</c:if> 
	
	<br><br>

	<c:if test="${ (loginUser.userNo == normal.user.userNo)}">
	<a href = "<c:url value ='/normal/updateNormal.do' > 
	<c:param name = 'saleNo'  value = '${normal.saleNo}'/></c:url> ">수정하기</a><br>
	<a href = "<c:url value = '/normal/turnState.do'>
					<c:param name = 'saleNo' value = '${normal.saleNo}'/></c:url>"> 판매 상태 변경  </a> <br>
	<a href = "<c:url value = '/order/userView.do'>
	<c:param name = 'saleNo' value = '${normal.saleNo}'/> </c:url> "> 주문자 내역 보기 </a> <br>
	</c:if>
	<c:if test="${ (loginUser.userNo != normal.user.userNo)}">
	<a href = "<c:url value ='/normal/buyNormal.do' > 
	<c:param name = 'saleNo'  value = '${normal.saleNo}'/></c:url> ">장바구니</a><br>
	</c:if>
	<br>
	<c:if test="${user.id != normal.user.id}">
		<a href="<c:url value='/message/sendMsg.do'>
					<c:param name='saleNo' value='${normal.saleNo}' />
				</c:url>">
		쪽지보내기</a>
	</c:if>
	<br><br>
	
	</div>
	</div>
	<div style="clear: both;">&nbsp;</div>
	</div>
	<div id="footer-menu">
	<ul>
		<li class="current_page_item"><a href="#">Homepage</a></li>
		<li><a href="#">Blog</a></li>
		<li><a href="#">Photos</a></li>
		<li><a href="#">About</a></li>
		<li><a href="#">Contact</a></li>
	</ul>
</div>
<div id="footer">
	<p>&copy; Untitled. All rights reserved. Design by <a href="http://templated.co" rel="nofollow">TEMPLATED</a>.</p>
</div>
</body>
</html>