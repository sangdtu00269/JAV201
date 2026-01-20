<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<form action="/benh-vien/them" method="post">
    Ten benh vien: <input type="text" name="tenBenhVien"> <br>
    Dia chi: <input type="text" name="diaChi"> <br>
    <button type="submit">Add</button>
</form>
<body>
    <table>
        <thead>
            <th>Ten benh vien</th>
            <th>Dia chi</th>
            <th>Hanh dong</th>
        </thead>
        <tbody>
            <c:forEach items="${listBenhVien}" var="bv">
                <tr>
                    <td>${bv.tenBenhVien}</td>
                    <td>${bv.diaChi}</td>
                    <td>
                        <a href="/benh-vien/view-update?id=${bv.id}"><button>View update</button></a>
                        <a href="/benh-vien/xoa?id=${bv.id}"><button>Delete</button></a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
