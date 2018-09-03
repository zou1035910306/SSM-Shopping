//输入框键盘弹起事件，在这里发送ajax请求
$(function(){
    $("#searchContent").keyup(function(){
        //设置ajax请求url和请求内容
        var sendUrl = contextPath+"/AjaxShowSearchProductNameServlet?time"+new Date().getTime();
        var sendDate = {
            "value":$("#searchContent").val()
        }
        //发送ajax请求
        $.ajax({
            type:"post",
            url:sendUrl,
            data:sendDate,
            async:true,
            //请求成功的回调函数
            success:function(backData,textStatus,xmlHttprequest){
                var ss = backData.split(",");
                var childDiv = "";
                for(var i = 0;i < ss.length;i++){
                    childDiv +="<div onclick='setSearchContent(this)'>" + ss[i] + "</div>";
                }
                //显示搜索框
                $("#searchResult").html(childDiv);
                $("#searchResult").show();
            }
        });
    });
});

//选中搜索列表中的一条数据，设置为搜索框内容
function setSearchContent(caller){
    $("#searchContent").val($(caller).html());
    $("#searchResult").hide();
}

//搜索功能
function doSearch(){
    //获取要搜索的内容
    var category = $("#searchContent").val();
    //alert(contextPath+"/ShowBlurProductsServlet?category="+category);
    window.location.href = contextPath+"/ShowBlurProductsServlet?category="+category;
}