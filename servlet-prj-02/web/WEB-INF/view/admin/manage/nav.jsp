<%--
  Created by IntelliJ IDEA.
  User: OU
  Date: 2020/2/7
  Time: 22:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
</head>
<body>
<nav class="col-md-2 d-none d-md-block bg-light pt-5 left_nav">
    <ul class="nav flex-column">
        <li class="nav-item">
            <a class="nav-link active" href="${pageContext.request.contextPath}/admin/manage/newsCate">分类管理</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/admin/manage/news">文章管理</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/admin/manage/publish">发表新闻</a>
        </li>
    </ul>
</nav>
</body>
</html>
