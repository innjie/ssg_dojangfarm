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

			if(responseJson.length == 0){
				alert("저장된 카드가 없습니다. 카드를 먼저 추가해주세요.\n마이페이지-회원정보-나의카드-카드추가");
			}
			else{
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
	<c:set var="targetUrl"><c:url value="/auction/bidAuction.do" /></c:set>
	
	<form:form id="form" modelAttribute="bidCommand" action="${targetUrl}">	
		제목  ${auction.title}<br>	
		품목  ${auction.product.pName}<br>	
		최소 가격   ${auction.minPrice}<br>
		현재 입찰 가격  ${auction.bidPrice}<br>
		기간  ${auction.sDeadline}<br><br><br>
		
		<form:label path="bidPrice">가격 </form:label>
		<form:input path="bidPrice" />
		<form:errors path="bidPrice" />
		<br><br>
		
		<form:label path="phone">전화번호 </form:label>
		<form:input path="phone" />
		<form:errors path="phone" />
		<br><br>
		
  		<form:label path="cardNo">cardNo </form:label>
		<form:input path="cardNo" />
		<input type="button" value="Search!" onClick="searchCard(${user.userNo})" />
		<form:errors path="cardNo" />
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
		<input type="hidden" name="minPrice" value="${auction.minPrice}" />
		<input type="hidden" name="nowPrice" value="${auction.bidPrice}" />
		<input type="submit" value="입찰" />
		<br><br>
		<a href="<c:url value='/auction/viewAuction.do'> 
					<c:param name="aNo" value="${auction.aNo}" />
				</c:url>">
		이전</a>	
		
	</form:form>
	<br><br>
	<div id="result"></div>
</body>
</html>