<%--
  User: 涂元坤
  Mail: 766564616@qq.com
  Date: 2017/12/28
  Time: 23:41 星期四
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>阴阳五行人体质研究</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/css/calendar/calendar.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/css/tplsCss/xianTian.css">
</head>
<body>
<!--先天分析页面-->
<div class="xT-main">
    <!--头部表单-->
    <div class="xT-header">
        <form action="#">
            <div class="header-p"><b>基本信息</b></div>
            <hr>
            <div class="header-content">
                <!--姓名、性别-->
                <div class="header-content-1">
                    <div>
                        <span>姓名:</span>
                        <input type="text" class="form-control" required style="width: 120px;">
                    </div>
                    <div style="margin-top: 2%">
                        <span>性别:</span>
                        <select name="gender" id="#" class="form-control" style="width: 80px;">
                            <option value="男">男</option>
                            <option value="女">女</option>
                        </select>
                    </div>
                </div>
                <!--出生日期、身份证号-->
                <div class="header-content-2">
                    <div>
                        <span>出生日期:</span>
                        <input type="text" id="birthday" class="Js_date input public_icon_sel animated form-control"
                               data-type="1" value="" placeholder="请选择日期" onfocus="this.blur()" style="width:160px;">
                        <input type="number" class="form-control" ng-maxlength="23" ng-minlength="0" placeholder="0"
                               style="width:60px;">&nbsp;时
                        <input type="number" class="form-control" ng-maxlength="59" ng-minlength="0" placeholder="0"
                               style="width:60px;">&nbsp;分
                    </div>
                    <div style="margin-top: 2%">
                        <span>身份证号:</span>
                        <input type="number" class="form-control" required style="width: 190px;">
                    </div>
                </div>
            </div>
            <!--执行命令按钮组-->
            <div class="header-btn">
                <span class="header-btn-group" style="margin-left: 4.7%">
                    <input type="button" class="btn btn-primary" value="查询">
                </span>
                <span class="header-btn-group">
                    <input type="button" class="btn btn-primary" value="删除">
                </span>
                <span class="header-btn-group">
                    <input type="button" class="btn btn-primary" value="导出数据">
                </span>
            </div>
        </form>
    </div>
    <!--页面主内容-->
    <div class="xT-content">
        <div class="content-p"><b>先天五行分析结果</b></div>
        <hr>
        <!--表-->
        <div class="row content-table">
            <!--右表-->
            <div class="content-right col-md-6 table-responsive" style="">
                <form action="#" role="form">
                    <!--时空结构表-->
                    <table class="table table-bordered" style="margin-bottom: 0px;">
                        <caption><h4><b>时空结构</b></h4></caption>
                        <thead>
                        <tr>
                            <th>- -</th>
                            <th>年柱</th>
                            <th>月柱</th>
                            <th>日柱</th>
                            <th>时柱</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <th>天干</th>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>
                        <tr>
                            <th>地支</th>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>
                        </tbody>
                    </table>
                    <!--五行结构表-->
                    <table class="table table-bordered" style="margin-bottom: 0px;">
                        <caption><h4><b>五行结构</b></h4></caption>
                        <thead>
                        <tr>
                            <th>木</th>
                            <th>火</th>
                            <th>水</th>
                            <th>金</th>
                            <th>土</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>32</td>
                            <td>32</td>
                            <td>32</td>
                            <td>32</td>
                            <td>23</td>
                        </tr>
                        </tbody>
                    </table>
                    <!--所属所缺-->
                    <div style="margin-top: 20px;">
                        <div style="float: left;">
                            <span>所属:</span>
                            <div style="width: 100px;height: 25px;float:right;border: 1px solid #8eacae;margin: 0 10px;"></div>
                        </div>
                        <div style="float: left">
                            <span>所缺:</span>
                            <div style="width: 100px;height: 25px;float:right;border: 1px solid #8eacae;margin-left: 10px;"></div>
                        </div>
                    </div>
                </form>
            </div>
            <!--左图-->
            <div class="content-left col-md-6">
                <div class="content-left-row">
                    <h4><b>五行结构图</b></h4>
                    <!--五行结构图-->
                    <img src="" alt="">
                </div>
            </div>
        </div>
    </div>
</div>
<script src="js/calendar/calendar.js"></script>
<script src="js/calendar/main.js"></script>
</body>
</html>
