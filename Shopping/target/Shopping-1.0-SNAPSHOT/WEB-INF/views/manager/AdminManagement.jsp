<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../commons/nav.jsp"%>
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
    <!-- Main content -->
    <section class="content">
        <form action="<%=request.getContextPath()%>/backend/user/checkUser" method="post">
            <input type="text" placeholder="请填写用户名" name="username">
            <input type="submit" class="btn btn-danger" value="查找用户">
        </form>


        <div class="box box-info">
            <div class="box-body" style="display: block;">
                <div class="table-responsive">
                    <table class="table no-margin">
                        <thead>
                        <tr>
                            <th>账号</th>
                            <th>密码</th>
                            <th>昵称</th>
                            <th>状态:"1"表示正常,"2"表示禁用</th>
                            <th>用户创号时间</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="user" items="${users}">
                            <tr>
                                <td>${user.username}</td>
                                <td>${user.password}</td>
                                <td>${user.nickname}</td>
                                <td>${user.status}</td>
                                <td>${user.uptime}</td>
                                <td>
                                    <a type="button" class="btn btn-danger"
                                       href="<%=request.getContextPath()%>/backend/user/startUser/${user.uId}">启用该用户</a>
                                    <a type="button" class="btn btn-danger"
                                       href="<%=request.getContextPath()%>/backend/user/deleteUser/${user.uId}">禁用该用户</a>
                                    <a type="button" class="btn btn-danger"
                                       href="<%=request.getContextPath()%>/backend/user/update/${user.uId}">修改用户信息</a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </section>
</div>
<jsp:include page="../commons/tail.jsp"/>

<script>

</script>
</body>
</html>
