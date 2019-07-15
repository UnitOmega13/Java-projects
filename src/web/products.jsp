<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <tr>
        <th>Name</th>
        <th>Description</th>
        <th>Price</th>
    </tr>
    <c:forEach items="${allProducts}" var="product">
        <tr>
            <td>${product.name}</td>
            <td>${product.description}</td>
            <td>${product.price}</td>
            <td><a href="products/edit?id=${product.id}">Update</a></td>
            <td><a href="products/delete?id=${product.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<br>
<form action="users.jsp">
    <input type="submit" value="Users">
</form>
</body>
</html>
