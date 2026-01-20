<%--
  Created by IntelliJ IDEA.
  User: Hp
  Date: 1/18/2026
  Time: 5:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/benh-vien/sua" method="post">
    ID: <input type="number" readonly name="id" value="${bv.id}"> <br>
    Ten benh vien: <input type="text" name="tenBenhVien" value="${bv.tenBenhVien}"> <br>
    Dia chi: <input type="text" name="diaChi" value="${bv.diaChi}"> <br>
    <button type="submit">Save</button>
</form>
</body>
</html>
