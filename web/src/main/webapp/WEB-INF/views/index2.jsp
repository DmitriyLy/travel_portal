<%@ taglib uri="http://www.springframework.org/security/tags"
           prefix="security"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home</title>
</head>
<body>
<jsp:include page="_menu.jsp"/>

<h2>Misha cool!!</h2>

<spring:url value="/labels/1/attachments" var="uploadUrl"/>
<form method="POST" enctype="multipart/form-data" action="${uploadUrl}">
    File to upload: <input type="file" name="attach"><br />
    <input type="submit" value="Upload"> Press here to upload the file!
</form>
<img src="${contextPath}/resources/upload/Screenshot from 2016-11-13 14-47-34.png">


<c:if test="${empty pageContext.request.userPrincipal.name}">
    Click to 'User Info' to show user info (It will redirect to login page)
</c:if>
</body>
</html>
