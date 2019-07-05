<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>First Page</title>
</head>
<div align="center">
    <form action="${pageContext.request.contextPath}/users" method="get">
        Логин <input type="text"> <br>
        Пароль <input type="password"> <br>
        <input type="submit" value="Login">
    </form>
    <form action="/register" method="get">
        <input type="submit" value="Registration">
    </form>
</div>
</body>
</html>
