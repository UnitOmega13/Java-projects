<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>First Page</title>
</head>
${passerror}
<form action="/registration" method="post">
    <p>Email <input name="email" type="email"></p>
    <p>Password <input name="password" type="password"></p>
    <button type="submit">Submit</button>
</form>
<form action="/registration" method="get">
    <input type="submit" value="Registration">
</form>
</div>
</body>
</html>
