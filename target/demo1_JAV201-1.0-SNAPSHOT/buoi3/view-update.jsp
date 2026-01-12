<%--
  Created by IntelliJ IDEA.
  User: Hp
  Date: 1/11/2026
  Time: 8:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/ban-phim/sua" method="post">
    Sua ban phim: <br>
    ID ban phim: <input type="number" name="id" required value="${bp_detail.id}"> <br>
    Ten ban phim: <input type="text" name="tenBanPhim" required value="${bp_detail.tenBanPhim}"> <br>
    Tinh trang: <input type="radio" name="tinhTrang" required value="true" ${bp_detail.tinhTrang?"Checked":""}> Hoat dong
    <input type="radio" name="tinhTrang" required value="false" ${bp_detail.tinhTrang==false?"Checked":""}> Khong hoat dong
    <br>
    Gia: <input type="number" step="any" required value="${bp_detail.gia}" name="gia"> <br>
    So luong: <input type="number" name="soLuong" required value="${bp_detail.soLuong}"> <br>
    <button>Sua</button>
</form>
</body>
</html>
