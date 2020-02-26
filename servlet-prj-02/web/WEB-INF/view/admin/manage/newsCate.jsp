<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>新闻分类管理</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap-4.3.1-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/manage.css">
    <style>
        input[disabled=disabled]{
            border: none;
            background-color: white;
        }
    </style>
</head>
<body>
<%--header--%>
<%@include file="header.jsp"%>
<%--{padding-top: 3rem !important},内填充距离设置，container-fluid占据全部视窗--%>
<div class="container-fluid pt-5">
    <div class="row">
        <%--侧边导航栏--%>
        <%@include file="nav.jsp"%>
            <%--使用main标签区分导航栏和侧边栏--%>
            <%----%>
        <main class="col-md-9 ml-sm-auto col-lg-10 px-4">
            <div class="d-flex flex-column pt-3 pb-5 mb-3">
                <form class="p-3 mb-2 ml-4" method="post" action="${pageContext.request.contextPath}/admin/manage/newsCate">
                    <label>
                        <input type="text" name="name">
                    </label>
                    <button type="submit" name="method" value="insert" class="btn btn-dark btn-sm ml-5">添加</button>
                </form>
                <ul>
                    <c:forEach items="${requestScope.allCate}" var="cate">
                        <li class="p-3 border-top">
                            <form class="row" method="post" action="${pageContext.request.contextPath}/admin/manage/newsCate">
                                <input type="text" disabled="disabled" value="${cate.name}" class="${cate.id}" name="name" />
                                <div style="display: none;" class="ml-2 btn-group btn-group-sm ${cate.id}">
                                    <button type="submit" class="btn btn-dark" name="id" value="${cate.id}">保存</button>
                                    <button type="button" class="btn btn-dark ml-3" onclick="cancel(${cate.id})">取消</button>
                                </div>
                                <div class="ml-auto btn-group btn-group-sm">
                                    <button type="button" class="btn btn-info mr-3" onclick="toEdit(${cate.id})">编辑</button>
                                    <button type="submit" class="btn btn-danger" name="id" value="${cate.id}" onclick="return confirmDelete()">删除</button>
                                </div>
                            </form>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </main>
    </div>
</div>
<script src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/static/bootstrap-4.3.1-dist/js/bootstrap.min.js"></script>
<script>
    function toEdit (id) {
        let input = document.getElementsByClassName(id)[0];
        input.removeAttribute("disabled");
        let editButton = document.getElementsByClassName(id)[1];
        editButton.style.display = "";
    }
    function cancel(id){
        let input = document.getElementsByClassName(id)[0];
        input.setAttribute("disabled","disabled");
        let editButton = document.getElementsByClassName(id)[1];
        editButton.style.display = "none";
    }
    function confirmDelete() {
        return window.confirm("你确认删除该分类及其所有新闻吗？");
    }
</script>
</body>
</html>