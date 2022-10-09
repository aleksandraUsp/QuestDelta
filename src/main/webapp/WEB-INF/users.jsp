<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@include file="/header-icons.html"%>
<html>
<head>
    <title>Users</title>
</head>

<body>
<ul>
<c:forEach var="user" items="${requestScope.users}">
    <li>
        <img src="images/${user.image}" width="100" alt="${user.image}">
            ${user.role}:<a href="user?id=${user.id}">${user.login}</a>
    </li>
    <br>
</c:forEach>
    <li><a href="user?id=0">Creat new user</a></li>
</ul>
<%@include file="/footer.html"%>
</body>
</html>
