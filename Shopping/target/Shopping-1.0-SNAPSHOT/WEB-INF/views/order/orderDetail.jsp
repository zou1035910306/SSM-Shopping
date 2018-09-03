<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../commons/nav.jsp"%>

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
    <!-- Main content -->
    <section class="content">
        <div class="box box-info">
            <div class="box-body" style="display: block;">
                <div class="table-responsive">
                    <table class="table no-margin">
                        <thead>
                        <tr>
                            <th>所属订单编号</th>
                            <th>书本数量</th>
                            <th>书本名字</th>
                            <th>书本单价</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="detail" items="${details}">
                            <tr>
                                <td>${detail.odId}</td>
                                <td>${detail.bookNum}</td>
                                <td>${detail.bookName}</td>
                                <td>${detail.bookPrice}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </section>
</div>
</body>
</html>
