var xianTianApp = angular.module('xianTianApp', []);

xianTianApp.controller('xianTianCtrl', function ($scope) {
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
    $scope.exitSystem = function (e) {
        if (confirm('确定退出系统？')) {
            window.location.href = 'exit';
        }
    };
    $scope.checkQuery = function (firstClick) {
        var phoneValue = phone.find('option:selected');
        var url = 'doctor/element/inborn';
        if (!/^[\u4E00-\u9FA5A-Za-z]+$/.test(name.val())) {
            alert("请输入有效的姓名");
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
                console.log(data);
                console.log(phoneVal());
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
                }
                else if (data.code === 0) {
                    angular.element('#queryMobile').modal('hide');
                    var item = data.data;
                    var conclusion_name = angular.element('#conclusion-name');
                    var conclusion_lunarBirth = angular.element('#conclusion-lunarBirth');
                    var conclusion_solarBirth = angular.element('#conclusion-solarBirth');
                    var table_1 = angular.element('.table_1');
                    var table_2 = angular.element('.table_2');
                    var your_conclusion = angular.element('#your-conclusion');
                    var conclusion_img = document.getElementById('conclusion-img');
                    console.log(item[0]);
                    console.log(item[1].name);
                    console.log(item[1].horoscope);
                    conclusion_name.text(item[1].name);
                    conclusion_lunarBirth.text(item[1].lunarBirth + '时');
                    conclusion_solarBirth.text(item[1].solarBirth + '时');
                    var horoscope = item[1].horoscope;
                    table_1.each(function () {// 获取表格table中，第几个td的文本
                        $(this).find('td').eq(0).text(horoscope.charAt(0));
                        $(this).find('td').eq(1).text(horoscope.charAt(2));
                        $(this).find('td').eq(2).text(horoscope.charAt(4));
                        $(this).find('td').eq(3).text(horoscope.charAt(6));

                        $(this).find('td').eq(4).text(horoscope.charAt(1));
                        $(this).find('td').eq(5).text(horoscope.charAt(3));
                        $(this).find('td').eq(6).text(horoscope.charAt(5));
                        $(this).find('td').eq(7).text(horoscope.charAt(7));
                    });
                    table_2.each(function () {  // 获取表格table中，第几个td的文本
                        $(this).find('td').eq(0).text(item[1].wood);
                        $(this).find('td').eq(1).text(item[1].fire);
                        $(this).find('td').eq(2).text(item[1].earth);
                        $(this).find('td').eq(3).text(item[1].metal);
                        $(this).find('td').eq(4).text(item[1].water);
                    });
                    conclusion_img.src = '/elements/' + item[0];
                    your_conclusion.text(item[1].inborn);
                    phone.html('');
                } else {
                    angular.element('#queryMobile').modal('hide');
                    alert(data.msg);
                }
            });
    }
});
