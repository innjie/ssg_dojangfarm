<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="../IncludeTop.jsp" %>
<head>
<title>Error!</title>
</head>
<body>
<h3><font color="red">Error!</font></h3>

<b><c:out value="${message}" default="No further information was provided."/></b>
</body>