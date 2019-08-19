<%@ page import="main.model.User" %>
<%@ page import="java.util.List" %>
<%@ page import="main.factories.UserDAOFactory" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="main.model.Product" %>
<%@ page import="main.factories.ProductDAOFactory" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 05.07.2019
  Time: 4:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
</head>
<body>

<div align="left">
    <%
        List<User> userList = UserDAOFactory.getInstance().getAll();
        PrintWriter printWriter = response.getWriter();
        printWriter.write("<form action=\"/registration\" method=\"get\">\n" +
                "<input type=\"submit\" value=\"New User\">\n" +
                "</form>");
        printWriter.write("<table border=\"1\">");
        printWriter.write("<tr>");
        printWriter.write("<th>Login</th>");
        printWriter.write("<th>Email</th>");
        printWriter.write("<th>Password</th>");
        printWriter.write("</tr>");
        if (!userList.isEmpty()) {
            for (User user : userList) {
                printWriter.write("<tr>");
                printWriter.write("<td>" + user.getEmail() + "</td>");
                printWriter.write("<td>" + user.getLogin() + "</td>");
                printWriter.write("<td>" + user.getPassword() + "</td>");
                printWriter.write("</tr>");
            }
        }
        printWriter.write("</table>");
    %>

    <%
        List<Product> productList = ProductDAOFactory.getInstance().getAll();
        printWriter.write("<br><br>");
        printWriter.write("<form action=\"/new_product\" method=\"get\">\n" +
                "    <button type=\"submit\">New Product</button>\n" +
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
                printWriter.write("</tr>");
            }
        }
        printWriter.write("</table>");
    %>

    <br>
    <form action="index.jsp">
        <input type="submit" value="Back to main page">
    </form>

</div>
</body>
</html>
