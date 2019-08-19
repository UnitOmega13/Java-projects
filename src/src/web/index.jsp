<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>First Page</title>
</head>
<form action="/users" method="get">
    Логин <input type="text" name="login"> <br>
    Пароль <input type="password" name="password"> <br>
    <input type="submit" value="Login">
</form>

<form action="/registration" method="get">
    <input type="submit" value="Registration">
</form>
</div>
</body>
</html>
