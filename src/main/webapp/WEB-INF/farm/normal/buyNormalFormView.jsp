<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<html>
<head>
<meta charset="UTF-8">
<title>일반판매 결제</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<link href="../templated-vegetable/style.css" rel="stylesheet"
	type="text/css" media="screen" />
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
<%@ include file="../IncludeTop.jsp" %>
<div id="page">
	<div id="content">
		<div class="post">
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
		<form:input path="cardNo" />
		<input type="button" value="Search!" onClick="searchCard(${user.userNo})" />
		<form:errors path="cardNo" />
		<br>
		
		<form:label path="addrNo">addrNo </form:label>
		<form:input path="addrNo" />
		<input type="button" value="Search!" onClick="searchAddress(${user.userNo})" />
		<form:errors path="addrNo" />
		<br><br>
		<form:hidden path = "saleNo" value = "${normal.saleNo }"/>
		<form:hidden path = "saleType" value = "Normal"/>
		<input type="submit" value="결제" />
	</form:form>
	<br>
	<div id="result"></div>
		</div>
		</div>
	<!-- end #sidebar -->
	<div style="clear: both;">&nbsp;</div>
</div>
<!-- end #page -->
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
<!-- end #footer -->
</body>
</html>