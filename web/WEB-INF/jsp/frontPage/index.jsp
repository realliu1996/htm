<%--
  Created by IntelliJ IDEA.
  User: 刘真
  Date: 2019/2/28
  Time: 17:16
  description: 前台首页
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
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <link href="dist/css/bootstrap.css" rel="stylesheet"/>
    <link href="dist/css/style.css" rel="stylesheet"/>
    <!-- js -->
    <script src="dist/js/jquery-2.1.4.min.js"></script>
    <!-- //js -->
    <link rel="stylesheet" href="dist/css/jquery-ui1.css">
    <!-- font-awesome-icons -->
    <link href="bower_components/font-awesome/css/font-awesome.css" rel="stylesheet">
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
<div class="banner">
    <div class="container">
        <nav class="navbar navbar-default">
            <div class="collapse navbar-collapse navbar-right" id="bs-example-navbar-collapse-1">
                <nav class="link-effect-12">
                    <ul class="nav navbar-nav w3_agile_nav">
                        <li class="dropdown active">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span data-hover="Short Codes">首页</span> <b class="caret"></b></a>
                            <ul class="dropdown-menu agile_short_dropdown">
                                <li><a href="house/selectOrder">推荐</a></li>
                                <li><a href="house/selectAll">房源</a></li>
                                <li><a href="typography.html">中介</a></li>
                            </ul>
                        </li>
                        <li><a href="properties.html"><span>我的申请</span></a></li>
                        <li><a href="properties.html"><span>房屋合同</span></a></li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span data-hover="Short Codes">统计报表</span> <b class="caret"></b></a>
                            <ul class="dropdown-menu agile_short_dropdown">
                                <li><a href="index.html">我的收藏</a></li>
                                <li><a href="typography.html">我的租赁</a></li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span data-hover="Short Codes">基础数据</span> <b class="caret"></b></a>
                            <ul class="dropdown-menu agile_short_dropdown">
                                <li><a href="index.html">租客信息</a></li>
                                <li><a href="typography.html">系统信息</a></li>
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

<!-- services -->
<div class="services">
    <div class="container">
        <div class="w3layouts_header">
            <p><span><i class="fa fa-key" aria-hidden="true"></i></span></p>
            <h5>推荐 <span>房屋</span></h5>
        </div>
        <div class="w3_services_grids">
            <div class="col-md-4 w3l_services_grid">
                <div class="w3ls_services_grid agileits_services_grid"  style="background: url('https://www.realliu.cn/images/${sessionScope.houseList[0].image}') no-repeat 0px 0px;
                        background-size: cover;
                        -webkit-background-size: cover;
                        -moz-background-size: cover;
                        -o-background-size: cover;
                        -ms-background-size: cover;
                        border-bottom:3px solid #10b5fb;">
                    <div class="agile_services_grid1_sub">
                        <p>￥${sessionScope.houseList[0].price} </p>
                    </div>
                    <div class="agileinfo_services_grid_pos">
                        <i class="fa fa-user-o" aria-hidden="true"></i>
                    </div>
                </div>
                <div class="wthree_service_text">
                    <h3>${sessionScope.houseList[0].buildNum}</h3>
                    <h4 class="w3_agileits_service">${sessionScope.houseList[0].houseArea}㎡</h4>
                </div>
            </div>
            <div class="col-md-4 w3l_services_grid">
                <div class="w3ls_services_grid agileits_services_grid2" style="	background: url('https://www.realliu.cn/images/${sessionScope.houseList[1].image}') no-repeat 0px 0px;
                        background-size: cover;
                        -webkit-background-size: cover;
                        -moz-background-size: cover;
                        -o-background-size: cover;
                        -ms-background-size: cover;
                        border-bottom:3px solid #21e790;">
                    <div class="agile_services_grid1_sub agileits_w3layouts_ser_sub1">
                        <p>￥${sessionScope.houseList[1].price}</p>
                    </div>
                    <div class="agileinfo_services_grid_pos agile_services_grid_pos1">
                        <i class="fa fa-bath" aria-hidden="true"></i>
                    </div>
                </div>
                <div class="wthree_service_text">
                    <h3>${sessionScope.houseList[1].buildNum}</h3>
                    <h4 class="w3_agileits_service2">${sessionScope.houseList[1].houseArea}㎡</h4>
                </div>
            </div>
            <div class="col-md-4 w3l_services_grid">
                <div class="w3ls_services_grid agileits_services_grid1" style="	background: url('https://www.realliu.cn/images/${sessionScope.houseList[2].image}') no-repeat 0px 0px;
                        background-size: cover;
                        -webkit-background-size: cover;
                        -moz-background-size: cover;
                        -o-background-size: cover;
                        -ms-background-size: cover;
                        border-bottom:3px solid #e72121;">
                    <div class="agile_services_grid1_sub agileits_w3layouts_ser_sub">
                        <p>￥${sessionScope.houseList[2].price}</p>
                    </div>
                    <div class="agileinfo_services_grid_pos agile_services_grid_pos">
                        <i class="fa fa-home" aria-hidden="true"></i>
                    </div>
                </div>
                <div class="wthree_service_text">
                    <h3>${sessionScope.houseList[2].buildNum}</h3>
                    <h4 class="w3_agileits_service1">${sessionScope.houseList[2].houseArea}㎡</h4>
                </div>
            </div>
            <div class="col-md-6 w3l_services_grid">
                <div class="w3ls_services_grid agileits_services_grid3" style="	background: url('https://www.realliu.cn/images/${sessionScope.houseList[3].image}') no-repeat 0px 0px;
                        background-size: cover;
                        -webkit-background-size: cover;
                        -moz-background-size: cover;
                        -o-background-size: cover;
                        -ms-background-size: cover;
                        border-bottom:3px solid #a821e7;">
                    <div class="agile_services_grid1_sub agileits_w3layouts_ser_sub2">
                        <p>￥${sessionScope.houseList[3].price}</p>
                    </div>
                    <div class="agileinfo_services_grid_pos agile_services_grid_pos2">
                        <i class="fa fa-home" aria-hidden="true"></i>
                    </div>
                </div>
                <div class="wthree_service_text">
                    <h3>${sessionScope.houseList[3].buildNum}</h3>
                    <h4 class="w3_agileits_service3">${sessionScope.houseList[3].houseArea}㎡</h4>
                </div>
            </div>
            <div class="col-md-6 w3l_services_grid">
                <div class="w3ls_services_grid agileits_services_grid4" style="	background: url('https://www.realliu.cn/images/${sessionScope.houseList[4].image}') no-repeat 0px 0px;
                        background-size: cover;
                        -webkit-background-size: cover;
                        -moz-background-size: cover;
                        -o-background-size: cover;
                        -ms-background-size: cover;
                        border-bottom:3px solid #fbb810;">
                    <div class="agile_services_grid1_sub agileits_w3layouts_ser_sub3">
                        <p>￥${sessionScope.houseList[4].price}</p>
                    </div>
                    <div class="agileinfo_services_grid_pos agile_services_grid_pos3">
                        <i class="fa fa-home" aria-hidden="true"></i>
                    </div>
                </div>
                <div class="wthree_service_text">
                    <h3>${sessionScope.houseList[4].buildNum}</h3>
                    <h4 class="w3_agileits_service4">${sessionScope.houseList[4].houseArea}㎡</h4>
                </div>
            </div>
            <div class="clearfix"> </div>
        </div>
    </div>
</div>
<!-- //services -->
<!-- skills -->
<div class="skills">
    <div class="container">
        <div class="w3layouts_header w3_agile_head">
            <p><span><i class="fa fa-bullseye" aria-hidden="true"></i></span></p>
            <h5>我们的 <span>服务</span></h5>
        </div>
        <div class="w3layouts_skills_grids">
            <div class="col-md-3 w3ls_about_guage">
                <h4>房源品质</h4>
                <canvas id="gauge1" width="200" height="100"></canvas>
            </div>
            <div class="col-md-3 w3ls_about_guage">
                <h4>房源地段</h4>
                <canvas id="gauge2" width="200" height="100"></canvas>
            </div>
            <div class="col-md-3 w3ls_about_guage">
                <h4>房源价格</h4>
                <canvas id="gauge3" width="200" height="100"></canvas>
            </div>
            <div class="col-md-3 w3ls_about_guage">
                <h4>服务质量</h4>
                <canvas id="gauge4" width="200" height="100"></canvas>
            </div>
            <div class="clearfix"> </div>
        </div>
    </div>
</div>
<!-- //skills -->
<!-- //featured-services -->
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
<!-- gauge-meter -->
<script src="dist/js/jquery.gauge.js"></script>
<!-- toastr -->
<script src="dist/js/toastr.js"></script>
<script>

    var userName = "${sessionScope.user.userName }";
    var msg = "${sessionScope.msg }";

    $(document).ready(function (){
        $("#gauge1").gauge(90,{color: "#fb5710",unit: " %",type: "halfcircle"});
        $("#gauge2").gauge(90, {color: "#a821e7", unit: " %",type: "halfcircle"});
        $("#gauge3").gauge(95, {color: "#fbb810",unit: " %",type: "halfcircle"});
        $("#gauge4").gauge(90, {color: "#21d0e7",unit: " %",type: "halfcircle"});
    });

    function init() {

        if (userName !=""){
            $('#userInfo').html("欢迎租客 "+userName);
            $('#inout').attr("href","/exitIndex");
            $('#login').html("注销");
        }

        if (msg !=""){
            toastr.options.positionClass = 'toast-center-center';
            toastr.info(msg);
            <c:remove var="msg" scope="session"/>
        }

    }


</script>
<!-- //gauge-meter -->
<!-- range -->
<script src="dist/js/jquery-ui.js"></script>
<!-- start-smooth-scrolling -->
<script src="dist/js/move-top.js"></script>
<script src="dist/js/easing.js"></script>
<!-- for bootstrap working -->
<script src="dist/js/bootstrap.js"></script>
<!-- //for bootstrap working -->
</body>
</html>
