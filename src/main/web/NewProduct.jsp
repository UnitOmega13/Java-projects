<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration of new Product</title>
</head>
<body>
<div align="center">
    <form action="${pageContext.request.contextPath}/newProduct" method="post">
        Product name <input name="name" type="text"/>
        Product description <input name="description" type="text">
        Product price <input name="price" type="number">
        <button type="submit">Add new product</button>
    </form>
</div>
</body>
</html>
