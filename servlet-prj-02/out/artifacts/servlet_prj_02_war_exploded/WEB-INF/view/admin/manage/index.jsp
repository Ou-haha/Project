<%--
  Created by IntelliJ IDEA.
  User: OU
  Date: 2020/2/7
  Time: 20:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>系统管理中心</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap-4.3.1-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/manage.css">
</head>
<body>
<%--header--%>
<%@include file="header.jsp"%>
<div class="container-fluid pt-5">
    <div class="row">
        <%--侧边导航栏--%>
        <%@include file="nav.jsp"%>
        <main class="col-md-9 ml-sm-auto col-lg-10 px-4">
            <div class="d-flex flex-column pt-3 pb-5 mb-3">

            </div>
        </main>
    </div>
</div>
<script src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/static/bootstrap-4.3.1-dist/js/bootstrap.min.js"></script>
</body>
</html>
