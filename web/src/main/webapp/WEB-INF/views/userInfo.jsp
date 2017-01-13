<%@ taglib uri="http://www.springframework.org/security/tags"
           prefix="security"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <meta charset="UTF-8">
    <title>User Info</title>
</head>
<body>
<jsp:include page="_menu.jsp" />

<h1>User Info Page</h1>
<h3>Welcome : ${pageContext.request.userPrincipal.name}</h3>
<a href="${pageContext.request.contextPath}/logout">Logout</a>


</body>
</html>
