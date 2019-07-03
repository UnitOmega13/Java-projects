<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 04.07.2019
  Time: 0:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Entry</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/login" method="POST">
    Login: <input type="text" name="login"/>
    Password: <input type="password" name="password"/>
    <input type="submit" value="Login">
</form>

</body>
</html>
