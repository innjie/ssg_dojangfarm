<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�������� ����</title>
</head>
<body>
 <table border="1" width="600" height="800">
	<tr>
	<td  colspan="4">${common.title }</td>
	</tr>

	<tr >
	<td rowspan="4">����</td>
	</tr>
	
	<tr>
	<td>ǰ��</td>
	<td>${common.product.pName }</td>
	<td>����</td>
	<td>${ common.price}</td>
	</tr>
	
	<tr>
	<td>�ּ��ο�</td>
	<td>${common.min }</td>
	<td>�����Ͻ�</td>
	<td>${common.daedline }</td>
	</tr>

	<tr>
	<td colspan="4">${common.info }</td>
	</tr>
</table>
<a href="CommonListView" >[���� �ܰ��]</a>
<!-- <c:if test="${(common.state== \"�Ǹ���\") && (session.id != common.user.id)}"> 
��� ¥������... syntex error �߻��� --> 
<input type="button" value="��û"/>	

</body>
</html>