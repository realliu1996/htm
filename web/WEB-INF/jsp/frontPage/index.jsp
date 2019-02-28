<%--
  Created by IntelliJ IDEA.
  User: 刘真
  Date: 2019/2/28
  Time: 17:16
  description: 前台首页
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
</head>
<body>
<!-- header -->
<div class="header">
    <div class="container">
        <div class="w3_agile_logo">
            <h1><a href="index.html"><span>HTM</span>二手房屋租赁</a></h1>
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
<div class="banner">
    <div class="container">
        <nav class="navbar navbar-default">
            <div class="collapse navbar-collapse navbar-right" id="bs-example-navbar-collapse-1">
                <nav class="link-effect-12">
                    <ul class="nav navbar-nav w3_agile_nav">
                        <li class="dropdown active">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span data-hover="Short Codes">首页</span> <b class="caret"></b></a>
                            <ul class="dropdown-menu agile_short_dropdown">
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

<!-- services -->
<div class="services">
    <div class="container">
        <div class="w3layouts_header">
            <p><span><i class="fa fa-key" aria-hidden="true"></i></span></p>
            <h5>推荐 <span>房屋</span></h5>
        </div>
        <div class="w3_services_grids">
            <div class="col-md-4 w3l_services_grid">
                <div class="w3ls_services_grid agileits_services_grid">
                    <div class="agile_services_grid1_sub">
                        <p>$ 32,000</p>
                    </div>
                    <div class="agileinfo_services_grid_pos">
                        <i class="fa fa-user-o" aria-hidden="true"></i>
                    </div>
                </div>
                <div class="wthree_service_text">
                    <h3>2 Bedroom house for rent</h3>
                    <h4 class="w3_agileits_service">Reality Agency</h4>
                    <ul>
                        <li><i class="fa fa-star" aria-hidden="true"></i></li>
                        <li><i class="fa fa-star" aria-hidden="true"></i></li>
                        <li><i class="fa fa-star-half-o" aria-hidden="true"></i></li>
                        <li><i class="fa fa-star-o" aria-hidden="true"></i></li>
                        <li><i class="fa fa-star-o" aria-hidden="true"></i></li>
                        <li>(543)</li>
                    </ul>
                </div>
            </div>
            <div class="col-md-4 w3l_services_grid">
                <div class="w3ls_services_grid agileits_services_grid2">
                    <div class="agile_services_grid1_sub agileits_w3layouts_ser_sub1">
                        <p>$ 12,000</p>
                    </div>
                    <div class="agileinfo_services_grid_pos agile_services_grid_pos1">
                        <i class="fa fa-bath" aria-hidden="true"></i>
                    </div>
                </div>
                <div class="wthree_service_text">
                    <h3>High rise Buildings for rent</h3>
                    <h4 class="w3_agileits_service2">Reality Agency</h4>
                    <ul>
                        <li><i class="fa fa-star" aria-hidden="true"></i></li>
                        <li><i class="fa fa-star" aria-hidden="true"></i></li>
                        <li><i class="fa fa-star" aria-hidden="true"></i></li>
                        <li><i class="fa fa-star" aria-hidden="true"></i></li>
                        <li><i class="fa fa-star-half-o" aria-hidden="true"></i></li>
                        <li>(4321)</li>
                    </ul>
                </div>
            </div>
            <div class="col-md-4 w3l_services_grid">
                <div class="w3ls_services_grid agileits_services_grid1">
                    <div class="agile_services_grid1_sub agileits_w3layouts_ser_sub">
                        <p>$ 45,000</p>
                    </div>
                    <div class="agileinfo_services_grid_pos agile_services_grid_pos">
                        <i class="fa fa-home" aria-hidden="true"></i>
                    </div>
                </div>
                <div class="wthree_service_text">
                    <h3>Big luxury house for rent</h3>
                    <h4 class="w3_agileits_service1">Reality Agency</h4>
                    <ul>
                        <li><i class="fa fa-star" aria-hidden="true"></i></li>
                        <li><i class="fa fa-star" aria-hidden="true"></i></li>
                        <li><i class="fa fa-star" aria-hidden="true"></i></li>
                        <li><i class="fa fa-star-half-o" aria-hidden="true"></i></li>
                        <li><i class="fa fa-star-o" aria-hidden="true"></i></li>
                        <li>(854)</li>
                    </ul>
                </div>
            </div>
            <div class="col-md-6 w3l_services_grid">
                <div class="w3ls_services_grid agileits_services_grid3">
                    <div class="agile_services_grid1_sub agileits_w3layouts_ser_sub2">
                        <p>$ 23,543</p>
                    </div>
                    <div class="agileinfo_services_grid_pos agile_services_grid_pos2">
                        <i class="fa fa-home" aria-hidden="true"></i>
                    </div>
                </div>
                <div class="wthree_service_text">
                    <h3>Low rise Buildings for rent</h3>
                    <h4 class="w3_agileits_service3">Reality Agency</h4>
                    <ul>
                        <li><i class="fa fa-star" aria-hidden="true"></i></li>
                        <li><i class="fa fa-star" aria-hidden="true"></i></li>
                        <li><i class="fa fa-star" aria-hidden="true"></i></li>
                        <li><i class="fa fa-star-half-o" aria-hidden="true"></i></li>
                        <li><i class="fa fa-star-o" aria-hidden="true"></i></li>
                        <li>(231)</li>
                    </ul>
                </div>
            </div>
            <div class="col-md-6 w3l_services_grid">
                <div class="w3ls_services_grid agileits_services_grid4">
                    <div class="agile_services_grid1_sub agileits_w3layouts_ser_sub3">
                        <p>$ 45,426</p>
                    </div>
                    <div class="agileinfo_services_grid_pos agile_services_grid_pos3">
                        <i class="fa fa-home" aria-hidden="true"></i>
                    </div>
                </div>
                <div class="wthree_service_text">
                    <h3>Low rise Buildings for rent</h3>
                    <h4 class="w3_agileits_service4">Reality Agency</h4>
                    <ul>
                        <li><i class="fa fa-star" aria-hidden="true"></i></li>
                        <li><i class="fa fa-star" aria-hidden="true"></i></li>
                        <li><i class="fa fa-star-half-o" aria-hidden="true"></i></li>
                        <li><i class="fa fa-star-o" aria-hidden="true"></i></li>
                        <li><i class="fa fa-star-o" aria-hidden="true"></i></li>
                        <li>(653)</li>
                    </ul>
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
                <h4>Make Money</h4>
                <canvas id="gauge1" width="200" height="100"></canvas>
            </div>
            <div class="col-md-3 w3ls_about_guage">
                <h4>Matching Buyer</h4>
                <canvas id="gauge2" width="200" height="100"></canvas>
            </div>
            <div class="col-md-3 w3ls_about_guage">
                <h4>Market Appraisals</h4>
                <canvas id="gauge3" width="200" height="100"></canvas>
            </div>
            <div class="col-md-3 w3ls_about_guage">
                <h4>Support</h4>
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
<script>
    $(document).ready(function (){
        $("#gauge1").gauge(30,{color: "#fb5710",unit: " %",type: "halfcircle"});
        $("#gauge2").gauge(70, {color: "#a821e7", unit: " %",type: "halfcircle"});
        $("#gauge3").gauge(75, {color: "#fbb810",unit: " %",type: "halfcircle"});
        $("#gauge4").gauge(90, {color: "#21d0e7",unit: " %",type: "halfcircle"});
    });
</script>
<!-- //gauge-meter -->
<!-- range -->
<script src="dist/js/jquery-ui.js"></script>
<!-- start-smooth-scrolling -->
<script src="dist/js/move-top.js"></script>
<script src="dist/js/easing.js"></script>
<script type="text/javascript">
    jQuery(document).ready(function($) {
        $(".scroll").click(function(event){
            event.preventDefault();
            $('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
        });
    });
</script>
<!-- start-smooth-scrolling -->
<!-- for bootstrap working -->
<script src="dist/js/bootstrap.js"></script>
<!-- //for bootstrap working -->
<!-- here stars scrolling icon -->
<script type="text/javascript">
    $(document).ready(function() {
        /*
            var defaults = {
            containerID: 'toTop', // fading element id
            containerHoverID: 'toTopHover', // fading element hover id
            scrollSpeed: 1200,
            easingType: 'linear'
            };
        */

        $().UItoTop({ easingType: 'easeOutQuart' });

    });
</script>
<!-- //here ends scrolling icon -->
</body>
</html>
