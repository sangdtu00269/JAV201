<%--
  Created by IntelliJ IDEA.
  User: Hp
  Date: 1/13/2026
  Time: 3:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/giang-vien/sua" method="post">
    Id: <input type="hidden" name="id" value="${gv.id}"><br>
    Ten giang vien: <input type="text" name="tenGiangVien" value="${gv.tenGiangVien}"><br>
    Tuoi: <input type="number" name="tuoi" value="${gv.tuoi}"><br>
    Gioi tinh: <input type="radio" name="gioiTinh" value="true" ${gv.gioiTinh?"Checked":""}>Nữ
    <input type="radio" name="gioiTinh" value="false" ${gv.gioiTinh==false?"Checked":""}>Nam<br>
    Ten truong:
    <select name="idTruongHoc">
        <c:forEach items="${listTruongHoc}" var="th">
            <option value="${th.id}" label="${th.tenTruong}" ${gv.truongHoc.id == th.id ? "Selected" : ""}></option>
        </c:forEach>
    </select>
    <br>
    <button>Save</button>
</form>
</body>
</html>
