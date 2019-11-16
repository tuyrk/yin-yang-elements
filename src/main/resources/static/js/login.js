var loginApp = angular.module('loginApp', []);
loginApp.controller('loginCtrl', function ($scope, $interval) {
    var shake = angular.element('#shake');
    var validCode;
    /* //enter键登录
     angular.element('body').keydown(function (event) {
         if (event.keyCode === 13) {
             $scope.isLogin();
         }
     });*/
    /**
     * 登录验证
     */
    $scope.isLogin = function () {
        var username = angular.element('#username');
        var password = angular.element('#password');
        console.log(username.val().trim() + password.val().trim());
        /*var pattern_user = /^\d{8,10}$/;*/
        var pattern_Pass = /^[0-9a-zA-Z!@#$%^&*()_.]{6,16}$/;
        var url = 'doctor/manage/login';
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
        $.post(url, {
                username: username.val().trim(),
                password: password.val().trim()
            },
            function (data) {
                console.log(data);
                if (data.code === 0) {
                    window.location.href = 'scada';
                } else {
                    setDivCenter(data.msg)
                }
            });
    };
    /*reg  And find validate*/
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
    /**
     * 验证码验证
     * @param mail 当前传入的的邮箱（注册时的，找回密码时的）
     * @param flag 设置当前确定按钮的disabled
     * @param isRegis 标识调用此函数时注册还是找回密码，分别使用不同的参数post数据
     */
    $scope.sendCode = function (mail, flag, isRegis) {
        var timer = 59;
        var codeValue = angular.element('#' + flag);
        var url = 'doctor/manage/sendCode';
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
        if (isRegis) {
            $.post(url, {
                    mail: mail.trim(),
                    username: $scope.user.username.trim(),
                    password: $scope.user.password.trim(),
                    realname: $scope.user.name.trim(),
                    isRegis: isRegis
                },
                function (data) {
                    console.log(data);
                    if (data.code === 0) {
                        validCode = data.data;
                        console.log(validCode)
                    }
                })
        } else {
            $.post(url, {
                    mail: mail.trim(),
                    isRegis: isRegis
                },
                function (data) {
                    console.log(data);
                    if (data.code === 0) {
                        validCode = data.data;
                        console.log(validCode)
                    }
                })
        }

    };
    /**
     * 取消定时器
     */
    $scope.stopSet = function () {
        $interval.cancel(sendCode);
    };
    /**
     * 调用取消定时器的方法
     */
    $scope.$on("$destory", function () {
        $scope.stopSet();
    });
    /**
     * 注册验证
     */
    $scope.regist = function () {
        var url = 'doctor/manage/regis';
        //console.log($scope.user.username.trim() + $scope.user.password.trim() + $scope.user.name.trim() + $scope.user.email.trim() + $scope.user.validateCode.trim());
        /*if (validCode && $scope.user.validateCode.trim() === validCode) {*/
            $.post(url, {
                username: $scope.user.username.trim(),
                password: $scope.user.password.trim(),
                realname: $scope.user.name.trim(),
                mail: $scope.user.email.trim()
            }, function (data) {
                console.log(data);
                if (data.code === 0) {
                    setDivCenter("注册成功！");
                    setTimeout(function () {
                        window.location.reload();
                    }, 2000)
                } else {
                    setDivCenter("用户已注册！");
                }
            })
        /*} else {
            setDivCenter("验证码错误！");
        }*/
    };
    /**
     * 找回密码验证
     */
    $scope.modifyPassword = function () {
        var url = 'doctor/manage/retrieve';
        console.log($scope.user.findPassword.trim() + $scope.user.findEmail.trim() + $scope.user.findValidateCode.trim());
        if (validCode && $scope.user.findValidateCode.trim() === validCode) {
            $.post(url, {
                    password: $scope.user.findPassword.trim(),
                    mail: $scope.user.findEmail.trim()
                },
                function (data) {
                    console.log(data);
                    if (data.code === 0) {
                        setDivCenter("找回密码成功,请重新登录");
                        setTimeout(function () {
                            window.location.reload();
                        }, 2000)
                    } else {
                        setDivCenter("用户不存在！");
                    }
                });
        } else {
            setDivCenter("验证码错误！");
        }

    };

    /**
     * 错误提示样式
     */
    function setDivCenter(str) {
        shake.addClass('shake');
        shake.text(str);
        shake.show().delay(3000).fadeOut();
    }
});