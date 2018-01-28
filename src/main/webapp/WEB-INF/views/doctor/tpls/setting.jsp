<%--
  User: 涂元坤
  Mail: 766564616@qq.com
  Date: 2017/12/25
  Time: 20:22 星期一
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <style>
        .modifyOutMain {
            width: 60%;
            height: 300px;
            margin: 0 auto;
            margin-top: 5%;
            padding: 5% 0;
            border-top: 1px solid #7b8b8d;
            border-bottom: 1px solid #7b8b8d;
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
        .group-input .setBtn {
            margin-left: 31%;
            width: 50%;

        }
        .group-input .setBtn:hover,
        .group-input .setBtn:focus,
        .group-input .setBtn:active {
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
        <p class="modifyPasswordP">个人设置</p>
        <form action="#" name="setForm">
            <!--旧邮箱-->
            <div class="group-input">
                <span>旧邮箱：</span>
                <input type="email" class="form-control" value="${doctor.mail}" disabled>
            </div>
            <!--新邮箱-->
            <div class="group-input">
                <span>新邮箱：</span>
                <input type="email" class="form-control" name="email" id="email" required
                       ng-model="user.email"
                       ng-class="showErrorCss(setForm.email)"
                       ng-pattern="/^[A-Za-z0-9\u4e00-\u9fa5]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/">
                <i class="fa fa-check-circle" aria-hidden="true" ng-show="showSuccessIcon(setForm.email)"></i>
                <p ng-show="showErrorMessage(setForm.email,'required')">
                    <i class="fa fa-exclamation-circle" aria-hidden="true"></i>邮箱不能为空</p>
                <p ng-show="showErrorMessage(setForm.email,'pattern')">
                    <i class="fa fa-exclamation-circle" aria-hidden="true"></i>请输入合法的邮箱</p>
            </div>
            <div class="group-input" style="margin-bottom: 0">
                <input type="button" class="btn btn-primary setBtn" name="setBtn"
                       ng-disabled="!setForm.$valid"
                       value="确认修改" onclick="modify()">
            </div>
        </form>
    </div>
</div>
<script>
    function modify() {
        var contextPath = $("#contextPath").text().trim();
        $.post(
            contextPath + '/doctor/modifyMail',
            {
                'newMail': $("#email").val()
            },
            function (data) {
                if ('success' === data.status) {
                    alert("修改成功！");
                    window.location.reload();
                    return;
                } else if ('bound' === data.status) {
                    setDivCenter("邮箱已绑定！");
                    return;
                }
                setDivCenter("修改失败！");
            }, "json");
    }
    function setDivCenter(str) {
        var shake = angular.element('#shake');
        shake.addClass('shake');
        shake.text(str);
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
