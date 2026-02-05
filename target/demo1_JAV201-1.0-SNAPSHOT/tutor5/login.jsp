<%--
  Created by IntelliJ IDEA.
  User: Hp
  Date: 1/31/2026
  Time: 3:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${message}
<form action="/login-tutor" method="post">
    username: <input type="text" name="username"> <br>
    password: <input type="password" name="password"> <br>
    <button>Login</button>
</form>
</body>
</html>
