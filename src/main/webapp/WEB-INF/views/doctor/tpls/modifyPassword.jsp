<%--
  User: 涂元坤
  Mail: 766564616@qq.com
  Date: 2017/12/28
  Time: 18:40 星期四
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <style>
        .modifyOutMain {
            width: 60%;
            height: 350px;
            margin: 0 auto;
            margin-top: 5%;
            padding: 5% 0;
            border-top: 1px solid #7b8b8d;
            border-bottom: 1px solid #7b8b8d;
            background-color: #f5f9fc;
        }

        .modifyMain .error {
            border: 1px red solid;
        }

        .modifyMain .success {
            border: 1px solid #d0f2dc;
        }

        .modifyMain {
            width: 60%;
            margin: 0 auto;
        }

        .modifyPasswordP {
            text-align: center;
            margin-bottom: 5%;
            color: #7b8b8d;
            font-size: 1.7rem;
        }

        .group-input {
            margin-bottom: 2.5%;
        }

        .group-input span {
            color: dimgrey;
            display: inline-block;
            width: 30%;
            text-align: right;
        }

        .group-input .form-control {
            width: 50%;
            display: inline-block;
        }

        .group-input .fa-check-circle {
            color: green;
        }

        .group-input p {
            color: #a94442;
            margin: 0;
            margin-left: 31%;
            font-size: 10px;
        }

        .group-input .modifyBtn {
            margin-left: 31%;
            width: 50%;
        }

        .group-input .modifyBtn:hover,
        .group-input .modifyBtn:focus,
        .group-input .modifyBtn:active {
            background-color: #a94442;
            border: #a94442;
        }

        /*alert css*/
        .flex-alert {
            top: 100px;
            padding-left:150px;
        }
        .shake {
            width: 50%;
        }
        /*alert css end */
    </style>
</head>
<body>
<div class="modifyOutMain">
    <div class="modifyMain">
        <!--晃动提示-->
        <div class="flex-alert"><div class="flex-item" id="shake"></div></div>
        <p class="modifyPasswordP">修改密码</p>
        <form action="#" name="modifyForm">
            <!--旧密码-->
            <div class="group-input">
                <span>旧密码：</span>
                <input type="password" class="form-control" name="modifyPassword" id="modifyPassword" required
                       ng-model="user.modifyPassword"
                       ng-class="showErrorCss(modifyForm.modifyPassword)"
                       ng-pattern="/^[0-9a-zA-Z_@#.]{6,16}$/">
                <i class="fa fa-check-circle" aria-hidden="true"
                   ng-show="showSuccessIcon(modifyForm.modifyPassword)"></i>
                <p ng-show="showErrorMessage(modifyForm.modifyPassword,'required')"><i
                        class="fa fa-exclamation-circle" aria-hidden="true"></i>旧密码不能为空</p>
                <p ng-show="showErrorMessage(modifyForm.modifyPassword,'pattern')"><i
                        class="fa fa-exclamation-circle" aria-hidden="true"></i>密码至少为6位数字</p>
            </div>
            <!--新密码-->
            <div class="group-input">
                <span>新密码：</span>
                <input type="password" class="form-control" name="newPassword" id="newPassword" required
                       ng-model="user.newPassword"
                       ng-class="showErrorCss(modifyForm.newPassword)"
                       ng-pattern="/^[0-9a-zA-Z_@#.]{6,16}$/">
                <i class="fa fa-check-circle" aria-hidden="true"
                   ng-show="showSuccessIcon(modifyForm.newPassword)"></i>
                <p ng-show="showErrorMessage(modifyForm.newPassword,'required')"><i
                        class="fa fa-exclamation-circle" aria-hidden="true"></i>新密码不能为空</p>
                <p ng-show="showErrorMessage(modifyForm.newPassword,'pattern')"><i
                        class="fa fa-exclamation-circle" aria-hidden="true"></i>密码至少为6位数字</p>
            </div>
            <!--确认密码-->
            <div class="group-input">
                <span>确认密码：</span>
                <input type="password" class="form-control" name="modifyRePassword"
                       ng-model="user.modifyRePassword"
                       ng-class="showErrorCss(modifyForm.modifyRePassword)" required>
                <i class="fa fa-check-circle" aria-hidden="true"
                   ng-show="(user.newPassword==user.modifyRePassword)&&showSuccessIcon(modifyForm.modifyRePassword)"></i>
                <p ng-show="(user.newPassword!=user.modifyRePassword)&&modifyForm.modifyRePassword.$touched"><i class="fa fa-exclamation-circle"
                                                                        aria-hidden="true"></i>两次密码不一致</p>
                <p ng-show="showErrorMessage(modifyForm.modifyRePassword,'required')"><i
                        class="fa fa-exclamation-circle" aria-hidden="true"></i>确认密码不能为空</p>
            </div>
            <div class="group-input" style="margin-bottom: 0">
                <input type="button" class="btn btn-primary modifyBtn" name="modifyBtn" value="确认修改"
                       ng-disabled="!modifyForm.$valid" onclick="modify()">
            </div>
        </form>
    </div>
</div>
<script>
    function modify() {
        var contextPath = $("#contextPath").text().trim();
        $.post(
            contextPath + '/doctor/modifyPwd',
            {
                'modifyPassword': $("#modifyPassword").val(),
                'newPassword': $("#newPassword").val()
            },
            function (data) {
                if ('error' === data.status) {
                    setDivCenter("旧密码错误！");return;
                }
                if ('success' === data.status) {
                    alert("修改成功,请重新登录!");
                    window.location = contextPath + '/logout';
                    return;
                }
                setDivCenter("修改失败！");
            }, "json");
    }
    function setDivCenter(str) {
        var shake = angular.element('#shake');
        shake.text(str);
        shake.addClass('shake');
        shake.show().delay(3000).fadeOut();
    }
    $(function () {
        $('.list-group-item').on('click',function () {
            $('.list-group-item').removeClass('exchangeActive');
            $(this).addClass('exchangeActive');
        })
    });
</script>
</body>
</html>