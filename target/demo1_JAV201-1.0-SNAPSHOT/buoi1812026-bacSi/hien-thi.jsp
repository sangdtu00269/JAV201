<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Hp
  Date: 1/18/2026
  Time: 9:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/bac-si/them" method="post">
    Ten bac si: <input type="text" name="tenBacSi"> <br>
    Tuoi: <input type="number" name="tuoi"> <br>
    Gioi tinh: <input type="radio" name="gioiTinh" value="true"> Nam
    <input type="radio" name="gioiTinh" value="false"> Nu
    <br>
    Ten benh vien:
    <select name="idBenhVien">
        <c:forEach items="${listBenhVien}" var="bv">
            <option value="${bv.id}" label="${bv.tenBenhVien}"></option>
        </c:forEach>
    </select>
    <br>
    <button>Add</button>
</form>
<table>
    <thead>
    <th>Ten bac si</th>
    <th>Tuoi</th>
    <th>Gioi tinh</th>
    <th>Ten benh vien</th>
    <th>Dia chi</th>
    <th>Hanh dong</th>
    </thead>
    <tbody>
    <c:forEach items="${listBacSi}" var="bs">
        <tr>
            <td>${bs.tenBacSi}</td>
            <td>${bs.tuoi}</td>
            <td>${bs.gioiTinh?"Nam":"Nu"}</td>
            <td>${bs.benhVien.tenBenhVien}</td>
            <td>${bs.benhVien.diaChi}</td>
            <td>
                <a href="/bac-si/view-update?id=${bs.id}"><button>View update</button></a>
                <a href="/bac-si/xoa?id=${bs.id}"><button>Delete</button></a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
