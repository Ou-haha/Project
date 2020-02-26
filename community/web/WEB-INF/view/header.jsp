<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
</head>
<body>
<header class="bg-dark">
    <div class="container d-flex">
        <a href="${pageContext.request.contextPath}/">首页</a>
        <div class="flex-grow-1 d-flex justify-content-end">
            <form class="d-flex flex-wrap align-content-center m-0" action="${pageContext.request.contextPath}/search">
                <input type="text" placeholder="搜索你想要找的社区" name="name">
                <input type="submit">
            </form>
            <c:choose>
                <c:when test="${sessionScope.userStatus}">
                    <span>${sessionScope.username}</span>
                    <a href="${pageContext.request.contextPath}/logout" onclick="return logout()">注销</a>
                </c:when>
                <c:otherwise>
                    <a href="${pageContext.request.contextPath}/login">登录</a>
                    <a href="${pageContext.request.contextPath}/register">注册</a>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
    <script>
        function logout() {
            return window.confirm("是否退出当前账户？")
        }
    </script>
</header>
</body>
</html>
