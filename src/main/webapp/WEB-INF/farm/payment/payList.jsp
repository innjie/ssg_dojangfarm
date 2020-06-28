<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="product_group">
		<ul class="goods_group_list">
			<li id="" class="goods_pay_item">
				<div class="goods_item">
					<a href="" class="goods_img">
						<img src="" width="60" height="60" alt=" ">
					</a>
					<div class="goods_info">
						<a class="goods" href="">
							<p class="name">상품명 : </p>
							<ul class="info">
								<li>상품금액 : 원</li>
								<li class="date">상품구매날짜 . . .
								</li>
							</ul>
						</a> 
						<span class="state">결제완료</span>
						<p class="notify1">
							<b>결제 및 상세 내역 확인 및 취소요청은 <a href="" class="link"></a>에서 확인하실 수 있습니다.</b>
						</p>
						<p class="notify2">구매가 완료되었습니다. 이용해주셔서 감사합니다.</p>
					</div>
				</div>
				<div class="seller_info">
					<span class="seller"> </span> <a href="" class="qna_btn" target="_blank">문의하기</a>
				</div>
			</li>
		</ul>
	</div>
	<div class="viewmore" id="moreButton">
		<button type="button" class="viewmore_btn">
			<span>더보기</span>
		</button>
	</div>
</body>
</html>