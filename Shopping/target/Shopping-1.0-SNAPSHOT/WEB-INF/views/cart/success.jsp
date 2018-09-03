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
                        <div>
                            <h3>商品已成功加入购物车！</h3>
                            <span id="flashBuy" style="display: none">商品数量有限，请您尽快下单并付款！</span>
                            <h3>
                                <a class="btn-1" href="/cart/cart" id="GotoShoppingCart">去购物车结算</a>
                            </h3>
                        </div>
                        <h3>
                        <span class="ml10">您还可以 <a
                                class="ftx-05" href="javascript:history.back();">继续购物</a></span>
                        </h3>
					</span>
                    </div>
                </div>
            </div>
        </section>
    </div>
<%@include file="../commons/tail.jsp"%>

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
