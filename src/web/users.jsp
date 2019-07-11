<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
<div style="text-align: center">
    ${accessDenied}
    <p>
        <button onclick="location.href='/users/add'"> New user</button>
        <button onclick="location.href='/products'"> Products</button>
    </p>
    <table align="center" border="1">
        <tr>
            <th>Login</th>
            <th>Email</th>
            <th>Password</th>
        </tr>
        <c:forEach var="user" items="${userList}">
            <tr>
                <td>${user.login}</td>
                <td>${user.email}</td>
                <td>${user.password}</td>
                <td>${user.accessRole}</td>
                <td>
                    <form action="/users/edit" method="get">
                        <input type="hidden" name="userId" value="${user.id}">
                        <button type="submit">edit</button>
                    </form>
                </td>
                <td>
                    <form action="/users/delete" method="get">
                        <input type="hidden" name="userId" value="${user.id}">
                        <button type="submit">delete</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
