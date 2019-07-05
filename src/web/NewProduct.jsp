<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration of new Product</title>
</head>
<body>
<div align="center">
    <form action="/add" method="post">
        Название <input type="text" name="name"> <br>
        Описание <input type="text" name="description"> <br>
        Цена <input type="number" step="0.01" min="0" placeholder="0,00" name="price"> <br>
        <input type="submit" value="Add new Product"></form>
    </form>
    <form action="index.jsp">
        <input type="submit" value="Return back">
    </form>
</div>
</body>
</html>
