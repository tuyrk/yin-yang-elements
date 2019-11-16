var settingApp = angular.module('settingApp', []);
$(function () {
    $.post('doctor/manage/info', function (data) {
        console.log(data);
        if(data.code===0){
            $('#dropdownMenu1_realname').html(data.data.realname);
            $('#oldEmail').val(data.data.mail)
        }
    })
});
window.load = function () {
    $('.list-group-item').on('click', function () {
        $('.list-group-item').removeClass('exchangeActive');
        $(this).addClass('exchangeActive');
    })
};
settingApp.controller('settingCtrl', function ($scope) {
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
    $scope.modify = function (flag) {
        var newMail = $('#email');
        var oldPassword = $('#modifyPassword');
        var newPassword = $('#newPassword');
        var url = 'doctor/manage/modify';
        if (flag === 'email') {
            $.post(url, {
                    mail: newMail.val()
                },
                function (data) {
                    console.log(data);
                    if(data.code===0){
                        setDivCenter('修改成功');
                    } else{
                        setDivCenter(data.msg);
                    }
                });
        } else if (flag === 'password') {
            $.post(url, {
                    password: newPassword.val()
                },
                function (data) {
                    console.log(data);
                    if(data.code===0){
                        setDivCenter('修改成功');
                    } else{
                        setDivCenter(data.msg);
                    }
                });
        }
    };
    $scope.exitSystem = function () {
        if (confirm('确定退出系统？')) {
            window.location.href = 'exit';
        }
    };

    function setDivCenter(str) {
        var shake = angular.element('#shake');
        shake.addClass('shake');
        shake.text(str);
        shake.show().delay(3000).fadeOut();
    }
});