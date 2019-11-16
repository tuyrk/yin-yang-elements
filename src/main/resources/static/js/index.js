var indexApp = angular.module('indexApp', []);
indexApp.controller('indexCtrl', function ($scope) {
    /**
     * 获取用户的信息，展示在页面内
     */
    $(function () {
        $.post('doctor/manage/info', function (data) {
            console.log(data);
            if (data.code === 0) {
                $('#dropdownMenu1_realname').html(data.data.realname);
            }
        });
        filterSex();
        //返回顶部js代码
        var backButton = $('.back_to_top');
        function backToTop() {
            $('html,body').animate({
                scrollTop: 0
            }, 800);
        }

        backButton.on('click', backToTop);
        $(window).on('scroll', function () {/*当滚动条的垂直位置大于浏览器所能看到的页面的那部分的高度时，回到顶部按钮就显示 */
            if ($(window).scrollTop() > $(window).height()) {
                backButton.fadeIn();
            }
            else {
                backButton.fadeOut();
            }
        });
        $(window).trigger('scroll');
        /*触发滚动事件，避免刷新的时候显示回到顶部按钮*/
    });
    /**
     * 处理当前左导航栏的选中样式??
     */
    $('.ulCilck').on('click', '.list-exchange', function () {
        $('.list-exchange').removeClass('exchangeActive');
        $(this).addClass('exchangeActive');
    });
    var name = angular.element("#name");
    var phone = angular.element('#phone');
    var phoneList = angular.element('#phoneList');
    var birthday = angular.element('#birthday');
    var sex = angular.element('#sex');
    var nameItem = $("input[type='radio']");
    var pattern_phone = /^(13[\d]|15[\d]|17[678]|18[\d]|14[57])[\d]{8}$/;
    var pattern_name = /^[\u4E00-\u9FA5A-Za-z]+$/;
    var isQuery=false;//调用查询删除不用的数据
    var checkItemName = [
        'lianXing',
        'mianSe',
        'quGan',
        'siZhi',
        'yuYin',
        'xingLi',
        'hanRe',
        'han',
        'yinShiKouWei',
        'daBian',
        'xiaoBian',
        'shuiMian',
        'jingShengZhuangTai',
        'touBu',
        'shuangMu',
        'xiongXie',
        'zhiTi',
        'yueJing',
        'yiFaMu',
        'kouChun',
        'xinXiong',
        'yiFaHuo',
        'touShen',
        'sheChun',
        'weiWan',
        'fuBu',
        'yiFaTu',
        'keSou',
        'geTan',
        'biBu',
        'piFu',
        'yaoQi',
        'xingYu',
        'yiJing',
        'daiXia',
        'haoFaJiJie',
        'haoFaBingWei'
    ];
    $scope.exitSystem = function () {
        if (confirm('确定退出系统？')) {
            window.location.href = 'exit';
        }
    };
    /**
     * 是否显示单选按钮的子选项
     * @param itemShow 要显示的item
     * @param itemHide 要隐藏的item
     * @param itemName 要移除checked的item
     */
    $scope.showChildItem = function (itemShow, itemHide, itemName) {
        var showItem = $('#' + itemShow);
        var hideItem = $('.' + itemHide);
        var nameItem = 'input[name=' + itemName + ']';
        hideItem.css('display', 'none');
        showItem.css('display', 'block');
        $(nameItem).removeAttr('checked');
    };

    /**
     * 处理出生日期格式
     * 公历:2018-05-15 08
     * 农历:2018-04-01 08
     * 农历:2017-闰06-01 08->2017-06-01 08
     */
    function setDate(dateValue) {
        var temp = dateValue;
        if (temp.indexOf('公') !== -1) {
            if (temp[temp.indexOf('时') - 1] !== " ") {
                var t1 = temp.substring(0, temp.indexOf('时'));
                var h = t1;
                if (h[h.length - 1] <= 9 && h[h.length - 2] === ' ') {
                    var m = h[h.length - 1];
                    var t2 = h.substring(0, h.length - 1);
                    var t3 = t2.concat('0' + m);
                    temp = t3
                } else {
                    temp = t1
                }
            }
            else {
                var t1 = temp.substring(0, temp.indexOf('时'));
                var t3 = t1.concat('00');
                temp = t3;

            }
        } else if (temp.indexOf('农') !== -1) {
            if (temp[temp.indexOf('时') - 1] !== " ") {
                var t1 = temp.substring(0, temp.indexOf('时') - 1);
                if (t1.indexOf('闰') > 0) {
                    t1 = t1.split('闰').join('').toString();
                }
                temp = t1;
            } else {
                var t1 = temp.substring(0, temp.indexOf('时'));
                var t3 = t1.concat('00');
                if (t3.indexOf('闰') > 0) {
                    t3 = t3.split('闰').join('').toString();
                }
                temp = t3;
            }
        }
        return temp;
    }

    /**
     * 检查单选框是否都选中
     * @param itemName 所有单选框选项
     * @returns {number} 返回所有选中的单选框选项
     */
    function checkItem(itemName) {
        var result = [];
        itemName.map(function (i) {
            if ($(this).is(":checked")) {
                result.push($(this).val());
            }
        });
        return result
    }

    /**
     * 检查单选框是否都选中,未选中时跳转到第一个未选中的item
     * @param itemName 所有单选框选项
     */
    function checkItemFocus(itemName) {
        var focusItem = true;
        for (var i = 0; i < itemName.length; i++) {
            var tempName = $('input[name=' + itemName[i] + ']');
            tempName.each(function () {
                if ($(this).is(':checked')) {
                    focusItem = false;//如果当前有选中的则赋值为false
                }
            });
            /**
             * 根据真假判断当面的name所属的checkBox是否应该跳转
             */
            if (focusItem) {
                console.log(itemName[i] + ' unchecked');
                //根据父item是否被选中，来显示子item
                if (itemName[i] === 'mianSe') {
                    var tempParent = $('input[name=outmianSe]');
                    tempParent.each(function () {
                        if ($(this).is(':checked')) {
                            $('#mianSe' + $(this).val()).css('display', 'block');
                        }
                    });
                }
                if (itemName[i] === 'xingLi') {
                    var tempParent_2 = $('input[name=outXingLi]');
                    tempParent_2.each(function () {
                        if ($(this).is(':checked')) {
                            $('#xingLi' + $(this).val()).css('display', 'block');
                        }
                    });
                }
                /**
                 * 因为focus跳转的的位置不是很友好，
                 * 所以为了位置在用户正中，使跳的位置往后移了一个节点
                 */
                if (i - 1 >= 0) {
                    $('input[name=' + itemName[i - 1] + ']').focus();
                } else {
                    phone.focus();
                }
                return;
            }
            focusItem = true;
        }
    }

    /**
     * 保存提交的ajax
     * @param isUpdate 当有重复的号码、姓名，是否要覆盖原有的数据
     */
    function postSubmitForm(isUpdate) {
        var url  ="doctor/scada/collect";
        var rc = checkItem(nameItem);
        $.post(url,
            {
                name: name.val(),
                birth: setDate(birthday.val()),
                sex: sex.val(),
                phone: phone.val(),
                lianXing: rc[0],
                mianSe: rc[2],
                quGan: rc[3],
                siZhi: rc[4],
                yuYin: rc[5],
                xingLi: rc[7],
                hanRe: rc[8],
                han: rc[9],
                yinShiKouWei: rc[10],
                daBian: rc[11],
                xiaoBian: rc[12],
                shuiMian: rc[13],
                jingShengZhuangTai: rc[14],
                touBu: rc[15],
                shuangMu: rc[16],
                xiongXie: rc[17],
                zhiTi: rc[18],
                yueJing: rc[19],
                yiFaMu: rc[20],
                kouChun: rc[21],
                xinXiong: rc[22],
                yiFaHuo: rc[23],
                touShen: rc[24],
                sheChun: rc[25],
                weiWan: rc[26],
                fuBu: rc[27],
                yiFaTu: rc[28],
                keSou: rc[29],
                geTan: rc[30],
                biBu: rc[31],
                piFu: rc[32],
                yaoQi: rc[33],
                xingYu: rc[34],
                yiJing: rc[35],
                daiXia: rc[36],
                haoFaJiJie: rc[37],
                haoFaBingWei: rc[38],
                isUpdate: isUpdate
            },
            function (data) {
                console.log(data);
                if (data.code === 17 && !isUpdate) {
                    if (confirm('此号码的数据已录入，是否覆盖？')) {
                        postSubmitForm(true);
                        return;
                    }
                }
                if (data.code !== 0) {
                    alert(data.msg)
                } else {
                    alert('保存成功');
                }
            });
    }

    function filterSex(){
        var yueJing=$('input[name=yueJing]');
        var daiXia=$('input[name=daiXia]');
        var yiJing=$('input[name=yiJing]');
        console.log('filterSex:'+sex.val());
        if(sex.val()==='男'){
            yueJing.each(function () {
                if($(this).val()==='C') {
                    $(this).prop('checked','true');
                }
                $(this).attr('disabled','disabled');
            });
            daiXia.each(function () {
                if($(this).val()==='C') {
                    $(this).prop('checked','true');
                }
                $(this).attr('disabled','disabled');
            });
            yiJing.each(function () {
                if($(this).val()==='B') {
                    $(this).removeProp('checked');
                }
                $(this).removeAttr('disabled');
            });
        }else if(sex.val()==='女'){
            yiJing.each(function () {
                if($(this).val()==='B') {
                    $(this).prop('checked','true');
                }
                $(this).attr('disabled','disabled');
            });
            yueJing.each(function () {
                if($(this).val()==='C') {
                    $(this).removeProp('checked');
                }
                $(this).removeAttr('disabled');
            });
            daiXia.each(function () {
                if($(this).val()==='C') {
                    $(this).removeProp('checked');
                }
                $(this).removeAttr('disabled');
            });
        }else{
            yiJing.each(function () {
                if($(this).val()==='B') {
                    $(this).removeProp('checked');
                }
                $(this).removeAttr('disabled');
            });
            yueJing.each(function () {
                if($(this).val()==='C') {
                    $(this).removeProp('checked');
                }
                $(this).removeAttr('disabled');
            });
            daiXia.each(function () {
                if($(this).val()==='C') {
                    $(this).removeProp('checked');
                }
                $(this).removeAttr('disabled');
            });
        }
    }
    /**
     * 根据不同的性别过滤不同的选项
     */
    $scope.filterItem=function(){
        filterSex();
    };

    /**
     *点击保存回调函数
     */
    $scope.isValidForm = function () {
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
        if (sex.val()==='请选择') {
            alert("请选择您的性别");
            sex.focus();
            return;
        }
        if (!pattern_phone.test(phone.val())) {
            alert("手机号码错误");
            phone.focus();
            return;
        }
        //检查单选框是否选中
        if (checkItem(nameItem).length !== 39) {
            alert('选项不能留空');
            checkItemFocus(checkItemName);
            return;
        }
        postSubmitForm(false);
    };

    $scope.isQuery=function () {
        if (isQuery){
            queryAjax();
        }else{
            deleteAjax();
        }
        angular.element('#mobileModal').modal('hide');
    };
    /**
     *单击查询回调函数
     */
    function queryAjax() {
        var url =  "doctor/scada/query";
        console.log(phoneList.val());
        $.ajax({
            type: "POST",
            url: url,
            data: {
                name: name.val(),
                phone: phoneVal()
            },
            dataType: "json",
            success: function (data) {
                console.log(data);
                if (data.code === 14) {
                    for (var i = 0; i < data.data.length; i++) {
                        phoneList.append('<option value=' + data.data[i] + '>' + data.data[i] + '</option>');
                    }
                    /*if (!firstClick) {
                        if (!pattern_phone.test(phone.val())) {
                            alert("请先选择您想查询的手机号码");
                            phone.focus();
                        }
                    }*/
                    angular.element('#mobileModal').modal('show');
                    return;
                }
                if (data.code !== 0) {
                    if (!data.msg){
                        alert('您尚未登录');
                        window.location.href='/'
                    }else{
                        alert(data.msg);
                    }
                } else {
                    name.val(data.data[0].name);
                    birthday.val('公历:' + data.data[0].birth.substring(0, 13) + '时');
                    sex.val(data.data[0].sex);
                    filterSex();
                    console.log('Ajax:'+sex.val());
                    phone.val(data.data[0].phone);
                    var dataList = [];
                    dataList = data.data[1];
                    var dataBlog = [
                        {
                            key: 'lianXing',
                            value: dataList.lianXing
                        }, {
                            key: 'mianSe',
                            value: dataList.mianSe
                        }, {
                            key: 'quGan',
                            value: dataList.quGan
                        }, {
                            key: 'siZhi',
                            value: dataList.siZhi
                        }, {
                            key: 'yuYin',
                            value: dataList.yuYin
                        }, {
                            key: 'xingLi',
                            value: dataList.xingLi
                        }, {
                            key: 'hanRe',
                            value: dataList.hanRe
                        }, {
                            key: 'han',
                            value: dataList.han
                        }, {
                            key: 'yinShiKouWei',
                            value: dataList.yinShiKouWei
                        }, {
                            key: 'daBian',
                            value: dataList.daBian
                        }, {
                            key: 'xiaoBian',
                            value: dataList.xiaoBian
                        }, {
                            key: 'shuiMian',
                            value: dataList.shuiMian
                        }, {
                            key: 'jingShengZhuangTai',
                            value: dataList.jingShengZhuangTai
                        }, {
                            key: 'touBu',
                            value: dataList.touBu
                        }, {
                            key: 'shuangMu',
                            value: dataList.shuangMu
                        }, {
                            key: 'xiongXie',
                            value: dataList.xiongXie
                        }, {
                            key: 'zhiTi',
                            value: dataList.zhiTi
                        }, {
                            key: 'yueJing',
                            value: dataList.yueJing
                        }, {
                            key: 'yiFaMu',
                            value: dataList.yiFaMu
                        }, {
                            key: 'kouChun',
                            value: dataList.kouChun
                        }, {
                            key: 'xinXiong',
                            value: dataList.xinXiong
                        }, {
                            key: 'yiFaHuo',
                            value: dataList.yiFaHuo
                        }, {
                            key: 'touShen',
                            value: dataList.touShen
                        }, {
                            key: 'sheChun',
                            value: dataList.sheChun
                        }, {
                            key: 'weiWan',
                            value: dataList.weiWan
                        }, {
                            key: 'fuBu',
                            value: dataList.fuBu
                        }, {
                            key: 'yiFaTu',
                            value: dataList.yiFaTu
                        }, {
                            key: 'keSou',
                            value: dataList.keSou
                        }, {
                            key: 'geTan',
                            value: dataList.geTan
                        }, {
                            key: 'biBu',
                            value: dataList.biBu
                        }, {
                            key: 'piFu',
                            value: dataList.piFu
                        }, {
                            key: 'yaoQi',
                            value: dataList.yaoQi
                        }, {
                            key: 'xingYu',
                            value: dataList.xingYu
                        }, {
                            key: 'yiJing',
                            value: dataList.yiJing
                        }, {
                            key: 'daiXia',
                            value: dataList.daiXia
                        }, {
                            key: 'haoFaJiJie',
                            value: dataList.haoFaJiJie
                        }, {
                            key: 'haoFaBingWei',
                            value: dataList.haoFaBingWei
                        }
                    ];
                    for (var i = 0; i < dataBlog.length; i++) {
                        var tempName = $('input[name=' + dataBlog[i].key + ']');
                        /**
                         * 把获取到的数据与单选组的name属性一一对应的，
                         * 遍历获得的name单选框选项，如果当前name下的某一个单选项的值与获取到数组里的value相等
                         * 使之成为选中状态
                         */
                        tempName.each(function () {
                            if ($(this).val() === dataBlog[i].value) {
                                $(this).prop("checked", true);
                            } else {
                                $(this).prop("checked", false);
                            }
                        });
                        /**
                         * 把有子选项的单项框的div显示，并使父级的单项项成为选中状态
                         */
                        if (dataBlog[i].key === 'mianSe') {
                            var outTempName = $("input[name=outmianSe]");
                            console.log(dataBlog[i].value);
                            outTempName.each(function () {
                                if ($(this).val() === dataBlog[i].value[0].toString()) {
                                    console.log('mainSe选中的：' + $(this).val());
                                    $(this).prop("checked", true);
                                    $('#mianSe' + $(this).val()).css('display', 'block');
                                } else {
                                    console.log('未选中的：' + $(this).val());
                                    $(this).prop("checked", false);
                                    $('#mianSe' + $(this).val()).css('display', 'none');
                                }
                            });
                        }
                        if (dataBlog[i].key === 'xingLi') {
                            var outTempName = $('input[name="outXingLi"]');
                            console.log(dataBlog[i].value);
                            outTempName.each(function () {
                                if ($(this).val() === dataBlog[i].value[0].toString()) {
                                    console.log('xingLi选中的：' + $(this).val());
                                    $(this).prop("checked", true);
                                    $('#xingLi' + $(this).val()).css('display', 'block');
                                } else {
                                    console.log('未选中的：' + $(this).val());
                                    $(this).prop("checked", false);
                                    $('#xingLi' + $(this).val()).css('display', 'none');
                                }
                            });
                        }
                    }
                }
            },
        });
        phoneList.html('')
    }
    $scope.queryData = function () {
        /*if (!pattern_name.test(name.val())) {
            alert("姓名格式错误");
            name.focus();
            return;
        }*/
        /*if (!pattern_phone.test(phone.val())) {
            alert("手机号码错误");
            phone.focus();
            return;
        }*/
        if (!name.val()&&!phone.val()){
            alert("请输入姓名或手机号码查询");
            name.focus();
            return;
        }
        isQuery=true;
        queryAjax();

    };
    function phoneVal() {
        if (phone.val() === '') {
            return phoneList.val();
        } else {
            return phone.val()
        }
    }
    /**
     *点击删除回调函数
     */
    function deleteAjax() {
        var url = "doctor/scada/delete";
        if (confirm('确定要删除此人信息?')) {
            $.post(url,
                {
                    name: name.val(),
                    phone: phoneVal()
                },
                function (data) {
                    if (data.code === 14) {
                        for (var i = 0; i < data.data.length; i++) {
                            phoneList.append('<option value=' + data.data[i] + '>' + data.data[i] + '</option>');
                        }
                        /*if (!firstClick) {
                            if (!pattern_phone.test(phone.val())) {
                                alert("请先选择您想查询的手机号码");
                                phone.focus();
                            }
                        }*/
                        angular.element('#mobileModal').modal('show');
                        return;
                    }
                    if (data.code === 0) {
                        alert('删除成功')
                    }
                    else if (data.code === 10) {
                        alert('数据已经被删除过')
                    } else {
                        alert(data.msg)
                    }
                });
        }
        phoneList.html('')
    }
    $scope.deleteData = function () {
        /*if (!pattern_name.test(name.val())) {
            alert("姓名格式错误");
            name.focus();
            return;
        }
        if (!pattern_phone.test(phone.val())) {
            alert("手机号码错误");
            phone.focus();
            return;
        }*/
        if (!name.val()&&!phone.val()){
            alert("请输入姓名或手机号码删除");
            name.focus();
            return;
        }
        isQuery=false;
        deleteAjax();

    };
    /**
     * 导出数据
     */
    $scope.exportData = function () {
        window.location.href="doctor/scada/export";
    };
})
;
