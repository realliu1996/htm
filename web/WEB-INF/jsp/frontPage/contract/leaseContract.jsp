<%--
  Created by IntelliJ IDEA.
  User: 刘真
  Date: 2019/4/17
  Time: 15:17
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
                        <li>租赁期限自  <span style="color: red;font-weight:bold;">${contract.startTime}</span>  至  <span style="color: red;font-weight:bold;">${contract.endTime}</span>  止。</li>
                    </div>
                    <li>第四条 租金。</li>
                    <div class="col-md-12">
                        <li>该房屋月租金为 <span style="color: red;font-weight:bold;">${contract.rentalPrice}</span> 元整。</li>
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
    </div>
    <div class="col-md-7"></div>
    <div class="col-md-5">
        <div class="col-md-6"></div>
        <nav>
            <ul class="pagination pagination-sm no-margin">
                <button id="agree" type="button" class="btn btn-primary">同意</button>
                <button id="refuse" type="button" class="btn btn-primary">拒绝</button>
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
    var contractId = "${contract.contractId}";
    var houseId = "${chouse.houseId}";

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

    $("#agree").click(function () {
        //支付宝支付跳转
        window.location.href = "alipay/goAlipay?contractId="+contractId+"&houseId="+houseId;

    });

    $("#refuse").click(function () {
        var contractId = "${contract.contractId}";
        $.ajax({
            url:"${pageContext.request.contextPath}/contract/contractTenant",
            type: "POST",
            contentType: "application/x-www-form-urlencoded;charset=utf-8",
            data :{"contractId" : contractId},
            dataType: "text",
            success:function(data){
                if (data == "true") {
                    toastr.options.positionClass = 'toast-center-center';
                    toastr.info("合同已拒绝");
                    setTimeout(function(){
                        $("#myModal").modal('hide');
                        window.location.href = "contract/selectByTenantId";
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
<!-- //gauge-meter -->

</body>
</html>

