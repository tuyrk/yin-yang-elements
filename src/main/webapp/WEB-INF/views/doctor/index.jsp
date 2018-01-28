<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  User: 涂元坤
  Mail: 766564616@qq.com
  Date: 2017/12/18
  Time: 22:11 星期一
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html ng-app="indexApp" ng-controller="indexCtrl">
<head>
    <title>阴阳五行人体质研究</title>
    <link rel="icon" href="${pageContext.request.contextPath}/statics/images/login/logo.png" type="image/x-icon">
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/statics/images/login/logo.png"
          type="image/x-icon"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/css/lib/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/css/lib/fonts/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/css/index.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/css/tplsCss/staticis.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/css/calendar/calendar.css">
</head>
<body>
<!--页面头部-->
<div class="navbar navbar-default navbar-fixed-top top" role="navigation">
    <div class="container-fluid">
        <!--左面Logo显示-->
        <div class="header">
            <div class=" header-left-logo">
                <img src="${pageContext.request.contextPath}/statics/images/index/indexLogo-sm.png" alt="indexLogo"
                     class="img-responsive">
            </div>
        </div>
        <!--右边用户按钮下拉提示-->
        <div class="header-nav">
            <div class="pull-right header-right-user">
                <i class="fa fa-user fa-lg" aria-hidden="true" style="vertical-align: middle"></i>
                <span>欢迎登陆:</span>
                <div class="dropdown user">
                    <button type="button" class="btn dropdown-toggle" id="dropdownMenu1"
                            data-toggle="dropdown">${doctor.name}
                        <span class="caret" style="margin-left:5px;"></span>
                    </button>
                    <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
                        <li role="presentation">
                            <a role="menuitem" tabindex="-1"
                               href="${pageContext.request.contextPath}/doctor/modifyPassword">
                                <i class="fa fa-pencil-square-o" aria-hidden="true" style="margin-right: 2px;"></i>修改密码</a>
                        </li>
                        <li role="presentation">
                            <a role="menuitem" tabindex="-1" href="${pageContext.request.contextPath}/logout">
                                <i class="fa fa-power-off" aria-hidden="true"  style="margin-right: 3px;"></i>退出系统</a>
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
    <div class="col-xs-2 main-left-menuBar ulCilck" id="main-left-menuBar">
        <!--体质研究-->
        <div class="functionMenu">
            <a class="list-group-item active" style="border-top: none">体质研究</a>
            <a ui-sref="index" class="list-group-item list-exchange exchangeActive" style="cursor: pointer"><i class="fa fa-hourglass-start"
                                                                         aria-hidden="true"></i>数据采集</a>
            <a ui-sref="inborn" class="list-group-item list-exchange"><i class="fa fa-hourglass-start" aria-hidden="true"></i>先天五行</a>
            <a ui-sref="houTian" class="list-group-item list-exchange"><i class="fa fa-hourglass-end" aria-hidden="true"></i>后天五行</a>
        </div>
        <!--个人管理-->
        <div class="usersMenu">
            <a class="list-group-item active" style="border-top: none">个人管理</a>
            <a href="${pageContext.request.contextPath}/doctor/setting" class="list-group-item list-exchange">
                <i class="fa fa-cogs" aria-hidden="true"></i>个人设置</a>
            <a href="${pageContext.request.contextPath}/doctor/modifyPassword" id="list-modify-Password" class="list-group-item">
                <i class="fa fa-pencil-square-o" aria-hidden="true"></i>修改密码</a>
            <a href="${pageContext.request.contextPath}/logout" class="list-group-item">
                <i class="fa fa-power-off" aria-hidden="true"></i>退出系统</a>
        </div>
    </div>
    <!--右边路由显示子页面-->
    <div class="col-xs-10 main-right-detail" id="main-right-detail">
        <div style="text-align: center;color: red">${state}</div>
        <!--数据采集主内容-->
        <div class="staticis-main">
            <form action="${pageContext.request.contextPath}/doctor/qualitative" method="post" id="indexForm"
                  name="indexForm">
                <!--头部表单-->
                <div class="staticis-header">
                    <div class="header-p"><b>基本信息</b></div>
                    <hr>
                    <div class="header-content">
                        <!--姓名、性别-->
                        <div class="header-content-1">
                            <div>
                                <span>姓名:</span>
                                <input type="text" id="name" name="name" class="form-control" value="${name}" required
                                       style="width: 100px;">
                            </div>
                            <div style="margin-top: 2%">
                                <span>性别:</span>
                                <select name="sex" class="form-control" style="width: 80px;">
                                    <option value="男">男</option>
                                    <option value="女">女</option>
                                </select>
                            </div>
                        </div>
                        <!--出生日期、身份证号-->
                        <div class="header-content-2">
                            <div>
                                <span>出生日期:</span>
                                <input type="text" name="birth.date" id="birthday"
                                       class="Js_date input public_icon_sel animated form-control"
                                       data-type="1" placeholder="请选择日期" onfocus="this.blur()" style="width:140px;"
                                       required>
                                <select name="birth.hour" id="selectHour" class="form-control" style="width:75px;"
                                        required>
                                </select>&nbsp;时
                                <select name="birth.minute" id="selectMin" class="form-control" style="width:75px;"
                                        required>
                                </select>&nbsp;分
                            </div>
                            <div style="margin-top: 2%">
                                <span>手机号码:</span>
                                <span id="contextPath" style="display: none">${pageContext.request.contextPath}</span>
                                <input type="hidden" id="status" name="status" value="${status}">
                                <input type="text" id="phone" name="phone" class="form-control" value="${phone}"
                                       required style="width: 190px;">
                            </div>
                        </div>
                    </div>
                    <!--执行命令按钮组-->
                    <div class="header-btn">
                        <span class="header-btn-group">
                                <input type="button" class="btn btn-primary" value="查询" ng-click="queryData()">
                        </span>
                        <span class="header-btn-group">
                                <input type="button" class="btn btn-primary" value="删除" ng-click="deleteData()">
                        </span>
                        <span class="header-btn-group" style="margin-right: 10px;">
                            <a href="${pageContext.request.contextPath}/doctor/exportData"><input type="button"
                                                                                                  class="btn btn-primary"
                                                                                                  value="导出数据"></a>
                        </span>
                    </div>
                </div>
                <!--页面主内容-分类条目-->
                <div class="staticis-content">
                    <div class="content-p"><b>分类条目</b></div>
                    <hr>
                    <!--脸形特点-->
                    <div class="item">
                        <span>1.脸形特点</span>
                        <div class="radio"><label><input type="radio" name="feature" value="A"
                                                         <c:if test="${category.feature == 'A' || empty category}">checked</c:if>>脸形上部宽、下部窄，面长瘦露骨</label>
                        </div>
                        <div class="radio"><label><input type="radio" name="feature" value="B"
                                                         <c:if test="${category.feature == 'B'}">checked</c:if>>脸形上部略尖、下部宽</label>
                        </div>
                        <div class="radio"><label><input type="radio" name="feature" value="C"
                                                         <c:if test="${category.feature == 'C'}">checked</c:if>>脸形圆，头大，蒜头鼻</label>
                        </div>
                        <div class="radio"><label><input type="radio" name="feature" value="D"
                                                         <c:if test="${category.feature == 'D'}">checked</c:if>>脸形方正，头小</label>
                        </div>
                        <div class="radio"><label><input type="radio" name="feature" value="E"
                                                         <c:if test="${category.feature == 'E'}">checked</c:if>>脸形宽，头大</label>
                        </div>
                    </div>
                    <hr>
                    <!--面色特点-->
                    <div class="item">
                        <span>2.面色特点</span>
                        <div class="radio"><label><input type="radio" name="complexion" value="A"
                                                         <c:if test="${category.complexion == 'A' || empty category}">checked</c:if>>偏青色</label>
                        </div>
                        <div class="radio"><label><input type="radio" name="complexion" value="B"
                                                         <c:if test="${category.complexion == 'B'}">checked</c:if>>偏紅色</label>
                        </div>
                        <div class="radio"><label><input type="radio" name="complexion" value="C"
                                                         <c:if test="${category.complexion == 'C'}">checked</c:if>>偏黄色</label>
                        </div>
                        <div class="radio"><label><input type="radio" name="complexion" value="D"
                                                         <c:if test="${category.complexion == 'D'}">checked</c:if>>偏白色</label>
                        </div>
                        <div class="radio"><label><input type="radio" name="complexion" value="E"
                                                         <c:if test="${category.complexion == 'E'}">checked</c:if>>偏黑色</label>
                        </div>
                    </div>
                    <hr>
                    <!--躯干特点-->
                    <div class="item">
                        <span>3.躯干特点</span>
                        <div class="radio"><label><input type="radio" name="trunk" value="A"
                                                         <c:if test="${category.trunk == 'A' || empty category}">checked</c:if>>身材瘦长</label>
                        </div>
                        <div class="radio"><label><input type="radio" name="trunk" value="B"
                                                         <c:if test="${category.trunk == 'B'}">checked</c:if>>身材壮实，肩背肌肉丰满，体多丰盈</label>
                        </div>
                        <div class="radio"><label><input type="radio" name="trunk" value="C"
                                                         <c:if test="${category.trunk == 'C'}">checked</c:if>>身材圆润，肩背圆，腹大</label>
                        </div>
                        <div class="radio"><label><input type="radio" name="trunk" value="D"
                                                         <c:if test="${category.trunk == 'D'}">checked</c:if>>身材偏瘦，身段不高，肩背小，腹小</label>
                        </div>
                        <div class="radio"><label><input type="radio" name="trunk" value="E"
                                                         <c:if test="${category.trunk == 'E'}">checked</c:if>>身材修长，肩背小，腹大</label>
                        </div>
                    </div>
                    <hr>
                    <!--四肢特点-->
                    <div class="item">
                        <span>4.四肢特点</span>
                        <div class="radio"><label><input type="radio" name="limb" value="A"
                                                         <c:if test="${category.limb == 'A' || empty category}">checked</c:if>>手足细长瘦</label>
                        </div>
                        <div class="radio"><label><input type="radio" name="limb" value="B"
                                                         <c:if test="${category.limb == 'B'}">checked</c:if>>手足根粗指尖</label>
                        </div>
                        <div class="radio"><label><input type="radio" name="limb" value="C"
                                                         <c:if test="${category.limb == 'C'}">checked</c:if>>手足小肉多</label>
                        </div>
                        <div class="radio"><label><input type="radio" name="limb" value="D"
                                                         <c:if test="${category.limb == 'D'}">checked</c:if>>手足小</label>
                        </div>
                        <div class="radio"><label><input type="radio" name="limb" value="E"
                                                         <c:if test="${category.limb == 'E'}">checked</c:if>>无特异</label>
                        </div>
                    </div>
                    <hr>
                    <!--语音特点-->
                    <div class="item">
                        <span>5.语音特点</span>
                        <div class="radio"><label><input type="radio" name="voice" value="A"
                                                         <c:if test="${category.voice == 'A' || empty category}">checked</c:if>>语音直而短，较响亮</label>
                        </div>
                        <div class="radio"><label><input type="radio" name="voice" value="B"
                                                         <c:if test="${category.voice == 'B'}">checked</c:if>>语音尖锐常有破音</label>
                        </div>
                        <div class="radio"><label><input type="radio" name="voice" value="C"
                                                         <c:if test="${category.voice == 'C'}">checked</c:if>>语音浑厚</label>
                        </div>
                        <div class="radio"><label><input type="radio" name="voice" value="D"
                                                         <c:if test="${category.voice == 'D'}">checked</c:if>>语音响亮</label>
                        </div>
                        <div class="radio"><label><input type="radio" name="voice" value="E"
                                                         <c:if test="${category.voice == 'E'}">checked</c:if>>语音慢而低</label>
                        </div>
                    </div>
                    <hr>
                    <!--心理特征-->
                    <div class="item">
                        <span>6.心理特征</span>
                        <div class="radio radio-block"><label><input type="radio" name="psychology" value="A"
                                                                     <c:if test="${category.psychology == 'A' || empty category}">checked</c:if>>性格内向，善于思考，多愁善感</label>
                        </div>
                        <div class="radio radio-block"><label><input type="radio" name="psychology" value="B"
                                                                     <c:if test="${category.psychology == 'B'}">checked</c:if>>性格外向，乐观善言，心宽忘忧</label>
                        </div>
                        <div class="radio radio-block"><label><input type="radio" name="psychology" value="C"
                                                                     <c:if test="${category.psychology == 'C'}">checked</c:if>>性格稳重，温厚冷静，不易冲动，有包容性</label>
                        </div>
                        <div class="radio radio-block"><label><input type="radio" name="psychology" value="D"
                                                                     <c:if test="${category.psychology == 'D'}">checked</c:if>>性格外向，喜欢竞争，严肃孤傲</label>
                        </div>
                        <div class="radio radio-block"><label><input type="radio" name="psychology" value="E"
                                                                     <c:if test="${category.psychology == 'E'}">checked</c:if>>性格内向，安静沉稳、冷静智慧，行动迟缓</label>
                        </div>
                    </div>
                    <hr>
                    <!--好发病位-->
                    <div class="item">
                        <span>7.好发病位</span>
                        <div class="radio radio-block"><label><input type="radio" name="disease" value="A"
                                                                     <c:if test="${category.disease == 'A' || empty category}">checked</c:if>>肝系（肝、胆、目、血、关节），情志及妇科等</label>
                        </div>
                        <div class="radio radio-block"><label><input type="radio" name="disease" value="B"
                                                                     <c:if test="${category.disease == 'B'}">checked</c:if>>心系（心脑、血脉、小肠、口舌），痈疮及神志等</label>
                        </div>
                        <div class="radio radio-block"><label><input type="radio" name="disease" value="C"
                                                                     <c:if test="${category.disease == 'C'}">checked</c:if>>脾系（脾、胃、唇口、肌肉）、血证</label>
                        </div>
                        <div class="radio radio-block"><label><input type="radio" name="disease" value="D"
                                                                     <c:if test="${category.disease == 'D'}">checked</c:if>>肺系（肺、大肠、鼻、皮肤）</label>
                        </div>
                        <div class="radio radio-block"><label><input type="radio" name="disease" value="E"
                                                                     <c:if test="${category.disease == 'E'}">checked</c:if>>肾系（肾、膀胱、耳、二阴、骨）</label>
                        </div>
                    </div>
                    <!--保存-->
                    <div class="item">
                        <input type="button" class="form-control nextStep" ng-click="isValidPhone()" value="保存">
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<!--尾注-->
<div class=" footer">&copy;阴阳五行人体质研究</div>
<script src="${pageContext.request.contextPath}/statics/js/lib/jquery-1.11.1.min.js"></script>
<script src="${pageContext.request.contextPath}/statics/js/lib/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/statics/js/lib/angular-1.3.0.js"></script>
<script src="${pageContext.request.contextPath}/statics/js/calendar/calendar.js"></script>
<script src="${pageContext.request.contextPath}/statics/js/calendar/main.js"></script>
<script src="${pageContext.request.contextPath}/statics/js/index.js"></script>
<script>
    $(function () {
        for (var i = 0; i < 24; i++) {
            $("#selectHour").append("<option value='" + i + "'>" + i + "</option>");//i 变量
        }
        for (var i = 0; i < 60; i++) {
            $("#selectMin").append("<option value='" + i + "'>" + i + "</option>");//i 变量
        }
    })
</script>
</body>
</html>
