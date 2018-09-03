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
                    <form action="<%=request.getContextPath()%>/backend/book/updateBook" method="post">
                        <input type="hidden" name="bId" value="${book.bId}">
                        书本作者：<input name="author" value="${book.author}"/>
                        <br/>
                        <input type="hidden" name="bookImage" value="${book.bookImage}">
                        书本名字：<input name="bookName" value="${book.bookName}"/>
                        <br/>
                        书本价格：<input name="price" value="${book.price}"/>
                        <br/>
                        总页数：<input name="totalPage" value="${book.totalPage}"/>
                        <br/>
                        出版社：<input name="pubilshing" value="${book.pubilshing}"/>
                        库存：<input name="stock" value="${book.stock}"/>
                        销量：<input name="sale" value="${book.sale}"/>
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
