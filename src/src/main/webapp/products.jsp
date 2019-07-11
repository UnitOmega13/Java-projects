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
<button onclick="location.href='/new_product'"> Add user</button>
<table border="1">
    <tr>
        <th>Login</th>
        <th>Password</th>
    </tr>
    <c:forEach items="${allProducts}" var="product">
        <tr>
            <td>${product.name}</td>
            <td>${product.description}</td>
            <td>${product.price}</td>
            <td>
                <form action="/product/edit" method="get">
                    <input type="hidden" name="productId" value="${product.id}">
                    <button type="submit">edit</button>
                </form>
            </td>
            <td>
                <form action="/product/delete" method="get">
                    <input type="hidden" name="productId" value="${product.id}">
                    <button type="submit">delete</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
<br>
<form action="users.jsp">
    <input type="submit" value="Users">
</form>
</body>
</html>
