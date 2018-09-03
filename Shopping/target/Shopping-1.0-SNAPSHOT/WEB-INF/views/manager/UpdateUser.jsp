<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../commons/nav.jsp"%>

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
    <!-- Main content -->
    <section class="content">
        <a type="button" class="btn btn-danger" onclick="showChoose()">目录选择</a>

        <div class="box-body" style="display: none;" id="chooseType">
            <form action="<%=request.getContextPath()%>/book/searchByCategory" method="post">
                <select name="typeList" id="typeList">
                    <option value="">请选择</option>
                </select>
                <input type="submit" class="btn btn-danger" value="查询">
            </form>
        </div>
        <form action="<%=request.getContextPath()%>/book/checkBook" method="post">
            <input type="text" placeholder="请填写书籍名" name="bookName">
            <input type="submit" class="btn btn-danger" value="查询书籍">
        </form>


        <div class="box box-info">
            <div class="box-body" style="display: block;">
                <div class="table-responsive">
                    <form action="<%=request.getContextPath()%>/backend/user/updateUser" method="post">
                        <input type="hidden" name="uId" value="${user.uId}">
                        用户账号：<input name="username" value="${user.username}"/>
                        <br/>
                        用户密码：<input name="password" value="${user.password}"/>
                        <br/>
                        用户昵称：<input name="nickname" value="${user.nickname}"/>
                        <input type="submit" value="提交">
                    </form>
                </div>
            </div>
        </div>
    </section>
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

    function locationChange() {
        var type = "";
        var obj = document.getElementById('typeList');
        obj.options.length = 0;
        $.ajax({
            type: "post",
            url: "/book/getParentTypeList",
            cache: false,
            data: {type: type},
            dataType: "json",
            success: function (result) {
                if (result.length > 0) {
                    for (var i in result) {
                        var selectOption = new Option(result[i].name, result[i].cId);
                        obj.add(selectOption);
                    }
                }
            }
        });
    }


</script>
</body>
</html>
