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

					var zip = responseJson[index].zip;
					var addr = responseJson[index].addr;
					var detail = responseJson[index].detail;
					
					//$("#result > ol").append("<li onClick=setAddress("+zip+",41,41);>");
					$("#result > ol").append("<li onClick=setAddress("+zip+",'"+addr+"','"+detail+"');>");
					$("#result > ol").append("ZIP: " + zip);
					$("#result > ol").append("<br>ADDR: " + addr);
					$("#result > ol").append("<br>DETAIL: " + detail);
					$("#result > ol").append("</li>");
				}	
			}		
	  	},
		error: function(){
			alert("내용을 입력하세요");
		}
	});
}

function setAddress(zip, addr, detail) {
	alert("select addr " + addr);
	
	$("#zip").val(zip);
	$("#addr").val(addr);
	$("#detail").val(detail);
	$("#result").html("");
};

function createAddress() {
	var reqUrl = "../rest/address/create";
	var address = {
			zip:$("#zip").val(),
			addr:$("#addr").val(),
			detail:$("#detail").val()
	};

	if(address.zip == 0){
		$("#result").html("우편번호를 입력하세요");
	}
	else if(address.addr == ""){
		$("#result").html("주소를 입력하세요");
	}
	else if(address.detail == ""){
		$("#result").html("상세주소를 입력하세요");
	}
	else{
		$.ajax({			
			type: "POST",
			url: reqUrl,
			contentType: "application/json",
			data: JSON.stringify(address),
			success: function(responseJson){	
				$("#result").text(responseJson);
		  	},
			error: function(){
				alert("내용을 입력하세요");
			}
		});
	}
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
		<br><br>
	
		<form:label path="zip">우편번호 </form:label>
		<form:input id="zip" path="zip" />
		&nbsp;&nbsp;<form:errors path="zip" /><br>
		<form:label path="addr">주소 </form:label>
		<form:input id="addr" path="addr" />
		&nbsp;&nbsp;<form:errors path="addr" /><br>
		<form:label path="detail">상세주소 </form:label>
		<form:input id="detail" path="detail" />			
		&nbsp;&nbsp;<form:errors path="detail" /><br>
 		<input type="button" value="찾기" onClick="searchAddress(${user.userNo})" />
		<input type="button" value="추가" onClick="createAddress()" />   		
		<br><br><br><br>
		 
		<input type="hidden" name="aNo" value="${auction.aNo}" />
    	<input type="image" src="../images/payment_icon_yellow_medium.png" />
	</form:form>
	<br><br>
	<div id="result"></div>
	<br><br>
	<a href="<c:url value='/auction/viewAuction.do'>
				<c:param name="aNo" value="${auction.aNo}" />
			</c:url>">
	이전</a>	
</body>
</html>