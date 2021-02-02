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
<title>일반판매 결제</title>
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
				$("#cardResult").empty();
				for(index = 0; index < responseJson.length; index++){
					$("#cardResult").append("<option>" + responseJson[index].cardNo + "</option>");
				}	
			}		
	  	},
	});
}

function searchAddress(userNo) {

	var reqUrl = "../rest/addressListBy/" + userNo;
	var selectedItem = $("#addrResult").val();
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
				$("#addrResult").empty();
				for(index = 0; index < responseJson.length; index++){
					$("#addrResult").append("<option>" + responseJson[index].addrNo + "</option>");
				}	
			}		
	  	},
	});
}

function selectedCard(userNo) {
	var reqUrl = "../rest/cardListBy/" + userNo;
	var selectedItem = $("#cardResult").val();
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
					if(responseJson[index].cardNo == selectedItem) {
						$("#selectedCard").html("<ol></ol>");
						$("#selectedCard").append("<li>");
						$("#selectedCard").append("CARDNO: " + responseJson[index].cardNo);
						$("#selectedCard").append("<br>BANK: " + responseJson[index].bank);
						$("#selectedCard").append("<br>TYPE: " + responseJson[index].type);
						$("#selectedCard").append("<br>CARDPAYNO: " + responseJson[index].cardPayNo);
						$("#selectedCard").append("</li>");
					}
				}	
			}		
	  	},
	});
}

function selectedAddress(userNo) {
	var reqUrl = "../rest/addressListBy/" + userNo;
	var selectedItem = $("#addrResult").val();
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
					if(responseJson[index].addrNo == selectedItem) {
						$("#selectedAddress").html("<ol></ol>");
						$("#selectedAddress").append("<li>");
						$("#selectedAddress").append("ADDRNO: " + responseJson[index].addrNo);
						$("#selectedAddress").append("<br>ADDR: " + responseJson[index].addr);
						$("#selectedAddress").append("<br>ZIP: " + responseJson[index].zip);
						$("#selectedAddress").append("<br>DETAIL: " + responseJson[index].detail);
						$("#selectedAddress").append("</li>");
					}
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
<%@ include file="../IncludeTop.jsp" %>
<c:set var="targetUrI">
		<c:url value="/normal/buyNormal.do" />
	</c:set>
	
	<form:form action = "${targetUrI }" commandName = "payment" method = "POST">
		제목 : ${normal.title }<br>
		가격 : ${normal.price}<br>
		품목 : ${normal.product.pName }<br>
		
		<form:label path = "quantity">수량 </form:label>
		<form:input path = "quantity"/>
		<form:errors path = "quantity"/>
		<br>

		<form:label path="phone">전화번호 </form:label>
		<form:input path="phone" />
		<form:errors path="phone" />
		<br>

		<form:label path="cardNo">cardNo </form:label>
		<form:select id = "cardResult" path = "cardNo" onchange="selectedCard(${user.userNo })">
		</form:select>
		<input type="button" value="Load my Card"
			onClick="searchCard(${user.userNo})" />
		<form:errors path="cardNo" />
		<br>
		
		<form:label path="addrNo">addrNo </form:label>
		<form:select id = "addrResult" path = "addrNo" onchange = "selectedAddress(${user.userNo })">
		</form:select>
		<input type="button" value="Load My Address"
			onClick="searchAddress(${user.userNo})" />
		<form:errors path="addrNo" />
		<br><br>
		<form:hidden path = "saleNo" value = "${normal.saleNo }"/>
		<form:hidden path = "saleType" value = "Normal"/>
		<input type="submit" value="결제" />
	</form:form>
	<br>
		<p> 선택한 카드</p>
<div id = "selectedCard"></div> <br>
<p> 선택한 배송지 </p>
<div id = "selectedAddress"></div> <br>
</body>
</html>