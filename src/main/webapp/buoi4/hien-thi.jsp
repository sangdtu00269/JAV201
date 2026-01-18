<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Hp
  Date: 1/13/2026
  Time: 3:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/giang-vien/them" method="post">
    Ten giang vien: <input type="text" required name="tenGiangVien"> <br>
    Tuoi: <input type="number" required name="tuoi"> <br>
    Gioi tinh:
    Nam <input type="radio" name="gioiTinh" value="false">
    Nu <input type="radio" name="gioiTinh" value="true">
    <br>
    Ten truong:
    <select name="idTruongHoc">
        <c:forEach items="${listTruongHoc}" var="th">
            <option value="${th.id}" label="${th.tenTruong}"></option>
        </c:forEach>
    </select>
    <br>
    <button>Add</button>
</select>
</form>
<table border="1px" style="border-collapse: collapse">
    <thead>
    <th>ID</th>
    <th>Ten giang vien</th>
    <th>Tuoi</th>
    <th>Gioi tinh</th>
    <th>Ten truong</th>
    <th>Dia chi</th>
    <th>Hanh dong</th>
    </thead>
    <tbody>
    <c:forEach var="gv" items="${listGiangVien}">
        <tr>
            <td>${gv.id}</td>
            <td>${gv.tenGiangVien}</td>
            <td>${gv.tuoi}</td>
            <td>${gv.gioiTinh == false ? "Nam":"Nữ"}</td>
            <td>${gv.truongHoc.tenTruong}</td>
            <td>${gv.truongHoc.diaChi}</td>
            <td>
                <a href="/giang-vien/view-update?id=${gv.id}">
                    <button>Detail</button>
                </a>
                <a href="/giang-vien/xoa?id=${gv.id}">
                    <button>Delete</button>
                </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
