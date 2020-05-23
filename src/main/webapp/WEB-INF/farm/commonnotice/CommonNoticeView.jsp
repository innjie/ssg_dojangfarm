<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공동구매 공지 보기</title>
</head>
<body>
	<table>
		<tr>
			<td>${commonNotice.title}</td>
			<td>${commonNotice.user.name}</td>
		</tr>

		<tr colspan="2">
			<td>${commonNotice.info }</td>
		</tr>
	</table>
	<a href="CommonNoticeListView">[이전 단계로]</a> 
</body>
</html>