<%--
  Created by IntelliJ IDEA.
  User: 刘真
  Date: 2019/1/22
  Time: 9:30
  description: 房东信息页面
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <!-- iCheck for checkboxes and radio inputs -->
    <link rel="stylesheet" href="plugins/iCheck/all.css">
    <!-- Select2 -->
    <link rel="stylesheet" href="bower_components/select2/dist/css/select2.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="dist/css/AdminLTE.min.css">
    <!-- AdminLTE Skins. Choose a skin from the css/skins
         folder instead of downloading all of them to reduce the load. -->
    <link rel="stylesheet" href="dist/css/skins/_all-skins.min.css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

    <!-- Google Font -->
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

    <header class="main-header">
        <!-- Logo -->
        <a class="logo">
            <!-- mini logo for sidebar mini 50x50 pixels -->
            <span class="logo-mini"><b>H</b>TM</span>
            <!-- logo for regular state and mobile devices -->
            <span class="logo-lg">二手房屋租赁系统</span>
        </a>
        <!-- Header Navbar: style can be found in header.less -->
        <nav class="navbar navbar-static-top">
            <!-- Sidebar toggle button-->
            <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
                <span class="sr-only">切换导航</span>
            </a>

            <div class="navbar-custom-menu">
                <ul class="nav navbar-nav">
                    <!-- User Account: style can be found in dropdown.less -->
                    <li class="dropdown user user-menu">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <img src="dist/img/1.jpg" class="user-image" alt="User Image">
                            <span class="hidden-xs">${sessionScope.user.userRole }-${sessionScope.user.userName }</span>
                        </a>
                        <ul class="dropdown-menu">
                            <!-- User image -->
                            <li class="user-header">
                                <img src="dist/img/1.jpg" class="img-circle" alt="User Image">

                                <p>
                                    ${sessionScope.user.userRole }-${sessionScope.user.userName }
                                    <small>${sessionScope.date }</small>
                                </p>
                            </li>
                            <!-- Menu Body -->
                            <!-- Menu Footer-->
                            <li class="user-footer">
                                <div class="pull-left">
                                    <a class="btn btn-default btn-flat">待加</a>
                                </div>
                                <div class="pull-right">
                                    <a href="/exitpage" class="btn btn-default btn-flat">注销</a>
                                </div>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
        </nav>
    </header>
    <!-- Left side column. contains the logo and sidebar -->
    <aside class="main-sidebar">
        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">
            <!-- Sidebar user panel -->
            <div class="user-panel">
                <div class="pull-left image">
                    <img src="dist/img/1.jpg" class="img-circle" alt="User Image">
                </div>
                <div class="pull-left info">
                    <p>${sessionScope.user.userRole }-${sessionScope.user.userName }</p>
                    <a><i class="fa fa-circle text-success"></i> 在线</a>
                </div>
            </div>
            <!-- search form -->
            <form action="#" method="get" class="sidebar-form">
                <div class="input-group">
                    <input type="text" name="q" class="form-control" placeholder="搜索...">
                    <span class="input-group-btn">
                <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
                </button>
              </span>
                </div>
            </form>
            <!-- /.search form -->
            <!-- sidebar menu: : style can be found in sidebar.less -->
            <ul class="sidebar-menu" data-widget="tree">
                <li class="header">导航</li>
                <li class="treeview" id="dashboard">
                    <a href="#">
                        <i class="fa fa-dashboard"></i> <span>首页</span>
                        <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="../../index.html"><i class="fa fa-circle-o"></i> 我的房源</a></li>
                    </ul>
                </li>
                <li class="treeview" id="marketing">
                    <a href="#">
                        <i class="fa fa-edit"></i> <span>房屋租赁</span>
                        <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                    </a>
                    <ul class="treeview-menu">
                        <li id="sales"><a href="/showhouseentry"><i class="fa fa-circle-o"></i> 房屋录入</a></li>
                        <li id="development"><a href="../tables/simple1.html"><i class="fa fa-circle-o"></i>  我的申请</a></li>
                        <li id="development"><a href="../tables/simple1.html"><i class="fa fa-circle-o"></i>  租客申请</a></li>
                    </ul>
                </li>

                <li class="treeview" id="service">
                    <a href="#">
                        <i class="fa fa-table"></i> <span>合同管理</span>
                        <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                    </a>
                    <ul class="treeview-menu">
                        <li id="create"><a href="../forms/advanced2.html"><i class="fa fa-circle-o"></i> 房屋合同</a></li>
                    </ul>
                </li>

                <li class="treeview" id="statistics">
                    <a href="#">
                        <i class="fa fa-pie-chart"></i>
                        <span>统计报表</span>
                        <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="../charts/chartjs1.html"><i class="fa fa-circle-o"></i> 我的租赁</a></li>
                    </ul>
                </li>

                <li class="treeview active" id="basis">
                    <a href="#">
                        <i class="fa fa-laptop"></i> <span>基础数据</span>
                        <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                    </a>
                    <ul class="treeview-menu">
                        <li class="active"><a href="/showlandlordinfo"><i class="fa fa-circle-o"></i> 房东信息</a></li>
                        <li><a href="/showlandlordsystem"><i class="fa fa-circle-o"></i> 系统信息</a></li>
                    </ul>
                </li>

            </ul>
        </section>
        <!-- /.sidebar -->
    </aside>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                基础数据管理
                <small>Basic data management</small>
            </h1>
            <ol class="breadcrumb">
                <li><a><i class="fa fa-dashboard"></i> Home</a></li>
                <li><a>基础数据管理</a></li>
                <li class="active">房东信息</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">

            <div class="box box-default">
                <div class="box-header with-border">
                    <h3 class="box-title">房东信息</h3>
                </div>
                <!-- /.box-header -->
                <form class="form-horizontal" role="form" action="#" method="get">
                    <div class="box-body">

                        <table class="table table-bordered">

                            <tr height="75px">
                                <td width="15%" style="vertical-align:middle; text-align:center;">昵称</td>
                                <td width="35%" style="vertical-align:middle; text-align:left;">${sessionScope.landlord.landlordNick }</td>
                                <td width="15%" style="vertical-align:middle; text-align:center;">角色</td>
                                <td width="35%" style="vertical-align:middle; text-align:left;">${sessionScope.landlord.role }</td>
                            </tr>
                            <tr height="75px">
                                <td style="vertical-align:middle; text-align:center;">真实姓名</td>
                                <td style="vertical-align:middle; text-align:left;">${sessionScope.landlord.landlordName }</td>
                                <td style="vertical-align:middle; text-align:center;">性别</td>
                                <td style="vertical-align:middle; text-align:left;">${sessionScope.landlord.landlordSex }</td>
                            </tr>
                            <tr height="75px">
                                <td style="vertical-align:middle; text-align:center;">出生年月</td>
                                <td style="vertical-align:middle; text-align:left;">${sessionScope.landlord.landlordBirth }</td>
                                <td style="vertical-align:middle; text-align:center;">联系地址</td>
                                <td style="vertical-align:middle; text-align:left;">${sessionScope.landlord.landlordAddr }</td>
                            </tr>
                            <tr height="75px">
                                <td style="vertical-align:middle; text-align:center;">联系电话</td>
                                <td style="vertical-align:middle; text-align:left;">${sessionScope.landlord.landlordTel }</td>
                                <td style="vertical-align:middle; text-align:center;">联系邮箱</td>
                                <td style="vertical-align:middle; text-align:left;">${sessionScope.landlord.landlordMail }</td>
                            </tr>
                            <tr height="75px">
                                <td style="vertical-align:middle; text-align:center;">工作</td>
                                <td style="vertical-align:middle; text-align:left;">${sessionScope.landlord.landlordWork }</td>
                            </tr>

                        </table>

                    </div>

                    <!-- /.box-body -->
                    <div class="box-footer">
                    </div>
                </form>
            </div>
            <!-- /.box -->
            <!-- /.row -->
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
    <footer class="main-footer">
        <strong>Copyright &copy; 2019 <a href="https://www.realliu.cn">realliu</a>.</strong> All rights reserved.
    </footer>

</div>
<!-- ./wrapper -->

<!-- jQuery 3 -->
<script src="bower_components/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- Select2 -->
<script src="bower_components/select2/dist/js/select2.full.min.js"></script>
<!-- InputMask -->
<script src="plugins/input-mask/jquery.inputmask.js"></script>
<script src="plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
<script src="plugins/input-mask/jquery.inputmask.extensions.js"></script>
<!-- SlimScroll -->
<script src="bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>
<!-- iCheck 1.0.1 -->
<script src="plugins/iCheck/icheck.min.js"></script>
<!-- FastClick -->
<script src="bower_components/fastclick/lib/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="dist/js/demo.js"></script>
</body>
</html>

