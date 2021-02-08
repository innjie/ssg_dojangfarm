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
<title>주소 추가</title>
</head>
<body>
	<%@ include file="../IncludeTop.jsp" %>
<div id="page">
		<div id="content">
		<div class = "post">
	<form:form modelAttribute="addressCommand" >
		
		<form:label path="aName">주소 이름 </form:label>
		<form:input path="aName" />
		<form:errors path="aName" />
		<br>
		
		<form:label path="zip">우편번호 </form:label>
		<form:input path="zip" />
		<form:errors path="zip" />
		<br>
		
		<form:label path="addr">주소 </form:label>
		<form:input path="addr" />
		<form:errors path="addr" />
		<br>
		
		<form:label path="detail">상세 </form:label>
		<form:input path="detail" />
		<form:errors path="detail" />
		<br><br>
		
		<input type="submit" value="추가" />
		&nbsp;&nbsp;
		<a href="<c:url value='/address/getAddressList.do' />">이전</a>
		
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