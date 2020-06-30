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
<title>공동구매 참여</title>
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
	<%@ include file="../IncludeTop.jsp"%>
	<h2>${common.title }신청 폼</h2>

	<c:set var="targetUrI">
		<c:url value="/commonjoin/join.do" />
	</c:set>
	<form:form action=' ${targetUrI }' commandName="cjCommand"
		method="POST">

		<form:label path="common.saleNo">상품번호</form:label>
		<form:input path="common.saleNo" value="${common.saleNo }"
			readonly="true" />
		<form:errors path="common.saleNo" />
		<br>


		<form:label path="count">개수</form:label>
		<form:input path="count" />
		<form:errors path="count" />
		<br>
		<form:label path="phone">전화번호 </form:label>
		<form:input path="phone" />
		<form:errors path="phone" />
		<br>

		<form:label path="cardNo">cardNo </form:label>
		<form:input path="cardNo" />
		<input type="button" value="Search!"
			onClick="searchCard(${user.userNo})" />
		<form:errors path="cardNo" />
		<br>

		<form:label path="addrNo">addrNo </form:label>
		<form:input path="addrNo" />
		<input type="button" value="Search!"
			onClick="searchAddress(${user.userNo})" />
		<form:errors path="addrNo" />
		<br>
		<br>
		<form:hidden path="common.saleNo" value="${common.saleNo }" />
		<form:hidden path="common.saleType" value="Common" />
		
		<input type="submit" value="추가" />
	</form:form>
<div id="result"></div>
</body>
</html>