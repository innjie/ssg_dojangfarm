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

function addAddress() {

	var reqUrl = "../rest/address";
	var form = document.getElementById("form");
	var address = {
			'addr':form.addr.value, 
			'detail':form.detail.value, 
			'zip':form.zip.value
	};
		
	$.ajax({			
		type: "POST",
		url: reqUrl,
		contentType: "application/json",
		processData: false,
		data: JSON.stringify(address),
		success: function(responseJson){			
			//$("#detail").html("<ul></ul>");
			//$("#detail > ul").append("<li>addr: " + responseJson.addr + "</li>");
			//$("#detail > ul").append("<li>detail: " + responseJson.detail + "</li>");
			//$("#detail > ul").append("<li>zip: " + responseJson.zip + "</li>");
			alert("Success Add New Address");		
	  	},
		error: function(){
			alert("제대로 입력하세요");
		}
	});
}


</script>
</head>
<body>
	<c:set var="targetUrl"><c:url value="/auction/immePurchaseKaKao.do" /></c:set>
	
	<form:form modelAttribute="imPurCommand" action="${targetUrl}">	
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
	<br><br>
	<form id="form">
		주소<input type="text" name="addr">
		상세주소<input type="text" name="detail">
		우편번호<input type="text" name="zip">
		<input type="button" value="주소등록" onClick="addAddress()" />
	</form>
	<br><br>
	<div id="result"></div>
	<br><br>
	<a href="<c:url value='/auction/viewAuction.do'>
				<c:param name="aNo" value="${auction.aNo}" />
			</c:url>">
	이전</a>	
</body>
</html>