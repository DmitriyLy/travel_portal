<%@ taglib uri="http://www.springframework.org/security/tags"
           prefix="security"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <meta charset="UTF-8">
    <title>Home</title>
</head>
<body>
<jsp:include page="_menu.jsp"/>

<h2>Home Page</h2>

<c:if test="${empty pageContext.request.userPrincipal.name}">
    Click to 'User Info' to show user info (It will redirect to login page)
</c:if>
</body>
</html>
