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
<title>경매 리스트</title>

<script type="text/javascript" src="../js/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
function search() {
	 
	var form = document.getElementById("form");
	var condition = {
		type: form.type.value, 
		text: form.text.value
	} 	
	//var	jsonStr = JSON.stringify(messages);
	var reqUrl = (condition.type == "title") ? ("../rest/auctionListBy/title/" + condition.text) : ("../rest/auctionListBy/product/" + condition.text);
	alert(reqUrl);
	
	$.ajax({			
		type: "GET",
		//url: (condition.type == "title") ? "/rest/auctionListBy/title/" + condition.text : "/rest/auctionListBy/product/" + condition.text, 
		//url: "rest/auctionListBy/title/수박",
		url: reqUrl,
		contentType: "application/json",
		processData: false,
		success: function(responseJson){
			for(i = 0; i < responseJson.length; i++){
				$("#result").html("<ul></ul>");

	
				$("#result > ul").append("<li>Auction Title: " + responseJson[i].title + "</li>");
				$("#result > ul").append("<li>Auction pName: " + responseJson[i].product.pName + "</li>");
				$("#result > ul").append("<li>Auction minPrice: " + responseJson[i].minPrice + "</li>");
				$("#result > ul").append("<br>");

				
			}
	  	},
		error: function(){
			alert("내용을 입력하세요");
		}
	});
	
}

function getAuction(aNo) {
	var reqUrl = "../rest/auctionBy/" + aNo;

	alert("select auction No" + aNo);
	
	$.ajax({
		type: "GET",
		url: reqUrl,
		processData: false,
		success: function(responseJson){	// object parsed from JSON text	
			$("#detail").html("<ul></ul>");
			$("#detail > ul").append("<li>Auction Title: " + responseJson.title + "</li>");
			$("#detail > ul").append("<li>Auction pName: " + responseJson.product.pName + "</li>");
			$("#detail > ul").append("<li>Auction minPrice: " + responseJson.minPrice + "</li>");
			$("#detail > ul").append("<li>Auction bidPrice: " + responseJson.bidPrice + "</li>");
			if(responseJson.imPurAva){
				$("#detail > ul").append("<li>Auction imPurPrice: " + responseJson.imPurPrice + "</li>");
			}
			$("#detail > ul").append("<li>Auction rDate: " + responseJson.rDate + "</li>");
			$("#detail > ul").append("<li>Auction detail: " + responseJson.detail + "</li>");
		},
		error: function(){
			alert("ERROR", arguments);
		}
	});
};
</script>
</head>
<body>
	<table>
		<tr>
			<td>
				<div id="detail"></div>
			</td>
		</tr>
	</table>

	<a href="<c:url value='/auction/registerAuctionForm.do' />">경매 추가</a>
	<br><br>
	<table border="1">
		<tr>
			<td>순번</td>
			<td>제목</td>
			<td>최소 가격</td>
			<td>입찰 가격</td>
			<td>즉시구매 가격</td>
			<td>기간</td>
		</tr>
		<c:forEach var="auc" items="${auctionList}" varStatus="status">
			<c:if test="${auc.finish != true}">
				<tr>
					<td onClick="getAuction(${auc.aNo});">${status.count}</td>
					<td>
						<a href="<c:url value='/auction/viewAuction.do'>
									<c:param name='aNo' value='${auc.aNo}' />
								</c:url>">
						${auc.title}</a>
					</td>
					<td>${auc.minPrice}</td>
					<td>
						<c:if test="${auc.bidPrice != 0}">
							${auc.bidPrice}
						</c:if>
					</td>
					<td>${auc.imPurPrice}</td>
					<td>${auc.deadline}</td>						
				</tr>
			</c:if>
		</c:forEach>
	</table>
	<br><br>
	<form id="form" action="<c:url value="/auction/findAuctionList.do"/>">	<%-- 컨트롤러에서 type에 따라 다른 dao 사용 --%>
		<select name="type">
			<option value="title">제목</option>
			<option value="pName">품목</option>
		</select>
		<input type="text" name="text">&nbsp;	<%-- text - title or pName --%>
		<input type="submit" value="찾기">
		<input type="button" value="Search!" onClick="search()" /><br>
	</form>
	<br><br>
	<table>
		<tr>
			<td>
				<div id="result"></div>
			</td>
		</tr>
	</table>
</body>
</html>