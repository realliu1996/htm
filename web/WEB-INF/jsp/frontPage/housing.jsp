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
</head>
<body>
<!-- header -->
<div class="header">
    <div class="container">
        <div class="w3_agile_logo">
            <h1><a href="house/selectOrder"><span>HTM</span>二手房屋租赁</a></h1>
        </div>
        <div class="agile_header_social">
            <ul class="agileits_social_list">
                <li><a href="#" class="w3_agile_facebook"><i class="fa fa-facebook" aria-hidden="true"></i></a></li>
                <li><a href="#" class="agile_twitter"><i class="fa fa-twitter" aria-hidden="true"></i></a></li>
                <li><a href="#" class="w3_agile_dribble"><i class="fa fa-dribbble" aria-hidden="true"></i></a></li>
                <li><a href="#" class="w3_agile_vimeo"><i class="fa fa-vimeo" aria-hidden="true"></i></a></li>
            </ul>
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
                        <li><a href="/showlogin"><span>登录</span></a></li>
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
            </c:forEach>


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
<!-- start-smooth-scrolling -->
<script type="text/javascript" src="dist/js/move-top.js"></script>
<script type="text/javascript" src="dist/js/easing.js"></script>
<!-- for bootstrap working -->
<script src="dist/js/bootstrap.js"></script>
</body>
</html>
