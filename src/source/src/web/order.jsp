<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Products in cart</title>
</head>
<body>
<form method="post">
    <h4>${code}</h4>
    <p>Delivery address<input name="address" type="text" value="${address}"></p>
    <p>Validation code<input name="code" type="text"></p>
    <p>
        <input type="submit" value="Get code" formaction="/buy/code">
        <input type="submit" value="Submit" formaction="/buy/order">
        <%--        make Submit hidden while getcode not prest or Submit is correct--%>
    </p>
</form>
<table align="center" border="1">
    <tr>
        <th>Name</th>
        <th>Price</th>
        <th>Quantity</th>
        <th>Sum</th>
    </tr>
    <c:forEach var="product" items="${productList}" varStatus="loop">
        <tr>
            <td>${product.product.name}</td>
            <td>${product.product.price}</td>
            <td>${product.amount}</td>
            <td>${product.sum}</td>
            <td>
                <form action="/product/buy" method="post">
                    <input type="hidden" name="productIndex" value="${loop.count}">
                    <input type="submit" value="remove">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>