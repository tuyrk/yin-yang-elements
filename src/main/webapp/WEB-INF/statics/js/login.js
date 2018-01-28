var loginApp = angular.module('loginApp', []);
loginApp.controller('loginCtrl', function ($scope, $interval, $http) {
    /*login validate*/
    var contextPath = angular.element("#contextPath").text();
    var shake = angular.element('#shake');
    $scope.isLogin = function () {
        var username = angular.element('#username');
        var password = angular.element('#password');
        /*var pattern_user = /^\d{8,10}$/;*/
        var pattern_Pass = /^[0-9a-zA-Z!@#$%^&*()_.]{6,16}$/;
        if (!username.val()) {
            setDivCenter('账号不能为空！');
            username.focus();
            return;
        }
        if (!password.val()) {
            setDivCenter('密码不能为空！');
            password.focus();
            return;
        }
        if (!pattern_Pass.test(password.val())) {
            setDivCenter("密码输入有误！");
            password.focus();
            return;
        }
        $http({
            method: 'post',
            url: contextPath + '/login',
            params: {'username': username.val().trim(), 'password': password.val().trim()}
        }).then(function (result) {
            if ('success' === result.data.status) {
                window.location = contextPath + '/doctor/';
            } else if ('unaudited' === result.data.status) {
                setDivCenter("您还未通过管理员审核，暂无法登录！");
            } else {
                setDivCenter("用户名或密码错误！");
            }
        }).catch(function () {
            console.log(result.data.status);
            setDivCenter("登录失败！");
        });
    };

    function setDivCenter(str) {
        shake.addClass('shake');
        shake.text(str);
        shake.show().delay(3000).fadeOut();
    }

    angular.element('body').keydown(function () {
        if (event.keyCode === 13) {
            $scope.isLogin();
        }
    });

    /*reg  And fina validate*/
    $scope.showErrorCss = function (errorName) {
        return {
            error: errorName.$invalid && errorName.$touched,
            success: errorName.$valid && errorName.$touched
        }
    };
    $scope.showErrorMessage = function (errorName, error) {
        return errorName.$error[error] && errorName.$touched;
    };
    $scope.showSuccessIcon = function (successName) {
        return successName.$valid && successName.$touched
    };
    $scope.sendCode = function (mail, flag) {
        var timer = 59;
        var codeValue = angular.element('#' + flag);
        if (flag === 'sendCodeFor') {
            angular.element('#findEmail').attr('disabled', 'disabled');
        }
        codeValue.addClass('disabled');
        codeValue.css({
            color: '#fff'
        });
        sendCode = $interval(function () {
            if (timer >= 0) {
                codeValue.val(timer-- + '秒后获取');
            }
            else {
                $scope.stopSet();
                codeValue.removeClass('disabled');
                codeValue.val('重新发送');
                timer = 59;
            }
        }, 1000);

        $http({
            method: 'post',
            url: contextPath + '/sendMail',
            params: {'mail': mail.trim(), 'flag': flag}
        }).then(function (result) {
            if ('fail' === result.data.status) {
                setDivCenter("发送失败！");
            }
        }).catch(function () {
            setDivCenter("发送失败！");
        });
    };

    $scope.stopSet = function () {
        $interval.cancel(sendCode);
    };

    $scope.$on("$destory", function () {
        $scope.stopSet();
    });

    $scope.regist = function () {
        $http({
            method: 'post',
            url: contextPath + '/register',
            params: {
                'username': $scope.user.username.trim(),
                'password': $scope.user.password.trim(),
                'name': $scope.user.name.trim(),
                'mail': $scope.user.email.trim()
                // 'validateCode': $scope.user.validateCode.trim()
            }
        }).then(function (result) {
            if ('success' === result.data.status) {
                alert("注册成功！");
                window.location.reload();
            }
            if ('error' === result.data.status) {
                setDivCenter("验证码错误！");
                return;
            }
            if ('registered' === result.data.status) {
                setDivCenter("用户名已注册！");
                return;
            }
            if ('bound' === result.data.status) {
                setDivCenter("邮箱已绑定！");
                return;
            }
            if ('fail' === result.data.status) {
                setDivCenter("注册失败！");
            }
        }).catch(function () {
            setDivCenter("注册失败！");
        });
    };

    $scope.modifyPassword = function () {
        $http({
            method: 'post',
            url: contextPath + '/modifyPassword',
            params: {
                'password': $scope.user.findPassword.trim(),
                'mail': $scope.user.findEmail.trim(),
                'validateCode': $scope.user.findValidateCode.trim()
            }
        }).then(function (result) {
            if ('error' === result.data.status) {
                setDivCenter("验证码错误！");
                return;
            }
            if ('unregistered' === result.data.status) {
                setDivCenter("此邮箱未注册！");
                return;
            }
            if ('fail' === result.data.status) {
                setDivCenter("修改失败！");
                return;
            }
            if ('success' === result.data.status) {
                alert("修改成功！");
            }
            window.location.reload();
        }).catch(function () {
            setDivCenter("注册失败！");
        });
    }
});
