<%--
  Created by IntelliJ IDEA.
  User: OU
  Date: 2020/2/7
  Time: 22:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>系统管理中心</title>
</head>
<body>
    <nav>
        <div class="navbar navbar-dark fixed-top bg-dark p-0 shadow">
            <a class="navbar-brand col-sm-3 col-md-2 mr-0" href="${pageContext.request.contextPath}/admin/manage">管理系统</a>
            <ul class="navbar-nav px-3">
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/logout">注销</a>
                </li>
            </ul>
        </div>
    </nav>
</body>
</html>
