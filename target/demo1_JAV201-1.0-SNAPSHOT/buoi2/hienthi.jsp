<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lovep
  Date: 1/8/2026
  Time: 3:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/truong-hoc/them" method="post">

    <input type="text" name="tenTruong" value="${th_detail.tenTruong}" placeholder="Nhap ten truong"> <br>
    <input type="text" name="diaChi" value="${th_detail.diaChi}" placeholder="Nhap dia chi"> <br>
    <button type="submit">Them</button>
</form>
Bang thong tin:
<table border="1px" style="border-collapse: collapse">
    <thead>
    <tr>
        <th>Ten truong</th>
        <th>Dia chi</th>
        <th>Hanh dong</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listTruongHoc}" var="th">
        <tr>
            <td>${th.tenTruong}</td>
            <td>${th.diaChi}</td>
            <td><button><a href="/truong-hoc/view-update?id=${th.id}">Detail</a></button></td>
            <td><button><a href="/truong-hoc/xoa?id=${th.id}">Delete</a></button></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
