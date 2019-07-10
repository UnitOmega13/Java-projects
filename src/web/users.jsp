<%@ page import="model.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="factories.UserServiceFactory" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Users</title>
</head>
<body>

<div align="left">
    <table border="1">
        <tr>
            <th>Login</th>
            <th>Password</th>
        </tr>
        <c:forEach items="${allUsers}" var="user">
            <tr>
                <td>${user.login}</td>
                <td>${user.password}</td>
                <td><a href="users/edit?id=${user.id}">Update</a></td>
                <td><a href="users/delete?id=${user.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>

    <form action="/products" method="get">
        <input type="submit" value="Products list">
    </form>

    <br>
    <form action="index.jsp">
        <input type="submit" value="Back to main page">
    </form>

</div>
</body>
</html>
