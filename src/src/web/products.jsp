<%@ page import="model.Product" %>
<%@ page import="factories.ProductDAOFactory" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.List" %>
<%@ page import="factories.ProductServiceFactory" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    List<Product> productList = ProductServiceFactory.getInstance().getAll();
    PrintWriter printWriter = response.getWriter();
    printWriter.write("<form action=\"/new_product\" method=\"get\">\n" +
            "    <button type=\"submit\">Добавить товар</button>\n" +
            "</form>");
    printWriter.write("<table border=\"1\">");
    printWriter.write("<tr>");
    printWriter.write("<th>Name</th>");
    printWriter.write("<th>Description</th>");
    printWriter.write("<th>Price</th>");
    printWriter.write("</tr>");
    if (!productList.isEmpty()) {
        for (Product product : productList) {
            printWriter.write("<tr>");
            printWriter.write("<td>" + product.getName() + "</td>");
            printWriter.write("<td>" + product.getDescription() + "</td>");
            printWriter.write("<td>" + product.getPrice() + "</td>");
            printWriter.write("<td>" + "<a href = \"/products/remove?id=" + product.getId()
                    + "\"> remove product</a>" + "</td>");
            printWriter.write("<td>" + "<a href = \"/products/edit?id=" + product.getId()
                    + "\"> change product</a>" + "</td>");
            printWriter.write("</tr>");
        }
    }
    printWriter.write("</table>");
%>
<br>
<form action="users.jsp">
    <input type="submit" value="Users">
</form>
</body>
</html>
