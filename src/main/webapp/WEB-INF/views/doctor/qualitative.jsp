<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/statics/images/login/logo.png" type="image/x-icon"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/css/lib/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/css/lib/fonts/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/css/index.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/css/tplsCss/qualitative.css">
</head>
<body id="qualitativeMain">
<!--页面头部-->
<div class="navbar navbar-default navbar-fixed-top top" role="navigation">
    <div class="container-fluid">
        <!--左面Logo显示-->
        <div class="header">
            <div class=" header-left-logo"><img src="${pageContext.request.contextPath}/statics/images/index/indexLogo-sm.png" alt="indexLogo" class="img-responsive"></div>
        </div>
        <!--右边用户按钮下拉提示-->
        <div class="header-nav">
            <div class="pull-right header-right-user">
                <i class="fa fa-user fa-lg" aria-hidden="true" style="vertical-align: middle"></i>
                <span>欢迎登陆:</span>
                <div class="dropdown user">
                    <button type="button" class="btn dropdown-toggle" id="dropdownMenu1" data-toggle="dropdown">${doctor.name}
                        <span class="caret" style="margin-left:5px;"></span>
                    </button>
                    <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
                        <li role="presentation">
                            <a role="menuitem" tabindex="-1" href="${pageContext.request.contextPath}/doctor/modifyPassword"><i class="fa fa-pencil-square-o" aria-hidden="true" style="margin-right: 2px;"></i>修改密码</a>
                        </li>
                        <li role="presentation">
                            <a role="menuitem" tabindex="-1" href="${pageContext.request.contextPath}/logout"><i class="fa fa-power-off" aria-hidden="true"  style="margin-right: 3px;"></i>退出系统</a>
                        </li3
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
            <a ui-sref="index" class="list-group-item list-exchange  list-exchange-active exchangeActive"><i class="fa fa-hourglass-start" aria-hidden="true"></i>数据采集</a>
            <a ui-sref="inborn" class="list-group-item list-exchange"><i class="fa fa-hourglass-start" aria-hidden="true"></i>先天五行</a>
            <a ui-sref="houTian" class="list-group-item list-exchange"><i class="fa fa-hourglass-end" aria-hidden="true"></i>后天五行</a>
        </div>
        <!--个人管理-->
        <div class="usersMenu">
            <a class="list-group-item active" style="border-top: none">个人管理</a>
            <a href="${pageContext.request.contextPath}/doctor/setting" class="list-group-item list-exchange">
                <i class="fa fa-cogs" aria-hidden="true"></i>个人设置</a>
            <a href="${pageContext.request.contextPath}/doctor/modifyPassword" class="list-group-item list-exchange">
                <i class="fa fa-pencil-square-o" aria-hidden="true"></i>修改密码</a>
            <a href="${pageContext.request.contextPath}/logout" class="list-group-item list-exchange">
                <i class="fa fa-power-off" aria-hidden="true"></i>退出系统</a>
        </div>
    </div>
    <!--右边路由显示子页面-->
    <div class="col-xs-10 main-right-detail" id="main-right-detail">
        <div class="xingRenMain">
            <div class="xingRenContent">
                <form action="${pageContext.request.contextPath}/doctor/index" method="post">
                    <input type="hidden" name="phone" value="${respondent.phone}">
                    <c:if test="${fn:substring(respondent.acquireGenus, 0, 1) == '1'}">
                        <!--木行人-->
                        <div>
                            <div class="xingRen"><p>木行人定性分析</p></div>
                            <input type="hidden" name="wood" value="wood">
                            <!--面色特点-->
                            <div class="item">
                                <span>1.面色特点</span>
                                <div class="radio"><label><input type="radio" name="woodComplexion" value="A" <c:if test="${itemWood.woodComplexion == 'A' || empty itemWood}">checked</c:if>>面色青，晦暗无光泽</label></div>
                                <div class="radio"><label><input type="radio" name="woodComplexion" value="B" <c:if test="${itemWood.woodComplexion == 'B'}">checked</c:if>>面色青，少光泽</label></div>
                                <div class="radio"><label><input type="radio" name="woodComplexion" value="C" <c:if test="${itemWood.woodComplexion == 'C'}">checked</c:if>>面色偏青</label></div>
                                <div class="radio"><label><input type="radio" name="woodComplexion" value="D" <c:if test="${itemWood.woodComplexion == 'D'}">checked</c:if>>面色青，有光泽</label></div>
                                <div class="radio"><label><input type="radio" name="woodComplexion" value="E" <c:if test="${itemWood.woodComplexion == 'E'}">checked</c:if>>面色青，泛红光</label></div>
                            </div>
                            <hr>
                            <!--心理特征-->
                            <div class="item">
                                <span>2.心理特征</span>
                                <div class="radio"><label><input type="radio" name="woodPsychology" value="B" <c:if test="${itemWood.woodPsychology == 'B' || empty itemWood}">checked</c:if>>心胸狭小，消极忧虑，心情郁闷</label></div>
                                <div class="radio"><label><input type="radio" name="woodPsychology" value="C" <c:if test="${itemWood.woodPsychology == 'C'}">checked</c:if>>性格内向，善于思考，多愁善感</label></div>
                                <div class="radio"><label><input type="radio" name="woodPsychology" value="D" <c:if test="${itemWood.woodPsychology == 'D'}">checked</c:if>>性情急躁，忿忿不平，易于发怒</label></div>
                            </div>
                            <hr>
                            <!--寒热-->
                            <div class="item">
                                <span>3.寒热</span>
                                <div class="radio"><label><input type="radio" name="woodCold" value="A" <c:if test="${itemWood.woodCold == 'A' || empty itemWood}">checked</c:if>>面部紫暗，手足冰冷</label></div>
                                <div class="radio"><label><input type="radio" name="woodCold" value="B" <c:if test="${itemWood.woodCold == 'B'}">checked</c:if>>面色青暗，手足不温</label></div>
                                <div class="radio"><label><input type="radio" name="woodCold" value="C" <c:if test="${itemWood.woodCold == 'C'}">checked</c:if>>面部、手足常温</label></div>
                                <div class="radio"><label><input type="radio" name="woodCold" value="D" <c:if test="${itemWood.woodCold == 'D'}">checked</c:if>>面部、手足心微热</label></div>
                                <div class="radio"><label><input type="radio" name="woodCold" value="E" <c:if test="${itemWood.woodCold == 'E'}">checked</c:if>>面红、手足心热</label></div>
                            </div>
                            <hr>
                            <!--汗症-->
                            <div class="item">
                                <span>4.汗症</span>
                                <div class="radio"><label><input type="radio" name="woodSweat" value="A" <c:if test="${itemWood.woodSweat == 'A' || empty itemWood}">checked</c:if>>时有冷汗</label></div>
                                <div class="radio"><label><input type="radio" name="woodSweat" value="B" <c:if test="${itemWood.woodSweat == 'B'}">checked</c:if>>偶有冷汗、自汗</label></div>
                                <div class="radio"><label><input type="radio" name="woodSweat" value="C" <c:if test="${itemWood.woodSweat == 'C'}">checked</c:if>>汗出正常</label></div>
                                <div class="radio"><label><input type="radio" name="woodSweat" value="D" <c:if test="${itemWood.woodSweat == 'D'}">checked</c:if>>夜间偶有盗汗</label></div>
                                <div class="radio"><label><input type="radio" name="woodSweat" value="E" <c:if test="${itemWood.woodSweat == 'E'}">checked</c:if>>夜间易潮热盗汗、汗量多</label></div>
                            </div>
                            <hr>
                            <!--饮食口味-->
                            <div class="item">
                                <span>5.饮食口味</span>
                                <div class="radio"><label><input type="radio" name="woodDiet" value="A" <c:if test="${itemWood.woodDiet == 'A' || empty itemWood}">checked</c:if>>食欲不振，口不渴或渴喜热饮</label></div>
                                <div class="radio"><label><input type="radio" name="woodDiet" value="B" <c:if test="${itemWood.woodDiet == 'B'}">checked</c:if>>食少，口不渴或渴喜热饮</label></div>
                                <div class="radio"><label><input type="radio" name="woodDiet" value="C" <c:if test="${itemWood.woodDiet == 'C'}">checked</c:if>>正常饮食，偏食酸味</label></div>
                                <div class="radio"><label><input type="radio" name="woodDiet" value="D" <c:if test="${itemWood.woodDiet == 'D'}">checked</c:if>>能食，喜酸，渴不多饮</label></div>
                                <div class="radio"><label><input type="radio" name="woodDiet" value="E" <c:if test="${itemWood.woodDiet == 'E'}">checked</c:if>>多食易饥，喜酸，口大渴，喜冷饮</label></div>
                            </div>
                            <hr>
                            <!--大便-->
                            <div class="item">
                                <span>6.大便</span>
                                <div class="radio radio-block"><label><input type="radio" name="woodShit" value="A" <c:if test="${itemWood.woodShit == 'A' || empty itemWood}">checked</c:if>>大便溏薄，便次较多</label></div>
                                <div class="radio radio-block"><label><input type="radio" name="woodShit" value="B" <c:if test="${itemWood.woodShit == 'B'}">checked</c:if>>大便稀软不成形</label></div>
                                <div class="radio radio-block"><label><input type="radio" name="woodShit" value="C" <c:if test="${itemWood.woodShit == 'C'}">checked</c:if>>大便正常</label></div>
                                <div class="radio radio-block"><label><input type="radio" name="woodShit" value="D" <c:if test="${itemWood.woodShit == 'D'}">checked</c:if>>大便粘滞不爽</label></div>
                                <div class="radio radio-block"><label><input type="radio" name="woodShit" value="E" <c:if test="${itemWood.woodShit == 'E'}">checked</c:if>>大便酸臭秘结</label></div>
                            </div>
                            <hr>
                            <!--小便-->
                            <div class="item">
                                <span>7.小便</span>
                                <div class="radio radio-block"><label><input type="radio" name="woodUrine" value="A" <c:if test="${itemWood.woodUrine == 'A' || empty itemWood}">checked</c:if>>小便清长，量多</label></div>
                                <div class="radio radio-block"><label><input type="radio" name="woodUrine" value="B" <c:if test="${itemWood.woodUrine == 'B'}">checked</c:if>>小便清长，量偏多</label></div>
                                <div class="radio radio-block"><label><input type="radio" name="woodUrine" value="C" <c:if test="${itemWood.woodUrine == 'C'}">checked</c:if>>小便正常</label></div>
                                <div class="radio radio-block"><label><input type="radio" name="woodUrine" value="D" <c:if test="${itemWood.woodUrine == 'D'}">checked</c:if>>小便黄，量较少</label></div>
                                <div class="radio radio-block"><label><input type="radio" name="woodUrine" value="E" <c:if test="${itemWood.woodUrine == 'E'}">checked</c:if>>小便黄赤，量少</label></div>
                            </div>
                            <!--睡眠-->
                            <div class="item">
                                <span>8.睡眠</span>
                                <div class="radio"><label><input type="radio" name="woodSleep" value="A" <c:if test="${itemWood.woodSleep == 'A' || empty itemWood}">checked</c:if>>困倦易睡，多梦，睡后易醒</label></div>
                                <div class="radio"><label><input type="radio" name="woodSleep" value="B" <c:if test="${itemWood.woodSleep == 'B'}">checked</c:if>>入睡快，偶有多梦易醒</label></div>
                                <div class="radio"><label><input type="radio" name="woodSleep" value="C" <c:if test="${itemWood.woodSleep == 'C'}">checked</c:if>>入睡快，睡后不易醒</label></div>
                                <div class="radio"><label><input type="radio" name="woodSleep" value="D" <c:if test="${itemWood.woodSleep == 'D'}">checked</c:if>>不易入睡，睡中易惊醒</label></div>
                                <div class="radio"><label><input type="radio" name="woodSleep" value="E" <c:if test="${itemWood.woodSleep == 'E'}">checked</c:if>>夜卧不安，多梦易醒</label></div>
                            </div>
                            <hr>
                            <!--头晕目眩-->
                            <div class="item">
                                <span>9.头晕目眩</span>
                                <div class="radio"><label><input type="radio" name="woodDizzy" value="A" <c:if test="${itemWood.woodDizzy == 'A' || empty itemWood}">checked</c:if>>时常头晕目眩</label></div>
                                <div class="radio"><label><input type="radio" name="woodDizzy" value="B" <c:if test="${itemWood.woodDizzy == 'B'}">checked</c:if>>偶有头晕目眩</label></div>
                                <div class="radio"><label><input type="radio" name="woodDizzy" value="C" <c:if test="${itemWood.woodDizzy == 'C'}">checked</c:if>>无头目不适</label></div>
                                <div class="radio"><label><input type="radio" name="woodDizzy" value="D" <c:if test="${itemWood.woodDizzy == 'D'}">checked</c:if>>偶有头晕胀痛</label></div>
                                <div class="radio"><label><input type="radio" name="woodDizzy" value="E" <c:if test="${itemWood.woodDizzy == 'E'}">checked</c:if>>时常头晕胀痛</label></div>
                            </div>
                            <hr>
                            <!--双目症状-->
                            <div class="item">
                                <span>10.双目症状</span>
                                <div class="radio"><label><input type="radio" name="woodEyes" value="A" <c:if test="${itemWood.woodEyes == 'A' || empty itemWood}">checked</c:if>>双目昏涩，冷泪频频</label></div>
                                <div class="radio"><label><input type="radio" name="woodEyes" value="B" <c:if test="${itemWood.woodEyes == 'B'}">checked</c:if>>双目干涩，流冷泪</label></div>
                                <div class="radio"><label><input type="radio" name="woodEyes" value="C" <c:if test="${itemWood.woodEyes == 'C'}">checked</c:if>>双目有神，视力良好</label></div>
                                <div class="radio"><label><input type="radio" name="woodEyes" value="D" <c:if test="${itemWood.woodEyes == 'D'}">checked</c:if>>双目红，眵多黄稠</label></div>
                                <div class="radio"><label><input type="radio" name="woodEyes" value="E" <c:if test="${itemWood.woodEyes == 'E'}">checked</c:if>>双目红赤、偶见胀痛，眵多黄稠</label></div>
                            </div>
                            <hr>
                            <!--胸胁症状-->
                            <div class="item">
                                <span>11.胸胁症状</span>
                                <div class="radio"><label><input type="radio" name="woodChest" value="A" <c:if test="${itemWood.woodChest == 'A' || empty itemWood}">checked</c:if>>时常胸胁胀闷或隐痛，喜太息</label></div>
                                <div class="radio"><label><input type="radio" name="woodChest" value="B" <c:if test="${itemWood.woodChest == 'B'}">checked</c:if>>偶有胸胁胀闷或隐痛，喜太息</label></div>
                                <div class="radio"><label><input type="radio" name="woodChest" value="C" <c:if test="${itemWood.woodChest == 'C'}">checked</c:if>>情志舒畅，胸胁无不适</label></div>
                                <div class="radio"><label><input type="radio" name="woodChest" value="D" <c:if test="${itemWood.woodChest == 'D'}">checked</c:if>>偶有胸胁胀痛，或伴烧灼感</label></div>
                                <div class="radio"><label><input type="radio" name="woodChest" value="E" <c:if test="${itemWood.woodChest == 'E'}">checked</c:if>>时常胸胁胀痛，或伴烧灼感</label></div>
                            </div>
                            <hr>
                            <!--肢体症状-->
                            <div class="item">
                                <span>12.肢体症状</span>
                                <div class="radio"><label><input type="radio" name="woodLimbs" value="B" <c:if test="${itemWood.woodLimbs == 'B' || empty itemWood}">checked</c:if>>肢体拘挛不舒，肢体麻木</label></div>
                                <div class="radio"><label><input type="radio" name="woodLimbs" value="C" <c:if test="${itemWood.woodLimbs == 'C'}">checked</c:if>>筋力强健，活动自如</label></div>
                                <div class="radio"><label><input type="radio" name="woodLimbs" value="D" <c:if test="${itemWood.woodLimbs == 'D'}">checked</c:if>>肢体震颤，手足抽搐</label></div>
                            </div>
                            <hr>
                            <c:if test="${respondent.sex == '女'}">
                                <!--月经症状-->
                                <div class="item">
                                    <span>13.月经症状</span>
                                    <div class="radio radio-block"><label><input type="radio" name="woodMenstruate" value="A" <c:if test="${itemWood.woodMenstruate == 'A' || empty itemWood}">checked</c:if>>月经后期，量少，经闭</label></div>
                                    <div class="radio radio-block"><label><input type="radio" name="woodMenstruate" value="B" <c:if test="${itemWood.woodMenstruate == 'B'}">checked</c:if>>月经量少，质清，色淡</label></div>
                                    <div class="radio radio-block"><label><input type="radio" name="woodMenstruate" value="C" <c:if test="${itemWood.woodMenstruate == 'C'}">checked</c:if>>月经正常</label></div>
                                    <div class="radio radio-block"><label><input type="radio" name="woodMenstruate" value="D" <c:if test="${itemWood.woodMenstruate == 'D'}">checked</c:if>>月经量多，质稠，色红</label></div>
                                    <div class="radio radio-block"><label><input type="radio" name="woodMenstruate" value="E" <c:if test="${itemWood.woodMenstruate == 'E'}">checked</c:if>>月经先期，质稠或成块，色暗</label></div>
                                </div>
                                <hr>
                            </c:if>
                            <!--好发季节-->
                            <div class="item">
                                <span>14.好发季节</span>
                                <div class="radio radio-block"><label><input type="radio" name="woodSeason" value="B" <c:if test="${itemWood.woodSeason == 'B' || empty itemWood}">checked</c:if>>耐春夏，不耐秋冬，秋冬易感疾病</label></div>
                                <div class="radio radio-block"><label><input type="radio" name="woodSeason" value="C" <c:if test="${itemWood.woodSeason == 'C'}">checked</c:if>>四季如常，偶尔染疾</label></div>
                                <div class="radio radio-block"><label><input type="radio" name="woodSeason" value="D" <c:if test="${itemWood.woodSeason == 'D'}">checked</c:if>>耐秋冬，不耐春夏，春夏易感疾病</label></div>
                            </div>
                        </div>
                    </c:if>
                    <c:if test="${fn:substring(respondent.acquireGenus, 1, 2) == '1'}">
                        <!--火行人-->
                        <div>
                            <div class="xingRen"><p>火行人定性分析</p></div>
                            <input type="hidden" name="fire" value="fire">
                            <!--面色特点-->
                            <div class="item">
                                <span>1.面色特点</span>
                                <div class="radio"><label><input type="radio" name="fireComplexion" value="A" <c:if test="${itemFire.fireComplexion == 'A' || empty itemFire}">checked</c:if>>面色无华</label></div>
                                <div class="radio"><label><input type="radio" name="fireComplexion" value="B" <c:if test="${itemFire.fireComplexion == 'B'}">checked</c:if>>面色淡白，少光泽</label></div>
                                <div class="radio"><label><input type="radio" name="fireComplexion" value="C" <c:if test="${itemFire.fireComplexion == 'C'}">checked</c:if>>面色红润</label></div>
                                <div class="radio"><label><input type="radio" name="fireComplexion" value="D" <c:if test="${itemFire.fireComplexion == 'D'}">checked</c:if>>面色红，有光泽</label></div>
                                <div class="radio"><label><input type="radio" name="fireComplexion" value="E" <c:if test="${itemFire.fireComplexion == 'E'}">checked</c:if>>满面红光</label></div>
                            </div>
                            <hr>
                            <!--心理特征-->
                            <div class="item">
                                <span>2.心理特征</span>
                                <div class="radio"><label><input type="radio" name="firePsychology" value="B" <c:if test="${itemFire.firePsychology == 'B' || empty itemFire}">checked</c:if>>反应迟钝，喜虚荣，多猜忌，计较小事</label></div>
                                <div class="radio"><label><input type="radio" name="firePsychology" value="C" <c:if test="${itemFire.firePsychology == 'C'}">checked</c:if>>性格外向，乐观善言，心宽忘忧</label></div>
                                <div class="radio"><label><input type="radio" name="firePsychology" value="D" <c:if test="${itemFire.firePsychology == 'D'}">checked</c:if>>急躁多言，粗心大意，情绪波动，冲动易怒</label></div>
                            </div>
                            <hr>
                            <!--寒热-->
                            <div class="item">
                                <span>3.寒热</span>
                                <div class="radio"><label><input type="radio" name="fireCold" value="A" <c:if test="${itemFire.fireCold == 'A' || empty itemFire}">checked</c:if>>身寒，手足发冷</label></div>
                                <div class="radio"><label><input type="radio" name="fireCold" value="B" <c:if test="${itemFire.fireCold == 'B'}">checked</c:if>>手足不温</label></div>
                                <div class="radio"><label><input type="radio" name="fireCold" value="C" <c:if test="${itemFire.fireCold == 'C'}">checked</c:if>>手足心常温</label></div>
                                <div class="radio"><label><input type="radio" name="fireCold" value="D" <c:if test="${itemFire.fireCold == 'D'}">checked</c:if>>手、足心微热</label></div>
                                <div class="radio"><label><input type="radio" name="fireCold" value="E" <c:if test="${itemFire.fireCold == 'E'}">checked</c:if>>身热，手足心发烫</label></div>
                            </div>
                            <hr>
                            <!--汗症-->
                            <div class="item">
                                <span>4.汗症</span>
                                <div class="radio"><label><input type="radio" name="fireSweat" value="A" <c:if test="${itemFire.fireSweat == 'A' || empty itemFire}">checked</c:if>>时有冷汗、自汗</label></div>
                                <div class="radio"><label><input type="radio" name="fireSweat" value="B" <c:if test="${itemFire.fireSweat == 'B'}">checked</c:if>>偶有冷汗</label></div>
                                <div class="radio"><label><input type="radio" name="fireSweat" value="C" <c:if test="${itemFire.fireSweat == 'C'}">checked</c:if>>汗出正常</label></div>
                                <div class="radio"><label><input type="radio" name="fireSweat" value="D" <c:if test="${itemFire.fireSweat == 'D'}">checked</c:if>>易出汗</label></div>
                                <div class="radio"><label><input type="radio" name="fireSweat" value="E" <c:if test="${itemFire.fireSweat == 'E'}">checked</c:if>>易出汗、汗量多</label></div>
                            </div>
                            <hr>
                            <!--饮食口味-->
                            <div class="item">
                                <span>5.饮食口味</span>
                                <div class="radio"><label><input type="radio" name="fireDiet" value="A" <c:if test="${itemFire.fireDiet == 'A' || empty itemFire}">checked</c:if>>食欲不振，口不渴或渴喜热饮</label></div>
                                <div class="radio"><label><input type="radio" name="fireDiet" value="B" <c:if test="${itemFire.fireDiet == 'B'}">checked</c:if>>食欲减退，口不渴或渴喜热饮</label></div>
                                <div class="radio"><label><input type="radio" name="fireDiet" value="C" <c:if test="${itemFire.fireDiet == 'C'}">checked</c:if>>正常饮食，偶有口中泛苦</label></div>
                                <div class="radio"><label><input type="radio" name="fireDiet" value="D" <c:if test="${itemFire.fireDiet == 'D'}">checked</c:if>>能食，渴喜冷饮</label></div>
                                <div class="radio"><label><input type="radio" name="fireDiet" value="E" <c:if test="${itemFire.fireDiet == 'E'}">checked</c:if>>多食，口渴，喜冷饮</label></div>
                            </div>
                            <hr>
                            <!--小便-->
                            <div class="item">
                                <span>6.小便</span>
                                <div class="radio radio-block"><label><input type="radio" name="fireUrine" value="A" <c:if test="${itemFire.fireUrine == 'A' || empty itemFire}">checked</c:if>>小便清长，量多</label></div>
                                <div class="radio radio-block"><label><input type="radio" name="fireUrine" value="B" <c:if test="${itemFire.fireUrine == 'B'}">checked</c:if>>小便清长，量偏多</label></div>
                                <div class="radio radio-block"><label><input type="radio" name="fireUrine" value="C" <c:if test="${itemFire.fireUrine == 'C'}">checked</c:if>>小便正常</label></div>
                                <div class="radio radio-block"><label><input type="radio" name="fireUrine" value="D" <c:if test="${itemFire.fireUrine == 'D'}">checked</c:if>>小便黄，量较少</label></div>
                                <div class="radio radio-block"><label><input type="radio" name="fireUrine" value="E" <c:if test="${itemFire.fireUrine == 'E'}">checked</c:if>>小便黄赤，量少</label></div>
                            </div>
                            <hr>
                            <!--睡眠-->
                            <div class="item">
                                <span>7.睡眠</span>
                                <div class="radio"><label><input type="radio" name="fireSleep" value="A" <c:if test="${itemFire.fireSleep == 'A' || empty itemFire}">checked</c:if>>疲倦易睡，多梦，睡后易醒</label></div>
                                <div class="radio"><label><input type="radio" name="fireSleep" value="B" <c:if test="${itemFire.fireSleep == 'B'}">checked</c:if>>入睡较快，易醒</label></div>
                                <div class="radio"><label><input type="radio" name="fireSleep" value="C" <c:if test="${itemFire.fireSleep == 'C'}">checked</c:if>>入睡快，睡后不易醒</label></div>
                                <div class="radio"><label><input type="radio" name="fireSleep" value="D" <c:if test="${itemFire.fireSleep == 'D'}">checked</c:if>>不易入睡，多梦易安</label></div>
                                <div class="radio"><label><input type="radio" name="fireSleep" value="E" <c:if test="${itemFire.fireSleep == 'E'}">checked</c:if>>入睡难，多梦，睡中易动难安</label></div>
                            </div>
                            <hr>
                            <!--精神状态-->
                            <div class="item">
                                <span>8.精神状态</span>
                                <div class="radio"><label><input type="radio" name="fireMental" value="A" <c:if test="${itemFire.fireMental == 'A' || empty itemFire}">checked</c:if>>精神不振，乏力易倦，健忘</label></div>
                                <div class="radio"><label><input type="radio" name="fireMental" value="B" <c:if test="${itemFire.fireMental == 'B'}">checked</c:if>>偶有肢体乏力，少言懒语</label></div>
                                <div class="radio"><label><input type="radio" name="fireMental" value="C" <c:if test="${itemFire.fireMental == 'C'}">checked</c:if>>精神饱满，言语清晰</label></div>
                                <div class="radio"><label><input type="radio" name="fireMental" value="D" <c:if test="${itemFire.fireMental == 'D'}">checked</c:if>>偶有精神亢奋</label></div>
                                <div class="radio"><label><input type="radio" name="fireMental" value="E" <c:if test="${itemFire.fireMental == 'E'}">checked</c:if>>烦躁多言，好动</label></div>
                            </div>
                            <hr>
                            <!--口唇症状-->
                            <div class="item">
                                <span>9.口唇症状</span>
                                <div class="radio"><label><input type="radio" name="fireLips" value="A" <c:if test="${itemFire.fireLips == 'A' || empty itemFire}">checked</c:if>>口唇紫暗</label></div>
                                <div class="radio"><label><input type="radio" name="fireLips" value="B" <c:if test="${itemFire.fireLips == 'B'}">checked</c:if>>口唇淡白</label></div>
                                <div class="radio"><label><input type="radio" name="fireLips" value="C" <c:if test="${itemFire.fireLips == 'C'}">checked</c:if>>口唇淡红色</label></div>
                                <div class="radio"><label><input type="radio" name="fireLips" value="D" <c:if test="${itemFire.fireLips == 'D'}">checked</c:if>>口唇鲜红，偶有生疮</label></div>
                                <div class="radio"><label><input type="radio" name="fireLips" value="E" <c:if test="${itemFire.fireLips == 'E'}">checked</c:if>>时常口舌生疮，易口苦</label></div>
                            </div>
                            <hr>
                            <!--心胸症状-->
                            <div class="item">
                                <span>10.心胸症状</span>
                                <div class="radio"><label><input type="radio" name="fireMind" value="A" <c:if test="${itemFire.fireMind == 'A' || empty itemFire}">checked</c:if>>心悸心慌，心胸憋闷</label></div>
                                <div class="radio"><label><input type="radio" name="fireMind" value="B" <c:if test="${itemFire.fireMind == 'B'}">checked</c:if>>偶有心慌、胸闷气短</label></div>
                                <div class="radio"><label><input type="radio" name="fireMind" value="C" <c:if test="${itemFire.fireMind == 'C'}">checked</c:if>>未见心胸不适</label></div>
                                <div class="radio"><label><input type="radio" name="fireMind" value="D" <c:if test="${itemFire.fireMind == 'D'}">checked</c:if>>偶有心胸烦热</label></div>
                                <div class="radio"><label><input type="radio" name="fireMind" value="E" <c:if test="${itemFire.fireMind == 'E'}">checked</c:if>>时常心胸烦热</label></div>
                            </div>
                            <hr>
                            <!--易发症状-->
                            <div class="item">
                                <span>11.易发症状</span>
                                <div class="radio"><label><input type="radio" name="fireProne" value="B" <c:if test="${itemFire.fireProne == 'B' || empty itemFire}">checked</c:if>>易发痴呆、胸痹</label></div>
                                <div class="radio"><label><input type="radio" name="fireProne" value="C" <c:if test="${itemFire.fireProne == 'C'}">checked</c:if>>无明显易发症状</label></div>
                                <div class="radio"><label><input type="radio" name="fireProne" value="D" <c:if test="${itemFire.fireProne == 'D'}">checked</c:if>>易发痴呆、胸痹</label></div>
                            </div>
                            <hr>
                            <!--好发季节-->
                            <div class="item">
                                <span>14.好发季节</span>
                                <div class="radio radio-block"><label><input type="radio" name="fireSeason" value="B" <c:if test="${itemFire.fireSeason == 'B' || empty itemFire}">checked</c:if>>耐春夏，不耐秋冬，秋冬易感疾病</label></div>
                                <div class="radio radio-block"><label><input type="radio" name="fireSeason" value="C" <c:if test="${itemFire.fireSeason == 'C'}">checked</c:if>>四季如常，偶尔染疾</label></div>
                                <div class="radio radio-block"><label><input type="radio" name="fireSeason" value="D" <c:if test="${itemFire.fireSeason == 'D'}">checked</c:if>>耐秋冬，不耐春夏，春夏易感疾病</label></div>
                            </div>
                        </div>
                    </c:if>
                    <c:if test="${fn:substring(respondent.acquireGenus, 2, 3) == '1'}">
                        <!--土行人-->
                        <div>
                            <div class="xingRen"><p>土行人定性分析</p></div>
                            <input type="hidden" name="earth" value="earth">
                            <!--面色特点-->
                            <div class="item">
                                <span>1.面色特点</span>
                                <div class="radio"><label><input type="radio" name="earthComplexion" value="A" <c:if test="${itemEarth.earthComplexion == 'A' || empty itemEarth}">checked</c:if>>面色暗黄，无光泽</label></div>
                                <div class="radio"><label><input type="radio" name="earthComplexion" value="B" <c:if test="${itemEarth.earthComplexion == 'B'}">checked</c:if>>面色黄，少光泽</label></div>
                                <div class="radio"><label><input type="radio" name="earthComplexion" value="C" <c:if test="${itemEarth.earthComplexion == 'C'}">checked</c:if>>面色偏黄</label></div>
                                <div class="radio"><label><input type="radio" name="earthComplexion" value="D" <c:if test="${itemEarth.earthComplexion == 'D'}">checked</c:if>>面色黄泛光</label></div>
                                <div class="radio"><label><input type="radio" name="earthComplexion" value="E" <c:if test="${itemEarth.earthComplexion == 'E'}">checked</c:if>>面色黄，泛红光</label></div>
                            </div>
                            <hr>
                            <!--心理特征-->
                            <div class="item">
                                <span>2.心理特征</span>
                                <div class="radio"><label><input type="radio" name="earthPsychology" value="B" <c:if test="${itemEarth.earthPsychology == 'A' || empty itemEarth}">checked</c:if>>性格呆板，寡言少语，喜忧思</label></div>
                                <div class="radio"><label><input type="radio" name="earthPsychology" value="C" <c:if test="${itemEarth.earthPsychology == 'B'}">checked</c:if>>沉着稳重，性情温厚，冷静，不易冲动，具有包容性</label></div>
                                <div class="radio"><label><input type="radio" name="earthPsychology" value="D" <c:if test="${itemEarth.earthPsychology == 'C'}">checked</c:if>>易怒冲动，好生闷气</label></div>
                            </div>
                            <hr>
                            <!--饮食口味-->
                            <div class="item">
                                <span>3.饮食口味</span>
                                <div class="radio"><label><input type="radio" name="earthDiet" value="A" <c:if test="${itemEarth.earthDiet == 'A' || empty itemEarth}">checked</c:if>>食欲不振，口淡无味，口不渴或渴喜热饮</label></div>
                                <div class="radio"><label><input type="radio" name="earthDiet" value="B" <c:if test="${itemEarth.earthDiet == 'B'}">checked</c:if>>食少，口淡，口不渴或渴喜热饮</label></div>
                                <div class="radio"><label><input type="radio" name="earthDiet" value="C" <c:if test="${itemEarth.earthDiet == 'C'}">checked</c:if>>饮食正常，偏食甜食</label></div>
                                <div class="radio"><label><input type="radio" name="earthDiet" value="D" <c:if test="${itemEarth.earthDiet == 'D'}">checked</c:if>>食欲旺盛，好食甜食，渴喜冷饮</label></div>
                                <div class="radio"><label><input type="radio" name="earthDiet" value="E" <c:if test="${itemEarth.earthDiet == 'E'}">checked</c:if>>多食易饥，嗜食肥甘厚味，口干喜冷饮</label></div>
                            </div>
                            <hr>
                            <!--大便-->
                            <div class="item">
                                <span>4.大便</span>
                                <div class="radio radio-block"><label><input type="radio" name="earthShit" value="A" <c:if test="${itemEarth.earthShit == 'A' || empty itemEarth}">checked</c:if>>大便溏薄，便次较多</label></div>
                                <div class="radio radio-block"><label><input type="radio" name="earthShit" value="B" <c:if test="${itemEarth.earthShit == 'B'}">checked</c:if>>大便稀软不成形</label></div>
                                <div class="radio radio-block"><label><input type="radio" name="earthShit" value="C" <c:if test="${itemEarth.earthShit == 'C'}">checked</c:if>>大便正常</label></div>
                                <div class="radio radio-block"><label><input type="radio" name="earthShit" value="D" <c:if test="${itemEarth.earthShit == 'D'}">checked</c:if>>大便粘滞不爽</label></div>
                                <div class="radio radio-block"><label><input type="radio" name="earthShit" value="E" <c:if test="${itemEarth.earthShit == 'E'}">checked</c:if>>大便酸臭秘结</label></div>
                            </div>
                            <hr>
                            <!--精神状态-->
                            <div class="item">
                                <span>5.精神状态</span>
                                <div class="radio"><label><input type="radio" name="earthMental" value="A" <c:if test="${itemEarth.earthMental == 'A' || empty itemEarth}">checked</c:if>>精神不振，倦怠乏力，懒言嗜卧</label></div>
                                <div class="radio"><label><input type="radio" name="earthMental" value="B" <c:if test="${itemEarth.earthMental == 'B'}">checked</c:if>>偶有全身乏力，懒言嗜卧</label></div>
                                <div class="radio"><label><input type="radio" name="earthMental" value="C" <c:if test="${itemEarth.earthMental == 'C'}">checked</c:if>>精神饱满</label></div>
                                <div class="radio"><label><input type="radio" name="earthMental" value="D" <c:if test="${itemEarth.earthMental == 'D'}">checked</c:if>>偶有精神亢奋</label></div>
                                <div class="radio"><label><input type="radio" name="earthMental" value="E" <c:if test="${itemEarth.earthMental == 'E'}">checked</c:if>>烦躁多言，好动</label></div>
                            </div>
                            <hr>
                            <!--头身症状-->
                            <div class="item">
                                <span>6.头身症状</span>
                                <div class="radio"><label><input type="radio" name="earthBody" value="A" <c:if test="${itemEarth.earthBody == 'A' || empty itemEarth}">checked</c:if>>时常头目眩晕，神疲乏力</label></div>
                                <div class="radio"><label><input type="radio" name="earthBody" value="B" <c:if test="${itemEarth.earthBody == 'B'}">checked</c:if>>偶有头晕，四肢乏力</label></div>
                                <div class="radio"><label><input type="radio" name="earthBody" value="C" <c:if test="${itemEarth.earthBody == 'C'}">checked</c:if>>未见头身不适</label></div>
                                <div class="radio"><label><input type="radio" name="earthBody" value="D" <c:if test="${itemEarth.earthBody == 'D'}">checked</c:if>>偶有头身困重</label></div>
                                <div class="radio"><label><input type="radio" name="earthBody" value="E" <c:if test="${itemEarth.earthBody == 'E'}">checked</c:if>>时常头身困重，不清醒</label></div>
                            </div>
                            <hr>
                            <!--口唇症状-->
                            <div class="item">
                                <span>7.口唇症状</span>
                                <div class="radio"><label><input type="radio" name="earthLips" value="A" <c:if test="${itemEarth.earthLips == 'A' || empty itemEarth}">checked</c:if>>口唇苍白，口泛清水</label></div>
                                <div class="radio"><label><input type="radio" name="earthLips" value="B" <c:if test="${itemEarth.earthLips == 'B'}">checked</c:if>>舌淡唇白，口泛清水</label></div>
                                <div class="radio"><label><input type="radio" name="earthLips" value="C" <c:if test="${itemEarth.earthLips == 'C'}">checked</c:if>>唇舌淡红，偶有口中发甜</label></div>
                                <div class="radio"><label><input type="radio" name="earthLips" value="D" <c:if test="${itemEarth.earthLips == 'D'}">checked</c:if>>唇舌鲜红，口中黏腻，舌苔厚腻</label></div>
                                <div class="radio"><label><input type="radio" name="earthLips" value="E" <c:if test="${itemEarth.earthLips == 'E'}">checked</c:if>>唇舌鲜红、干裂，口臭，口舌生疮</label></div>
                            </div>
                            <hr>
                            <!--胃脘症状-->
                            <div class="item">
                                <span>8.胃脘症状</span>
                                <div class="radio"><label><input type="radio" name="earthStomach" value="A" <c:if test="${itemEarth.earthStomach == 'A' || empty itemEarth}">checked</c:if>>冷痛、喜温喜按，纳少</label></div>
                                <div class="radio"><label><input type="radio" name="earthStomach" value="B" <c:if test="${itemEarth.earthStomach == 'B'}">checked</c:if>>腹痛或腹胀，喜温</label></div>
                                <div class="radio"><label><input type="radio" name="earthStomach" value="C" <c:if test="${itemEarth.earthStomach == 'C'}">checked</c:if>>胃脘部未见不适</label></div>
                                <div class="radio"><label><input type="radio" name="earthStomach" value="D" <c:if test="${itemEarth.earthStomach == 'D'}">checked</c:if>>胃脘部胀闷，纳呆</label></div>
                                <div class="radio"><label><input type="radio" name="earthStomach" value="E" <c:if test="${itemEarth.earthStomach == 'E'}">checked</c:if>>胃脘部烧灼痛，吞酸嘈杂</label></div>
                            </div>
                            <hr>
                            <!--好发季节-->
                            <div class="item">
                                <span>9.好发季节</span>
                                <div class="radio radio-block"><label><input type="radio" name="earthSeason" value="B" <c:if test="${itemEarth.earthSeason == 'B' || empty itemEarth}">checked</c:if>>耐春夏，不耐秋冬，秋冬易感疾病</label></div>
                                <div class="radio radio-block"><label><input type="radio" name="earthSeason" value="C" <c:if test="${itemEarth.earthSeason == 'C'}">checked</c:if>>四季如常，偶尔染疾</label></div>
                                <div class="radio radio-block"><label><input type="radio" name="earthSeason" value="D" <c:if test="${itemEarth.earthSeason == 'D'}">checked</c:if>>耐秋冬，不耐春夏，春夏易感疾病</label></div>
                            </div>
                        </div>
                    </c:if>
                    <c:if test="${fn:substring(respondent.acquireGenus, 3, 4) == '1'}">
                        <!--金行人-->
                        <div>
                            <div class="xingRen"><p>金行人定性分析</p></div>
                            <input type="hidden" name="metal" value="metal">
                            <!--面色特点-->
                            <div class="item">
                                <span>1.面色特点</span>
                                <div class="radio"><label><input type="radio" name="metalComplexion" value="A" <c:if test="${itemMetal.metalComplexion == 'A' || empty itemMetal}">checked</c:if>>面色苍白</label></div>
                                <div class="radio"><label><input type="radio" name="metalComplexion" value="B" <c:if test="${itemMetal.metalComplexion == 'B'}">checked</c:if>>面色淡白少光泽</label></div>
                                <div class="radio"><label><input type="radio" name="metalComplexion" value="C" <c:if test="${itemMetal.metalComplexion == 'C'}">checked</c:if>>面色偏白</label></div>
                                <div class="radio"><label><input type="radio" name="metalComplexion" value="D" <c:if test="${itemMetal.metalComplexion == 'D'}">checked</c:if>>面色白有光泽</label></div>
                                <div class="radio"><label><input type="radio" name="metalComplexion" value="E" <c:if test="${itemMetal.metalComplexion == 'E'}">checked</c:if>>面色白泛红光</label></div>
                            </div>
                            <hr>
                            <!--心理特征-->
                            <div class="item">
                                <span>2.心理特征</span>
                                <div class="radio"><label><input type="radio" name="metalPsychology" value="B" <c:if test="${itemMetal.metalPsychology == 'B' || empty itemMetal}">checked</c:if>>悲忧自扰，烦恼多多，牢骚满腹，情绪易失控</label></div>
                                <div class="radio"><label><input type="radio" name="metalPsychology" value="C" <c:if test="${itemMetal.metalPsychology == 'C'}">checked</c:if>>性格外向，喜欢竞争，严肃孤傲</label></div>
                                <div class="radio"><label><input type="radio" name="metalPsychology" value="D" <c:if test="${itemMetal.metalPsychology == 'D'}">checked</c:if>>强调自我，争强好胜，易怒失控，有攻击性</label></div>
                            </div>
                            <hr>
                            <!--汗症-->
                            <div class="item">
                                <span>3.汗症</span>
                                <div class="radio"><label><input type="radio" name="metalSweat" value="A" <c:if test="${itemMetal.metalSweat == 'A' || empty itemMetal}">checked</c:if>>动则汗出，时有冷汗</label></div>
                                <div class="radio"><label><input type="radio" name="metalSweat" value="B" <c:if test="${itemMetal.metalSweat == 'B'}">checked</c:if>>偶有冷汗、自汗</label></div>
                                <div class="radio"><label><input type="radio" name="metalSweat" value="C" <c:if test="${itemMetal.metalSweat == 'C'}">checked</c:if>>汗出正常</label></div>
                                <div class="radio"><label><input type="radio" name="metalSweat" value="D" <c:if test="${itemMetal.metalSweat == 'D'}">checked</c:if>>夜间偶有盗汗</label></div>
                                <div class="radio"><label><input type="radio" name="metalSweat" value="E" <c:if test="${itemMetal.metalSweat == 'E'}">checked</c:if>>夜间易盗汗、汗量多</label></div>
                            </div>
                            <hr>
                            <!--饮食口味-->
                            <div class="item">
                                <span>4.饮食口味</span>
                                <div class="radio"><label><input type="radio" name="metalDiet" value="A" <c:if test="${itemMetal.metalDiet == 'A' || empty itemMetal}">checked</c:if>>口淡，口不渴或渴喜热饮</label></div>
                                <div class="radio"><label><input type="radio" name="metalDiet" value="B" <c:if test="${itemMetal.metalDiet == 'B'}">checked</c:if>>偶有口淡、喜热饮</label></div>
                                <div class="radio"><label><input type="radio" name="metalDiet" value="C" <c:if test="${itemMetal.metalDiet == 'C'}">checked</c:if>>饮食、饮水正常</label></div>
                                <div class="radio"><label><input type="radio" name="metalDiet" value="D" <c:if test="${itemMetal.metalDiet == 'D'}">checked</c:if>>口燥咽干，喜冷饮</label></div>
                                <div class="radio"><label><input type="radio" name="metalDiet" value="E" <c:if test="${itemMetal.metalDiet == 'E'}">checked</c:if>>口燥咽干，口渴，喜冷饮</label></div>
                            </div>
                            <hr>
                            <!--大便-->
                            <div class="item">
                                <span>5.大便</span>
                                <div class="radio radio-block"><label><input type="radio" name="metalShit" value="A" <c:if test="${itemMetal.metalShit == 'A' || empty itemMetal}">checked</c:if>>大便溏薄，便次较多</label></div>
                                <div class="radio radio-block"><label><input type="radio" name="metalShit" value="B" <c:if test="${itemMetal.metalShit == 'B'}">checked</c:if>>大便稀软不成形</label></div>
                                <div class="radio radio-block"><label><input type="radio" name="metalShit" value="C" <c:if test="${itemMetal.metalShit == 'C'}">checked</c:if>>大便正常</label></div>
                                <div class="radio radio-block"><label><input type="radio" name="metalShit" value="D" <c:if test="${itemMetal.metalShit == 'D'}">checked</c:if>>大便粘滞不爽</label></div>
                                <div class="radio radio-block"><label><input type="radio" name="metalShit" value="E" <c:if test="${itemMetal.metalShit == 'E'}">checked</c:if>>大便酸臭秘结</label></div>
                            </div>
                            <hr>
                            <!--精神状态-->
                            <div class="item">
                                <span>6.睡眠</span>
                                <div class="radio"><label><input type="radio" name="metalMental" value="A" <c:if test="${itemMetal.metalMental == 'A' || empty itemMetal}">checked</c:if>>时常气短乏力，声音低怯</label></div>
                                <div class="radio"><label><input type="radio" name="metalMental" value="B" <c:if test="${itemMetal.metalMental == 'B'}">checked</c:if>>偶有倦怠乏力，懒言</label></div>
                                <div class="radio"><label><input type="radio" name="metalMental" value="C" <c:if test="${itemMetal.metalMental == 'C'}">checked</c:if>>精神饱满</label></div>
                                <div class="radio"><label><input type="radio" name="metalMental" value="D" <c:if test="${itemMetal.metalMental == 'D'}">checked</c:if>>偶有精神亢奋，不安</label></div>
                                <div class="radio"><label><input type="radio" name="metalMental" value="E" <c:if test="${itemMetal.metalMental == 'E'}">checked</c:if>>时常亢奋，好动，多言</label></div>
                            </div>
                            <hr>
                            <!--咳嗽-->
                            <div class="item">
                                <span>7.咳嗽</span>
                                <div class="radio"><label><input type="radio" name="metalCough" value="A" <c:if test="${itemMetal.metalCough == 'A' || empty itemMetal}">checked</c:if>>咳嗽气紧，神疲懒言，畏寒易感冒</label></div>
                                <div class="radio"><label><input type="radio" name="metalCough" value="B" <c:if test="${itemMetal.metalCough == 'B'}">checked</c:if>>咳嗽，懒言，语声低怯</label></div>
                                <div class="radio"><label><input type="radio" name="metalCough" value="C" <c:if test="${itemMetal.metalCough == 'C'}">checked</c:if>>无咳嗽</label></div>
                                <div class="radio"><label><input type="radio" name="metalCough" value="D" <c:if test="${itemMetal.metalCough == 'D'}">checked</c:if>>偶有咳嗽，伴咽喉红肿</label></div>
                                <div class="radio"><label><input type="radio" name="metalCough" value="E" <c:if test="${itemMetal.metalCough == 'E'}">checked</c:if>>咳嗽气促，气急，伴口干、咽喉肿痛</label></div>
                            </div>
                            <hr>
                            <!--咯痰-->
                            <div class="item">
                                <span>8.咯痰</span>
                                <div class="radio"><label><input type="radio" name="metalExpectoration" value="A" <c:if test="${itemMetal.metalExpectoration == 'A' || empty itemMetal}">checked</c:if>>痰白稀薄，量多</label></div>
                                <div class="radio"><label><input type="radio" name="metalExpectoration" value="B" <c:if test="${itemMetal.metalExpectoration == 'B'}">checked</c:if>>痰色清白</label></div>
                                <div class="radio"><label><input type="radio" name="metalExpectoration" value="C" <c:if test="${itemMetal.metalExpectoration == 'C'}">checked</c:if>>无咳痰</label></div>
                                <div class="radio"><label><input type="radio" name="metalExpectoration" value="D" <c:if test="${itemMetal.metalExpectoration == 'D'}">checked</c:if>>痰稠色黄</label></div>
                                <div class="radio"><label><input type="radio" name="metalExpectoration" value="E" <c:if test="${itemMetal.metalExpectoration == 'E'}">checked</c:if>>痰粘色黄，不易咯出</label></div>
                            </div>
                            <hr>
                            <!--鼻部症状-->
                            <div class="item">
                                <span>9.鼻部症状</span>
                                <div class="radio"><label><input type="radio" name="metalNose" value="A" <c:if test="${itemMetal.metalNose == 'A'|| empty itemMetal}">checked</c:if>>鼻流清涕，量多</label></div>
                                <div class="radio"><label><input type="radio" name="metalNose" value="B" <c:if test="${itemMetal.metalNose == 'B'}">checked</c:if>>鼻流清涕</label></div>
                                <div class="radio"><label><input type="radio" name="metalNose" value="C" <c:if test="${itemMetal.metalNose == 'C'}">checked</c:if>>无明显鼻部症状</label></div>
                                <div class="radio"><label><input type="radio" name="metalNose" value="D" <c:if test="${itemMetal.metalNose == 'D'}">checked</c:if>>鼻塞、流浊涕</label></div>
                                <div class="radio"><label><input type="radio" name="metalNose" value="E" <c:if test="${itemMetal.metalNose == 'E'}">checked</c:if>>鼻塞，鼻干，流黄浊涕</label></div>
                            </div>
                            <hr>
                            <!--皮肤-->
                            <div class="item">
                                <span>10.皮肤</span>
                                <div class="radio"><label><input type="radio" name="metalSkin" value="B" <c:if test="${itemMetal.metalSkin == 'B' || empty itemMetal}">checked</c:if>>皮肤干枯</label></div>
                                <div class="radio"><label><input type="radio" name="metalSkin" value="C" <c:if test="${itemMetal.metalSkin == 'C'}">checked</c:if>>皮肤润泽</label></div>
                                <div class="radio"><label><input type="radio" name="metalSkin" value="D" <c:if test="${itemMetal.metalSkin == 'D'}">checked</c:if>>皮肤油腻</label></div>
                            </div>
                            <hr>
                            <!--好发季节-->
                            <div class="item">
                                <span>11.好发季节</span>
                                <div class="radio radio-block"><label><input type="radio" name="metalSeason" value="B" <c:if test="${itemMetal.metalSeason == 'B' || empty itemMetal}">checked</c:if>>耐春夏，不耐秋冬，秋冬易感疾病</label></div>
                                <div class="radio radio-block"><label><input type="radio" name="metalSeason" value="C" <c:if test="${itemMetal.metalSeason == 'C'}">checked</c:if>>四季如常，偶尔染疾</label></div>
                                <div class="radio radio-block"><label><input type="radio" name="metalSeason" value="D" <c:if test="${itemMetal.metalSeason == 'D'}">checked</c:if>>耐秋冬，不耐春夏，春夏易感疾病</label></div>
                            </div>
                        </div>
                    </c:if>
                    <c:if test="${fn:substring(respondent.acquireGenus, 4, 5) == '1'}">
                        <!--水行人-->
                        <div>
                            <div class="xingRen"><p>水行人定性分析</p></div>
                            <input type="hidden" name="water" value="water">
                            <!--面色特点-->
                            <div class="item">
                                <span>1.面色特点</span>
                                <div class="radio"><label><input type="radio" name="waterComplexion" value="A" <c:if test="${itemWater.waterComplexion == 'A' || empty itemWater}">checked</c:if>>面色黑且暗淡无光</label></div>
                                <div class="radio"><label><input type="radio" name="waterComplexion" value="B" <c:if test="${itemWater.waterComplexion == 'B'}">checked</c:if>>面色黑少光泽</label></div>
                                <div class="radio"><label><input type="radio" name="waterComplexion" value="C" <c:if test="${itemWater.waterComplexion == 'C'}">checked</c:if>>面色偏黑</label></div>
                                <div class="radio"><label><input type="radio" name="waterComplexion" value="D" <c:if test="${itemWater.waterComplexion == 'D'}">checked</c:if>>面色黑有光泽</label></div>
                                <div class="radio"><label><input type="radio" name="waterComplexion" value="E" <c:if test="${itemWater.waterComplexion == 'E'}">checked</c:if>>面色黑泛红光</label></div>
                            </div>
                            <hr>
                            <!--心理特征-->
                            <div class="item">
                                <span>2.心理特征</span>
                                <div class="radio"><label><input type="radio" name="waterPsychology" value="B" <c:if test="${itemWater.waterPsychology == 'B' || empty itemWater}">checked</c:if>>优柔寡断、多思多虑，胆小怕事，冷淡缓慢</label></div>
                                <div class="radio"><label><input type="radio" name="waterPsychology" value="C" <c:if test="${itemWater.waterPsychology == 'C'}">checked</c:if>>性格内向，安静沉稳，行动迟缓，冷静智慧</label></div>
                                <div class="radio"><label><input type="radio" name="waterPsychology" value="D" <c:if test="${itemWater.waterPsychology == 'D'}">checked</c:if>>情感丰富，性易烦闷，容易冲动</label></div>
                            </div>
                            <hr>
                            <!--汗症-->
                            <div class="item">
                                <span>3.汗症</span>
                                <div class="radio"><label><input type="radio" name="waterSweat" value="A" <c:if test="${itemWater.waterSweat == 'A' || empty itemWater}">checked</c:if>>时常自汗，出冷汗</label></div>
                                <div class="radio"><label><input type="radio" name="waterSweat" value="B" <c:if test="${itemWater.waterSweat == 'B'}">checked</c:if>>偶有自汗</label></div>
                                <div class="radio"><label><input type="radio" name="waterSweat" value="C" <c:if test="${itemWater.waterSweat == 'C'}">checked</c:if>>汗出正常</label></div>
                                <div class="radio"><label><input type="radio" name="waterSweat" value="D" <c:if test="${itemWater.waterSweat == 'D'}">checked</c:if>>偶有潮热、盗汗</label></div>
                                <div class="radio"><label><input type="radio" name="waterSweat" value="E" <c:if test="${itemWater.waterSweat == 'E'}">checked</c:if>>时常潮热、盗汗</label></div>
                            </div>
                            <hr>
                            <!-小便-->
                            <div class="item">
                                <span>4.小便</span>
                                <div class="radio radio-block"><label><input type="radio" name="waterUrine" value="A" <c:if test="${itemWater.waterUrine == 'A' || empty itemWater}">checked</c:if>>小便清长，量多</label></div>
                                <div class="radio radio-block"><label><input type="radio" name="waterUrine" value="B" <c:if test="${itemWater.waterUrine == 'B'}">checked</c:if>>小便清长</label></div>
                                <div class="radio radio-block"><label><input type="radio" name="waterUrine" value="C" <c:if test="${itemWater.waterUrine == 'C'}">checked</c:if>>小便正常</label></div>
                                <div class="radio radio-block"><label><input type="radio" name="waterUrine" value="D" <c:if test="${itemWater.waterUrine == 'D'}">checked</c:if>>小便黄，量较少</label></div>
                                <div class="radio radio-block"><label><input type="radio" name="waterUrine" value="E" <c:if test="${itemWater.waterUrine == 'E'}">checked</c:if>>小便黄赤，量少，偶有臊臭味</label></div>
                            </div>
                            <hr>
                            <!--腰膝症状-->
                            <div class="item">
                                <span>5.腰膝症状</span>
                                <div class="radio"><label><input type="radio" name="waterWaist" value="A" <c:if test="${itemWater.waterWaist == 'A' || empty itemWater}">checked</c:if>>时常腰膝酸软无力，畏寒肢冷</label></div>
                                <div class="radio"><label><input type="radio" name="waterWaist" value="B" <c:if test="${itemWater.waterWaist == 'B'}">checked</c:if>>偶有腰膝酸软，乏力</label></div>
                                <div class="radio"><label><input type="radio" name="waterWaist" value="C" <c:if test="${itemWater.waterWaist == 'C'}">checked</c:if>>腰膝部活动自如</label></div>
                                <div class="radio"><label><input type="radio" name="waterWaist" value="D" <c:if test="${itemWater.waterWaist == 'D'}">checked</c:if>>腰膝酸痛</label></div>
                                <div class="radio"><label><input type="radio" name="waterWaist" value="E" <c:if test="${itemWater.waterWaist == 'E'}">checked</c:if>>经常腰膝酸痛</label></div>
                            </div>
                            <hr>
                            <!--性欲-->
                            <div class="item">
                                <span>6.性欲</span>
                                <div class="radio"><label><input type="radio" name="waterSexuality" value="B" <c:if test="${itemWater.waterSexuality == 'B' || empty itemWater}">checked</c:if>>性欲低下</label></div>
                                <div class="radio"><label><input type="radio" name="waterSexuality" value="C" <c:if test="${itemWater.waterSexuality == 'C'}">checked</c:if>>性欲正常</label></div>
                                <div class="radio"><label><input type="radio" name="waterSexuality" value="D" <c:if test="${itemWater.waterSexuality == 'D'}">checked</c:if>>性欲较强</label></div>
                            </div>
                            <hr>
                            <c:if test="${respondent.sex == '男'}">
                                <!--遗精-->
                                <div class="item">
                                    <span>7.遗精</span>
                                    <div class="radio"><label><input type="radio" name="waterSpermatorrhea" value="B" <c:if test="${itemWater.waterSpermatorrhea == 'B' || empty itemWater}">checked</c:if>>阳痿，滑精</label></div>
                                    <div class="radio"><label><input type="radio" name="waterSpermatorrhea" value="C" <c:if test="${itemWater.waterSpermatorrhea == 'C'}">checked</c:if>>正常</label></div>
                                    <div class="radio"><label><input type="radio" name="waterSpermatorrhea" value="D" <c:if test="${itemWater.waterSpermatorrhea == 'D'}">checked</c:if>>阳强易举，遗精早泄</label></div>
                                </div>
                                <hr>
                            </c:if>
                            <c:if test="${respondent.sex == '女'}">
                                <!--月经症状-->
                                <div class="item">
                                    <span>8.月经症状</span>
                                    <div class="radio"><label><input type="radio" name="waterMenstruate" value="A" <c:if test="${itemWater.waterMenstruate == 'A' || empty itemWater}">checked</c:if>>月经后期，量少，经闭</label></div>
                                    <div class="radio"><label><input type="radio" name="waterMenstruate" value="B" <c:if test="${itemWater.waterMenstruate == 'B'}">checked</c:if>>月经量少，质清，色淡</label></div>
                                    <div class="radio"><label><input type="radio" name="waterMenstruate" value="C" <c:if test="${itemWater.waterMenstruate == 'C'}">checked</c:if>>月经正常</label></div>
                                    <div class="radio"><label><input type="radio" name="waterMenstruate" value="D" <c:if test="${itemWater.waterMenstruate == 'D'}">checked</c:if>>月经量多，质稠，色红</label></div>
                                    <div class="radio"><label><input type="radio" name="waterMenstruate" value="E" <c:if test="${itemWater.waterMenstruate == 'E'}">checked</c:if>>月经先期，质稠或成块，色暗</label></div>
                                </div>
                                <hr>
                                <!--带下症状-->
                                <div class="item">
                                    <span>9.带下症状</span>
                                    <div class="radio"><label><input type="radio" name="waterLeucorrhea" value="A" <c:if test="${itemWater.waterLeucorrhea == 'A' || empty itemWater}">checked</c:if>>带下色白、量多、质清晰</label></div>
                                    <div class="radio"><label><input type="radio" name="waterLeucorrhea" value="B" <c:if test="${itemWater.waterLeucorrhea == 'B'}">checked</c:if>>带下色白、质清晰</label></div>
                                    <div class="radio"><label><input type="radio" name="waterLeucorrhea" value="C" <c:if test="${itemWater.waterLeucorrhea == 'C'}">checked</c:if>>带下正常</label></div>
                                    <div class="radio"><label><input type="radio" name="waterLeucorrhea" value="D" <c:if test="${itemWater.waterLeucorrhea == 'D'}">checked</c:if>>带下色黄、质黏稠</label></div>
                                    <div class="radio"><label><input type="radio" name="waterLeucorrhea" value="E" <c:if test="${itemWater.waterLeucorrhea == 'E'}">checked</c:if>>带下色黄或红，质稠，有异味</label></div>
                                </div>
                                <hr>
                            </c:if>
                            <!--好发季节-->
                            <div class="item">
                                <span>10.好发季节</span>
                                <div class="radio radio-block"><label><input type="radio" name="waterSeason" value="B" <c:if test="${itemWater.waterSeason == 'B' || empty itemWater}">checked</c:if>>耐春夏，不耐秋冬，秋冬易感疾病</label></div>
                                <div class="radio radio-block"><label><input type="radio" name="waterSeason" value="C" <c:if test="${itemWater.waterSeason == 'C'}">checked</c:if>>四季如常，偶尔染疾</label></div>
                                <div class="radio radio-block"><label><input type="radio" name="waterSeason" value="D" <c:if test="${itemWater.waterSeason == 'D'}">checked</c:if>>耐秋冬，不耐春夏，春夏易感疾病</label></div>
                            </div>
                        </div>
                    </c:if>
                    <!--保存-->
                    <div class="item">
                        <input type="submit" class="form-control qualitative-submit" value="提交">
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<!--尾注-->
<div class=" footer">&copy;阴阳五行人体质研究</div>
<script src="${pageContext.request.contextPath}/statics/js/lib/jquery-1.11.1.min.js"></script>
<script src="${pageContext.request.contextPath}/statics/js/lib/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/statics/js/lib/angular-1.3.0.js"></script>
<script src="${pageContext.request.contextPath}/statics/js/index.js"></script>
<script>
    $(function () {
        //js提示是否继续录入的问题
        $("#qualitativeMain").on('click', 'a', function (e) {
            if (!confirm("录入未完成，是否退出？")) {
                e.preventDefault();
                $(this).removeClass('exchangeActive');
                $('.list-exchange-active').addClass('exchangeActive');
            }
            else{
                $('.list-exchange').removeClass('exchangeActive');
                $(this).addClass('exchangeActive');
            }
        });
    })
</script>
</body>
</html>
