<%--
  Created by IntelliJ IDEA.
  User: 刘真
  Date: 2019/4/15
  Time: 23:51
  description: 房东录入申请审核
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
                        <li><a href="agency/dashBoard"><i class="fa fa-circle-o"></i> 仪表盘</a></li>
                    </ul>
                </li>
                <li class="treeview active" id="marketing">
                    <a href="#">
                        <i class="fa fa-edit"></i> <span>租赁处理</span>
                        <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                    </a>
                    <ul class="treeview-menu">
                        <li class="active"><a href="landlordApplication/selectByAgencyId"><i class="fa fa-circle-o"></i> 录入审核</a></li>
                        <li><a href="tenantApplication/selectByCond"><i class="fa fa-circle-o"></i>  租房审核</a></li>
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
                        <li id="create"><a href="contract/selectForAgency"><i class="fa fa-circle-o"></i> 房屋合同</a></li>
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
                        <li><a href="landlordApplication/selectForAgency"><i class="fa fa-circle-o"></i> 录入处理</a></li>
                        <li><a href="tenantApplication/selectCountForAgency"><i class="fa fa-circle-o"></i> 租赁处理</a></li>
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
                        <li><a href="/showagencyinfo"><i class="fa fa-circle-o"></i> 中介信息</a></li>
                        <li><a href="/showagencysystem"><i class="fa fa-circle-o"></i> 系统信息</a></li>
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
                录入审核
                <small>Entry review</small>
            </h1>
            <ol class="breadcrumb">
                <li><a><i class="fa fa-dashboard"></i> Home</a></li>
                <li>租赁处理</li>
                <li class="active">录入审核</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <form class="form-horizontal" role="form" action="house/selectByCond" method="post">
                    <div class="col-md-12">
                        <div class="box">
                            <div class="box-header with-border">
                                <h3 class="box-title">搜索条件</h3>
                            </div>
                            <div class="box-body">
                                <div class="col-md-4 form-group">
                                    <label for="firstname" class="col-sm-4 control-label">房东</label>
                                    <div class="col-sm-8">
                                        <input type="text" class="form-control" placeholder="" name="community">
                                    </div>
                                </div>
                                <div class="col-md-4 form-group">
                                    <label for="firstname" class="col-sm-4 control-label">中介</label>
                                    <div class="col-sm-8">
                                        <select class="form-control select2" style="width: 100%;" name="houseType">
                                            <option value="" selected="selected">全部</option>
                                            <option value="一室一厅一卫">一室一厅一卫</option>
                                            <option value="两室一厅一卫">两室一厅一卫</option>
                                            <option value="三室一厅一卫">三室一厅一卫</option>
                                            <option value="三室两厅一卫">三室两厅一卫</option>
                                        </select>
                                    </div>
                                </div>

                                <div class="col-md-4 form-group">
                                    <div class="col-md-6 form-group"></div>
                                    <div class="col-md-3 form-group">
                                        <button type="submit" class="btn btn-primary">查询</button>
                                    </div>
                                    <div class="col-md-2 form-group"></div>
                                    <div class="col-md-3 form-group">
                                        <button type="button" class="btn btn-primary">帮助</button>
                                    </div>
                                </div>

                            </div>
                            <!-- /.box-body -->
                        </div>
                        <!-- /.box -->
                    </div>
                    <!-- /.col -->

                </form>

            </div>
            <!-- /.row -->

            <div class="row">
                <div class="col-md-12">
                    <div class="box">
                        <div class="box-header with-border">
                            <h3 class="box-title">搜索结果</h3>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body">
                            <table class="table table-bordered" style="text-align: center">
                                <tr>
                                    <th style="width: 10%"><center>序号</center></th>
                                    <th style="width: 15%"><center>申请单类型</center></th>
                                    <th style="width: 20%"><center>房屋小区</center></th>
                                    <th style="width: 15%"><center>房东</center></th>
                                    <th style="width: 20%"><center>中介</center></th>
                                    <th style="width: 10%"><center>状态</center></th>
                                    <th style="width: 10%"><center>处理</center></th>
                                </tr>

                                <c:forEach items="${landlordApplications}" var="landlordApplications" varStatus="status">
                                    <tr>
                                        <td>${status.index + 1}</td>
                                        <td>${landlordApplications.applyType}</td>
                                        <td>${landlordApplications.community}</td>
                                        <td>${landlordApplications.landlordName}</td>
                                        <td>${landlordApplications.agencyName}</td>
                                        <td>${landlordApplications.status}</td>
                                        <td>
                                            <a onclick="house(${landlordApplications.applyId},${landlordApplications.houseId});" aria-label="处理">
                                                <i class="fa fa-tasks" aria-hidden="true"></i>
                                            </a>
                                        </td>
                                    </tr>
                                </c:forEach>

                            </table>
                        </div>
                        <!-- /.box-body -->
                        <div class="box-footer clearfix">
                            <ul class="pagination pagination-sm no-margin pull-right">
                                <li><a href="#">&laquo;</a></li>
                                <li><a href="#">1</a></li>
                                <li><a href="#">2</a></li>
                                <li><a href="#">3</a></li>
                                <li><a href="#">&raquo;</a></li>
                            </ul>
                        </div>
                    </div>
                    <!-- /.box -->
                </div>
                <!-- /.col -->
            </div>
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

<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <form id="tenantApplication">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"
                            aria-hidden="true">×
                    </button>
                    <h4 class="modal-title" id="myModalLabel">
                        录入审核
                    </h4>
                </div>
                <div class="modal-body">
                    <div class="row">
                        <div class="col-lg-1"></div>
                        <div class="col-lg-5 in-gp-tl">
                            <div class="input-group">
						<span class="input-group-btn">
							<p class="list-group-item1">小区&nbsp;</p>
						</span>
                                <input id="community" type="text" class="form-control" placeholder="" readonly="readonly">
                                <input id="houseId" type="hidden" name="houseId"/>
                            </div>
                        </div>
                        <div class="col-lg-5 in-gp-tl">
                            <div class="input-group">
						<span class="input-group-btn">
							<p class="list-group-item1">&nbsp;&nbsp;&nbsp;栋号&nbsp;</p>
						</span>
                                <input id="buildNum" type="text" class="form-control" placeholder="" readonly="readonly">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-1"></div>
                        <div class="col-lg-5 in-gp-tl">
                            <div class="input-group">
						<span class="input-group-btn">
							<p class="list-group-item1">层号&nbsp;</p>
						</span>
                                <input id="layerNum" type="text" class="form-control" placeholder="" readonly="readonly">
                            </div>
                        </div>
                        <div class="col-lg-5 in-gp-tl">
                            <div class="input-group">
						<span class="input-group-btn">
							<p class="list-group-item1">&nbsp;&nbsp;&nbsp;房号&nbsp;</p>
						</span>
                                <input id="roomNum" type="text" class="form-control" placeholder="" readonly="readonly">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-1"></div>
                        <div class="col-lg-5 in-gp-tl">
                            <div class="input-group">
						<span class="input-group-btn">
							<p class="list-group-item1">面积&nbsp;</p>
						</span>
                                <input id="houseArea" type="text" class="form-control" placeholder="" readonly="readonly">
                            </div>
                        </div>
                        <div class="col-lg-5 in-gp-tl">
                            <div class="input-group">
						<span class="input-group-btn">
							<p class="list-group-item1">&nbsp;&nbsp;&nbsp;户型&nbsp;</p>
						</span>
                                <input id="houseType" type="text" class="form-control" placeholder="" readonly="readonly">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-1"></div>
                        <div class="col-lg-5 in-gp-tl">
                            <div class="input-group">
						<span class="input-group-btn">
							<p class="list-group-item1">坐落&nbsp;</p>
						</span>
                                <input id="located" type="text" class="form-control" placeholder="" readonly="readonly">
                            </div>
                        </div>
                        <div class="col-lg-5 in-gp-tl">
                            <div class="input-group">
						<span class="input-group-btn">
							<p class="list-group-item1">&nbsp;&nbsp;&nbsp;位置&nbsp;</p>
						</span>
                                <input id="position" type="text" class="form-control" placeholder="" readonly="readonly">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-1"></div>
                        <div class="col-lg-5 in-gp-tl">
                            <div class="input-group">
						<span class="input-group-btn">
							<p class="list-group-item1">价格&nbsp;</p>
						</span>
                                <input id="price" type="text" class="form-control" placeholder="" readonly="readonly">
                            </div>
                        </div>
                        <div class="col-lg-5 in-gp-tl">
                            <div class="input-group">
						<span class="input-group-btn">
							<p class="list-group-item1">&nbsp;&nbsp;&nbsp;中介&nbsp;</p>
						</span>
                                <input id="agencyName" type="text" class="form-control" placeholder="" readonly="readonly">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-1"></div>
                        <div class="col-lg-5 in-gp-tl">
                            <div class="input-group">
						<span class="input-group-btn">
							<p class="list-group-item1">房东&nbsp;</p>
						</span>
                                <input id="image" type="text" class="form-control" placeholder="" readonly="readonly">
                            </div>
                        </div>
                        <div class="col-lg-5 in-gp-tl">
                            <div class="input-group">
						<span class="input-group-btn">
							<p class="list-group-item1">&nbsp;&nbsp;&nbsp;审核&nbsp;</p>
						</span>
                                <select class="form-control select2" style="width: 100%;" id="view">
                                    <option selected="selected">--请选择--</option>
                                    <option value="U">通过</option>
                                    <option value="E">不通过</option>
                                </select>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary" id="application">
                        提交
                    </button>
                </div>
            </form>
        </div>
    </div>
</div>
<!-- 模态框（Modal） -->

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

    var houseId;
    var applyId;

    function house(aId,hId) {

        $.ajax({
            url:"${pageContext.request.contextPath}/house/selectById",
            type: "POST",
            data :{"houseId" : hId},
            dataType:"json",
            success: function(data){
                if(data.houseId != 0) {
                    $('#community').val(data.community);
                    $('#buildNum').val(data.buildNum);
                    $('#layerNum').val(data.layerNum);
                    $('#roomNum').val(data.roomNum);
                    $('#houseArea').val(data.houseArea);
                    $('#houseType').val(data.houseType);
                    $('#located').val(data.located);
                    $('#position').val(data.position);
                    $('#price').val(data.price);
                    $('#agencyName').val(data.agencyName);
                    $('#image').val(data.image);

                    houseId =data.houseId;
                    applyId =aId;
                    $('#myModal').modal("show");
                }else {
                    toastr.options.positionClass = 'toast-center-center';
                    toastr.info("无法审核");
                }
            },
            error: function () {
                toastr.options.positionClass = 'toast-center-center';
                toastr.info("未知错误");
            },
        });

    }

    $("#application").click(function () {

        var view = $("#view option:selected").val();

        $.ajax({
            url:"${pageContext.request.contextPath}/landlordApplication/reviewForLandlord",
            type: "POST",
            contentType: "application/x-www-form-urlencoded;charset=utf-8",
            data :{"applyId" : applyId,"houseId" : houseId,"view" : view},
            dataType: "text",
            success:function(data){
                if (data == "true") {
                    toastr.options.positionClass = 'toast-center-center';
                    toastr.info("审核完成");
                    setTimeout(function(){
                        $("#myModal").modal('hide');
                        window.location.href = "landlordApplication/selectByAgencyId";
                    },1000)
                }else {
                    toastr.options.positionClass = 'toast-center-center';
                    toastr.info("审核失败");
                }
            },
            error:function(){
                toastr.options.positionClass = 'toast-center-center';
                toastr.info("审核失败");
            }
        });

    });



</script>
</body>
</html>


