<%--
  User: 涂元坤
  Mail: 766564616@qq.com
  Date: 2017/12/25
  Time: 20:08 星期一
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html ng-app="pageBaseApp" ng-controller="pageBaseCtrl">
<head>
    <title>阴阳五行人体质研究</title>
    <link rel="icon" href="${pageContext.request.contextPath}/statics/images/login/logo.png" type="image/x-icon">
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/statics/images/login/logo.png"
          type="image/x-icon"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/css/lib/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/css/lib/fonts/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/css/index.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/css/alert.css">
</head>
<body>
<!--页面头部-->
<div class="navbar navbar-default navbar-fixed-top top" role="navigation">
    <div class="container-fluid">
        <!--左面Logo显示-->
        <div class="header">
            <div class=" header-left-logo">
                <img src="${pageContext.request.contextPath}/statics/images/index/indexLogo-sm.png" alt="indexLogo" class="img-responsive">
            </div>
        </div>
        <!--右边用户按钮下拉提示-->
        <div class="header-nav">
            <div class="pull-right header-right-user">
                <i class="fa fa-user fa-lg" aria-hidden="true" style="vertical-align: middle"></i>
                <span>欢迎登陆:</span>
                <div class="dropdown user">
                    <button type="button" class="btn dropdown-toggle" id="dropdownMenu1" data-toggle="dropdown">${doctor.name}
                        <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
                        <li role="presentation">
                            <a role="menuitem" tabindex="-1" ui-sref="modifyPassword">
                                <i class="fa fa-pencil-square-o" aria-hidden="true" style="margin-right: 2px;"></i>修改密码
                            </a>
                        </li>
                        <li role="presentation">
                            <a role="menuitem" tabindex="-1" href="${pageContext.request.contextPath}/logout">
                                <i class="fa fa-power-off" aria-hidden="true"></i>退出系统
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
<!--中间主内容-->
<div class="container-f row main">
    <!--左边导航菜单-->
    <div class="col-xs-2 main-left-menuBar" id="main-left-menuBar">
        <!--体质研究-->
        <div class="functionMenu">
            <a class="list-group-item active" style="border-top: none">体质研究</a>
            <a href="${pageContext.request.contextPath}/doctor/" class="list-group-item">
                <i class="fa fa-hourglass-start" aria-hidden="true"></i>数据采集</a>
            <a ui-sref="xianTian" class="list-group-item">
                <i class="fa fa-hourglass-start" aria-hidden="true"></i>先天五行</a>
            <a ui-sref="houTian" class="list-group-item">
                <i class="fa fa-hourglass-end" aria-hidden="true"></i>后天五行</a>
        </div>
        <!--个人管理-->
        <div class="usersMenu">
            <a class="list-group-item active" style="border-top: none">个人管理</a>
            <a ui-sref="setting" class="list-group-item"><i class="fa fa-cogs" aria-hidden="true"></i>个人设置</a>
            <a ui-sref="modifyPassword" class="list-group-item"><i class="fa fa-pencil-square-o" aria-hidden="true"></i>修改密码</a>
            <a href="${pageContext.request.contextPath}/logout" class="list-group-item"><i class="fa fa-power-off" aria-hidden="true"></i>退出系统</a>
        </div>
    </div>
    <!--右边路由显示子页面-->
    <div class="col-xs-10 main-right-detail" id="main-right-detail">
        <div class="flex-alert">
            <div class="flex-item" id="shake"><span></span></div>
        </div>
        <!--AngularJs 路由显示子页面-->
        <span id="contextPath" style="display: none">${pageContext.request.contextPath}</span>
        <span id="pageName" style="display: none">${pageName}</span>
        <div ui-view>
        </div>
    </div>
</div>
<!--尾注-->
<div class=" footer">&copy;阴阳五行人体质研究</div>
<script src="${pageContext.request.contextPath}/statics/js/lib/jquery-1.11.1.min.js"></script>
<script src="${pageContext.request.contextPath}/statics/js/lib/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/statics/js/lib/angular.min.js"></script>
<script src="${pageContext.request.contextPath}/statics/js/lib/angular-ui-router.js"></script>
<script src="${pageContext.request.contextPath}/statics/js/pageBase.js"></script>
</body>
</html>
