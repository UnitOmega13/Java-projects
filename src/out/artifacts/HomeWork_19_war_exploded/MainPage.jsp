<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main</title>
</head>
<body>
<H1>Hello ${userName}</H1>
<br/>
<a href="${pageContext.request.contextPath}/logout">
    <input type="submit" value="End session">
</a>
<c:if test="${userName=='admin'}">
    <a href="${pageContext.request.contextPath}/newProduct">
        <input type="submit" value="Add new item"/>
    </a>
</c:if>
<table>
    <c:forEach products="${products}" var="products">
        <tr>
            <td>${products.name}</td>
        </tr>
        <tr>
            <td>${products.description}</td>
        </tr>
        <tr>
            <td>${products.price} UAH
                <c:if test="${userName}!='admin'"><input type="submit" value="Add"></c:if> </td>
            <td>code: ${products.productCode}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
