<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>移动电子商务系统</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.6 -->
  <link rel="stylesheet" href='<%=request.getContextPath()%>/css/bootstrap.min.css'>
  <!-- Font Awesome -->
  <link rel="stylesheet" href='<%=request.getContextPath()%>/css/font-awesome.min.css'>
  <!-- Ionicons -->
  <link rel="stylesheet" href='<%=request.getContextPath()%>/css/ionicons.min.css'>
  <!-- Theme style -->
  <link rel="stylesheet" href='<%=request.getContextPath()%>/css/AdminLTE.min.css'>
  <!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
  <link rel="stylesheet" href='<%=request.getContextPath()%>/css/_all-skins.min.css'>
  <link rel="shortcut icon" href='/img/favicon.ico' type="image/x-icon">
  <link rel="Bookmark" href='/img/favicon.ico'>
  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="login-box">
  <div class="login-logo">
    <b>欢迎来到登陆界面</b>
  </div>
  <!-- /.login-logo -->
  <div class="login-box-body">
    <h2 class="login-box-msg">用户登录</h2>
    <h5>${message}</h5>
    <form action="<%=request.getContextPath()%>/user/realm" method="post">
      <div class="form-group has-feedback">
        <label class="col-md-4 control-label">用户名</label>
        <input type="text" class="form-control" name="username" placeholder="请输入用户名">
        <span class="glyphicon glyphicon-user form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
        <label class="col-md-4 control-label">密码</label>
        <input type="password" class="form-control" name="password" placeholder="请输入密码">
        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
      </div>
      <div class="row">
        <div class="col-xs-8">
        </div>
        <!-- /.col -->
        <div class="col-xs-4">
          <br/>
          <a type="button" class="btn btn-primary btn-block btn-flat" href="<%=request.getContextPath()%>/user/registerPage">注册</a>
          <br/>
          <button type="submit" class="btn btn-primary btn-block btn-flat">登录</button>
        </div>
      </div>
    </form>
  </div>
</div>
<script src="<%=request.getContextPath()%>/js/jquery-2.2.3.min.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
</body>
</html>
