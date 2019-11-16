/*
http://cy.dashiwang.net/
 */
$(function () {
    for (var i = 0, max = $('.Js_date').length; i < max; i++) {
        new lCalendar().init('#' + $('.Js_date').eq(i).attr('id'));
    }
});
