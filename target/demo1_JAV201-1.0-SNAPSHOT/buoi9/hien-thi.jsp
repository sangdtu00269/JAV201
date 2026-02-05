<%--
  Created by IntelliJ IDEA.
  User: Hp
  Date: 1/24/2026
  Time: 2:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%
    pageContext.setAttribute("pageMessage","From page scope");
%>
<body>
<%--    request scope--%>
Message to request scope: ${requestMessage} <br>
<%--session scope--%>
Message to session scope: ${sessionScope.sessionMessage} <br>
<%--application scope--%>
Message to application scope: ${applicationScope.applicationMessage} <br>
<%--page scope--%>
Message to application scope: ${pageMessage} <br>
</body>
</html>
