<%--
  Created by IntelliJ IDEA.
  User: 刘真
  Date: 2019/1/2
  Time: 17:05
  description: 注册页面
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>二手房屋租赁系统</title>
    <link rel="icon" href="image/index.ico"/>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.7 -->
    <link rel="stylesheet" href="bower_components/bootstrap/dist/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="bower_components/font-awesome/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="bower_components/Ionicons/css/ionicons.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="dist/css/AdminLTE.min.css">
    <!-- iCheck -->
    <link rel="stylesheet" href="plugins/iCheck/square/blue.css">
    <!-- toastr -->
    <link rel="stylesheet" href="dist/css/toastr.css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

    <!-- Google Font -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
</head>
<body class="hold-transition register-page" style="height: 85%" onload="start();">
<div class="register-box" style="height: 55%;">
    <div class="register-logo">
        <a href="house/selectOrder"><b>HTM</b>二手房屋租赁系统</a>
    </div>

    <div class="register-box-body">
        <p class="login-box-msg">注册新用户</p>

        <form id="form" action="user/userRegister" method="post">
            <div class="form-group has-feedback">
                <input type="text" class="form-control" placeholder="Nick name" name="userName" id="userName">
                <span class="glyphicon glyphicon-user form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <select class="form-control" name="userRole">
                    <option selected="selected" value="租客">租客</option>
                    <option value="房东">房东</option>
                    <option value="中介">中介</option>
                </select>
            </div>
            <div class="form-group has-feedback">
                <input type="password" class="form-control" placeholder="Password" id="fPassword">
                <span class="glyphicon glyphicon-lock form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <input type="password" class="form-control" placeholder="Retype password" name="userPassword" id="sPassword">
                <span class="glyphicon glyphicon-log-in form-control-feedback"></span>
            </div>
            <div class="row">
                <div class="col-xs-8">
                    <div class="checkbox icheck">
                        <label>
                            <input type="checkbox" id="checkbox"> 我同意这些<a href="#">条款</a>
                        </label>
                    </div>
                </div>
                <!-- /.col -->
                <div class="col-xs-4">
                    <button type="submit" class="btn btn-primary btn-block btn-flat">注册</button>
                </div>
                <!-- /.col -->
            </div>
        </form>

        <a href="/showlogin" class="text-center">已经有用户账号了</a>
    </div>
    <!-- /.form-box -->
</div>
<!-- /.register-box -->

<div class="case container">

    <div class="col-md-3"></div>
    <div class="col-md-9"><img src="image/htm.png" class="img-rounded"></div>

</div>

<!-- jQuery 3 -->
<script src="bower_components/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- iCheck -->
<script src="plugins/iCheck/icheck.min.js"></script>
<!-- toastr -->
<script src="dist/js/toastr.js"></script>
<script>

    var msg="${sessionScope.msg }";

    var flag="false";

    $(function () {
        $('input').iCheck({
            checkboxClass: 'icheckbox_square-blue',
            radioClass: 'iradio_square-blue',
            increaseArea: '20%' /* optional */
        });

        $('#userName').blur(function () {

            var userName=$("#userName").val();

            if (userName == '') {
                toastr.options.positionClass = 'toast-center-center';
                toastr.info("用户名为空");
            }else {
                $.ajax({
                    url: "user/userNameCheck",
                    type: "post",
                    contentType: "application/x-www-form-urlencoded; charset=utf-8",
                    data: {"userName": userName},
                    dataType: "text",
                    success: function (data) {
                        toastr.options.positionClass = 'toast-center-center';
                        if (data == 'true') {
                            flag="true";
                            toastr.info("用户名可用");
                        } else if (data == 'false') {
                            flag="false";
                            toastr.info("用户名已存在");
                        } else if (data == 'error') {
                            flag="false";
                            toastr.info(msg);
                            <c:remove var="msg" scope="session"/>
                        }
                    }
                });
            }
        });

        $('#sPassword').blur(function(){
            var fPassword = $('#fPassword').val();
            var sPassword = $('#sPassword').val();
            toastr.options.positionClass = 'toast-center-center';
            if (fPassword=='' || sPassword=='') {
                toastr.info("密码不能为空");
            }else if(fPassword != sPassword) {
                toastr.info("两次密码不同");
            }else {
                toastr.info("密码符合");
            }
        });

        $('#form').submit(function(){

            if (flag == "true") {
                if ($('#checkbox').is(':checked')) {
                    return true;
                } else {
                    toastr.options.positionClass = 'toast-center-center';
                    toastr.info("未同意条款");
                    return false;
                }
            }else if (flag == "false"){
                toastr.options.positionClass = 'toast-center-center';
                toastr.info("用户名已存在");
                return false;
            }
        });


    });

    function start() {
        if (msg != ""){
            toastr.options.positionClass = 'toast-center-center';
            toastr.info(msg);
            <c:remove var="msg" scope="session"/>
        }
    }

</script>
</body>
</html>
