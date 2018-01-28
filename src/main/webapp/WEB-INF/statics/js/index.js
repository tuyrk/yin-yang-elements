var indexApp = angular.module('indexApp', []);
indexApp.controller('indexCtrl', function ($scope, $http) {
    $('.ulCilck').on('click', '.list-exchange', function () {
        $('.list-exchange').removeClass('exchangeActive');
        $(this).addClass('exchangeActive');
    });
    $scope.isValidPhone = function () {
        var name = angular.element("#name");
        var phone = angular.element('#phone');
        var birthday = angular.element('#birthday');
        var pattern_phone = /^(13[\d]|15[\d]|17[678]|18[\d]|14[57])[\d]{8}$/;
        var pattern_name = /^[\u4E00-\u9FA5A-Za-z]+$/;
        if (!pattern_name.test(name.val())) {
            alert("姓名格式错误");
            name.focus();
            return;
        }
        if (birthday.val() === "") {
            alert("请选择出生日期!");
            birthday.click();
            return;
        }
        if (!pattern_phone.test(phone.val())) {
            alert("手机号码错误");
            phone.focus();
            return;
        }

        var contextPath = angular.element("#contextPath").text();
        $http({
            method: 'post',
            url: contextPath + '/doctor/checkPhone',
            params: {'phone': phone.val().trim()}
        }).then(function (result) {
            if ('exists' === result.data.status) {
                if (confirm('此电话号码已录入,是否覆盖?')) {
                    angular.element("#status").val("exists");
                    angular.element("#indexForm").submit();
                }
                return;
            }
            angular.element("#indexForm").submit();
        }).catch(function () {
            alert("请重新提交！");
        });
    };

    $scope.queryData = function () {
        var url = angular.element("#contextPath").text() + "/doctor/queryData";
        angular.element("#indexForm").attr('action', url);
        angular.element("#indexForm").submit();
    };

    $scope.deleteData = function () {
        if (confirm('确定要删除此人信息?')){
            var name = angular.element("#name");
            var phone = angular.element('#phone');
            var contextPath = angular.element("#contextPath").text();
            $http({
                method: 'post',
                url: contextPath + '/doctor/deleteData',
                params: {'name': name.val().trim(), 'phone': phone.val().trim()}
            }).then(function (result) {
                if ('success' === result.data.status) {
                    alert("删除成功!");
                    return;
                }
                if ('no-exists' === result.data.status) {
                    alert("查无此人!");
                    return;
                }
                if ('repeat' === result.data.status) {
                    alert("姓名重复,请输入手机号码!");
                }
            }).catch(function () {
                alert("请重新提交！");
            });
        }
    }
});