<%--
  Created by IntelliJ IDEA.
  User: Hp
  Date: 1/7/2026
  Time: 10:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <p>Tên đăng nhập: <input type="text" name="tenDangNhap"></p>
    <p>Mật khẩu: <input type="password" name="matKhau"></p>
    <button type="submit" formaction="${pageContext.request.contextPath}/login">Đăng nhập</button>
</form>
</body>
</html>
