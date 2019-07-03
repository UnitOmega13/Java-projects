<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 04.07.2019
  Time: 0:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Registration</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/registration" method="POST">
    Login: <input type="text" name="login"/>
    Password: <input type="password" name="password"/>
    Password repeat: <input type="password" name="passwordRepeat"/>
    <input type="submit" value="Registration">
</form>

</body>
</html>
