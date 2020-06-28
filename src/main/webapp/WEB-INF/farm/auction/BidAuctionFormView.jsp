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
<title>입찰</title>
<script type="text/javascript" src="../js/jquery-3.4.1.min.js"></script>
<script type="text/javascript">

function searchCard(userNo) {
	
	var reqUrl = "../rest/cardListBy/" + userNo;
	
	$.ajax({			
		type: "GET",
		url: reqUrl,
		contentType: "application/json",
		processData: false,
		success: function(responseJson){			
			var str = '';
			var index = 0;
			
			for(index = 0; index < responseJson.length; index++){
				if(index == 0){
					$("#result").html("<ol></ol>");
				}	
				
				$("#result > ol").append("<li>");
				$("#result > ol").append("CARDNO: " + responseJson[index].cardNo);
				$("#result > ol").append("<br>BANK: " + responseJson[index].bank);
				$("#result > ol").append("<br>TYPE: " + responseJson[index].type);
				$("#result > ol").append("<br>CARDPAYNO: " + responseJson[index].cardPayNo);
				$("#result > ol").append("</li>");
			}			
	  	},
		error: function(){
			alert("내용을 입력하세요");
		}
	});
	
}

function searchAddress(userNo) {

	var reqUrl = "../rest/addressListBy/" + userNo;
	
	$.ajax({			
		type: "GET",
		url: reqUrl,
		contentType: "application/json",
		processData: false,
		success: function(responseJson){			
			var str = '';
			var index = 0;
			
			for(index = 0; index < responseJson.length; index++){
				if(index == 0){
					$("#result").html("<ol></ol>");
				}	
				
				$("#result > ol").append("<li>");
				$("#result > ol").append("ADDRNO: " + responseJson[index].addrNo);
				$("#result > ol").append("<br>ADDR: " + responseJson[index].addr);
				$("#result > ol").append("<br>ZIP: " + responseJson[index].zip);
				$("#result > ol").append("<br>DETAIL: " + responseJson[index].detail);
				$("#result > ol").append("</li>");
			}			
	  	},
		error: function(){
			alert("내용을 입력하세요");
		}
	});
	
}
</script>
</head>
<body>
	<c:set var="targetUrl"><c:url value="/auction/bidAuction.do" /></c:set>
	
	<form:form id="form" modelAttribute="bidCommand" action="${targetUrl}">	
		제목  ${auction.title}<br>	
		품목  ${auction.product.pName}<br>	
		최소 가격   ${auction.minPrice}<br>
		현재 입찰 가격  ${auction.bidPrice}<br>
		기간  ${auction.deadline}<br>
		
		<form:label path="bidPrice">가격 </form:label>
		<form:input path="bidPrice" />
		<form:errors path="bidPrice" />
		<br>
		
		<form:label path="phone">전화번호 </form:label>
		<form:input path="phone" />
		<form:errors path="phone" />
		<br>
		
		<form:label path="cardNo">cardNo </form:label>
		<form:input path="cardNo" />
		<input type="button" value="Search!" onClick="searchCard(${user.userNo})" />
		<form:errors path="cardNo" />
		<br>
		
		<form:label path="addrNo">addrNo </form:label>
		<form:input path="addrNo" />
		<input type="button" value="Search!" onClick="searchAddress(${user.userNo})" />
		<form:errors path="addrNo" />
		<br>
		
		<input type="hidden" name="aNo" value="${auction.aNo}" />
		<input type="hidden" name="minPrice" value="${auction.minPrice}" />
		<input type="hidden" name="nowPrice" value="${auction.bidPrice}" />
		<input type="submit" value="추가" />&nbsp;&nbsp;
		<a href="<c:url value='/auction/viewAuction.do'>
					<c:param name="aNo" value="${auction.aNo}" />
				</c:url>">
		이전</a>	
		
	</form:form>
	<br><br>
	<div id="result"></div>
</body>
</html>