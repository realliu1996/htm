<%--
  Created by IntelliJ IDEA.
  User: 刘真
  Date: 2019/4/15
  Time: 21:03
  description: 合同页面
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
    <!-- AdminLTE Skins. Choose a skin from the css/skins
         folder instead of downloading all of them to reduce the load. -->
    <link rel="stylesheet" href="dist/css/skins/_all-skins.min.css">
    <link href="dist/css/newstyle.css" rel="stylesheet" type="text/css" media="all" />
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
<body class="hold-transition skin-blue sidebar-mini" onload="">
<div class="wrapper">

    <header class="main-header">
        <!-- Logo -->
        <a href="../../index.html" class="logo">
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
                    <a href="#"><i class="fa fa-circle text-success"></i> 在线</a>
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
                        <li><a href="house/selectByCond"><i class="fa fa-circle-o"></i> 我的房源</a></li>
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
                        <li><a href="/showhouseentry"><i class="fa fa-circle-o"></i> 房屋录入</a></li>
                        <li><a href="landlordApplication/selectByCond"><i class="fa fa-circle-o"></i>  我的申请</a></li>
                        <li><a href="tenantApplication/selectByCondForLandlord"><i class="fa fa-circle-o"></i>  租客申请</a></li>
                    </ul>
                </li>

                <li class="treeview active" id="service">
                    <a href="#">
                        <i class="fa fa-table"></i> <span>合同管理</span>
                        <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                    </a>
                    <ul class="treeview-menu">
                        <li  class="active"><a href="contract/selectByLandlordId"><i class="fa fa-circle-o"></i> 房屋合同</a></li>
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
                        <li><a href="landlordApplication/selectByCondCount"><i class="fa fa-circle-o"></i> 我的录入</a></li>
                        <li><a href="tenantApplication/selectCountForLandlord"><i class="fa fa-circle-o"></i> 我的租赁</a></li>
                    </ul>
                </li>

                <li class="treeview" id="basis">
                    <a href="#">
                        <i class="fa fa-laptop"></i> <span>基础数据</span>
                        <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="/showlandlordinfo"><i class="fa fa-circle-o"></i> 房东信息</a></li>
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
                房屋合同
                <small>Entry review</small>
            </h1>
            <ol class="breadcrumb">
                <li><a><i class="fa fa-dashboard"></i> Home</a></li>
                <li>合同管理</li>
                <li>房屋合同</li>
                <li class="active">合同详情</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <div class="box">
                        <div class="box-header with-border">
                            <h3 class="box-title">房屋租赁合同</h3>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body">
                            <ul class="list-unstyled">
                                <li>出租方（以下简称甲方）: <span style="color: red;font-weight:bold;">${contract.landlordName}</span></li>
                                <li>承租方（以下简称乙方）: <span style="color: red;font-weight:bold;">${contract.tenantName}</span></li>
                                <li>甲、乙双方就下列房屋的租赁达成如下协议:</li>
                                <div class="col-md-12">
                                    <li>第一条 房屋基本情况。</li>
                                    <div class="col-md-12">
                                        <li>甲方房屋（以下简称该房屋）坐落于: <span style="color: red;font-weight:bold;">${chouse.position}</span></li>
                                    </div>
                                    <li>第二条 房屋用途。</li>
                                    <div class="col-md-12">
                                        <li>该房屋用途为租赁住房。</li>
                                        <li>除双方另有约定外，乙方不得任意改变房屋用途。</li>
                                    </div>
                                    <li>第三条 租赁期限。</li>
                                    <div class="col-md-12">
                                        <li>租赁期限自 <span style="color: red;font-weight:bold;">${contract.startTime}</span> 至 <span style="color: red;font-weight:bold;">${contract.endTime}</span> 止。</li>
                                    </div>
                                    <li>第四条 租金。</li>
                                    <div class="col-md-12">
                                        <li>该房屋月租金为  <span style="color: red;font-weight:bold;">${contract.rentalPrice}</span> 元整。</li>
                                        <li>租赁期间，如遇到国家有关政策调整，则按新政策规定调整租金标准；除此之外，出租方不得以任何理由任意调整租金。</li>
                                    </div>
                                    <li>第五条 交付房屋期限。</li>
                                    <div class="col-md-12">
                                        <li>甲方应于本合同生效之日起五日内，将该房屋交付给乙方。</li>
                                    </div>
                                    <li>第六条 甲方对房屋产权的承诺。</li>
                                    <div class="col-md-12">
                                        <li>甲方保证拥有房屋产权，提供相应证明。在交易时该房屋没有产权纠纷；除补充协议另有约定外，有关按揭、抵押债务、税项及租金等，甲方均在交付房屋前办妥。交易后如有上述未清事项，由甲方承担全部责任，由此给乙方造成经济损失的，由甲方负责赔偿。</li>
                                    </div>
                                    <li>第七条 维修养护责任。</li>
                                    <div class="col-md-12">
                                        <li>正常的房屋大修理费用由甲方承担；日常的房屋维修费用由乙承担。</li>
                                        <li>因乙方管理使用不善造成房屋及其相连设备的损失和维修费用，由乙方承担并责任赔偿损失。</li>
                                        <li>租赁期间，防火安全，门前三包，综合治理及安全、保卫等工作，乙方应执行当地有关部门规定并承担全部责任和服从甲方监督检查。</li>
                                    </div>
                                    <li>第八条 租赁期满。</li>
                                    <div class="col-md-12">
                                        <li>租赁期满后，如乙方要求继续租赁，甲方则优先同意继续租赁</li>
                                        <li>租赁期满后，如甲方未明确表示不续租的，则视为同意乙方继续承租</li>
                                    </div>
                                    <li>第九条 违约责任。</li>
                                    <div class="col-md-12">
                                        <li>租赁期间双方必须信守合同，任何一方违反本合同的规定，按年度须向对方交纳三个月租金作为违约金。 </li>
                                    </div>
                                    <li>第十条</li>
                                    <div class="col-md-12">
                                        <li>因不可抗力原因导致该房屋毁损和造成损失的，双方互不承担责任。</li>
                                    </div>
                                    <li>第十一条</li>
                                    <div class="col-md-12">
                                        <li>本合同未尽事项，由甲、乙双方另行议定，并签订补充协议。补充协议与本合同不一致的，以补充协议为准。</li>
                                    </div>
                                    <li>第十二条</li>
                                    <div class="col-md-12">
                                        <li>本合同之附件均为本合同不可分割之一部分。本合同及其附件内，空格部分填写的文字与印刷文字具有同等效力。本合同及其附件和补充协议中未规定的事项，均遵照中华人民共和国有关法律、法规和政策执行。</li>
                                    </div>　
                                </div>
                            </ul>

                        </div>
                        <!-- /.box-body -->
                        <div class="box-footer clearfix">
                            <ul class="pagination pagination-sm no-margin pull-right">
                                <button id="agree" type="button" class="btn btn-primary">同意</button>
                                <button id="refuse" type="button" class="btn btn-primary">拒绝</button>
                            </ul>
                        </div>
                    </div>
                    <!-- /.box -->
                </div>
                <!-- /.col -->
            </div>
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
<script src="dist/js/bootstrap.js"></script>
<!-- Slimscroll -->
<script src="bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="bower_components/fastclick/lib/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="dist/js/demo.js"></script>
<!-- toastr -->
<script src="dist/js/toastr.js"></script>
<script type="text/javascript">

    $("#agree").click(function () {
        var contractId = "${contract.contractId}";
        $.ajax({
            url:"${pageContext.request.contextPath}/contract/contractProcess",
            type: "POST",
            contentType: "application/x-www-form-urlencoded;charset=utf-8",
            data :{"contractId" : contractId,"view" : "agree"},
            dataType: "text",
            success:function(data){
                if (data == "true") {
                    toastr.options.positionClass = 'toast-center-center';
                    toastr.info("合同完成");
                    setTimeout(function(){
                        $("#myModal").modal('hide');
                        window.location.href = "contract/selectByLandlordId";
                    },1000)
                }else {
                    toastr.options.positionClass = 'toast-center-center';
                    toastr.info("合同失败");
                }
            },
            error:function(){
                toastr.options.positionClass = 'toast-center-center';
                toastr.info("合同失败");
            }
        });
    });

    $("#refuse").click(function () {
        var contractId = "${contract.contractId}";
        $.ajax({
            url:"${pageContext.request.contextPath}/contract/contractProcess",
            type: "POST",
            contentType: "application/x-www-form-urlencoded;charset=utf-8",
            data :{"contractId" : contractId,"view" : "refuse"},
            dataType: "text",
            success:function(data){
                if (data == "true") {
                    toastr.options.positionClass = 'toast-center-center';
                    toastr.info("合同已拒绝");
                    setTimeout(function(){
                        $("#myModal").modal('hide');
                        window.location.href = "contract/selectByLandlordId";
                    },1000)
                }else {
                    toastr.options.positionClass = 'toast-center-center';
                    toastr.info("合同失败");
                }
            },
            error:function(){
                toastr.options.positionClass = 'toast-center-center';
                toastr.info("合同失败");
            }
        });
    });

</script>
</body>
</html>


