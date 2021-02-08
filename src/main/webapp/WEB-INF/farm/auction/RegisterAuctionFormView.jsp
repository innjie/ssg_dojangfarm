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
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<link href="../templated-vegetable/style.css" rel="stylesheet"
	type="text/css" media="screen" />
<title>경매 등록</title>
</head>
<body>
	<c:set var="targetUrl"><c:url value="/auction/registerAuction.do" /></c:set>
		<%@ include file="../IncludeTop.jsp" %>
<div id="page">
		<div id="content">
		<div class = "post">
	<form:form modelAttribute="auctionCommand" action="${targetUrl}" enctype="multipart/form-data">
		<form:label path="title">제목 </form:label>
		<form:input path="title" />
		<form:errors path="title" />
		<br>
		
		<form:label path="product.pName">품목 </form:label>
		<br>
		<form:radiobuttons path="product.pName" items="${pName}"/>
		<br>
		<form:errors path="product.pName" />
		<br>
		
		<form:label path="detail">상세 정보 </form:label>
		<form:textarea path="detail" />
		<form:errors path="detail" />
		<br>
		
		<form:label path="minPrice">최소 가격 </form:label>
		<form:input path="minPrice" />
		<form:errors path="minPrice" />
		<br>
		 
		<form:label path="deadline">기간 </form:label>
		<form:input path="deadline" />
		<form:errors path="deadline" />
		<br>*기간은 YYYY-MM-DD HH:mm포맷으로 입력해주세요
		<br><br>   
		
		<form:label path="imPurAva">즉시구매 가능 여부 </form:label>
		<form:checkbox path="imPurAva" />
		<form:errors path="imPurAva" />
		<br>
		
		<form:label path="imPurPrice">즉시구매 가격 </form:label>
		<form:input path="imPurPrice" />
		<form:errors path="imPurPrice" />
		<br>
				
		사진 <input type="file" name="image" value="${auctionCommand.image}" />
		<br><br>	
		
		<input type="submit" value="추가" />&nbsp;&nbsp;
		<a href="<c:url value='/auction/viewAuctionList.do' />">이전</a>
		
	</form:form>
			</div>
	</div>
	<div style="clear: both;">&nbsp;</div>
	</div>
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
</body>
</html>