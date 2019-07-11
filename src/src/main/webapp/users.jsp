<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Users</title>
</head>
<body>

<div align="left">
    <button onclick="location.href='/registration'"> Add user</button>
    <table border="1">
        <tr>
            <th>Email</th>
            <th>Password</th>
        </tr>
        <c:forEach var="user" items="${allUsers}">
            <tr>
                <td>${user.email}</td>
                <td>${user.password}</td>
                <td>
                    <form action="/users/edit" method="get">
                        <input type="hidden" name="userId" value="${user.getId}">
                        <button type="submit">edit</button>
                    </form>
                </td>
                <td>
                    <form action="/users/delete" method="get">
                        <input type="hidden" name="userId" value="${user.getId}">
                        <button type="submit">delete</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>

    <form action="products.jsp" method="get">
        <input type="submit" value="Products list">
    </form>

    <br>
    <form action="index.jsp">
        <input type="submit" value="Back to main page">
    </form>

</div>
</body>
</html>
