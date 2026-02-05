<%--
  Created by IntelliJ IDEA.
  User: Hp
  Date: 2/3/2026
  Time: 2:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="/demoAjax/jquery3.7.1.js" type="application/javascript"></script>
    <script>
        function getData(){
            $.ajax({
                url: "/api/list",
                method: "get",
                dataType: "json",
                success: function(data) {
                    document.getElementById("data").innerText = data.id + " " + data.name + " " + data.gender
                },
                error: function (e) {
                    document.getElementById("data").innerText = "Loi"
                }
            })
        }
    </script>
</head>
<body>
    Thong tin sinh vien: <span id="data"></span>
    <br>
    <button onclick="getData()">Lay thong tin sinh vien</button>
</body>
</html>
