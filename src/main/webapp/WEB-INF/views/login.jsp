<%--
  User: 涂元坤
  Mail: 766564616@qq.com
  Date: 2017/12/25
  Time: 20:25 星期一
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html ng-app="loginApp" ng-controller="loginCtrl">
<head>
    <title>登录</title>
    <link rel="icon" href="${pageContext.request.contextPath}/statics/images/login/logo.png" type="image/x-icon">
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/statics/images/login/logo.png" type="image/x-icon"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/css/lib/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/css/lib/fonts/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/css/login.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/css/alert.css">
    <script>
        // Picture element HTML5 shiv
        document.createElement("picture");
    </script>
    <script async src="${pageContext.request.contextPath}/statics/js/lib/picturefill.min.js"></script>
</head>
<body>
<div class="container-fluid">
    <!--picturefill 插件做响应式图片设计-->
    <picture>
        <!--[if IE 9]>
        <video style="display: none;"><![endif]-->
        <source srcset="${pageContext.request.contextPath}/statics/images/login/login-bg.png"
                media="(min-width: 1025px)" class="img-responsive">
        <source srcset="${pageContext.request.contextPath}/statics/images/login/login-bg-mobile.png"
                media="(min-width: 320px)" style="width: 100%;height: auto">
        <!--[if IE 9]></video><![endif]-->
        <img srcset="${pageContext.request.contextPath}/statics/images/login/login-bg-mobile.png" alt="This is login background-image"
             style="width: 100%;height: auto">
    </picture>
    <!--主内容-->
    <div class="flex-container main">
        <!--登录管理员接口-->
        <div style="position: fixed;right: 0;top: 10px;">
            <p><a href="adminLogin.html">管理员登录<i class="fa fa-arrow-right" aria-hidden="true"></i></a></p>
        </div>
        <!--晃动提示-->
        <div class="flex-alert">
            <div class="flex-item" id="shake"><span></span></div>
        </div>
        <div class="main-content pull-left">
            <!--登录页面logo-->
            <div class="pull-left only-sm-header">
                <img src="${pageContext.request.contextPath}/statics/images/login/logo_2.png" alt="This is a logo!"  class="img-responsive"  style="margin-top: 4.5%">
            </div>
            <!--右侧登录验证表单-->
            <div class="pull-left main-form only-sm-form">
                <!--右侧登录验证表单-->
                <form action="${pageContext.request.contextPath}/login" name="loginForm" novalidate>
                    <div class="form-submit">
                        <div class="pull-left" style="width:70%;margin-right: 0.5em">
                            <!--账号-->
                            <div class="has-feedback">
                                <label for="username" class="sr-only">账户</label>
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-user fa-fw fa-i"></i> </span>
                                    <input type="text" id="username" name="username" class="form-control input" placeholder="账号" required>
                                </div>
                            </div>
                            <!--密码-->
                            <div class="has-feedback">
                                <label for="password" class="sr-only">密码</label>
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-lock fa-fw fa-i"></i> </span>
                                    <input type="password" id="password" name="password" class="form-control input" placeholder="密码" required>
                                </div>
                            </div>
                        </div>
                        <!--登录按钮-->
                        <div class="pull-right" style="width: 25%;">
                            <input type="button" id="login" value="登录" class="btn btn-primary" ng-click="isLogin()">
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <!--注册、找回密码-->
        <div class="main-footer pull-left">
            <span><a href="#reg" data-toggle="modal">注册</a></span><!-- 触发注册模态框 -->
            <span><a href="#find" data-toggle="modal">找回密码</a></span><!-- 触发找回密码模态框 -->
        </div>
    </div>
</div>
<span id="contextPath" style="display: none">${pageContext.request.contextPath}</span>
<!--注册 模态框（Modal） -->
<div class="modal fade" id="reg" tabindex="-1" role="dialog" aria-labelledby="myModalLabel-1" aria-hidden="true">
    <!--晃动提示-->
    <div class="flex-alert">
        <div class="flex-item" id="shake"><span></span></div>
    </div>
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel-1"><i class="fa fa-user fa-2x fa-i"></i>用户注册</h4>
            </div>
            <!--注册表单-->
            <div class="modal-body">
                <form action="#" novalidate name="regForm">
                    <!--账号-->
                    <div class="group-input">
                        <span>账号：</span>
                        <input type="text" class="form-control" name="username" required
                               ng-model="user.username"
                               ng-class="showErrorCss(regForm.username)">
                        <i class="fa fa-check-circle" aria-hidden="true" ng-show="showSuccessIcon(regForm.username)"></i>
                        <p ng-show="showErrorMessage(regForm.username,'required')">
                            <i class="fa fa-exclamation-circle" aria-hidden="true"></i>账号不能为空</p>
                    </div>
                    <!--姓名-->
                    <div class="group-input">
                        <span>姓名：</span>
                        <input type="text" class="form-control" name="name" required
                               ng-model="user.name"
                               ng-class="showErrorCss(regForm.name)"
                               ng-pattern="/^[\u4E00-\u9FA5A-Za-z]+$/">
                        <i class="fa fa-check-circle" aria-hidden="true" ng-show="showSuccessIcon(regForm.name)"></i>
                        <p ng-show="showErrorMessage(regForm.name,'required')">
                            <i class="fa fa-exclamation-circle" aria-hidden="true"></i>姓名不能为空</p>
                        <p ng-show="showErrorMessage(regForm.name,'pattern')">
                            <i class="fa fa-exclamation-circle" aria-hidden="true"></i>请输入合法的中文或英文姓名
                        </p>
                    </div>
                    <!--密码-->
                    <div class="group-input">
                        <span>密码：</span>
                        <input type="password" class="form-control" name="password" required
                               ng-model="user.password"
                               ng-class="showErrorCss(regForm.password)"
                               ng-pattern="/^[0-9a-zA-Z!@#$%^&*()_.]{6,16}$/">
                        <i class="fa fa-check-circle" aria-hidden="true"
                           ng-show="showSuccessIcon(regForm.password)"></i>
                        <p ng-show="showErrorMessage(regForm.password,'required')">
                            <i class="fa fa-exclamation-circle" aria-hidden="true"></i>密码不能为空</p>
                        <p ng-show="showErrorMessage(regForm.password,'pattern')">
                            <i class="fa fa-exclamation-circle" aria-hidden="true"></i>密码至少为6位合法字符
                        </p>
                    </div>
                    <!--确认密码-->
                    <div class="group-input">
                        <span>确认密码：</span>
                        <input type="password" class="form-control" name="rePassword" required
                               ng-model="user.rePassword"
                               ng-class="showErrorCss(regForm.rePassword)">
                        <i class="fa fa-check-circle" aria-hidden="true"
                           ng-show="(user.password==user.rePassword)&&showSuccessIcon(regForm.password)"></i>
                        <p ng-show="(user.password!=user.rePassword)&&regForm.rePassword.$touched">
                            <i class="fa fa-exclamation-circle" aria-hidden="true"></i>两次密码不一致</p>
                        <p ng-show="showErrorMessage(regForm.rePassword,'required')">
                            <i class="fa fa-exclamation-circle" aria-hidden="true"></i>密码不能为空
                        </p>
                    </div>
                    <!--邮箱-->
                    <div class="group-input">
                        <span>邮箱：</span>
                        <input type="email" class="form-control" name="email" required
                               ng-model="user.email"
                               ng-class="showErrorCss(regForm.email)"
                               ng-pattern="/^[A-Za-z0-9\u4e00-\u9fa5_]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/">
                        <i class="fa fa-check-circle" aria-hidden="true" ng-show="showSuccessIcon(regForm.email)"></i>
                        <p ng-show="showErrorMessage(regForm.email,'required')">
                            <i class="fa fa-exclamation-circle" aria-hidden="true"></i>邮箱不能为空</p>
                        <p ng-show="showErrorMessage(regForm.email,'pattern')">
                            <i class="fa fa-exclamation-circle" aria-hidden="true"></i>请输入合法的邮箱</p>
                    </div>
                    <!--验证码-->
                    <%--<div class="group-input">--%>
                        <%--<span>验证码：</span>--%>
                        <%--<input type="text" class="form-control validateCodeInput" name="validateCode"--%>
                               <%--ng-model="user.validateCode"--%>
                               <%--ng-class="showErrorCss(regForm.validateCode)"--%>
                               <%--ng-pattern="/^[0-9]{6,8}$/"--%>
                               <%--required>--%>
                        <%--<div class="validateCodeDiv">--%>
                            <%--<input type="button" class="btn btn-primary" id="sendCodeReg" value="发送验证码"--%>
                                   <%--ng-disabled="!showSuccessIcon(regForm.email)"--%>
                                   <%--ng-click="sendCode(user.email,'sendCodeReg')">--%>
                        <%--</div>--%>
                        <%--<i class="fa fa-check-circle" aria-hidden="true"--%>
                           <%--ng-show="showSuccessIcon(regForm.validateCode)"></i>--%>
                        <%--<p ng-show="showErrorMessage(regForm.validateCode,'required')"><i--%>
                                <%--class="fa fa-exclamation-circle" aria-hidden="true"></i>验证码不能为空</p>--%>
                        <%--<p ng-show="showErrorMessage(regForm.validateCode,'pattern')"><i--%>
                                <%--class="fa fa-exclamation-circle" aria-hidden="true"></i>您输入的验证码有误</p>--%>
                    <%--</div>--%>
                    <!--确认注册-->
                    <div class="group-input" style="text-align: center;margin-bottom: 0">
                        <input type="button" class="btn btn-primary reg" name="reg" value="确认注册"
                               ng-disabled="!regForm.$valid"
                               ng-click="regist()">
                    </div>
                </form>
            </div>
            <!--关闭-->
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<!--密码找回 模态框（Modal） -->
<div class="modal fade" id="find" tabindex="-1" role="dialog" aria-labelledby="myModalLabel-2" aria-hidden="true">
    <!--晃动提示-->
    <div class="flex-alert">
        <div class="flex-item" id="shake"><span></span></div>
    </div>
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel-2"><i class="fa fa-key fa-2x fa-i"></i>密码找回</h4>
            </div>
            <!--找回密码表单-->
            <div class="modal-body">
                <form action="#" novalidate name="findForm">
                    <!--邮箱-->
                    <div class="group-input">
                        <span>邮箱：</span>
                        <input type="email" class="form-control" name="findEmail" id="findEmail" required
                               ng-model="user.findEmail"
                               ng-class="showErrorCss(findForm.findEmail)"
                               ng-pattern="/^[A-Za-z0-9\u4e00-\u9fa5]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/">
                        <i class="fa fa-check-circle" aria-hidden="true"
                           ng-show="showSuccessIcon(findForm.findEmail)"></i>
                        <p ng-show="showErrorMessage(findForm.findEmail,'required')">
                            <i class="fa fa-exclamation-circle" aria-hidden="true"></i>邮箱不能为空
                        </p>
                        <p ng-show="showErrorMessage(findForm.findEmail,'pattern')">
                            <i class="fa fa-exclamation-circle" aria-hidden="true"></i>请输入合法的邮箱
                        </p>
                    </div>
                    <!--验证码-->
                    <div class="group-input">
                        <span>验证码：</span>
                        <input type="text" class="form-control validateCodeInput" name="findValidateCode" required
                               ng-model="user.findValidateCode"
                               ng-class="showErrorCss(findForm.findValidateCode)"
                               ng-pattern="/^[0-9]{6,8}$/">
                        <div class="validateCodeDiv">
                            <input type="button" class="btn btn-primary" id="sendCodeFor" value="发送验证码"
                                   ng-disabled="!showSuccessIcon(findForm.findEmail)"
                                   ng-click="sendCode(user.findEmail,'sendCodeFor')">
                        </div>
                        <i class="fa fa-check-circle" aria-hidden="true"
                           ng-show="showSuccessIcon(findForm.findValidateCode)"></i>
                        <p ng-show="showErrorMessage(findForm.findValidateCode,'required')"><i
                                class="fa fa-exclamation-circle" aria-hidden="true"></i>验证码不能为空</p>
                        <p ng-show="showErrorMessage(findForm.findValidateCode,'pattern')"><i
                                class="fa fa-exclamation-circle" aria-hidden="true"></i>您输入的验证码有误</p>
                    </div>
                    <!--新密码-->
                    <div class="group-input">
                        <span>新密码：</span>
                        <input type="password" class="form-control" name="findPassword"
                               ng-model="user.findPassword"
                               ng-class="showErrorCss(findForm.findPassword)"
                               ng-pattern="/^[0-9a-zA-Z_@#.]{6,16}$/"
                               required>
                        <i class="fa fa-check-circle" aria-hidden="true"
                           ng-show="showSuccessIcon(findForm.findPassword)"></i>
                        <p ng-show="showErrorMessage(findForm.findPassword,'required')"><i
                                class="fa fa-exclamation-circle" aria-hidden="true"></i>密码不能为空</p>
                        <p ng-show="showErrorMessage(findForm.findPassword,'pattern')"><i
                                class="fa fa-exclamation-circle" aria-hidden="true"></i>密码至少为6位数字</p>
                    </div>
                    <!--确认密码-->
                    <div class="group-input">
                        <span>确认密码：</span>
                        <input type="password" class="form-control" name="findRePassword" required
                               ng-model="user.findRePassword"
                               ng-class="showErrorCss(findForm.findRePassword)">
                        <i class="fa fa-check-circle" aria-hidden="true"
                           ng-show="(user.findPassword==user.findRePassword)&&showSuccessIcon(findForm.findRePassword)"></i>
                        <p ng-show="(user.findPassword!=user.findRePassword)&&findForm.findRePassword.$touched"><i class="fa fa-exclamation-circle"
                                                                               aria-hidden="true"></i>两次密码不一致</p>
                        <p ng-show="showErrorMessage(findForm.findRePassword,'required')"><i
                                class="fa fa-exclamation-circle" aria-hidden="true"></i>密码不能为空</p>

                    </div>
                    <!--确认修改-->
                    <div class="group-input" style="text-align: center;margin-bottom: 0">
                        <input type="button" class="btn btn-primary reg"
                               ng-click="modifyPassword()"
                               ng-disabled="!findForm.$valid"
                               value="确认修改">
                    </div>
                </form>
            </div>
            <!--关闭-->
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<script src="${pageContext.request.contextPath}/statics/js/lib/jquery-3.2.1.min.js"></script>
<script src="${pageContext.request.contextPath}/statics/js/lib/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/statics/js/lib/angular.min.js"></script>
<script src="${pageContext.request.contextPath}/statics/js/lib/angular-ui-router.js"></script>
<script src="${pageContext.request.contextPath}/statics/js/login.js"></script>
</body>
</html>