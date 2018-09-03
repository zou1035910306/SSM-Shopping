<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="modal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true"
                        onclick="closeModel()">&times;
                </button>
            </div>
            <div class="modal-body">
                <img id="imgInModalID" style="width:100%;height: auto;max-height: 800px;">
            </div>
        </div>
    </div>
</div>
<!-- ./wrapper -->
<!-- jQuery 2.2.0 -->
<script src='<%=request.getContextPath()%>/js/jquery-2.2.3.min.js'></script>
<!-- Bootstrap 3.3.6 -->
<script src='<%=request.getContextPath()%>/js/bootstrap.min.js'></script>
<!-- SlimScroll -->
<script src='<%=request.getContextPath()%>/js/jquery.slimscroll.min.js'></script>
<!-- FastClick -->
<script src='<%=request.getContextPath()%>/js/fastclick.js'></script>
<!-- AdminLTE App -->
<script src='<%=request.getContextPath()%>/js/app.min.js'></script>
<!-- AdminLTE for demo purposes -->
<script src='<%=request.getContextPath()%>/js/demo.js'></script>

<script src='<%=request.getContextPath()%>/js/zoom.js'></script>

<script src='<%=request.getContextPath()%>/js/transition.js'></script>

<!-- home.js -->
<script type="text/javascript" src="<%=request.getContextPath()%>/js/home.js"></script>
