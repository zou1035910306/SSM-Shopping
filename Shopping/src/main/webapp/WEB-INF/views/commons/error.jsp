<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../commons/nav.jsp"%>
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
    <!-- Main content -->
    <section class="content">

        <h1>您所购买某一书籍数量超过其库存，请检查</h1>
        <h3>${data}:${message}</h3>
        <a type="button" class="btn btn-danger"
           href="<%=request.getContextPath()%>/cart/cart">返回我的购物车</a>
    </section>

</div>
<jsp:include page="../commons/tail.jsp"/>

<script>

</script>
</body>
</html>
