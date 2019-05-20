<%--
  Created by IntelliJ IDEA.
  User: 刘真
  Date: 2019/4/18
  Time: 23:42
  description: 合同列表页面
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
            <div class="collapse navbar-collapse navbar-right" id="bs-example-navbar-collapse-1">
                <nav class="link-effect-12">
                    <ul class="nav navbar-nav w3_agile_nav">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span data-hover="Short Codes">首页</span> <b class="caret"></b></a>
                            <ul class="dropdown-menu agile_short_dropdown">
                                <li><a href="house/selectOrder">推荐</a></li>
                                <li><a href="house/selectAll">房源</a></li>
                                <li><a href="tenant/selectAllAgency">中介</a></li>
                            </ul>
                        </li>
                        <li><a href="tenantApplication/selectByCondForTenant"><span>我的申请</span></a></li>
                        <li class="active"><a href="contract/selectByTenantId"><span>房屋合同</span></a></li>
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
<!-- typography -->
<div class="services">
    <div class="w3layouts_header">
        <p><span><i class="fa fa-suitcase" aria-hidden="true"></i></span></p>
        <h5>房屋 <span>合同</span></h5>
    </div>
    <div class="container">
        <div class="page-header">
        </div>
        <div class="bs-docs-example">
            <table class="table table-hover" style="text-align: center">
                <thead>
                <tr>
                    <th style="width: 10%"><center>序号</center></th>
                    <th style="width: 10%"><center>房屋小区</center></th>
                    <th style="width: 10%"><center>房东名称</center></th>
                    <th style="width: 10%"><center>租房单价</center></th>
                    <th style="width: 10%"><center>租房时间</center></th>
                    <th style="width: 10%"><center>开始时间</center></th>
                    <th style="width: 10%"><center>结束时间</center></th>
                    <th style="width: 10%"><center>付款</center></th>
                    <th style="width: 10%"><center>状态</center></th>
                    <th style="width: 10%"><center>处理</center></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${contracts}" var="contracts" varStatus="status">
                    <tr>
                        <td>${status.index + 1}</td>
                        <td>${contracts.community}</td>
                        <td>${contracts.landlordName}</td>
                        <td>${contracts.rentalPrice}</td>
                        <td>${contracts.rentalTime}</td>
                        <td>${contracts.startTime}</td>
                        <td>${contracts.endTime}</td>
                        <td>${contracts.payment}</td>
                        <td>${contracts.status}</td>
                        <td>
                            <a href="contract/selectByContractIdForTenant/${contracts.contractId}" aria-label="处理">
                                <i class="fa fa-tasks" aria-hidden="true"></i>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <div class="col-md-7"></div>
    <div class="col-md-5">
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
</div>
<!-- //typography -->
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


<!-- start-smooth-scrolling -->
<script type="text/javascript" src="dist/js/move-top.js"></script>
<script type="text/javascript" src="dist/js/easing.js"></script>
<!-- start-smooth-scrolling -->
<!-- for bootstrap working -->
<script src="dist/js/bootstrap.js"></script>
<!-- //for bootstrap working -->
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
            $('#userInfo').css("color","blue");
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

</body>
</html>


