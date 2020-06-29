<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문 상세 보기</title>
<script>
$(document).ready(function() {
   var quantitiy = 0;
   $('.오른쪽').click(function(e) {
      e.preventDefault();
      var quantity = parseInt($('#quantity').val());
      $('#quantity').val(quantity + 1);
   });
   $('.왼쪽').click(function(e) {
      e.preventDefault();
      var quantity = parseInt($('#quantity').val());
      if (quantity > 0) {
         $('#quantity').val(quantity - 1);
      }
   });
});
</script>
</head>
<body>
	<table border="1" width="600" height="800">
		<thead>
			<tr>
				<th>&nbsp;</th>
				<th>&nbsp;</th>
				<th>제품 이름</th>
				<th>가격</th>
				<th>수량</th>
				<th>총 금액</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="product" items="${productList}">
				<tr>
					<td><a href="#">삭제버튼</a></td>
					<td><div class="img"
							style="background-image: url(images/사진명.png);"></div></td>
					<td class="product-name">
						<h3>${product.제품 이름1}</h3>
						<p>${product.제품 설명}</p>
					</td>
					<td class="price">${product.가격}</td>
					<td class="quantity"><input type="text" name="quantity"
						value="1" min="1" max="100"></td>
					<td class="total">${product.총금액}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<h3>결제 금액</h3>
	<p>
		<span>물품 총액</span> <span>가격</span>
	</p>
	<p>
		<span>배송비</span> <span>가격</span>
	</p>
	<p>
		<span>할인</span> <span>가격</span>
	</p>
	<hr>
	<p>
		<span>총 금액</span> <span>가격</span>
	</p>

</body>
</html>