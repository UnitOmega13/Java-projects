<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Registration</title>
</head>
<body>
<div align="center">
    ${passerror}
    <form action="${action}" method="POST">
        <table>
            <tr>
                <td>
                    Login <input type="text" name="login" value="<%= (request.getAttribute("defaultLogin") == null) ? ""
                      : request.getAttribute("defaultLogin")%>" required/>
                </td>
            </tr>
            <tr>
                <td>
                    E-mail <input type="email" name="email" value="<%= (request.getAttribute("defaultEmail") == null) ? ""
                      : request.getAttribute("defaultEmail")%>" required/>
                </td>
            </tr>
            <tr>
                <td>
                            <input type="radio" name="accessRole" value="user"/> User
                            <input type="radio" name="accessRole" value="admin"/>Admin
                </td>
            </tr>
            <tr>
                <td>
                    Password: <input type="password" name="password" value="" required/>
                </td>
            </tr>
            <tr>
                <td>
                    Repeat password: <input type="password" name="repeatedPassword" required/>
                </td>
            </tr>
        </table>
        <input type="submit" value="Registration">
    </form>
    <form action="/users">
        <input type="submit" value="Back to users list">
    </form>
</div>
</body>
</html>
