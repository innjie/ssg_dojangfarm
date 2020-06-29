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

			if(responseJson.length == 0){
				alert("저장된 주소가 없습니다. 주소를 먼저 추가해주세요.\n마이페이지-회원정보-나의주소록-주소추가");
			}
			else{
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
	<c:set var="targetUrl"><c:url value="/auction/immePurchaseKaKao.do" /></c:set>
	
	<form:form id="form" modelAttribute="imPurCommand" action="${targetUrl}">	
		제목  ${auction.title}<br>	
		품목  ${auction.product.pName}<br>	
		가격   ${auction.imPurPrice}<br>
		기간  ${auction.sDeadline}<br><br><br>
	
		<form:label path="phone">전화번호 </form:label>
		<form:input path="phone" />
		<form:errors path="phone" />
		<br>
	
		<form:label path="addrNo">addrNo </form:label>
		<form:input path="addrNo" />
		<input type="button" value="Search!" onClick="searchAddress(${user.userNo})" />
		<form:errors path="addrNo" />
		<br><br>
		 
		<input type="hidden" name="aNo" value="${auction.aNo}" />
    	<input type="image" src="../images/payment_icon_yellow_medium.png" />
	</form:form>
	<br>
	<a href="<c:url value='/auction/viewAuction.do'>
				<c:param name="aNo" value="${auction.aNo}" />
			</c:url>">
	이전</a>	
	<br><br>
	<div id="result"></div>
</body>
</html>