<%@ page import="model.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="factories.UserServiceFactory" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
</head>
<body>

<div align="left">
    <%
        List<User> userList = UserServiceFactory.getInstance().getAll();
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
                printWriter.write("<td>" + "<a href = \"/users/remove?id=" + user.getId()
                        + "\"> remove user</a>" + "</td>");
                printWriter.write("<td>" + "<a href = \"/users/change?id=" + user.getId()
                        + "\"> change user</a>" + "</td>");
                printWriter.write("</tr>");
            }
        }
        printWriter.write("</table>");
    %>

    <form action="/products" method="get">
        <input type="submit" value="Products list">
    </form>

    <br>
    <form action="index.jsp">
        <input type="submit" value="Back to main page">
    </form>

</div>
</body>
</html>
