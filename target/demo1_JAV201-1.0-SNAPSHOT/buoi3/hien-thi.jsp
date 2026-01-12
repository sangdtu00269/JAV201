<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Hp
  Date: 1/10/2026
  Time: 3:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/ban-phim/them" method="post">
    Them ban phim: <br>
    Ten ban phim: <input type="text" name="tenBanPhim" required value="${bp_detail.tenBanPhim}"> <br>
    Tinh trang: <input type="radio" name="tinhTrang" required value="true" ${bp_detail.tinhTrang?"Checked":""}> Hoat dong
    <input type="radio" name="tinhTrang" required value="false" ${bp_detail.tinhTrang==false?"Checked":""}> Khong hoat dong
    <br>
    Gia: <input type="number" step="any" required value="${bp_detail.gia}" name="gia"> <br>
    So luong: <input type="number" name="soLuong" required value="${bp_detail.soLuong}"> <br>
    <button>Add</button>
</form>
<table>
    <thead>
        <tr>
            <th>Ten ban phim</th>
            <th>Tinh trang</th>
            <th>Gia</th>
            <th>So luong</th>
            <th>Hanh Dong</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${listBanPhim}" var="bp">
            <tr>
                <td>${bp.tenBanPhim}</td>
                <td>${bp.tinhTrang?"Hoat dong":"Khong hoat dong"}</td>
                <td>${bp.gia}</td>
                <td>${bp.soLuong}</td>
                <td>
                    <a href="/ban-phim/view-update?id=${bp.id}"><button>Detail</button></a>
                    <a href="/ban-phim/xoa?id=${bp.id}"><button>Delete</button></a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>
