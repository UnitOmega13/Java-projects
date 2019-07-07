<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Registration</title>
</head>
<body>
<form action="/registration" method="POST">
    Login <input type="text" name="login" value="<%= (request.getAttribute("defaultLogin") == null) ? ""
                      : request.getAttribute("defaultLogin")%>"> <br>
    E-mail <input type="email" name="email"  value="<%= (request.getAttribute("defaultEmail") == null) ? ""
                      : request.getAttribute("defaultEmail")%>"> <br>
    Password: <input type="password" name="password"/>
    Password repeat: <input type="password" name="repeatedPassword"/>
    <input type="submit" value="Registration">
</form>
<form action="index.jsp">
    <input type="submit" value="Back to main page">
</form>
</body>
</html>
