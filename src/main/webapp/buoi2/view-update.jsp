<%--
  Created by IntelliJ IDEA.
  User: Hp
  Date: 1/11/2026
  Time: 8:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/truong-hoc/sua" method="post">
    <input type="number" name="id" value="${th_detail.id}" placeholder="Nhap id"> <br>
    <input type="text" name="tenTruong" value="${th_detail.tenTruong}" placeholder="Nhap ten truong"> <br>
    <input type="text" name="diaChi" value="${th_detail.diaChi}" placeholder="Nhap dia chi"> <br>
    <button type="submit">Sua</button>
</form>
</body>
</html>
