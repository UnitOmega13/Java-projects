<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Registration</title>
</head>
<body>
${passerror}
<form action="${action}" method="POST">
    Login <input type="text" name="login" value="<%= (request.getAttribute("defaultLogin") == null) ? ""
                      : request.getAttribute("defaultLogin")%>" required /> <br>
    E-mail <input type="email" name="email" value="<%= (request.getAttribute("defaultEmail") == null) ? ""
                      : request.getAttribute("defaultEmail")%>" required /> <br>
    <p> Access role <select data-selected="${accessRole}" name="accessRole" >
        <option value="user">user</option>
        <option value="admin">admin</option>
    </select></p>
    Password: <input type="password" name="password" value="" required/><br>
    Password repeat: <input type="password" name="repeatedPassword" required/><br>
    <input type="submit" value="Registration">
</form>
<form action="/users">
    <input type="submit" value="Back to users list">
</form>
</body>
</html>
