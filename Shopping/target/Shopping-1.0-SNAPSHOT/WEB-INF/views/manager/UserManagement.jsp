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
<!--分页-->
<div class="container">
    <nav class="text-center">
        <ul class="pagination text-center">
            <li><a href="<%=request.getContextPath()%>/backend/user/getAllUser?pageNo=1"><span>«首页</span> </a></li>
            <li>
                <a href="<%=request.getContextPath()%>/backend/user/getAllUser?pageNo=${(pageInfo.pageNum>1)?(pageInfo.pageNum-1):1}">上一页</a>
            </li>
            <li>
                <a href="<%=request.getContextPath()%>/backend/user/getAllUser?pageNo=${(pageInfo.pageNum<pageInfo.pages)?(pageInfo.pageNum+1):pageInfo.pages}">下一页</a>
            </li>
            <li><a href="<%=request.getContextPath()%>/backend/user/getAllUser?pageNo=${pageInfo.pages}"> <span>末页»</span></a>
            </li>
        </ul>
    </nav>
</div>
</div>
<jsp:include page="../commons/tail.jsp"/>

<script>

    function showChoose() {
        $("#chooseType").show();
        locationChange();
    }

    function showimage(source) {
        $("#imgInModalID").attr("src", source);
        $('.modal').show();
    }

    function closeModel() {
        $('.modal').hide();
    }

    $("#startUser").click(function(){
        $.ajax({
            url:"<%=request.getContextPath()%>/backend/user/stratUser",
            type:"POST",
            data:$("#empAddModal form").serialize(),
            success:function(result){
                //alert(result.msg);
                if(result.code == 100){
                    alert("注册成功")
                    window.location.href="<%=request.getContextPath()%>/user/loginPage";
                }
            }
        });
    });

    $("#deleteUser").click(function(){
        //1、模态框中填写的表单数据提交给服务器进行保存
        //1、先对要提交给服务器的数据进行校验
        if(!validate_username()&&!validate_password()&&!validate_nickname()){
            return false;
        };
        //1、判断之前的ajax用户名校验是否成功。如果成功。
        if($(this).attr("ajax-va")=="error"){
            return false;
        }

        //2、发送ajax请求保存用户
        $.ajax({
            url:"<%=request.getContextPath()%>/user/user",
            type:"POST",
            data:$("#empAddModal form").serialize(),
            success:function(result){
                //alert(result.msg);
                if(result.code == 100){
                    alert("注册成功")
                    window.location.href="<%=request.getContextPath()%>/user/loginPage";
                }
            }
        });
    });


</script>
</body>
</html>
