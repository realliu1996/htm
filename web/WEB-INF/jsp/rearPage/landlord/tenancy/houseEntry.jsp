<%--
  Created by IntelliJ IDEA.
  User: 刘真
  Date: 2019/1/22
  Time: 14:56
  description: 房屋录入页面
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
    <!-- iCheck for checkboxes and radio inputs -->
    <link rel="stylesheet" href="plugins/iCheck/all.css">
    <!-- Select2 -->
    <link rel="stylesheet" href="bower_components/select2/dist/css/select2.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="dist/css/AdminLTE.min.css">
    <!-- AdminLTE Skins. Choose a skin from the css/skins
         folder instead of downloading all of them to reduce the load. -->
    <link rel="stylesheet" href="dist/css/skins/_all-skins.min.css">
    <!-- toastr -->
    <link rel="stylesheet" href="dist/css/toastr.css">

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
<body class="hold-transition skin-blue sidebar-mini" onload="start();">
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
                        <li><a href="/showLandlordHome"><i class="fa fa-circle-o"></i> 我的房源</a></li>
                    </ul>
                </li>
                <li class="treeview active" id="marketing">
                    <a href="#">
                        <i class="fa fa-edit"></i> <span>房屋租赁</span>
                        <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                        </span>
                    </a>
                    <ul class="treeview-menu">
                        <li id="sales" class="active"><a href="/showhouseentry"><i class="fa fa-circle-o"></i> 房屋录入</a></li>
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
                房屋租赁管理
                <small>Basic data management</small>
            </h1>
            <ol class="breadcrumb">
                <li><a><i class="fa fa-dashboard"></i> Home</a></li>
                <li><a>房屋租赁管理</a></li>
                <li class="active">房屋录入</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <form id="form" class="form-horizontal" action="house/addHouse" method="post">
            <div class="row">
                <!-- left column -->
                <div class="col-md-6">
                    <div class="box box-default">
                        <div class="box-header with-border">
                            <h3 class="box-title">房屋录入</h3>
                        </div>
                        <!-- /.box-header -->
                            <div class="box-body">
                                <div class="row">
                                    <div class="col-md-8">
                                        <div class="form-group">
                                            <label class="col-sm-4 control-label">小区</label>
                                            <div class="col-sm-8">
                                                <input type="hidden" name="userId" value="${sessionScope.user.userId }">
                                                <select class="form-control select2" style="width: 100%;" id="community" name="community">
                                                    <option selected="selected" value="红谷新城">红谷新城</option>
                                                    <option value="绿地香颂">绿地香颂</option>
                                                    <option value="城开国际">城开国际</option>
                                                </select>
                                            </div>
                                        </div>
                                        <!-- /.form-group -->
                                        <div class="form-group">
                                            <label class="col-sm-4 control-label">栋号</label>
                                            <div id="firstHouse" class="col-sm-8">
                                                <select class="form-control select2" style="width: 100%;" id="firstBuild" name="buildNum">
                                                    <option selected="selected">--请选择--</option>
                                                    <option value="红谷新城1栋">红谷新城1栋</option>
                                                    <option value="红谷新城2栋">红谷新城2栋</option>
                                                    <option value="红谷新城3栋">红谷新城3栋</option>
                                                    <option value="红谷新城4栋">红谷新城4栋</option>
                                                    <option value="红谷新城5栋">红谷新城5栋</option>
                                                </select>
                                            </div>
                                            <div id="secondHouse" class="col-sm-8" hidden="hidden">
                                                <select class="form-control select2" style="width: 100%;" id="secondBuild" name="buildNum" disabled="disabled">
                                                    <option selected="selected">--请选择--</option>
                                                    <option value="绿地香颂A栋">绿地香颂A栋</option>
                                                    <option value="绿地香颂B栋">绿地香颂B栋</option>
                                                    <option value="绿地香颂C栋">绿地香颂C栋</option>
                                                    <option value="绿地香颂D栋">绿地香颂D栋</option>
                                                </select>
                                            </div>
                                            <div id="thirdHouse" class="col-sm-8" hidden="hidden">
                                                <select class="form-control select2" style="width: 100%;" id="thirdBuild" name="buildNum" disabled="disabled">
                                                    <option selected="selected">--请选择--</option>
                                                    <option value="城开国际1栋">城开国际1栋</option>
                                                    <option value="城开国际2栋">城开国际2栋</option>
                                                    <option value="城开国际3栋">城开国际3栋</option>
                                                    <option value="城开国际4栋">城开国际4栋</option>
                                                    <option value="城开国际5栋">城开国际5栋</option>
                                                </select>
                                            </div>
                                        </div>
                                        <!-- /.form-group -->
                                        <div class="form-group">
                                            <label class="col-sm-4 control-label">层号</label>
                                            <div class="col-sm-8">
                                                <input type="text" class="form-control" placeholder="" name="layerNum" id="layerNum">
                                            </div>
                                        </div>
                                        <!-- /.form-group -->
                                        <div class="form-group">
                                            <label class="col-sm-4 control-label">房号</label>
                                            <div class="col-sm-8">
                                                <input type="text" class="form-control" placeholder="" name="roomNum" id="roomNum">
                                            </div>
                                        </div>
                                        <!-- /.form-group -->

                                    </div>
                                    <!-- /.col -->
                                </div>
                                <!-- /.row -->
                            </div>
                            <!-- /.box-body -->
                    </div>
                    <!-- /.box -->
                    <!-- /.row -->
                </div>


                <div class="col-md-6">

                    <div class="box box-default">
                        <div class="box-header with-border">
                            <h3 class="box-title">房屋图片</h3>
                        </div>
                        <!-- /.box-header -->
                            <div class="box-body">
                                <div class="row">
                                    <div class="col-sm-12 col-md-12">
                                        <a class="center-block thumbnail" style="height: 145px;">
                                            <img  id="image" src="" alt="" width="130px">
                                        </a>
                                        <center>
                                        <div class="file-container" style="display:inline-block;position:relative;overflow: hidden;vertical-align:middle">
                                            <button class="btn btn-sm btn-success fileinput-button" type="button">上传</button>
                                            <input type="file" id="file" onchange="uploadImg()" style="position:absolute;top:0;left:0;font-size:34px; opacity:0">
                                            <input type="hidden" name="image" id="imageName">
                                            <input type="hidden" name="imagePath" id="imagePath">
                                            <span id="fileName"></span>
                                        </div>
                                        </center>
                                    </div>
                                </div>
                                <!-- /.row -->
                            </div>
                            <!-- /.box-body -->
                    </div>
                    <!-- /.box -->
                    <!-- /.row -->
                </div>

                <div class="col-md-12">

                    <div class="box box-default">
                            <div class="box-body">
                                <div class="row">
                                    <div class="col-md-4">
                                        <div class="form-group">
                                            <label class="col-sm-4 control-label">房源面积</label>
                                            <div class="col-sm-8">
                                                <input type="text" class="form-control" placeholder="㎡" name="houseArea">
                                            </div>
                                        </div>
                                        <!-- /.form-group -->
                                        <div class="form-group">
                                            <label class="col-sm-4 control-label">户型</label>
                                            <div class="col-sm-8">
                                                <select class="form-control select2" style="width: 100%;" name="houseType">
                                                    <option selected="selected">--请选择--</option>
                                                    <option value="一室一厅一卫">一室一厅一卫</option>
                                                    <option value="两室一厅一卫">两室一厅一卫</option>
                                                    <option value="三室一厅一卫">三室一厅一卫</option>
                                                    <option value="三室两厅一卫">三室两厅一卫</option>
                                                </select>
                                            </div>
                                        </div>
                                        <!-- /.form-group -->
                                        <div class="form-group">
                                            <label class="col-sm-4 control-label">坐落</label>
                                            <div class="col-sm-8">
                                                <select class="form-control select2" style="width: 100%;" name="located">
                                                    <option selected="selected">--请选择--</option>
                                                    <option value="城中区">城中区</option>
                                                    <option value="郊区">郊区</option>
                                                    <option value="城乡结合部">城乡结合部</option>
                                                </select>
                                            </div>
                                        </div>
                                        <!-- /.form-group -->

                                    </div>
                                    <!-- /.col -->
                                    <div class="col-md-2"></div>

                                    <div class="col-md-4">
                                        <div class="form-group">
                                            <label class="col-sm-4 control-label">位置</label>
                                            <div class="col-sm-8">
                                                <input type="text" class="form-control" placeholder="" value="" name="position" id="position">
                                            </div>
                                        </div>
                                        <!-- /.form-group -->
                                        <div class="form-group">
                                            <label class="col-sm-4 control-label">价格</label>
                                            <div class="col-sm-8">
                                                <input type="text" class="form-control" placeholder="元/月" name="price">
                                            </div>
                                        </div>
                                        <!-- /.form-group -->
                                        <div class="form-group">
                                            <label class="col-sm-4 control-label">中介</label>
                                            <div class="col-sm-8">
                                                <select class="form-control select2" style="width: 100%;" name="agencyId">
                                                    <option selected="selected">--请选择--</option>
                                                    <c:forEach items="${allAgency}" var="agency">
                                                    <option value="${agency.agencyId}"><c:out value="${agency.agencyName}"/></option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                        <!-- /.form-group -->

                                    </div>
                                    <!-- /.col -->


                                </div>
                                <!-- /.row -->
                            </div>

                            <!-- /.box-body -->
                            <div class="box-footer">
                                <div class="col-md-5 form-group">
                                </div>
                                <div class="col-md-1 form-group">
                                    <button type="submit" class="btn btn-primary">保存</button>
                                </div>
                                <div class="col-md-1 form-group">
                                    <button type="button" class="btn btn-primary" onclick="javascript:history.back(1);">返回</button>
                                </div>
                            </div>
                    </div>
                    <!-- /.box -->
                    <!-- /.row -->
                </div>

            </div>
            </form>
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
<!-- toastr -->
<script src="dist/js/toastr.js"></script>
<script type="text/javascript">

    var buildNum = "";
    var layerNum = "";
    var roomNum = "";
    var msg="${sessionScope.msg }";

    function start() {
        if (msg != ""){
            toastr.options.positionClass = 'toast-center-center';
            toastr.info(msg);
            <c:remove var="msg" scope="session"/>
        }
    }

    $("#community").change(function () {

        community = $("#community option:selected").val();

        if (community == "红谷新城") {
            $("#firstHouse").removeAttr("hidden");
            $("#firstBuild").removeAttr("disabled");
            $("#secondHouse").attr("hidden","hidden");
            $("#secondBuild").attr("disabled","disabled");
            $("#thirdHouse").attr("hidden","hidden");
            $("#thirdBuild").attr("disabled","disabled");
        }else if (community == "绿地香颂") {
            $("#secondHouse").removeAttr("hidden");
            $("#secondBuild").removeAttr("disabled");
            $("#firstHouse").attr("hidden","hidden");
            $("#firstBuild").attr("disabled","disabled");
            $("#thirdHouse").attr("hidden","hidden");
            $("#thirdBuild").attr("disabled","disabled");
        }else if (community == "城开国际") {
            $("#thirdHouse").removeAttr("hidden");
            $("#thirdBuild").removeAttr("disabled");
            $("#secondHouse").attr("hidden","hidden");
            $("#secondBuild").attr("disabled","disabled");
            $("#firstHouse").attr("hidden","hidden");
            $("#firstBuild").attr("disabled","disabled");
        }

    });

    $("#firstBuild").change(function () {
        buildNum = $("#firstBuild option:selected").val();
        $("#position").attr("value",buildNum);
    });

    $("#secondBuild").change(function () {
        buildNum = $("#secondBuild option:selected").val();
        $("#position").attr("value",buildNum);
    });

    $("#thirdBuild").change(function () {
        buildNum = $("#thirdBuild option:selected").val();
        $("#position").attr("value",buildNum);
    });

    $("#layerNum").blur(function () {
        layerNum = $("#layerNum").val();
        if (layerNum != "") {
            $("#position").attr("value",buildNum+layerNum+"层");
        }else {
            toastr.options.positionClass = 'toast-center-center';
            toastr.info("层号不能为空");
        }
    })

    $("#roomNum").blur(function () {
        roomNum = $("#roomNum").val();
        if (roomNum != "") {
            $("#position").attr("value",buildNum+layerNum+"层"+roomNum+"号");
        }else {
            toastr.options.positionClass = 'toast-center-center';
            toastr.info("房号不能为空");
        }
    })

    //ajax提交信息
    function uploadImg() {

        var formData = new FormData();
        formData.append("file", $("#file")[0].files[0]);

        if($("#file").val() != "") {
            $.ajax({
                url:"${pageContext.request.contextPath}/landlord/uploadFile",
                type: "POST",
                cache: false,
                data :formData,
                contentType: false,
                processData: false,
                dataType:"json",
                success: function(data){
                    if(data.code == 0) {
                        //图片显示
                        $("#imagePath").attr("value",data.url);
                        $("#imageName").attr("value",data.title);
                        $("#image").attr("src","https://www.realliu.cn/images/"+data.title);
                        $("#fileName").html(data.filename);
                    }else {
                        toastr.options.positionClass = 'toast-center-center';
                        toastr.info("上传失败");
                    }
                },
                error: function () {
                    toastr.options.positionClass = 'toast-center-center';
                    toastr.info("上传失败");
                },
            });
        } else {
            toastr.options.positionClass = 'toast-center-center';
            toastr.info("请先选择文件");
        }
    }


</script>
</body>
</html>
