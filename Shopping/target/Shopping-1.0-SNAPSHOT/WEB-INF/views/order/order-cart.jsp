<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../commons/nav.jsp" %>
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
                    <c:set var="totalPrice" value="0"></c:set>
                    <form id="orderForm" action="<%=request.getContextPath()%>/order/createOrder" method="post">
                        <c:forEach var="cart" items="${cartList}" varStatus="status">
                            <c:set var="totalPrice" value="${ totalPrice + (cart.price * cart.quantity)}"/>
                            <input type="hidden" name="ints[${status.index}]" value="${cart.b_id}">
                            <input type="hidden" name="details[${status.index}].bookName" value="${cart.book_name }"/>
                            <input type="hidden" name="details[${status.index}].bookPrice" value="${cart.price }"/>
                            <input type="hidden" name="details[${status.index}].bookNum" value="${cart.quantity }"/>
                        </c:forEach>
                        <input type="hidden" name="price" value="${totalPrice}"/>
                        请输入目标地址：<input type="text" name="targetAddress" id="targetAddress"/>
                        请输入接收电话：<input type="text" name="telephone" id="telephone"/>
                        请输入订单描述：<input type="text" name="description" id="description"/>
                    </form>
                </div>
            </div>
            <button type="submit" class="checkout-submit btn-1"
                    id="order-submit">
                提交订单
            </button>
        </div>

    </section>
</div>
</div>
<%@include file="../commons/tail.jsp" %>
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

    $("#order-submit").click(function () {
        var telephone = $("#telephone").val();
        //检验电话
        var regnickname = /(^[a-zA-Z0-9_-]{11}$)/;
        if (!regnickname.test(telephone)) {
            alert("接收电话不符合格式")
            return false;
        }
        $('#orderForm').submit()
    });

</script>
</body>
</html>
