<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../commons/nav.jsp"%>

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">

    <a type="button" class="btn btn-danger"
       href="<%=request.getContextPath()%>/backend/book/toSaveBook">增加图书</a>
    <form action="/book/checkBook" method="post">
            <input type="text" placeholder="请填写书籍名" name="bookName">
            <input type="submit" class="btn btn-danger" value="查询书籍">
        </form>


        <div class="box box-info">
            <div class="box-body" style="display: block;">
                <div class="table-responsive">
                    <table class="table no-margin">
                        <thead>
                        <tr>
                            <th>书本作者</th>
                            <th>封面</th>
                            <th>书名</th>
                            <th>价格</th>
                            <th>总页数</th>
                            <th>出版社</th>
                            <th>库存</th>
                            <th>销量</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="book" items="${books}">
                            <tr>
                                <td>${book.author}</td>
                                <td><img src="<%=request.getContextPath()%>/${book.bookImage}"
                                         style="width: 45px;height: 80px;"
                                         onclick='showimage("<%=request.getContextPath()%>/${book.bookImage}")'/>
                                </td>
                                <td>${book.bookName}</td>
                                <td>${book.price}</td>

                                <td>${book.totalPage}</td>
                                <td>${book.pubilshing}</td>
                                <td>${book.stock}</td>
                                <td>${book.sale}</td>
                                <td>
                                    <a type="button" class="btn btn-danger"
                                       href="<%=request.getContextPath()%>/backend/book/deleteBook/${book.bId}">下架该书籍</a>
                                    <a type="button" class="btn btn-danger"
                                       href="<%=request.getContextPath()%>/backend/book/update/${book.bId}">修改该书籍信息</a>
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
            <li><a href="<%=request.getContextPath()%>/book/toindex?pageNo=1"><span>«首页</span> </a></li>
            <li>
                <a href="<%=request.getContextPath()%>/book/toindex?pageNo=${(pageInfo.pageNum>1)?(pageInfo.pageNum-1):1}">上一页</a>
            </li>
            <li>
                <a href="<%=request.getContextPath()%>/book/toindex?pageNo=${(pageInfo.pageNum<pageInfo.pages)?(pageInfo.pageNum+1):pageInfo.pages}">下一页</a>
            </li>
            <li><a href="<%=request.getContextPath()%>/book/toindex?pageNo=${pageInfo.pages}"> <span>末页»</span></a>
            </li>
            <li class="pagespan">11/12</li>
        </ul>
    </nav>
</div>
</div>
<jsp:include page="../commons/tail.jsp"/>

<script>

</script>
</body>
</html>
