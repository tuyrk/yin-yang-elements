var houTianApp = angular.module('houTianApp', []);

houTianApp.controller('houTianCtrl', function ($scope) {
    /**
     * 获取用户的信息，展示在页面内
     */
    $(function () {
        $.post('doctor/manage/info', function (data) {
            console.log(data);
            if(data.code===0){
                $('#dropdownMenu1_realname').html(data.data.realname);
            }
        })
    });
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
    var name = angular.element("#name");
    var phone = angular.element("#phone");
    var pattern_phone = /^(13[\d]|15[\d]|17[678]|18[\d]|14[57])[\d]{8}$/;
    angular.element('#queryMobile').modal('hide');
    $scope.exitSystem = function () {
        if (confirm('确定退出系统？')) {
            window.location.href = 'exit';
        }
    };
    $scope.checkQueryHou = function (firstClick) {
        var phoneValue = phone.find('option:selected');
        var url = 'doctor/element/acquire';
        if (!/^[\u4E00-\u9FA5A-Za-z]+$/.test(name.val())) {
            alert("请输入有效的姓名");
            name.focus();
            return;
        }

        function phoneVal() {
            if (phoneValue.val() === '') {
                return phoneValue.val(null);
            } else {
                return phoneValue.val()
            }
        }

        $.post(url, {
                name: name.val(),
                phone: phoneVal()
            },
            function (data) {
                console.log(phoneVal());
                console.log(data);
                if (data.code === 14) {
                    for (var i = 0; i < data.data.length; i++) {
                        phone.append('<option value=' + data.data[i] + '>' + data.data[i] + '</option>');
                    }
                    if (!firstClick) {
                        if (!pattern_phone.test(phone.val())) {
                            alert("请先选择您想查询的手机号码");
                            phone.focus();
                        }
                    }
                    angular.element('#queryMobile').modal('show');
                } else if (data.code === 0) {
                    angular.element('#queryMobile').modal('hide');
                    var item = data.data;
                    console.log(data);
                    var your_conclusion = angular.element('#your-conclusion');
                    var content_left_img = document.getElementById('content-left-img');
                    var content_right_img = document.getElementById('content-right-img');
                    content_left_img.src = '/elements/' + item[0];
                    content_right_img.src = '/elements/' + item[1];
                    your_conclusion.text(item[2].acquire);
                    phone.html('');
                } else {
                    angular.element('#queryMobile').modal('hide');
                    alert(data.msg);
                }
            });
    }
});
