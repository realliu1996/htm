<%--
  Created by IntelliJ IDEA.
  User: 刘真
  Date: 2019/2/28
  Time: 17:32
  description: 房源页面
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
    <title>二手房屋租赁系统</title>
    <link rel="icon" href="image/index.ico"/>
    <!-- custom-theme -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="Tenements Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template,
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
    function hideURLbar(){ window.scrollTo(0,1); } </script>
    <!-- //custom-theme -->
    <link href="dist/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
    <link href="dist/css/style.css" rel="stylesheet" type="text/css" media="all" />
    <!-- js -->
    <script type="text/javascript" src="dist/js/jquery-2.1.4.min.js"></script>
    <!-- //js -->
    <!-- font-awesome-icons -->
    <link href="bower_components/font-awesome/css/font-awesome.css" rel="stylesheet">
    <!-- //font-awesome-icons -->
    <!-- toastr -->
    <link rel="stylesheet" href="dist/css/toastr.css">
</head>
<body onload="init()">
<!-- header -->
<div class="header">
    <div class="container">
        <div class="w3_agile_logo">
            <h1><a href="house/selectOrder"><span>HTM</span>二手房屋租赁</a></h1>
        </div>
        <div class="agile_header_social">
            <br/>
            <h4><span id="userInfo">未登录</span></h4>
        </div>
        <div class="clearfix"> </div>
    </div>
</div>
<!-- header -->
<!-- banner -->
<div class="banner1">
    <div class="container">
        <nav class="navbar navbar-default">
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse navbar-right" id="bs-example-navbar-collapse-1">
                <nav class="link-effect-12">
                    <ul class="nav navbar-nav w3_agile_nav">
                        <li class="dropdown active">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span data-hover="Short Codes">首页</span> <b class="caret"></b></a>
                            <ul class="dropdown-menu agile_short_dropdown">
                                <li><a href="house/selectOrder">推荐</a></li>
                                <li><a href="house/selectAll">房源</a></li>
                                <li><a href="tenant/selectAllAgency">中介</a></li>
                            </ul>
                        </li>
                        <li><a href="tenantApplication/selectByCondForTenant"><span>我的申请</span></a></li>
                        <li><a href="contract/selectByTenantId"><span>房屋合同</span></a></li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span data-hover="Short Codes">统计报表</span> <b class="caret"></b></a>
                            <ul class="dropdown-menu agile_short_dropdown">
                                <li><a href="contract/selectCountForTenant">我的合同</a></li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span data-hover="Short Codes">基础数据</span> <b class="caret"></b></a>
                            <ul class="dropdown-menu agile_short_dropdown">
                                <li><a href="/showFTenantInfo">租客信息</a></li>
                                <li><a href="/showFTenantSystem">系统信息</a></li>
                            </ul>
                        </li>
                        <li><a id="inout" href="/showlogin"><span id="login">登录</span></a></li>
                    </ul>
                    <div class="w3_agileits_search_form">
                        <form action="#" method="post">
                            <input type="search" name="Search" placeholder="Search" required="">
                            <input type="submit" value=" ">
                        </form>
                    </div>
                </nav>
            </div>
        </nav>
    </div>
</div>
<!-- //banner -->
<!-- properties -->
<div class="services">
    <div class="container">
        <div class="w3layouts_header">
            <p><span><i class="fa fa-building-o" aria-hidden="true"></i></span></p>
            <h5>所有 <span>房源</span></h5>
        </div>
        <div class="w3_services_grids">

            <c:forEach items="${houses}" var="houses">
            <a onclick="house(${houses.houseId});">
            <div class="col-md-4 w3l_services_grid">
                <div class="w3ls_services_grid agileits_services_grid" style="background: url('https://www.realliu.cn/images/${houses.image}') no-repeat 0px 0px;
                    background-size: cover;
                    -webkit-background-size: cover;
                    -moz-background-size: cover;
                    -o-background-size: cover;
                    -ms-background-size: cover;
	                border-bottom:3px solid #10b5fb;">
                    <div class="agile_services_grid1_sub">
                        <p>￥${houses.price}</p>
                    </div>
                    <div class="agileinfo_services_grid_pos agile_services_grid_pos">
                        <i class="fa fa-home" aria-hidden="true"></i>
                    </div>
                </div>
                <div class="wthree_service_text">
                    <h3>${houses.buildNum}</h3>
                    <h4 class="w3_agileits_service">${houses.houseArea}㎡</h4>
                </div>
            </div>
            </a>
            </c:forEach>
            <div class="col-md-9"></div>
            <div class="col-md-3">
                <div class="col-md-4"></div>
                <nav>
                    <ul class="pagination">
                        <li><a href="#" aria-label="Previous"><span aria-hidden="true">«</span></a></li>
                        <li><a href="#">首页</a></li>
                        <li><a href="#">尾页</a></li>
                        <li><a href="#" aria-label="Next"><span aria-hidden="true">»</span></a></li>
                    </ul>
                </nav>
            </div>
            <div class="clearfix"> </div>
        </div>
    </div>
</div>
<!-- //properties -->
<!-- footer -->
<div class="newsletter">
    <div class="container">
        <div class="w3ls_footer_grid">
            <div class="col-md-4 w3ls_footer_grid_left">
                <div class="w3ls_footer_grid_leftl">
                    <i class="fa fa-map-marker" aria-hidden="true"></i>
                </div>
                <div class="w3ls_footer_grid_leftr">
                    <h4>网站</h4>
                    <p>https://www.realliu.cn</p>
                </div>
                <div class="clearfix"> </div>
            </div>
            <div class="col-md-4 w3ls_footer_grid_left">
                <div class="w3ls_footer_grid_leftl">
                    <i class="fa fa-envelope" aria-hidden="true"></i>
                </div>
                <div class="w3ls_footer_grid_leftr">
                    <h4>邮箱</h4>
                    <p>1091041698@qq.com</p>
                </div>
                <div class="clearfix"> </div>
            </div>
            <div class="col-md-4 w3ls_footer_grid_left">
                <div class="w3ls_footer_grid_leftl">
                    <i class="fa fa-phone" aria-hidden="true"></i>
                </div>
                <div class="w3ls_footer_grid_leftr">
                    <h4>联系方式</h4>
                    <p>17770843724</p>
                </div>
                <div class="clearfix"> </div>
            </div>
            <div class="clearfix"> </div>
        </div>
    </div>
    <div class="w3l_footer_pos">
        <p>Copyright &copy; 2019 All Rights Reserved | <a href="https://www.realliu.cn">realliu</a></p>
    </div>
</div>
<!-- //footer -->

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
                    租房申请
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
							<p class="list-group-item1">&nbsp;&nbsp;&nbsp;时间&nbsp;</p>
						</span>
                            <select class="form-control select2" style="width: 100%;" name="rentalTime">
                                <option selected="selected">--请选择--</option>
                                <option value="6">半年</option>
                                <option value="12">一年</option>
                                <option value="24">两年</option>
                                <option value="36">三年</option>
                            </select>
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="application">
                    提交申请
                </button>
            </div>
            </form>
        </div>
    </div>
</div>
<!-- 模态框（Modal） -->

<script type="text/javascript" src="dist/js/move-top.js"></script>
<script type="text/javascript" src="dist/js/easing.js"></script>
<!-- for bootstrap working -->
<script src="dist/js/bootstrap.js"></script>
<!-- toastr -->
<script src="dist/js/toastr.js"></script>
<script>

    var userName = "${sessionScope.user.userName }";

    function init() {

        if (userName !=""){
            $('#userInfo').html("欢迎租客 "+userName);
            $('#userInfo').css("color","blue");
            $('#inout').attr("href","/exitIndex");
            $('#login').html("注销");
        }

    }


    function house(houseId) {

        $.ajax({
            url:"${pageContext.request.contextPath}/house/selectById",
            type: "POST",
            data :{"houseId" : houseId},
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

                    $('#houseId').val(data.houseId);

                    $('#myModal').modal("show");
                }else {
                    toastr.options.positionClass = 'toast-center-center';
                    toastr.info("无法申请");
                }
            },
            error: function () {
                toastr.options.positionClass = 'toast-center-center';
                toastr.info("请登录");
            },
        });

    }

    $("#application").click(function () {

        var data = $("#tenantApplication").serialize();

        $.ajax({
            url:"${pageContext.request.contextPath}/tenantApplication/addTenantApplication",
            type:"POST",
            contentType: "application/x-www-form-urlencoded;charset=utf-8",
            data:data,
            dataType:"text",
            success:function(data){
                if (data == "true") {
                    toastr.options.positionClass = 'toast-center-center';
                    toastr.info("申请成功");
                    setTimeout(function(){
                        $("#myModal").modal('hide');
                        window.location.href = "house/selectAll";
                    },1000)
                }else {
                    toastr.options.positionClass = 'toast-center-center';
                    toastr.info("申请失败");
                }
            },
            error:function(){
                toastr.options.positionClass = 'toast-center-center';
                toastr.info("申请失败");
            }
        });

    });

</script>
</body>
</html>
