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
                            <th>订单目标地址</th>
                            <th>快递员电话</th>
                            <th>订单情况:"0"未交费，“1"交费</th>
                            <th>订单下定用户姓名</th>
                            <th>总价</th>
                            <th>订单描述</th>
                            <th>下单时间</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="order" items="${orders}">
                            <tr>
                                <td>${order.targetAddress}</td>
                                <td>${order.telephone}</td>
                                <td>${order.orderStatus}</td>
                                <td>${order.username}</td>
                                <td>${order.price}</td>
                                <td>${order.description}</td>
                                <td>${order.uptime}</td>
                                <td>
                                    <a type="button" class="btn btn-danger"
                                       href="<%=request.getContextPath()%>/order/getAllDetailByOrder/${order.oId}">查看该订单细节</a>
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
</body>
</html>
