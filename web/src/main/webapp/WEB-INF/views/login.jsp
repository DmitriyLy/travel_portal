<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
</head>
<body>
<jsp:include page="_menu.jsp" />


<h2>Social Login</h2>

<a href="${pageContext.request.contextPath}/auth/facebook">Face
    Book</a>
<br />
<a href="${pageContext.request.contextPath}/auth/google">Google</a>
<br />

</body>
</html>