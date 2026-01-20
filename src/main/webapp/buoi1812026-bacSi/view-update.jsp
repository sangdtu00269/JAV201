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
<form action="/bac-si/sua" method="post">
    ID: <input type="number" name="id" value="${bs.id}"> <br>
    Ten bac si: <input type="text" name="tenBacSi" value="${bs.tenBacSi}"> <br>
    Tuoi: <input type="number" name="tuoi" value="${bs.tuoi}"> <br>
    Gioi tinh: <input type="radio" name="gioiTinh" value="true" ${bs.gioiTinh ? "Checked" : ""}> Nam
    <input type="radio" name="gioiTinh" value="false" ${bs.gioiTinh == false ? "Checked" : ""}> Nu
    <br>
    Ten benh vien:
    <select name="idBenhVien">
        <c:forEach items="${listBenhVien}" var="bv">
            <option value="${bv.id}" label="${bv.tenBenhVien}" ${bs.benhVien.id == bv.id ? "Selected" : ""}></option>
        </c:forEach>
    </select>
    <br>
    <button>Update</button>
</form>
</body>
</html>
