<%@ page import="model.Product" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.List" %>
<%@ page import="factories.ProductServiceFactory" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <tr>
        <th>Login</th>
        <th>Password</th>
    </tr>
    <c:forEach items="${allProducts}" var="user">
        <tr>
            <td>${user.login}</td>
            <td>${user.password}</td>
            <td><a href="users/edit?id=${user.id}">Update</a></td>
            <td><a href="users/delete?id=${user.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<br>
<form action="users.jsp">
    <input type="submit" value="Users">
</form>
</body>
</html>
