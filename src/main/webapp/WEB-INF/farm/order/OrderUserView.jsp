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
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<link href="../templated-vegetable/style.css" rel="stylesheet"
	type="text/css" media="screen" />
<title>주문자 리스트 보기</title>
</head>
<body>
<%@ include file="../IncludeTop.jsp" %>
<div id="page">
		<div id="content">
		<div class = "post">
	<table border="1">
		<tr>
			<td>주문번호</td>
			<td>수량</td>
			<td>주문자</td>
			<td>배송</td>
			<td>배송현황</td>
		</tr>
		<c:forEach var="order" items="${orderList.pageList}">
			<tr>
				<td><a
					href="<c:url value='/order/view.do'>
	<c:param name='orderNo' value='${order.orderNo }'/>
	</c:url>">${order.orderNo }</a>
				</td>
				<td>${order.quantity }</td>
				<td>${order.user.name }</td>
				<td>${order.delivery.dNo }</td>
				<c:if test="${order.delivery.status != '배송완료'}">
							<td>
								<a href="<c:url value='/delivery/turnStatus.do'>
											<c:param name='dNo'  value='${order.delivery.dNo }'/>
											<c:param name = 'status' value = '${order.delivery.status }'/>
											<c:param name = 'saleNo' value = '${order.saleNo}'/>
										</c:url>">
								${order.delivery.status } : 배송상태변경</a>
							</td>
						</c:if>
				<c:if test="${order.delivery.status == '배송완료'}">
							<td>
								${order.delivery.status }
							</td>
						</c:if>		
			
			</tr>
		</c:forEach>
	</table>
	<c:if test="${!orderList.firstPage}">
    		<a href='<c:url value="/order/userView2.do">
        				<c:param name="page" value="previous"/>
        			</c:url>'>
        	Prev</a>
    	</c:if> 
    	<c:if test="${!orderList.lastPage}">
    		<a href='<c:url value="/order/userView2.do">
        				<c:param name="page" value="next"/>
        			</c:url>'>
        	Next</a>
    	</c:if>
	<!--  매핑 확인하고 수정 -->
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