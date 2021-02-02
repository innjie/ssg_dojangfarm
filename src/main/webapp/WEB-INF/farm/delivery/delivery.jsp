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
<title>주문 상세 보기</title>
</head>
<body>
	<h3>배송지</h3>
	<form action="#">
		<h3>배송지 입력</h3>

		<label for="name">이름</label> <input type="text" placeholder="">
		<label for="country">지역</label> 
		<span>버튼</span> 
		<select name="" id="">
			<option value="">서울특별시</option>
			<option value="">경기도</option>
		</select> 
		<label for="address1">주소</label> <input type="text" placeholder="주소"> <input type="text" placeholder=""> 
		<label for="address2">상세주소</label> <input type="text" placeholder="상세주소"> 
		<label for="zip">우편번호</label> <input type="text" placeholder=""> 
		<label for="phone">전화번호</label> <input type="text" placeholder=""> 
		<label for="email">이메일</label> <input type="text" placeholder=""> 
		<label><input type="radio" name="optradio"> 주소지 등록 </label> 
		<label><input type="radio" name="optradio"> 내 주소지 사용 </label>
	</form>
</body>
</html>
