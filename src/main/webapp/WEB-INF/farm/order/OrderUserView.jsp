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
<title>주문자 리스트 보기</title>
</head>
<body>
<%@ include file="../IncludeTop.jsp" %>
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
				<c:if test = "${ order.delivery.status == '배송전'}">
				<td><a href="<c:url value='/delivery/turnStatus.do'> 
						<c:param name='dNo' value='${order.delivery.dNo }'/>
						</c:url>">배송전 : 배송변경하기</a>
				</td>
				</c:if>
				<c:if test = "${order.delivery.status == '배송중' }">
				<td>배송 중 </td>
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
	
</body>
</html>