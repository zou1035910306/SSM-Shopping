<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../commons/head.jsp"%>
<body class="hold-transition skin-blue sidebar-mini">
<div class="login-box">
    <div class="login-logo">
        <b>欢迎来到添加图书页面</b>
    </div>

    <div id="empAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title" id="myModalLabel">书籍添加</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal" action="/backend/book/saveBook">
                        <div class="form-group">
                            <label class="col-sm-2 control-label">类别有</label>
                            <div class="col-sm-10">
                                <c:forEach var="type" items="${types}" varStatus="count">
                                    <p>${count.count}:${type.name}   </p>
                                </c:forEach>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">类别</label>
                            <div class="col-sm-10">
                                <input type="text" name="cId" class="form-control" value="1">
                                <span class="help-block"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">author</label>
                            <div class="col-sm-10">
                                <input type="text" name="author" class="form-control" placeholder="请输入作者名">
                                <span class="help-block"></span>
                            </div>
                        </div>
                                <input type="hidden" name="bookImage" class="form-control" value="img/1.jpg">
                        <div class="form-group">
                            <label class="col-sm-2 control-label">bookName</label>
                            <div class="col-sm-10">
                                <input type="text" name="bookName" class="form-control" placeholder="请输入书籍名">
                                <span class="help-block"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">price</label>
                            <div class="col-sm-10">
                                <input type="text" name="price" class="form-control" placeholder="请输入单价">
                                <span class="help-block"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">totalPage</label>
                            <div class="col-sm-10">
                                <input type="text" name="totalPage" class="form-control" placeholder="请输入总页数">
                                <span class="help-block"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">pubilshing</label>
                            <div class="col-sm-10">
                                <input type="text" name="pubilshing" class="form-control" placeholder="请输入出版社">
                                <span class="help-block"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">stock</label>
                            <div class="col-sm-10">
                                <input type="text" name="stock" class="form-control" placeholder="请输入库存">
                                <span class="help-block"></span>
                            </div>
                        </div>
                        <input type="submit" value="Submit" />
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="<%=request.getContextPath()%>/js/jquery-2.2.3.min.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
<script type="text/javascript">

</script>
</body>


</html>
