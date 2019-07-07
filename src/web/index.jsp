<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>First Page</title>
</head>
<div align="center">
    <form action="${pageContext.request.contextPath}/users" method="get">
        Login <input type="text"> <br>
        Password <input type="password"> <br>
        <input type="submit" value="Login">
    </form>
</div>
</body>
</html>
